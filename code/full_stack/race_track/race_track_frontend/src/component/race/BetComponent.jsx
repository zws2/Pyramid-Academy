import React, { useState, useEffect } from 'react';
import RaceDataService from '../../service/RaceDataService'

export default function BetComponent() {

    const [error, setError] = useState("")
    const [user, setUser] = useState({username: "", email: "", password: "", credits: 0})
    const [race, setRace] = useState({id: 0, time: "", horses: "", results: ""})
    const [amount, setAmount] = useState(0)
    const [bets, setBets] = useState([])
    const [bet, setBet] =
        useState({
            id: 0,
            horse_name: "",
            amount_bet: 0
        })
    const [horses, setHorses] = useState([])

    useEffect(() => {

        const id = parseInt(window.location.href.substring(window.location.href.lastIndexOf('/') + 1))
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        RaceDataService.retrieveUser(stored_user.username)
            .then(response => {
                const temp_user = response.data
                setUser(temp_user)

                RaceDataService.retrieveAllBets().then(response => {
                    const temp_bets = response.data
                    const bet_list = []
                    for(let i=0; i<temp_bets.length; i++){
                        if(temp_bets[i].user_username === temp_user.username
                            && temp_bets[i].race_id === id){
                            bet_list.push(temp_bets[i])
                        }
                    }
                    setBets(bet_list)
                })
            })

        RaceDataService.retrieveRace(id)
            .then(
                response => {
                    let horses_temp = response.data.horses.split(",")
                    let horses_in_race = []

                    for(let i=0; i<horses_temp.length; i++){
                        let horse = {name:horses_temp[i], id:i}
                        horses_in_race.push(horse)
                    }
                    setHorses(horses_in_race)
                    setRace({
                        id: response.data.id,
                        time: response.data.time,
                        horses: response.data.horses,
                        results: response.data.results
                    })
                }
            )
    }, []) // eslint-disable-line react-hooks/exhaustive-deps

    const handleAddHorse = (horse) => {
        let temp_available = horses

        temp_available.splice(horses.indexOf(horse), 1)

        let temp_horse = { id: horse.id, horse_name: horse.name, amount:0}
        setBet(temp_horse)

        let new_horses = horses
        if(bet.horse_name !== ""){
            new_horses.push({ id: bet.id, name: bet.horse_name })
        }
        setHorses(new_horses)
    }

    const HandleSubmit = e => {
        e.preventDefault()

        const submitter = e.nativeEvent.submitter.name
        let value = user.credits

        if(isNaN(amount)){
            setError("must be a number.")
            return
        }else if(amount < 0){
            setError("Amount must not be negative.")
            return
        }else if(amount === 0){
            setError("Please enter an amount to bet.")
            return
        }else if(bet.horse_name ===""){
            setError("Must choose a horse.")
            return
        }else if(submitter === "bet"){
            let temp_value = parseInt(user.credits) - parseInt(amount)

            if(temp_value >= 0){
                value = temp_value

                let horse_to_add = {...bet, amount_bet: amount}
                let temp_horses_added = bets
                temp_horses_added.push(horse_to_add)
                setBets(temp_horses_added)

                const now = new Date()
                let temp_bet = {
                    amount_bet: amount,
                    timestamp: now.toLocaleString('en-US'),
                    user_username: user.username,
                    horse_name: bet.horse_name,
                    race_id: race.id
                }

                RaceDataService.addBet(temp_bet)
                RaceDataService.updateUser({...user, credits: value})

                let new_horses = horses
                if(bet.horse_name !== ""){
                    new_horses.push({ id: bet.id, name: bet.horse_name })
                }
                setHorses(new_horses)

                setBet({
                    id: 0,
                    horse_name: "",
                    amount: 0
                })
            }else {
                setError("You dont have enouogh credits.")
                return
            }
        }else{
            setError("Something went wrong...")
            return
        }

        let temp_user = {...user, credits: value}

        RaceDataService.updateUser(user)
        setError("")
        setUser(temp_user)
    }

    return(
        <div>
            <form className="smallForm" onSubmit={HandleSubmit}>
                <div className="form-inner">
                    <h2>Place your Bet</h2>
                    <h3>credits: ${user.credits}</h3>
                    <h3>horse: {bet.horse_name}</h3>
                    {(error !== "") ? ( <div className="error">{error}</div>) : ""}

                    <div className="form-group">
                        <h6>amount: </h6>
                        <input
                            style={{width:"200px"}}
                            type="text"
                            name="credits"
                            id="credits"
                            onChange={e => setAmount(e.target.value)}
                            value={amount}
                        />
                    </div>
                    <button
                        className="btn btn-lg"
                        name="bet"
                        style={{position:"absolute", right:"30px", bottom:"42px"}}
                    >Bet</button>
                 </div>
            </form>
            <br/><br/><br/><br/>
            <div className="left-horse-container">
                <table className="table table-striped">
                    <thead>
                        <tr className="table-dark" style={{textAlign: "center"}}>
                            <th>Runners</th>
                        </tr>
                    </thead>
                    <tbody style={{height:"10em", overflow:"scroll"}}>
                        {horses.map (
                            horse =>
                            <tr style={{textAlign: "center"}} key={horse.id}>
                                <td>{horse.name}</td>
                                <td>
                                    <button
                                        type="button"
                                        className="btn btn-success"
                                        onClick={() => handleAddHorse(horse)}
                                    >+</button>
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
            <div className="right-horse-container">
                <table className="table table-striped">
                    <thead>
                        <tr className="table-dark" style={{textAlign: "center"}}>
                            <th>horses</th>
                            <th>bets</th>
                        </tr>
                    </thead>
                    <tbody>
                        {bets.map (
                            bet =>
                            <tr style={{textAlign: "center"}} key={bet.id}>
                                <td>{bet.horse_name}: </td>
                                <td>${bet.amount_bet}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
