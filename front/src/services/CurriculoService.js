import ApiService from '../ApiService'

class CurriculoService extends ApiService {
    constructor () {
        super('/api/curriculo')
    }

    obterCurriculo(usuario) {
        return this.get(`/obter?usuario=${usuario}`)
    }

    validar(investimento) {

    }

    cadastrar(investimento) {

    }
}

export default CurriculoService