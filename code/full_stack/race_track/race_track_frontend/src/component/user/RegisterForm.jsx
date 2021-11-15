import React, { useState } from 'react';
import { useHistory} from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'

export default function RegisterForm() {

    const [details, setDetails] = useState({username: "", email: "", password: "", credits: 0})
    const [error, setError] = useState("")
    const history = useHistory();

    const HandleSubmit = e => {
        e.preventDefault()

        if(details.username === ""){
            setError("Must enter a username.")
        }else if (details.email === ""){
            setError("Must enter an email.")
        }else if (details.password === ""){
            setError("Must enter a password.")
        }else{
            RaceDataService.retrieveUser(details.username)
                .then( response => {
                    if(response.data === ""){
                        window.localStorage.setItem('user', JSON.stringify(details))
                        RaceDataService.addUser(details)
                            .then(response => {
                                if(response.status < 300){
                                    history.push('/')}
                                })
                    }else{
                        setError("That user already exists.")
                    }
                })
        }
    }

    return(
        <form className="smallForm" onSubmit={HandleSubmit}>
            <div className="form-inner">
                <h2>Register</h2>
                {(error !== "") ? ( <div className="error">{error}</div>) : ""}
                <div className="form-group">
                    <label htmlFor="username">Username:</label>
                    <input type="text" name="username" id="username"
                        onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email:</label>
                    <input type="text" name="email" id="email"
                        onChange={e => setDetails({...details, email: e.target.value})} value={details.email}/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input type="text" name="password" id="password"
                        onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>
                <br/><br/>
                 <button
                     className="btn btn-lg"
                     type="submit"
                     value="register"
                     style={{position:"absolute", right:"33%", bottom:"20px"}}
                 >Register</button>
            </div>
        </form>
    )
}