import React, { Component } from 'react';
import RaceDataService from '../../service/RaceDataService';
import FooterComponent from '../header_footer/FooterComponent';

class WelcomeComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            races: []
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
                    races: response.data,
                })
            }
        )
    }

    render() {

        const race = this.state.races[Math.floor(Math.random() * this.state.races.length)]

        return(         
            <div className="image_container">
            {
                race &&
                    <div >
                        <h1 style={{textAlign: "center"}}>{race.title}</h1>
                        <div className="imgbox">
                            <img className="img-fluid center-fit" alt={race.caption} src={"data:image/png;base64," + race.img} />
                        </div>
                        <p style={{textAlign:"center"}}>{race.caption}</p>
                        <p style={{textAlign:"center"}}>Contributor: {race.contributor}</p>
                    </div >
            }
                <FooterComponent />
            </div>
        )
    }
}

export default WelcomeComponent;  
