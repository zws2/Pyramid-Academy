import React, { useState, useEffect } from 'react'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'

export default function UpdateRaceComponent() {

    const [race, setRace] = useState({id: 0, time: "", horses: "", results: ""})
    const history = useHistory();

    useEffect(() => {
        const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1)
        RaceDataService.retrieveRace(id)
            .then(
                response => {
                    setRace({
                        id: response.data.id,
                        time: response.data.time,
                        horses: response.data.horses,
                        results: response.data.results
                    })
                }
            )
    }, []);

    const handleSubmit = e => {
        e.preventDefault()
        RaceDataService.updateRace(race)
            .then(history.push(`/raceRegistry`))
    }

    return(
        <form className="loginForm" onSubmit={handleSubmit}>
            <div className="form-inner">
                <h2>Update Race</h2>
                <div>
                    <label>Race ID: {race.id}</label>
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
                <div>
                    <label>Results:</label>
                    <input
                        className="form-control"
                        type="text"
                        name="results"
                        onChange={e => setRace({...race, results: e.target.value})}
                        value={race.results}
                    />
                </div>
                <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
            </div>
        </form>
    )
}
