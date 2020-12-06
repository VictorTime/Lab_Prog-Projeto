import ApiService from '../ApiService'

class AtividadeService extends ApiService {
    constructor () {
        super('/api/atividades')
    }

    obterInvestimentos(usuario) {
        return this.get(`/obter?usuario=${usuario}`)
    }

    validar(atividade) {

    }

    cadastrar(atividade) {

    }
}

export default AtividadeService