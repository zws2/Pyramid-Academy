import React, { useState, useEffect } from 'react'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'

export default function UpdateRaceComponent() {

    const [race, setRace] = useState({id: 0, time: "", horses: "", results: ""})
    const [error, setError] = useState("")
    const history = useHistory();
    const [horses, setHorses] =
            useState({
                available: [],
                added: []
            })

    useEffect(() => {
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
    }, []) // eslint-disable-line react-hooks/exhaustive-deps

    const handleAddHorse = (horse) => {
        let temp_available = horses.available
        let temp_added = horses.added

        if(horses.available.includes(horse)){
            temp_available.splice(horses.available.indexOf(horse), 1)
            temp_added.push(horse)
        }

        setHorses({...horses, available:temp_available, added: temp_added})
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

    const handleSubmit = e => {
        e.preventDefault()
        if(horses.added.length !== 6){
            setError("please select 6 horses")
        }else{
            let users_to_update = []
            RaceDataService.retrieveAllBets()
                .then(response => {
                    let notification_promises = []
                    for(let i=0; i<response.data.length; i++){
                        const current_bet = response.data[i]
                        if(current_bet.race_id === race.id){
                            let outcome_msg = ""
                            if(horses.added[0].name === current_bet.horse_name){
                                const credits = current_bet.amount_bet * 6
                                outcome_msg = "Your bet on " + current_bet.horse_name + " won you "
                                    + credits + " credits!"
                                users_to_update.push({username: current_bet.user_username, amount_won: credits})
                            }else {
                                const credits = current_bet.amount_bet
                                outcome_msg = "Your bet on " + current_bet.horse_name + " lost you "
                                    + credits + " credits!"
                            }
                            const notification = {
                                user_username: current_bet.user_username,
                                message: "Race " + current_bet.race_id + " has ended. " + outcome_msg
                            }
                            notification_promises.push(RaceDataService.addNotification(notification))
                        }
                    }
                    return Promise.all(notification_promises)
                }).then(async function() {
                    for(let i=0; i<users_to_update.length; i++){
                        await RaceDataService.retrieveUser(users_to_update[i].username)
                            .then(response => {
                                const updated_user =
                                    { ...response.data,
                                        credits: (users_to_update[i].amount_won + response.data.credits)}
                                return RaceDataService.updateUser(updated_user)
                        })
                    }
               }).then(function() {

                    let str = horses.added[0].name
                    for(let i=1; i<horses.added.length; i++){
                        str += ", " + horses.added[i].name
                    }

                    let race_submission = race
                    race_submission.results = str

                    return RaceDataService.updateRace(race_submission)
                })
                .then(response => {
                    if(response.status < 300){
                        return history.push('/raceRegistry')
                    }
                })
        }
    }

    return(
        <div>
            <form className="smallForm" onSubmit={handleSubmit}>
                <div className="form-inner">
                    <h2>Update Race</h2>
                    <div>
                        <label>Race ID: {race.id}</label>
                        {(error !== "") ? ( <div className="error">{error}</div>) : ""}
                    </div>
                    <br/>
                    <div>
                        <label>Time:</label>
                        <input
                            className="form-control"
                            type="text"
                            name="time"
                            onChange={e => setRace({...race, time: e.target.value})}
                            value={race.time}
                        />
                    </div>
                    <div>
                        <label>Horses:</label>
                        <input
                            className="form-control"
                            type="text"
                            name="horses"
                            onChange={e => setRace({...race, horses: e.target.value})}
                            value={race.horses}
                        />
                    </div>
                    <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
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
            <ol className="right-horse-container">
                <table className="table table-striped">
                    <thead>
                        <tr className="table-dark" style={{textAlign: "center"}}>
                            <th>Results</th>
                        </tr>
                    </thead>
                    <tbody>
                        {horses.added.map (
                            horse =>
                            <tr style={{textAlign: "center"}} key={horse.id}>
                                <td>{horse.name}</td>
                                <td><li/></td>
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
            </ol>
        </div>
    )
}
