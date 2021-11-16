import axios from 'axios'

class RaceDataService {

    retrieveAllRaces() {
        return axios.get(`http://localhost:8080/retrieveAllRaces`);
    }

    retrieveRace(id) {
        return axios.get(`http://localhost:8080/retrieveRace/${id}`);
    }

    deleteRace(id) {
        return axios.delete(`http://localhost:8080/deleteRace/${id}`)
    }

    updateRace(race) {
        return axios.put(`http://localhost:8080/updateRace/`, race)
    }

    addRace(race) {
        return axios.post(`http://localhost:8080/addRace/`, race)
    }
    
    retrieveAllUsers() {
            return axios.get(`http://localhost:8080/retrieveAllUsers`);
    }

    retrieveUser(username) {
        return axios.get(`http://localhost:8080/retrieveUser/${username}`);
    }

    deleteUser(id) {
        return axios.delete(`http://localhost:8080/deleteUser/${id}`)
    }

    updateUser(user) {
        return axios.put(`http://localhost:8080/updateUser/`, user)
    }
    
    addUser(user){
        return axios.post(`http://localhost:8080/addUser/`, user)
    }
    
    retrieveAllHorses() {
        return axios.get(`http://localhost:8080/retrieveAllHorses`);
    }

    retrieveHorse(id) {
        return axios.get(`http://localhost:8080/retrieveHorse/${id}`);
    }

    deleteHorse(id) {
        return axios.delete(`http://localhost:8080/deleteHorse/${id}`)
    }

    updateHorse(horse) {
        return axios.put(`http://localhost:8080/updateHorse/`, horse)
    }

    addHorse(horse) {
        return axios.post(`http://localhost:8080/addHorse/`, horse)
    }
        
    retrieveAllBets() {
        return axios.get(`http://localhost:8080/retrieveAllBets`);
    }

    retrieveBet(id) {
        return axios.get(`http://localhost:8080/retrieveBet/${id}`);
    }

    deleteBet(id) {
        return axios.delete(`http://localhost:8080/deleteBet/${id}`)
    }

    updateBet(bet) {
        return axios.put(`http://localhost:8080/updateBet/`, bet)
    }

    addBet(bet) {
        return axios.post(`http://localhost:8080/addBet/`, bet)
    }
}
export default new RaceDataService()