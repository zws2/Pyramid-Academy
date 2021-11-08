import React, { Component } from 'react'
import RaceDataService from '../../service/RaceDataService';
import FooterComponent from '../header_footer/FooterComponent';

class RaceRegistryComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            races: []
        }
        this.refreshRaceRegistry = this.refreshRaceRegistry.bind(this)
        this.deleteRaceClicked = this.deleteRaceClicked.bind(this)
        this.upDateRaceClicked = this.upDateRaceClicked.bind(this)
        this.addRaceClicked = this.addRaceClicked.bind(this)
    }

    componentDidMount() {
        this.refreshRaceRegistry()
    }

    refreshRaceRegistry() {
        setTimeout(() => {
            RaceDataService.retrieveAllRaces()
                .then(
                    response => {
                            this.setState({
                            races: response.data})})
        }, 500)
    }

    deleteRaceClicked(id, title, caption) {
        RaceDataService.deleteRace(id)
        .then(
            response => {
                this.setState({message: `Deleted Race: ${title}`})
                alert(this.state.message)
                this.refreshRaceRegistry()
            }
        )
    }
    
    upDateRaceClicked(race) {
        this.props.history.push(`/updateRace/${race.id}`)
    }

    addRaceClicked() {
        this.props.history.push(`/addRace/-1`)
    }

   render() {
        return(
           <div className="container">
               <h1 style={{textAlign:"center"}}>Race Registry</h1><br/>
               <div className="jumbotron sticky-top"  style={{textAlign: "center",  color: "white"}}>
               
                   <table className="table table-striped">
                       <thead>
                           <tr class="table-dark" style={{textAlign: "center"}}>
                               <th>Id</th>
                               <th>Title</th>
                               <th>Caption</th>
                               <th>Contributor</th>
                               <th></th>
                               <th>
                                    <div >
                                        <br/>
                                        <button className="btn btn-primary" onClick={this.addRaceClicked}>Add Race</button>
                                    </div>
                               </th>
                           </tr>
                       </thead>
                       <tbody>
                           {
                               this.state.races.map (
                                   race =>
                                   <tr style={{textAlign: "center"}} key={race.id}>
                                       <td>{race.id}</td>
                                       <td>{race.title}</td>
                                       <td>{race.caption}</td>
                                       <td>{race.contributor}</td>
                                       <td><button className="btn btn-warning" onClick={() => this.deleteRaceClicked(race.id, race.title, race.caption)}>Delete</button></td>
                                       <td><button className="btn btn-success" onClick={() => this.upDateRaceClicked(race)}>Update</button></td>
                                   </tr>
                               )
                           }
                       </tbody>
                        <br/>
                   </table>
               </div>
                <FooterComponent />
           </div>
        )
   } 
}

export default RaceRegistryComponent;
