import React from 'react'
import UsuarioService from '../services/UsuarioService';

class Login extends React.Component {
      


      constructor() {
      super();
      this.service = new UsuarioService()
      this.state = {
        usuario : {email :"" , senha: ""},
        email:"",
        senha:""
      };
  
      this.handleSubmit = this.handleSubmit.bind(this);

    }
    
    componentDidMount(){

      this.service.autenticar(this.state.usuario)
          .then((response) => {
              console.log(response.data)
              this.setState( {usuario:response.data}  )
          }).catch (erro =>{
              console.log(erro.response)
          })
  }
    handleSubmit(event) {
        alert('email foi ' + this.state.email);
        event.preventDefault();
      }
  
    render() {
      return (
        <form>
          <label>
           Email:
            <input
              type="text"
              email = {this.state.usuario.email}
            />
          </label>
          <br />
          <label>
            Senha
            <input
              type="text"
              senha={this.state.usuario.senha}
             />
          </label>
          <input type="submit" value="Enviar" />
        </form>
      );
    }
  }
export default Login