import React, { Component } from 'react';
import RaceDataService from '../../service/RaceDataService';
import FooterComponent from '../header_footer/FooterComponent';

class LoginComponent extends Component {
    constructor(props) {
            super(props)
            this.state = {
                id: this.props.match.params.id,
                username: '',
                password: '',
                email: '',
                credits: 0
            }
            this.handleSubmit = this.handleSubmit.bind(this)
            this.handleChange = this.handleChange.bind(this)
            this.handleFile = this.handleFile.bind(this)
        }

        handleChange(event) {
            this.setState({
                [event.target.name]: event.target.value
            })
        }

        handleFile(event){
            const preview = document.querySelector('img')
            const file = document.querySelector('input[type=file]').files[0]
            const reader = new FileReader()

            reader.addEventListener("load", function () {
                preview.src = reader.result
            }, false)

            if (file) {
                reader.readAsDataURL(file)
            }
        }

        handleSubmit() {
            let user = {
                id: this.state.id,
                Username: this.state.Username,
                Password: this.state.Password,
                Email: this.state.Email,
                Credits: 0
            }

            RaceDataService.addUser(user)
                .then(this.props.history.push(`/raceRegistry`))

        }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{height: "50px", backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Register</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                        <div>
                            <label>Username:</label>
                            <input className="form-control" type="text" name="Username" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Password:</label>
                            <input className="form-control" type="text" name="Password" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Email:</label>
                            <input className="form-control" type="text" name="Email" onChange={this.handleChange}/>
                        </div>
                        <br/>
                             <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
                    </form><br/><br/>
                </div>
                <FooterComponent />
            </div>
        )
    }
}

export default LoginComponent;
