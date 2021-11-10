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
}
export default new RaceDataService()