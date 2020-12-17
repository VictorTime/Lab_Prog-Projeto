import React, { Component } from 'react'
import UsuarioService from '../services/UsuarioService'
export class Cadastro extends Component {
  constructor(){
    super()
    this.service = new UsuarioService()
    this.state={
        matricula: "",
        nome: "",
        email: "",
        tipo: "",
        senha: "", 
    }

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChangeMatricula =  this.handleChangeMatricula.bind(this);
    this.handleChangeNome = this.handleChangeNome.bind(this);
    this.handleChangeEmail = this.handleChangeEmail.bind(this);
    this.handleChangeTipo = this.handleChangeTipo.bind(this);
    this.handleChangeSenha = this.handleChangeSenha.bind(this);
    }
    
    handleChangeMatricula(event) {
        this.setState({matricula: event.target.value});
    }
    
    handleChangeNome(event) {
        this.setState({nome: event.target.value});
    }

    handleChangeEmail(event) {
        this.setState({email: event.target.value});
    }

    handleChangeTipo(event) {
        this.setState({tipo: event.target.value});
    }

    handleChangeSenha(event) {
        this.setState({senha: event.target.value});
    }
        
    handleSubmit(event) {
        let isMounted = true;
        const usuario ={
            matricula: this.state.matricula,
            nome: this.state.nome,
            email: this.state.email,
            tipo: this.state.tipo,
            senha: this.state.senha,
        }
  
        this.service.salvar(usuario)
            .then((response) => {
                console.log(response.data)
                if (isMounted) this.setState( {usuario:response.data})
                window.document.location='#/login'
            }).catch ((erro) =>{
                console.log(erro)
            })
        isMounted = false
        alert('Um nome foi enviado: ' + this.state.email);
        event.preventDefault();


      
    }
    
    render() {
        <body className="hold-transition register-page" data-new-gr-c-s-check-loaded="14.987.0" data-gr-ext-installed=""></body>
        return (
            <div className ="content-wrapper">
                <section className="content-header">
                    <div className="container-fluid">
                        <div className="row mb-10">
                        <div className="col-sm-6"></div>
                        </div>
                    </div>
                </section>
            <div className="cadastro-box">
                
                <div className="cadastro-logo">
                </div>

                <div className="card">
                    <div className="card-body register-card-body">
                        <p className="login-box-msg">Novo Usuario No Portifolio</p>
                    </div>

                    <form action="#/login" onSubmit={this.handleSubmit} >

                        <div className="input-group mb-3">
                        <input type="number" className="form-control" placeholder="Matricula"
                        value ={this.state.matricula} onChange={this.handleChangeMatricula}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-envelope"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="text" className="form-control" placeholder="Nome Completo"
                        value ={this.state.nome} onChange={this.handleChangeNome}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-user"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="email" className="form-control" placeholder="Email"
                        value ={this.state.email} onChange={this.handleChangeEmail}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-envelope"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="password" className="form-control" placeholder="Senha"
                        value ={this.state.senha} onChange={this.handleChangeSenha}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-lock"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="number" className="form-control" placeholder="1 para Docente, 2 para Discente" placeholder="Tipo"
                        value ={this.state.tipo} onChange={this.handleChangeTipo}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-lock"></span>
                            </div>
                        </div>
                        </div>
                        <div className="row">
                        <div className="col-4">
                            <button href="#/login" type="submit" className="btn btn-primary btn-block">Registrar</button>
                        </div>

                        </div>
                    </form>
                </div>
            </div>
            </div>
        )
    }
}

export default Cadastro