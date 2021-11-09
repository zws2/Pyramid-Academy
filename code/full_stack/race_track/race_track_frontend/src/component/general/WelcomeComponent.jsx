import React, { Component } from 'react';
import RaceDataService from '../../service/RaceDataService';
import FooterComponent from '../header_footer/FooterComponent';
import pic from './horse.jpg';

class WelcomeComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            races: [],
            user: []
        }
        this.refreshRaceRegistry = this.refreshRaceRegistry.bind(this)
    }

    componentDidMount() {
            this.refreshRaceRegistry();
    }

    refreshRaceRegistry() {
        RaceDataService.retrieveAllRaces()
        .then(
            response => {
                this.setState({
                    races: response.data
                })
            }
        )
    }

    render() {

        return(
            <div >
                <h1 style={{textAlign:"center"}}>Welcome to the Races!</h1>
                <div className="imgbox">
                    <img className="img-fluid center-fit" alt="a weiner dog running" src={pic}/>
                </div>
                <FooterComponent />
            </div >
        )
    }
}

export default WelcomeComponent;  
