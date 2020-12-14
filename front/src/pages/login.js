import React from 'react'
import UsuarioService from '../services/UsuarioService';



class Login extends React.Component {      

  state={ 
    email :"abc@gmail.com",
    senha :"1"
  }

  
  constructor(){
    super()
    this.service = new UsuarioService()
    }

    

    componentDidMount(){
    
      const usuario ={
        email: this.state.email,
        senha: this.state.senha
      }
      
      
      this.service.autenticar(usuario)
          .then((response) => {
              console.log(response.data)
              this.setState( {usuario:response.data})
              localStorage.setItem('usuario',(response.data))
              console.log(localStorage.getItem('usuario')) 
          }).catch ((erro) =>{
              console.log(erro)
          })
    }
  
    render() {
      <body className="login-page" data-new-gr-c-s-check-loaded="14.987.0" data-gr-ext-installed="" ></body>  
      return (

      <div className ="content-wrapper">
        <section className="content-header">
          <div className="container-fluid">
            <div className="row mb-10">
              <div className="col-sm-6"></div>
            </div>
          </div>
        </section>
       <div className="login-box" >
        <div className="login-logo">
          Portifolio
        </div>
        <div className ="card">
          <div className="card-body login-card-body">
            <p className="login-box-msg">Login</p>
            
            <form>
              <div className="input-group mb-3">
                <input type="email" className="form-control" placeholder="Email" value ={this.state.email}
                  onChange={(e) => this.setState({email:e.target.value})}/>
                <div className="input-group-append">
                  <div className="input-group-text">
                    <span className="fas fa-envelope"></span>
                  </div>
                </div>
              </div>

              
              <div className="input-group mb-3">
                <input type="password" className="form-control" placeholder="Senha" value ={this.state.senha}
                onChange={(e) => this.setState({senha:e.target.value})}/>
                <div className="input-group-append">
                  <div className="input-group-text">
                    <span className="fas fa-lock"></span>
                  </div>
                </div>
              </div>

          <div className="row">
            <div className="col-4">
            <button href="#/" onClick={this.entrar} type="submit" className="btn btn-primary btn-block">Entrar</button>
          </div>
        </div>
            </form>
          </div>
        </div>
        <p className="mb-0">
          <a href="#/cadastro" className="text-center">Criar uma conta</a>
        </p>
       </div>
      </div>
       
      )
    }
  }
export default Login