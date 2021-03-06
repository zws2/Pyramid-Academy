import React, { useState, useEffect}  from 'react';
import RaceDataService from '../../service/RaceDataService'

export default function NotificationComponent(){

    const [notifications, setNotifications] = useState([])

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        if(stored_user !== null){
            RaceDataService.retrieveAllNotifications().then(response => {
                let temp_notifications = []
                for(let i=0; i<response.data.length; i++){
                    if(response.data[i].user_username === stored_user.username){
                        const note = {...response.data[i], is_read: true}
                        if(!response.data[i].is_read){
                            RaceDataService.updateNotification(note)
                        }
                        temp_notifications.push(note)
                    }
                }
                setNotifications(temp_notifications.reverse())
            })
        }
    }, []) // eslint-disable-line react-hooks/exhaustive-deps

    return(
        <div>
            <br/>
            <h1 style={{textAlign:"center", marginTop:"60px"}}>Notifications</h1>
            <table className="table table-striped">
               <thead>
                   <tr className="table-dark" style={{textAlign: "center"}}>
                       <th style={{width:"5%"}}>ID</th>
                       <th style={{width:"85%"}}>Message</th>
                   </tr>
               </thead>
               <tbody>
                   {notifications.map (
                       notification =>
                       <tr key={notification.id}>
                           <td style={{textAlign: "center"}}>{notification.id}</td>
                           <td>{notification.message}</td>
                       </tr>
                   )}
               </tbody>
            </table>
        </div>
    )
}