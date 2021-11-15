import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom';
import RaceDataService from '../../service/RaceDataService';

export default function RaceRegistryComponent() {

    const [races, setRaces] = useState([])
    const [user, setUser] = useState({username: ""})
    const [message, setMessage] = useState("")
    const history = useHistory();

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            setUser(stored_user)
        }
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

    const betClicked = () => {
        history.push(`/bet/-1`)
    }

    return(
        <div>
            <br/>
            <h1 style={{textAlign:"center", marginTop:"60px"}}>Race Registry</h1>
            <div className="container">
               <table className="table table-striped">
                   <thead>
                       <tr className="table-dark" style={{textAlign: "center"}}>
                           <th>Id</th>
                           <th>Time</th>
                           <th>Horses</th>
                           <th>Results</th>
                           <th></th>
                           {(user.username === "admin") &&
                               <th><button className="btn btn-primary" onClick={addRaceClicked}>Add Race</button></th>
                           }
                       </tr>
                   </thead>
                   <tbody>
                       {races.map (
                           race =>
                           <tr style={{textAlign: "center"}} key={race.id}>
                               <td>{race.id}</td>
                               <td>{race.time}</td>
                               <td>{race.horses}</td>
                               <td>{race.results}</td>
                               {(user.username === "admin") ? (
                                   <React.Fragment>
                                       <td><button
                                           className="btn btn-danger"
                                           onClick={() => deleteRaceClicked(race.id, race.time, race.results)}
                                       >Delete</button></td>
                                       <td><button
                                           className="btn btn-success"
                                           onClick={() => updateRaceClicked(race)}
                                       >Update</button></td>
                                   </React.Fragment>
                               ) : (
                                   <React.Fragment>
                                       <td><button
                                           className="btn btn-success"
                                           onClick={() => betClicked(race)}
                                       >Bet</button></td>
                                   </React.Fragment>
                               )}
                           </tr>
                       )}
                   </tbody>
               </table>
           </div>
       </div>
    )
}
