import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'

import Atividades from './views/atividades'
import posicao    from './views/posicao'


function Rotas(props) {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/atividades" conponent = {Atividades}/>
                   <Route path = "/posicao" conponent = {posicao}/>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas