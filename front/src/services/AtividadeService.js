import ApiService from '../ApiService'

class AtividadeService extends ApiService {
    constructor () {
        super('/api/atividades')
    }

    obterAtividades(usuario){
        return this.get(`/obter?usuario=${usuario}`)
    }
    salvar(atividade){
        
    }

    validar(atividade) {

    }

    cadastrar(atividade) {

    }
}

export default AtividadeService