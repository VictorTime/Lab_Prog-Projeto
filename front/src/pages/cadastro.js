import React, { Component } from 'react'
import UsuarioService from '../services/UsuarioService'
export class Cadastro extends Component {
    
    state={
        matricula: "5555218",
        nome: "Ramassad",
        email: "samabsdasdasds@gmail.com",
        tipo: "0",
        senha: "1",   
    }

  
  constructor(){
    super()
    this.service = new UsuarioService()
    }
    
    
    
    salvar(){
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

                    <form action="#/login">

                        <div className="input-group mb-3">
                        <input type="text" className="form-control" placeholder="Matricula"
                        value ={this.state.matricula} onChange={(e) => this.setState({matricula:e.target.value})}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-envelope"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="text" className="form-control" placeholder="Nome completo"
                        value ={this.state.nome} onChange={(e) => this.setState({nome:e.target.value})}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-user"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="email" className="form-control" placeholder="Email"
                        value ={this.state.email} onChange={(e) => this.setState({email:e.target.value})}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-envelope"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="password" className="form-control" placeholder="Senha"
                        value ={this.state.senha} onChange={(e) => this.setState({senha:e.target.value})}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-lock"></span>
                            </div>
                        </div>
                        </div>
                        <div className="input-group mb-3">
                        <input type="number" className="form-control" placeholder="1 para Docente, 2 para Discente" placeholder="Tipo"
                        value ={this.state.tipo} onChange={(e) => this.setState({tipo:e.target.value})}/>
                        <div className="input-group-append">
                            <div className="input-group-text">
                            <span className="fas fa-lock"></span>
                            </div>
                        </div>
                        </div>
                        <div className="row">
                        <div className="col-4">
                            <button onClick='#/login' type="submit" className="btn btn-primary btn-block">Registrar</button>
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