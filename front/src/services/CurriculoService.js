import ApiService from '../ApiService'
import axios from 'axios'

axios.defaults.headers['Access-Control-Allow-Origin'] = '*';
class CurriculoService extends ApiService {
   
    obterCurriculo(matricula) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,

            },
          }
        const response = axios.post('http://localhost:8080/api/curriculo/obter',matricula, options)
        console.log(response);
        return response;
    }


    salvar(curriculo) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,             
            },
          }
        const response = axios.post('http://localhost:8080/api/curriculo/salvar',curriculo, options)
           return response;
    }
}

export default CurriculoService