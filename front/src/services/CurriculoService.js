import ApiService from '../ApiService'
import axios from 'axios'

axios.defaults.headers['Access-Control-Allow-Origin'] = '*';
class CurriculoService extends ApiService {
   
    obterCurriculo(usuario) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
            },
          }
        const response = axios.post('http://localhost:8080/api/curriculo/obter',usuario, options)
           return response;
    }


    salvar(curriculo) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
              "Content-Type": "application/json;charset=UTF-8",
            },
          }
        const response = axios.post('http://localhost:8080/api/curriculo/salvar',curriculo, options)
           return response;
    }
}

export default CurriculoService