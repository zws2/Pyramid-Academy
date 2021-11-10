import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import LoginForm from '../general/LoginForm'
import { useHistory } from "react-router-dom";

export default function HeaderComponent(){

    const [user, setUser] = useState({username: "", email: "", password: ""})

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            setUser(stored_user)
        }
        }, []);


    const Logout = () => {
        setUser({username: "", email: "", password: ""})
        window.localStorage.setItem('user', JSON.stringify({username: "", email: "", password: ""}));
        window.location.reload(false);
    }

    const history = useHistory();

    const Login = () => {
        history.push('/login');
    }

    return(
        <header>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <ul className="navbar-nav">
                    <h3><Link className="nav-link" to="/">Home</Link></h3>
                    <h3><Link className="nav-link" to="/raceRegistry">View Races</Link></h3>
                    {(user.username !== "") ? (
                        <button onClick={Logout}>Logout</button>
                        ) : (
                        <button onClick={Login}>Login</button>
                    )}
                </ul>
            </nav>
        </header>
    )
}