import React from 'react'

import CurriculoTable from '../tables/CurriculoTable'
import CurriculoService from '../services/CurriculoService'

import SectionContent from '../views/sectionContent'

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
                <div className="content-wrapper">
                    <CurriculoTable 
                                    className="table table-bordered table-hover"
                                    curriculo={this.state.curriculo} />
                    <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2">
                        <div className="col-sm-6">
                        </div>
                        </div>
                    </div>
                    </section>

                    <SectionContent>

                        <div className="card-body">
                            <div className="box-header">
                                <button  type="submit" className="btn btn-primary">Adicionar nova atividade</button>
                            </div>
                        </div>

                        <CurriculoTable
                                    className="table table-bordered table-hover"
                                    curriculo={this.state.curriculo} />
                    </SectionContent> 
                                
                </div>
            </>
        )
    }
}



export default Curriculo
