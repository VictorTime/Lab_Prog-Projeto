import React from 'react'

class Login extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        email:"",
        senha:""
      };
  
      this.handleSubmit = this.handleSubmit.bind(this);

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
              email = {this.state.email}
            />
          </label>
          <br />
          <label>
            Senha
            <input
              type="text"
              senha={this.state.senha}
             />
          </label>
          <input type="submit" value="Enviar" />
        </form>
      );
    }
  }
export default Login