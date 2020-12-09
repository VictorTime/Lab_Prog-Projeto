import ApiService from '../ApiService'

class AtividadeService extends ApiService {
    constructor () {
        super('/api/atividades')
    }

    obterAtividades(usuario){
        return this.get(`/obter?usuario=${usuario}`)
    }
    salvar(atividade){
        return this.post(`/salvar?atividade=${atividade}`)
    }

    validar(usuario) {
        return this.post(`/validar?usuario=${usuario}`)
    }

}

export default AtividadeService