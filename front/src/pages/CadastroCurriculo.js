import React, { Component } from 'react'
import CurriculoService from '../services/CurriculoService'

export class CadastroCurriculo extends Component {

    constructor(props){
        super(props)
        this.service = new CurriculoService()
        this.state = {
            escolaridade:"",
            formacao:""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeEscolaridade = this.handleChangeEscolaridade.bind(this);
        this.handleChangeFormacao = this.handleChangeFormacao.bind(this);
    }
    

    handleChangeEscolaridade(event) {
        this.setState({escolaridade: event.target.value});
    }

    handleChangeFormacao(event) {
        this.setState({formacao: event.target.value});
    }
    
    handleSubmit(event) {

            let isMounted = true;
            const curriculo ={
                id_curriculo: Math.floor(Math.random()*10000),
                escolaridade: this.state.escolaridade,
                formacao: this.state.formacao,
                matricula:localStorage.getItem('usuario'),
            }
            

            this.service.salvar(curriculo)
                .then((response) => {
                    console.log(response.data)
                    if(isMounted) this.setState( {curriculo:response.data})
                    localStorage.setItem('curriculo',curriculo.id_curriculo)
                    window.document.location='#/atividades' 
                }).catch ((erro) =>{
                    
                    console.log(erro)
                })
            isMounted = false;
        alert('Um nome foi enviado: ' + this.state.formacao);
        event.preventDefault();
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
                            <p className="login-box-msg">Novo cadastro de Curriculo</p>
                        </div>

                        <form action="#/atividades" onSubmit={this.handleSubmit}>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Formacao"
                            value ={this.state.formacao} onChange={this.handleChangeFormacao}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Escolaridade"
                            value ={this.state.escolaridade} onChange={this.handleChangeEscolaridade}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="row">
                            <div className="col-4">
                                <button type="submit" className="btn btn-primary btn-block">Registrar</button>
                            </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
} export default CadastroCurriculo
