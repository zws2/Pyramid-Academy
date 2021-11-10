import React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import WelcomeComponent from './WelcomeComponent'
import HeaderComponent from '../header_footer/HeaderComponent'
import RaceRegistryComponent from '../race/RaceRegistryComponent'
import UpdateRaceComponent from '../race/UpdateRaceComponent'
import AddRaceComponent from '../race/AddRaceComponent'
import LoginForm from '../general/LoginForm'
import RegisterForm from '../general/RegisterForm'

function RouterComponent(){
   return(
       <div>
        <Router>
            <Switch>
                <Route exact path="/"><WelcomeComponent /></Route>
                <Route path="/login"><LoginForm /></Route>
                <Route path="/register"><RegisterForm /></Route>
                <Route path="/addRace/:id" component={AddRaceComponent} />
                <Route path="/updateRace/:id" component={UpdateRaceComponent} />
                <Route path="/raceRegistry" component={RaceRegistryComponent} />
            </Switch>
        </ Router>
        </div>
   )
}

export default RouterComponent;
