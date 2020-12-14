import React, { Component } from 'react'
import AtividadeService from '../services/AtividadeService'

export class CadastroAtividade extends Component {

    state = {
        id_atv:"213213",
        tipo_atv:"sadsasdas",
        resumo:"dasdasd",
        link:"asdasdas",
        titulo:"asdasdas"
    }

    constructor(props){
        super(props)
        this.service = new AtividadeService()

        this.handleClick = this.handleClick.bind(this);
        }
    
    handleClick() {
    this.setState(state => ({
      isToggleOn: !state.isToggleOn
    }));
    }
    salvar(){
        const atividade ={
            id_atv: Math.floor(Math.random()*10000),
            tipo_atv: this.state.tipo_atv,
            resumo: this.state.resumo,
            link: this.state.link,
            titulo: this.state.titulo
        }
        
        console.log(atividade)
        this.service.salvar(atividade)
            .then((response) => {
                console.log(response.data)
                this.setState( {usuario:response.data})
            }).catch ((erro) =>{
                console.log(erro)
            })
      }

    render() {
        <body className="hold-transition register-page" data-new-gr-c-s-check-loaded="14.987.0" data-gr-ext-installed=""></body>
        return (
           <div className ="content-wrapper">
               <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-2"></div>
                    </div>
                    </section>
                <div className="cadastro_atv-box">
                    <div className="cadastro_atv-logo">
                    </div>

                    <div className="card">
                        <div className="card-body register-card-body">
                            <p className="login-box-msg">Novo cadastro de Atividade no Portifolio</p>
                        </div>

                        <form action="#/atividades">
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Tipo de Atividade" 
                            value ={this.state.tipo_atv} onChange={(e) => this.setState({tipo_atv:e.target.value})}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-envelope"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Resumo da Atividade"
                            value ={this.state.resumo} onChange={(e) => this.setState({resumo:e.target.value})}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Titulo"
                            value ={this.state.titulo} onChange={(e) => this.setState({titulo:e.target.value})}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Link para atividade"
                            value ={this.state.link} onChange={(e) => this.setState({link:e.target.value})}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="row">
                            <div className="col-4">
                                <button onClick='#/atividades' type="submit" className="btn btn-primary btn-block">Registrar</button>
                            </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default CadastroAtividade
