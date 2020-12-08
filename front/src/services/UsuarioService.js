import ApiService from '../ApiService'

class UsuarioService extends ApiService {
    constructor () {
        super('/api/usuarios')
    }

    obterUsuarios(){
        return this.get("/allusuarios")
    }

    validar(usuario) {

    }

    cadastrar(usuario) {

    }
}

export default UsuarioService