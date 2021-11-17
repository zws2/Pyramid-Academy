import React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import WelcomeComponent from './WelcomeComponent'
import HeaderComponent from '../header_footer/HeaderComponent'
import FooterComponent from '../header_footer/FooterComponent'
import RaceRegistryComponent from '../race/RaceRegistryComponent'
import UpdateRaceComponent from '../race/UpdateRaceComponent'
import AddRaceComponent from '../race/AddRaceComponent'
import BetComponent from '../race/BetComponent'
import LoginForm from '../user/LoginForm'
import RegisterForm from '../user/RegisterForm'
import ProfileComponent from '../user/ProfileComponent'
import NotificationComponent from '../user/NotificationComponent'

function RouterComponent(){
   return(
       <div>
        <Router forceRefresh={true}>
            <HeaderComponent/>
            <Switch>
                <Route exact path="/"><WelcomeComponent /></Route>
                <Route path="/login"><LoginForm /></Route>
                <Route path="/register"><RegisterForm /></Route>
                <Route path="/addRace/:id"><AddRaceComponent /></Route>
                <Route path="/updateRace/:id"><UpdateRaceComponent /></Route>
                <Route path="/bet/:id"><BetComponent /></Route>
                <Route path="/raceRegistry"><RaceRegistryComponent /></Route>
                <Route path="/profile"><ProfileComponent /></Route>
                <Route path="/notifications"><NotificationComponent /></Route>
            </Switch>
            <FooterComponent/>
        </ Router>
        </div>
   )
}

export default RouterComponent;
