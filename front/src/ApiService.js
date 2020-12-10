import axios from 'axios'


const instance = axios.create({
    baseURL: 'http://localhost:8080',
});

class ApiService {
    constructor (apiUrl) {
        this.apiUrl = apiUrl
    }

    headers = {
        option : {
            "Access-Control-Allow-Origin": "*"
        }
    }
    options = {
        headers: {
          "Access-Control-Allow-Credentials": true,
        },
      };
    /**template string (crase) nos permite construir a URL concatenando variáveis dentro com ${}*/
    post(url, objeto, option) {
        return instance.post(`${this.apiUrl}${url}`, objeto, option)
    }
 
    put(url, objeto) {
        return instance.put(`${this.apiUrl}${url}`, objeto,this.options)
    }

    delete(url) {
        return instance.delete(`${this.apiUrl}${url}`)
    }

    get(url) {
        return instance.get(`${this.apiUrl}${url}`)
    }
}

export default ApiService

