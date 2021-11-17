import React, { useState, useEffect } from 'react';
import RaceDataService from '../../service/RaceDataService'

export default function ProfileComponent() {

    const [error, setError] = useState("")
    const [details, setDetails] = useState({username: "", email: "", password: "", credits: 0})
    const [amount, setAmount] = useState(0)

    useEffect(() => {
        const stored_user = JSON.parse(window.localStorage.getItem('user'));
        RaceDataService.retrieveUser(stored_user.username)
            .then(response => setDetails(response.data))
    }, []);

    const HandleSubmit = e => {
        e.preventDefault()

        const submitter = e.nativeEvent.submitter.name
        let value = details.credits

        if(isNaN(amount)){
            setError("must be a number.")
            return
        }else if(amount < 0){
            setError("Amount must not be negative.")
            return
        }else if(submitter === "withdraw"){
            let temp_value = parseInt(details.credits) - parseInt(amount)
            if(temp_value >= 0){
                value = temp_value
            }else {
                setError("You dont have enouogh credits.")
                return
            }
        }else if(submitter === "deposit"){
            value = parseInt(details.credits) + parseInt(amount)
        }else{
            setError("Something went wrong...")
            return
        }

        let user = {...details, credits: value}

        RaceDataService.updateUser(user)
        setError("")
        setDetails(user)
    }

    return(
        <form className="smallForm" onSubmit={HandleSubmit}>
            <div className="form-inner">
                <h2>Account Info</h2>
                <h3>username: {details.username}</h3>
                <h3>email: {details.email}</h3>
                <h3>credits: {details.credits}</h3>
                {(error !== "") ? ( <div className="error">{error}</div>) : ""}

                <div className="form-group">
                    <h6>amount: </h6>
                    <input
                        style={{width:"200px"}}
                        type="text"
                        name="credits"
                        id="credits"
                        onChange={e => setAmount(e.target.value)}
                        value={amount}
                    />
                </div>
                <button className="btn-success btn-lg" name="deposit" style={{position:"absolute", right:"30px"}}>deposit</button>
                <button className="btn-danger btn-lg" name="withdraw">withdraw</button>
             </div>
        </form>
    )
}
