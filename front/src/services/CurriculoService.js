import ApiService from '../ApiService'
import Curriculo from '../pages/Curriculo'

class CurriculoService extends ApiService {
    constructor () {
        super('/api/curriculo')
    }

    obterCurriculo(usuario) {
        return this.get(`/obter?usuario=${usuario}`)
    }


    salvar(curriculo) {
        return this.post(`/salvar?curriculo=${curriculo}`)
    }
}

export default CurriculoService