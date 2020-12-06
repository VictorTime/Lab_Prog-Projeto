import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8080',
});

class ApiService {
    constructor (apiUrl) {
        this.apiUrl = apiUrl
    }

    /**template string (crase) nos permite construir a URL concatenando variáveis dentro com ${}*/
    post(url, objeto) {
        return instance.post(`${this.apiUrl}${url}`, objeto)
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

