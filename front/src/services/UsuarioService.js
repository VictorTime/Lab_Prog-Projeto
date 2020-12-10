import ApiService from '../ApiService'

class UsuarioService extends ApiService {
    constructor () {
        super('/api/usuarios')
    }

    obterUsuarios(){
        return this.get("/allusuarios")
    }

    autenticar(usuario, options) {
        return this.post(`/autenticar?usuario=${usuario}`,options)
    }

    salvar(usuario,options) {
        return this.post(`/salvar?usuario=${usuario}`,options)
    }
}

export default UsuarioService