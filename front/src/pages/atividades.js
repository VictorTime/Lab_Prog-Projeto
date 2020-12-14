import React from 'react'


import AtividadesTable from '../tables/AtividadesTable'
import SectionContent from '../views/sectionContent'

import AtividadeService from '../services/AtividadeService'
import { Link } from 'react-router-dom'

class Atividades extends React.Component{

    
    state = {
        atividades : []
    }

    constructor() {
        super()
        this.service = new AtividadeService()
    }

    salvar = () => {
        
    }

    componentDidMount() {
        
        //this.service.obterAtividades(localStorage.getItem("_usuario"))
        this.service.obterAtividadesAll()
        .then( response => {
            console.log(response.data)
            this.setState( {atividades : response.data} )
        }).catch (erro => {
            console.log(erro.response)
        })
    }


	render() {

        return (
            <>
                <div className="content-wrapper">
                    <AtividadesTable 
                                    className="table table-bordered table-hover"
                                    atividades={this.state.atividades} />
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
                                <Link to= "/cadastroatividade">
                                <button  type="submit" className="btn btn-primary">Adicionar nova atividade</button>
                                </Link>
                            </div>
                        </div>

                        <AtividadesTable 
                                    className="table table-bordered table-hover"
                                    atividades={this.state.atividades} />
                    </SectionContent> 
                            
                </div>
            </>
        )
    }
} 

export default Atividades
