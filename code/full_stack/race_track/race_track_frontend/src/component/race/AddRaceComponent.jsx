import React, {Component} from 'react'
import RaceDataService from '../../service/RaceDataService'

class AddRaceComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            title: '',
            caption: '',
            contributor: '',
            img: '',
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

    handleSubmit() {
        console.log("submit")

        let race = {
            id: this.state.id,
            title: this.state.title,
            caption: this.state.caption,
            contributor: this.state.contributor
        }

        RaceDataService.addRace(race)
            .then(this.props.history.push(`/raceRegistry`))
    }

    render() {
        return(
            <div>
                <div className="jumbotron" style={{height: "50px", backgroundColor: "gray"}}>
                <h3 style={{textAlign: "center"}}>Add Race</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                        <div>
                            <label>Title:</label>
                            <input className="form-control" type="text" name="title" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Caption:</label>
                            <input className="form-control" type="text" name="caption" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Contributor:</label>
                            <input className="form-control" type="text" name="contributor" onChange={this.handleChange}/>
                        </div>
                        <div>
                        <br />
                             <input type="file" name="img" onChange={this.handleFile}/>
                             <img src="" height="200" alt="preview..."></img>
                        </div>
                        <br />
                             <input className="btn btn-success" type="submit" value="Submit" name="submit"/>
                    </form><br/><br/>
                </div>
            </div>
        )
    }
}

export default AddRaceComponent
