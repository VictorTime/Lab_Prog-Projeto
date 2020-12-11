import ApiService from '../ApiService'

class AtividadeService extends ApiService {
    constructor () {
        super('/api/atividades')
    }

    obterAtividades(usuario){
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
            },
          }
        const response = axios.post('http://localhost:8080/api/atividades/obter',usuario, options)
           return response;
    }
    salvar(atividade){
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
              "Content-Type": "application/json;charset=UTF-8",
            },
          }
        const response = axios.post('http://localhost:8080/api/atividades/salvar',atividade, options)
           return response;
    }
    /* Tem que ajeitar no backend
    validar(matricula_professor, atividade) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
            },
          }
        const response = axios.post('http://localhost:8080/api/atividades/validar',matricula_professor, options)
           return response;
    }
    */

}

export default AtividadeService