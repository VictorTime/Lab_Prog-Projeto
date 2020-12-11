import React from 'react'
import UsuarioService from '../services/UsuarioService';


class Login extends React.Component {      

  state={
    usuario:{
          matricula: "37183718",
          nome: "Ramesh",
          email: "samabaias@gmail.com",
          tipo: "0",
          senha: "1",
        }
  }

  constructor(){
    super()
    this.service = new UsuarioService()
    }
    componentDidMount(){
      
      console.log(JSON.stringify(this.state.usuario))
      this.service.salvar(JSON.stringify(this.state.usuario))
          .then((response) => {
              console.log(response.data)
              this.setState( {usuario:response.data})
          }).catch ((erro) =>{
              console.log(erro)
          })
  }
   
  
    render() {
      return (
        <form>
          <label>
           Email:
            
          </label>
          <br />
          <label>
            Senha
            
          </label>
          
        </form>
      )
    }
  }
export default Login