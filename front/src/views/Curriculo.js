import React from 'react'

import CurriculoTable from './CurriculoTable'
import CurriculoService from '../services/CurriculoService'

import SectionContent from './sectionContent'

class Curriculo extends React.Component {
    
    state = {
        curriculo :[],
        curr1 : 1,
        curr2 : 2 
    }

    constructor() {
        super()
        this.service = new CurriculoService()
    }

    salvar = () => {
        
    }

    componentDidMount(){
        localStorage.setItem("_usuario", JSON.stringify(57))

        this.service.obterCurriculo(JSON.parse(localStorage.getItem("_usuario")))
            .then((response) => {
                console.log(response.data)
                this.setState( {curriculo:response.data}  )
            }).catch (erro =>{
                console.log(erro.response)
            })
    }


	render() {

        return (
            <>
                <input value={this.state.ativ1}
                        onChange={(e) => {this.setState( {ativ1 : e.target.value} )}} />

                <div className="content-wrapper">
                    <CurriculoTable 
                                    className="table table-bordered table-hover"
                                    curriculos={this.state.curriculos} />
                    <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2">
                        <div className="col-sm-6">
                            <h1>Curriculos</h1>
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
