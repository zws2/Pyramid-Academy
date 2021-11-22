import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import { useHistory } from "react-router-dom";
import RaceDataService from '../../service/RaceDataService'
import bell from './bell.png';

export default function HeaderComponent(){

    const [user, setUser] = useState({username: "", email: "", password: ""})
    const [notificationNum, setNotificationNum] = useState(0)
    const history = useHistory();

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            setUser(stored_user)
            let num = 0
            RaceDataService.retrieveAllNotifications().then(response => {
                response.data.forEach(e =>{
                    if(!e.is_read && e.user_username === stored_user.username) num++
                })
                setNotificationNum(num)
            })
        }


    }, []);


    const Logout = () => {
        setUser({username: "", email: "", password: ""})
        window.localStorage.setItem('user', JSON.stringify({username: "", email: "", password: ""}));
        history.push({
            pathname: '/',
            state: {isLoggedIn:"false"}
        })
        window.location.reload(false);
    }

    const Login = () => {
        history.push('/login');
    }

    return(
        <header>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <ul className="navbar-nav">
                    <h3><Link className="nav-link" to="/">Home</Link></h3>
                    <h3><Link className="nav-link" to="/raceRegistry">Races</Link></h3>
                    {(user.username !== "") ? (
                        (user.username === "admin") ? (
                                <button onClick={Logout} style={{position:"absolute", right:"30px"}}>Logout</button>
                            ) : (
                            <React.Fragment>
                                <h3><Link className="nav-link" to="/profile">Profile</Link></h3>
                                <h3><Link className="nav-link" to="/notifications">
                                    <img
                                        alt="notifications"
                                        src={bell}
                                        style={{height:"35px"}}
                                    />
                                    Notifications: {notificationNum}
                                </Link></h3>
                                <button onClick={Logout} style={{position:"absolute", right:"30px"}}>Logout</button>
                            </React.Fragment>
                        )) : (
                        <button onClick={Login} style={{position:"absolute", right:"30px"}}>Login</button>
                    )}
                </ul>
            </nav>
        </header>
    )
}