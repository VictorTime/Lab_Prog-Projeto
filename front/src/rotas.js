import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'
import Usuario from './pages/Usuario'

import Cadastro from './pages/cadastro'
import Atividades from './pages/atividades'
import Curriculo    from './pages/Curriculo'
import Login from './pages/login'

//Define as urls que poderão ser acessadas
function Rotas(props) {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/atividades" component = {Atividades}/>
                   <Route path = "/curriculo" component = {Curriculo}/>
                   <Route path = "/usuario" component = {Usuario} />
                   <Route path = "/cadastro" component = {Cadastro}/>
                   <Route path = "/login" component ={Login}/>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas