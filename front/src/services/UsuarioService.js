import ApiService from '../ApiService'

class UsuarioService extends ApiService {
    constructor () {
        super('/api/usuarios')
    }

    obterUsuarios(){
        return this.get("/allusuarios")
    }

    autenticar(usuario) {
        return this.post(`/autenticar?usuario=${usuario}`)
    }

    cadastrar(usuario) {

    }
}

export default UsuarioService