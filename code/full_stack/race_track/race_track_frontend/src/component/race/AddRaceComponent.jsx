import React, { useState, useEffect }  from 'react'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService';
import DateTimePicker from 'react-datetime-picker';

export default function AddRaceComponent() {

    const [race, setRace] = useState({id: -1, time: "", horses: "", results: ""})
    const [error, setError] = useState("")
    const history = useHistory();
    const [horses, setHorses] =
        useState({
            available: [],
            added: []
        })

    useEffect(() => {
        RaceDataService.retrieveAllHorses().then(response => setHorses({...horses, available:response.data}))
    }, []);

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

                let str = horses.added[0].name
                for(let i=1; i<horses.added.length; i++){
                    str += ", " + horses.added[i].name
                }

                let race_submission = race
                race_submission.horses = str
                race_submission.time = race.time.toLocaleString("en-US")

                RaceDataService.addRace(race_submission)
                    .then(response => {
                        if(response.status < 300){
                            history.push('/raceRegistry')
                        }
                    })
            }



    }

    return(
        <div>
            <form className="smallForm" onSubmit={handleSubmit}>
                <div className="form-inner">
                    <h2>Add Race</h2>
                    {(error !== "") ? ( <div className="error">{error}</div>) : ""}
                    <DateTimePicker
                        onChange={(date) => setRace({...race, time:new Date(date)})}
                        value={race.time}
                    />
                    <br/>
                    <div>
                         <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
                    </div>
                </div>
            </form>
            <br/><br/><br/><br/>
            <div className="left-horse-container">
                <table className="table table-striped">
                    <thead>
                        <tr className="table-dark" style={{textAlign: "center"}}>
                            <th>Available Horses</th>
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
                            <th>Added Horses</th>
                        </tr>
                    </thead>
                    <tbody>
                        {horses.added.map (
                            horse =>
                            <tr style={{textAlign: "center"}} key={horse.id}>
                                <td>{horse.name}</td>
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
