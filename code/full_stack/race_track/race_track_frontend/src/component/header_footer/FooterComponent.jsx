import React, { Component } from 'react'

class FooterComponent extends Component {
    render() {
        const isRegistry = window.location.href.includes("raceRegistry")
        if(false){
            return(
                <footer className="registryFooter">
                     <span className="text-muted">Zachary Snyder</span>
                 </footer>
             )
        }else{
            return(
                <footer className="footer">
                    <span className="text-muted">Zachary Snyder</span>
                </footer>
            )
        }
    }
}


export default FooterComponent; 