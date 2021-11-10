import React, { useState } from 'react';
import { useHistory} from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'

export default function LoginForm() {

    const adminUser = {
        username: "admin",
        password: "pass"
    }

    const [details, setDetails] = useState({username: "", email: "", password: ""})
    const [error, setError] = useState("")
    const history = useHistory();

    const HandleSubmit = e => {
        e.preventDefault()

        if(details.username === adminUser.username && details.password === adminUser.password){
            window.localStorage.setItem('user', JSON.stringify(details));
            history.push('/admin');
        }else{
            RaceDataService
                .retrieveUser(details.username)
                    .then( response => {
                        if(response.data.password === details.password){
                            window.localStorage.setItem('user', JSON.stringify(details))
                            RaceDataService.addUser(details)
                                        .then(history.push('/'))
                        }else{
                            setError("Incorrect details.")
                        }
                    })
        }
    }

    const Register = () => {
            history.push('/register');
    }

    return(
        <form className="loginForm" onSubmit={HandleSubmit}>
            <div className="form-inner">
                <h2>Login</h2>
                {(error !== "") ? ( <div className="error">{error}</div>) : ""}
                <div className="form-group">
                    <label htmlFor="username">Username:</label>
                    <input type="text" name="username" id="username"
                        onChange={e => setDetails({...details, username: e.target.value})} value={details.username}/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input type="text" name="password" id="password"
                        onChange={e => setDetails({...details, password: e.target.value})} value={details.password}/>
                </div>
                <br/>
                 <input type="submit" value="login" style={{position:"absolute", right:"30px"}}/>
                 <button onClick={Register}>Register</button>
             </div>
        </form>
    )
}
