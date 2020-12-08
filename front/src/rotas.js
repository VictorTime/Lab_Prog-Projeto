import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'
import Usuario from './pages/Usuario'

import Atividades from './pages/atividades'
import Curriculo    from './pages/Curriculo'


function Rotas(props) {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/atividades" component = {Atividades}/>
                   <Route path = "/curriculo" component = {Curriculo}/>
                   <Route path = "/usuario" component = {Usuario} ></Route>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas