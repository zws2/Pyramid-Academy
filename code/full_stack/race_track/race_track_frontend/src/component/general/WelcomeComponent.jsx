import React, { useState, useEffect }  from 'react';
import HeaderComponent, {Login, Logout} from '../header_footer/HeaderComponent';
import FooterComponent from '../header_footer/FooterComponent';
import pic from './horse.jpg';

export default function WelcomeComponent(){

    const [user, setUser] = useState({username: "", email: "", password: ""})

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            setUser(stored_user)
        }
        }, []);

    return(
        <div>
            <HeaderComponent />
            <div className="WelcomeComponent">
                <div className="welcome">
                    {(user.username !== "") ? (

                        <h2 style={{textAlign:"center"}}>Welcome to the Races {user.username}!</h2>
                        ) : (
                        <h2 style={{textAlign:"center"}}>Please log in.</h2>
                    )}
                    <div className="imgbox">
                        <img className="img-fluid center-fit" alt="a weiner dog running" src={pic}/>
                    </div>
                </div>
            </div >
            <FooterComponent />
        </div>
    )
}