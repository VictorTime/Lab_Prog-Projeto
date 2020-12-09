import React from 'react'

import InvestimentoTable from './investimentoTable'
import SectionContent from '../componentes/sectionContent'

import InvestimentoService from '../services/InvestimentoService'

class Investimento extends React.Component {
    state = {
        investimentos : [],
        num1 : 1,
        num2: 2

    }

    constructor() {
        super()
        this.service = new InvestimentoService()
    }

    salvar = () => {
        
    }

    componentDidMount() {
        localStorage.setItem("_usuario", JSON.stringify(57))

        this.service.obterInvestimentos(JSON.parse(localStorage.getItem("_usuario")))
        .then( response => {
            console.log(response.data)
            this.setState( {investimentos : response.data} )
        }).catch (erro => {
            console.log(erro.response)
        })
    }

    render() {

        return (
            <>
                <input value={this.state.num1}
                        onChange={(e) => {this.setState( {num1 : e.target.value} )}} />

                <div className="content-wrapper">
                    <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2">
                        <div className="col-sm-6">
                            <h1>Investimentos</h1>
                        </div>
                        </div>
                    </div>
                    </section>

                    <SectionContent>

                        <div className="card-body">
                            <div className="box-header">
                                <button  type="submit" className="btn btn-primary">Adicionar novo investimento</button>
                            </div>
                        </div>

                        <InvestimentoTable 
                                    className="table table-bordered table-hover"
                                    investimentos={this.state.investimentos} />
                    </SectionContent> 
                            
                </div>
            </>
        )
    }
}

export default Investimento