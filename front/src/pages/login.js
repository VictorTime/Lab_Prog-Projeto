import React from 'react'
import UsuarioService from '../services/UsuarioService';





class Login extends React.Component {      

      constructor(props) {
      super(props);
      this.service = new UsuarioService()
      this.state = {
        email:"",
        senha:""
      };
  
      this.handleSubmit = this.handleSubmit.bind(this);

    }
    
    componentDidMount(){
      
      this.service.autenticar(this.state.email, this.state.senha)
          .then((response) => {
            console.log(response.data)
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
              value = {this.state.email}
              onChange={(e) => this.setState({email:e.target.value})}/>
            
          </label>
          <br />
          <label>
            Senha
            <input
              type="text"
              value ={this.state.senha}
              onChange={(e) => this.setState({senha:e.target.value})}/>
          </label>
          <input type="submit" value="Enviar" />
        </form>
      );
    }
  }
export default Login