import ApiService from '../ApiService'

class UsuarioService extends ApiService {
    constructor () {
        super('/api/usuarios')
    }

    obterUsuarios(){
        return this.get("/allusuarios")
    }

    autenticar(email,senha) {
        return this.post(`/autenticar?email=${email}?senha=${senha}`)
    }

    salvar(usuario) {
        return this.post(`/salvar?usuario=${usuario}`)
    }
}

export default UsuarioService