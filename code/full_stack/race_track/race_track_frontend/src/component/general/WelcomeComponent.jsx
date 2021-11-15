import React, { useState, useEffect }  from 'react';
import pic from './horse.jpg';

export default function WelcomeComponent(props){

    const [user, setUser] = useState({username: ""})

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            setUser(stored_user)
        }
    }, []);

    return(
        <div>
            <div className="WelcomeComponent">
                <div className="welcome">
                    <br/><br/><br/>
                    {(user.username !== "") ? (
                        (user.username === "admin") ? (
                            <h2 style={{textAlign:"center"}}>Logged in with administrator privileges.</h2>
                        ) : (
                            <h2 style={{textAlign:"center"}}>Welcome to the Races {user.username}!</h2>
                        )
                    ) : (
                        <h2 style={{textAlign:"center"}}>Please log in.</h2>
                    )}
                    <div className="imgbox">
                        <img className="img-fluid center-fit" alt="a weiner dog running" src={pic}/>
                    </div>
                </div>
            </div >
        </div>
    )
}