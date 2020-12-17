import React from 'react'

class NameForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {email: ''};
  
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {
      this.setState({email: event.target.value});
    }
  
    handleSubmit(event) {
      alert('Um nome foi enviado: ' + this.state.email);
      event.preventDefault();
    }
    
    render() {
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
            Nome:
            <input type="text" value={this.state.email} onChange={this.handleChange} />
          </label>
          <input type="submit" value="Enviar" />
        </form>
      );
    }
  }export default NameForm