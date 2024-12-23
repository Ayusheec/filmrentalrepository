import axios from "axios";
 
const API = "http://localhost:8080/api";
 
const actorService = {
  addActor: (actor) => axios.post(`${API}/actors/post`, actor),
 
  getActorsByLastName: (lastName) =>
    axios.get(`${API}/actors/lastname/${lastName}`),
 
  getActorsByFirstName: (firstName) =>
    axios.get(`${API}/actors/firstname/${firstName}`),
 
  updateLastName: (id, lastName) =>
    axios.put(`${API}/actors/update/lastname/${id}`, null, {
      params: { lastName },
    }),
 
  updateFirstName: (id, firstName) =>
    axios.put(`${API}/actors/update/firstname/${id}`, null, {
      params: { firstName },
    }),
 
  getFilmsByActorId: (id) => axios.get(`${API}/actors/${id}/films`),
 
  fetchAllActors: () => axios.get(`${API}/actors`),
};
 
export default actorService;