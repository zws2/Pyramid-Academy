import axios from 'axios'
import { useRouter } from 'next/router'

const RefreshData = () => {
    const router = useRouter();
    router.replace(router.asPath);
}

export async function submitRace(race) {
  const res = await axios.post(`http://localhost:8080/addRace/`, race)

  if (res.status < 300) {
    RefreshData();
  }

  return res
}

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
}

export default new RaceDataService()