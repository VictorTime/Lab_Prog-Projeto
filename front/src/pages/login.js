import React from 'react'
import UsuarioService from '../services/UsuarioService';


class Login extends React.Component {      

  constructor(props){
    super(props)
    this.state={ email :' ',senha :''};

    this.handleChangeEmail = this.handleChangeEmail.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChangeSenha = this.handleChangeSenha.bind(this);

    this.service = new UsuarioService()
  }

  handleChangeEmail(event) {
    this.setState({email: event.target.value});
  }

  handleChangeSenha(event) {
    this.setState({senha: event.target.value});
  }

  handleSubmit(event) {

    let isMounted = true;
    const usuario ={
      email: this.state.email,
      senha: this.state.senha
    }
    var store = require('store')
    this.service.autenticar(usuario)
        .then((response) => {
            console.log(response.data)
            if (isMounted) this.setState( {usuario:response.data})
            store.set('usuario',response.data)
            console.log(store.get('usuario'))
        }).catch ((erro) =>{
          alert("o login inválido");
          event.preventDefault();
          console.log(erro)
          window.document.location='#/login' 
        })
        window.document.location='#/curriculo' 
    isMounted = false;  

  }
  
    render() {
      <body className="login-page" data-new-gr-c-s-check-loaded="14.987.0" data-gr-ext-installed="" ></body>  
      return (

      <div className ="content-wrapper">
        <section className="content-header">
          <div className="container-fluid">
            <div className="row mb-8">
              <div className="col-sm-6"></div>
            </div>
          </div>
        
       <div className="login-box" >
        <div className="login-logo">
          Portifolio
        </div>
        <div className ="card">
          <div className="card-body login-card-body">
            <p className="login-box-msg">Login</p>
            
            <form onSubmit={this.handleSubmit}>
              <div className="input-group mb-3">
                <input type="email" className="form-control" placeholder="Email" 
                value={this.state.email} onChange={this.handleChangeEmail}/>
                <div className="input-group-append">
                  <div className="input-group-text">
                    <span className="fas fa-envelope"></span>
                  </div>
                </div>
              </div>

              
              <div className="input-group mb-3">
                <input type="password" className="form-control" placeholder="Senha" 
                value={this.state.senha} onChange={this.handleChangeSenha}/>
                <div className="input-group-append">
                  <div className="input-group-text">
                    <span className="fas fa-lock"></span>
                  </div>
                </div>
              </div>

              <div className="row">
                <div className="col-4">
                <button type="submit" className="btn btn-primary btn-block">Entrar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <p className="mb-0">
          <a href="#/cadastro" className="btn btn-primary btn-block">Criar uma conta Aluno</a>
        </p>
       </div>
       </section>
      </div>
       
      )
    }
  }
export default Login