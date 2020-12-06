import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import Curriculo from './pages/Curriculo';
import Atividade from './pages/Atividade'


function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Switch>
          <Route path='/' exact component={Home} />
          <Route path='/curriculo' component={Curriculo} />
          <Route path='/atividade' component={Atividade} />
        </Switch>
      </Router>
    </>
  );
}

export default App;
