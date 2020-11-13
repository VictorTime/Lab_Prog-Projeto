import logo from './logo.svg';
import './App.css';
import React from 'react';

class App extends React.Component {
  state = {
    nome : ''
  }
  render() {
    return(
      <div>
        <label> Nome:</label>
        <input type="text" value={this.state.nome} />          
      </div>
    )
  }
}
export default App;