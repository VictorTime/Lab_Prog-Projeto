import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'
import UsuarioComponente from './components/UsuarioComponent'

import Atividades from './views/atividades'
import Curriculo    from './views/Curriculo'


function Rotas(props) {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/atividades" component = {Atividades}/>
                   <Route path = "/curriculo" component = {Curriculo}/>
                   <Route path = "/usuario" component = {UsuarioComponente} ></Route>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas