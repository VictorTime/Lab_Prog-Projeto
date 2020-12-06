import React from 'react'


import AtividadesTable from '../views/atividadestable'
import SectionContent from '../views/sectionContent'

import AtividadeService from '../views/AtividadeService'

class Atividades extends React.Component{

    state = {
        ativiades : [],
        ativ1 : 1,
        ativ2: 2

    }

    constructor() {
        super()
        this.service = new AtividadeService()
    }

    salvar = () => {
        
    }

    componentDidMount() {
        localStorage.setItem("_usuario", JSON.stringify(57))

        this.service.obterInvestimentos(JSON.parse(localStorage.getItem("_usuario")))
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
                <input value={this.state.ativ1}
                        onChange={(e) => {this.setState( {ativ1 : e.target.value} )}} />

                <div className="content-wrapper">
                    <AtividadesTable 
                                    className="table table-bordered table-hover"
                                    atividades={this.state.atividades} />
                    <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2">
                        <div className="col-sm-6">
                            <h1>Atividades</h1>
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
