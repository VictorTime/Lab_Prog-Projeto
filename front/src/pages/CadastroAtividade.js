import React, { Component } from 'react'
import AtividadeService from '../services/AtividadeService'

export class CadastroAtividade extends Component {

    constructor(props){
        super(props)
        this.service = new AtividadeService()
        this.state = {
            id:"",
            tipo:"",
            resumo:"",
            link:"",
            titulo:""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeId =  this.handleChangeId.bind(this);
        this.handleChangeTipo = this.handleChangeTipo.bind(this);
        this.handleChangeResumo = this.handleChangeResumo.bind(this);
        this.handleChangeLink = this.handleChangeLink.bind(this);
        this.handleChangeTitulo = this.handleChangeTitulo.bind(this);
    }
    
    handleChangeId(event) {
        this.setState({id: event.target.value});
    }
    handleChangeTipo(event) {
        this.setState({tipo: event.target.value});
    }

    handleChangeResumo(event) {
        this.setState({ resumo: event.target.value});
    }

    handleChangeLink(event) {
        this.setState({link: event.target.value});
    }

    handleChangeTitulo(event) {
        this.setState({titulo: event.target.value});
    }
    
    handleSubmit(event) {

            let isMounted = true;
            const atividade ={
                id_atv: Math.floor(Math.random()*10000),
                tipo_atv: this.state.tipo,
                resumo: this.state.resumo,
                link: this.state.link,
                titulo: this.state.titulo,
                matricula:localStorage.getItem('usuario'),
            }
            

            this.service.salvar(atividade)
                .then((response) => {
                    console.log(response.data)
                    if(isMounted) this.setState( {atividade:response.data})
                    window.document.location='#/atividades' 
                }).catch ((erro) =>{
                    console.log(erro)
                })
            isMounted = false;
        alert('Um nome foi enviado: ' + this.state.titulo);
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
                            <p className="login-box-msg">Novo cadastro de Atividade no Portifolio</p>
                        </div>

                        <form action="#/atividades" onSubmit={this.handleSubmit}>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Tipo de Atividade" 
                            value ={this.state.tipo_atv} onChange={this.handleChangeTipo}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-envelope"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Resumo da Atividade"
                            value ={this.state.resumo} onChange={this.handleChangeResumo}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Titulo"
                            value ={this.state.titulo} onChange={this.handleChangeTitulo}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-lock"></span>
                                </div>
                            </div>
                            </div>
                            <div className="input-group mb-3">
                            <input type="text" className="form-control" placeholder="Link para atividade"
                            value ={this.state.link} onChange={this.handleChangeLink}/>
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
}

export default CadastroAtividade
