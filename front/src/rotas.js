import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'
import Usuario from './pages/Usuario'
import Cadastro from './pages/Cadastro'
import Atividades from './pages/Atividades'
import Curriculo    from './pages/Curriculo'
import Login from './pages/Login'
import CadastroAtividade from './pages/CadastroAtividade'
import NameForm from './pages/NameForm'
import CadastroCurriculo from './pages/CadastroCurriculo'

//Define as urls que poderão ser acessadas
function Rotas() {
	return (

          <HashRouter>
              <Switch>
                   <Route path = "/cadastroatividade" component ={CadastroAtividade}/>
                   <Route path = "/atividades" component = {Atividades}/>
                   <Route path = "/curriculo" component = {Curriculo}/>
                   <Route path = "/usuario" component = {Usuario} />
                   <Route path = "/cadastro" component = {Cadastro}/>
                   <Route path = "/login" component ={Login}/>
                   <Route path = "/form" component = {NameForm}/>
                   <Route path = "/cadastrocurriculo" component = {CadastroCurriculo}/>
              </Switch>
          </HashRouter>
                   
		)
}

export default Rotas