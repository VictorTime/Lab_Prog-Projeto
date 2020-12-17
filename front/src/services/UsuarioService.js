import ApiService from '../ApiService'
import axios from 'axios'

axios.defaults.headers['Access-Control-Allow-Origin'] = '*';

class UsuarioService extends ApiService {
      
    obterUsuarios(){
        const response = axios.get('http://localhost:8080/api/usuarios/allusuarios')
          return response
    }

    autenticar(usuario) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
            },
          }
        const response = axios.post('http://localhost:8080/api/usuarios/autenticar',usuario, options,
        {
          successRedirect : '/', 
          failureRedirect : '/login', 
          failureFlash : true
        })
        return response;
    }

    salvar(usuario) {
        const options = {
            headers: {
              "Access-Control-Allow-Credentials": true,
              "Content-Type": "application/json;charset=UTF-8",
            },
          }
        const response = axios.post('http://localhost:8080/api/usuarios/salvar',usuario, options,
        {
          successRedirect : '/login', 
          failureRedirect : '/cadastro', 
          failureFlash : true
        })
           return response;
    }
}


export default UsuarioService