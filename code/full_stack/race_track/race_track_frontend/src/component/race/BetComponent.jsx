import React, { useState, useEffect } from 'react';
import RaceDataService from '../../service/RaceDataService'

export default function BetComponent() {

    const [error, setError] = useState("")
    const [user, setUser] = useState({username: "", email: "", password: "", credits: 0})
    const [race, setRace] = useState({id: 0, time: "", horses: "", results: ""})
    const [amount, setAmount] = useState(0)
    const [bet, setBet] =
        useState({
            name: "",
            id: 0,
            amount_bet: 0
        })
    const [horses, setHorses] =
        useState({
            available: [],
            added: []
        })

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        RaceDataService.retrieveUser(stored_user.username)
            .then(response => {
                setUser(response.data)
            })

        const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1)
        RaceDataService.retrieveRace(id)
            .then(
                response => {
                    let horses_temp = response.data.horses.split(",")
                    let horses_in_race = []

                    for(let i=0; i<horses_temp.length; i++){
                        let horse = {name:horses_temp[i], id:i}
                        horses_in_race.push(horse)
                    }
                    setHorses({...horses, available:horses_in_race})
                    setRace({
                        id: response.data.id,
                        time: response.data.time,
                        horses: response.data.horses,
                        results: response.data.results
                    })
                }
            )
    }, []);

    const handleAddHorse = (horse) => {
        let temp_available = horses.available

        if(horses.available.includes(horse)){
            temp_available.splice(horses.available.indexOf(horse), 1)
        }

        let temp_horse = {...horse, amount:0}

        setBet(temp_horse)
    }

    const handleRemoveHorse = (horse) => {
        let temp_available = horses.available
        let temp_added = horses.added

        if(horses.added.includes(horse)){
            temp_added.splice(horses.added.indexOf(horse), 1)
            temp_available.push(horse)
        }

        setHorses({...horses, available:temp_available, added:temp_added})
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
        }else if(bet.name ===""){
            setError("Must choose a horse.")
            return
        }else if(submitter === "bet"){
            let temp_value = parseInt(user.credits) - parseInt(amount)

            let horse_to_add = {...bet, amount_bet: amount}
            let temp_horses_added = horses.added
            temp_horses_added.push(horse_to_add)
            setHorses({...horses, added: temp_horses_added})

            setBet({
                name: "",
                id: 0,
                amount: 0
            })

            if(temp_value >= 0){
                value = temp_value
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
                    <h3>horse: {bet.name}</h3>
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
                        {horses.available.map (
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
                        {horses.added.map (
                            horse =>
                            <tr style={{textAlign: "center"}} key={horse.id}>
                                <td>{horse.name}: </td>
                                <td>${horse.amount_bet}</td>
                                <td>
                                    <button
                                        type="button"
                                        className="btn btn-warning"
                                        onClick={() => handleRemoveHorse(horse)}
                                    >-</button>
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
