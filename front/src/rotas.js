import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'

import Atividades from './views/atividades'
import Curriculo    from './views/Curriculo'


function Rotas(props) {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/atividades" conponent = {Atividades}/>
                   <Route path = "/curriculo" conponent = {Curriculo}/>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas