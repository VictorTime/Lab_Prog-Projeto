import axios from 'axios'

axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';


const instance = axios.create({
    baseURL: 'http://localhost:8080',
});

class ApiService {
    constructor (apiUrl) {
        this.apiUrl = apiUrl
    }

 
    async post(url, objeto) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
            },
          }
        console.log(this.apiUrl + url)

        const response = instance.post('http://localhost:8080/api/usuarios/autenticar',objeto, options)
           return response;
        }
       
 
    put(url, objeto) {
        return instance.put(`${this.apiUrl}${url}`, objeto)
    }

    delete(url) {
        return instance.delete(`${this.apiUrl}${url}`)
    }

    get(url) {
        return instance.get(`${this.apiUrl}${url}`)
    }
}

export default ApiService

