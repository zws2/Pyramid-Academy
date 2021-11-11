import React, { useState }  from 'react'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'

export default function AddRaceComponent() {

    const [race, setRace] = useState({id: -1, time: "", horses: "", results: ""})
    const history = useHistory();
    const [horses, setHorses] =
        useState([
            "Biscuit",
            "Gravy",
            "Raisin",
            "Pepper",
            "Bean",
            "Peanut",
            "Muffin",
            "Meatball"
        ])

    const handleSubmit = e => {
        e.preventDefault()
        RaceDataService.addRace(race)
            .then(response => {
                if(response.status < 300){
                    history.push('/raceRegistry')
                }
            })
    }

    const handleSelect = e => {
        let str = ""
        if(race.horses === ""){
            str = e.target.value
        }else{
            str = race.horses + ", " + e.target.value
        }

        setRace({...race, horses: str})

        horses.splice(horses.indexOf(e.target.value), 1)

        console.log(horses)
        console.log(race.horses)

    }

    const listToOptions = (list) => {
        let components = []

        list.forEach(e =>{
            let str = <option value={e}>{e}</option>
            components.push(str)
        } )
        return components
    }

    return(
        <form className="loginForm" onSubmit={handleSubmit}>
            <div className="form-inner">
                <h2>Add Race</h2>
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
                    <select onChange={handleSelect}>
                        {listToOptions(horses)}
                    </select>
                    <input
                        className="form-control"
                        type="text" name="horses"
                        onChange={e => setRace({...race, horses: e.target.value})}
                        value={race.horses}
                    />
                </div>
                <div>
                    <label>Results:</label>
                    <input className="form-control"
                        type="text" name="results"
                        onChange={e => setRace({...race, results: e.target.value})}
                        value={race.results}
                    />
                </div>
                <div>
                     <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
                </div>
            </div>
        </form>
    )
}
