import React from 'react'
import CurriculoService from '../services/CurriculoService'


class Curriculo extends React.Component {
    
    state = {
        curriculo :[]
    }

    constructor() {
        super()
        this.service = new CurriculoService()
    }

    salvar = () => {
        
    }

    componentDidMount(){

        this.service.obterCurriculo(localStorage.getItem('usuario'))
            .then((response) => {
                console.log(response.data)
                localStorage.setItem('curriculo',response.data.id_curriculo)
                this.setState( {curriculo:response.data})
            }).catch (erro =>{
                window.document.location='#/cadastrocurriculo' 
                console.log(erro.response)
            })

        
    }


	render() {

        return (
            <>
                <div className="content-wrapper">
                    <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2">
                        <div className="col-sm-6">
                        </div>
                        </div>
                    </div>
                    </section>
                </div>
            </>
        )
    }
}



export default Curriculo
