import React from 'react'
import UsuarioService from '../services/UsuarioService';


class Login extends React.Component {      

      constructor(props) {
      super(props);
      this.service = new UsuarioService()
      this.state = {
        usuario:{email:"", senha:""},
        email:"",
        senha:""
        
      };

    }

    
    componentDidMount(){
      
      const user = {
        email: "rameshsss@gmail.com",
        senha: "1",
      };

      const headers = {
        option : {
            "Access-Control-Allow-Origin": false
        }
      }
      console.log("aq");
  
      const newuser = JSON.stringify(user)
      console.log(user);
      console.log(newuser);
      this.service.autenticar(newuser, headers)
          .then((response) => {
              console.log(response.data)
              this.setState( {curriculo:response.data}  )
          }).catch (erro =>{
              console.log(erro.response)
          })
  }
    somar = () => {
      const resultado = parseInt(this.state.email) 
                        + parseInt(this.state.senha)
      this.setState({soma : resultado}) 
    }
    handleChange(event) {
      this.setState({value: event.target.value});
    }
  
    handleSubmit(event) {
      alert('A name was submitted: ' + this.state.value);
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
              O nome digitado foi: {this.state.email}
          </label>
          <br />
          <label>
            Senha
            <input
              type="text"
              value ={this.state.senha}
              onChange={(e) => this.setState({senha:e.target.value})}/>
              O nome digitado foi: {this.state.senha}
          </label>
          <br />          
            {this.state.senha} + {this.state.email} = {this.state.soma}
          <br />
            <button onClick={this.somar}>Somar</button>     
        </form>
      );
    }
  }
export default Login