import React, { useState, useEffect } from 'react'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService';

export default function RaceRegistryComponent() {

    const [races, setRaces] = useState([])
    const [message, setMessage] = useState("")
    const history = useHistory();

    useEffect(() => {
            refreshRaceRegistry()
        }, []);

    const refreshRaceRegistry = () => {
            RaceDataService.retrieveAllRaces()
                .then(
                    response => {
                            setRaces(response.data)})
    }

    const deleteRaceClicked = (id) => {
        RaceDataService.deleteRace(id)
        .then(
            response => {
                setMessage(`Deleted Race: ${id}`)
                alert(message)
                refreshRaceRegistry()
            }
        )
    }
    
    const updateRaceClicked = (race) => {
        history.push(`/updateRace/${race.id}`)
    }

    const addRaceClicked = () => {
        history.push(`/addRace/-1`)
    }

    return(
        <div>
                <br/>
                <br/>
                <br/>
                <br/>
                <h1 style={{textAlign:"center"}}>Race Registry</h1>
            <div className="container">
                   <table className="table table-striped">
                       <thead>
                           <tr className="table-dark" style={{textAlign: "center"}}>
                               <th>Id</th>
                               <th>Time</th>
                               <th>Horses</th>
                               <th>Results</th>
                               <th></th>
                               <th>
                                    <div>
                                        <button className="btn btn-primary" onClick={addRaceClicked}>Add Race</button>
                                    </div>
                               </th>
                           </tr>
                       </thead>
                       <tbody>
                           {
                               races.map (
                                   race =>
                                   <tr style={{textAlign: "center"}} key={race.id}>
                                       <td>{race.id}</td>
                                       <td>{race.time}</td>
                                       <td>{race.horses}</td>
                                       <td>{race.results}</td>
                                       <td><button className="btn btn-warning" onClick={() => deleteRaceClicked(race.id, race.time, race.results)}>Delete</button></td>
                                       <td><button className="btn btn-success" onClick={() => updateRaceClicked(race)}>Update</button></td>
                                   </tr>
                               )
                           }
                       </tbody>
                   </table>
               </div>
           </div>
    )
}
