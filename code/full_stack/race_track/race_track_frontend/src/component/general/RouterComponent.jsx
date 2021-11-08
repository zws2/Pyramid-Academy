import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import WelcomeComponent from './WelcomeComponent'
import HeaderComponent from '../header_footer/HeaderComponent'
import RaceRegistryComponent from '../race/RaceRegistryComponent'
import UpdateRaceComponent from '../race/UpdateRaceComponent'
import AddRaceComponent from '../race/AddRaceComponent'

class RouterComponent extends Component {
   render() {
       return(
           <div>
            <Router>
                <HeaderComponent />
                    <Switch>
                        <Route exact path="/"><WelcomeComponent/></Route>
                        <Route path="/addRace/:id" component={AddRaceComponent} />
                        <Route path="/updateRace/:id" component={UpdateRaceComponent} />
                        <Route path="/raceRegistry" exact component={RaceRegistryComponent} />
                    </Switch>
            </ Router>
            </div>
       )
   } 
}

export default RouterComponent; 
