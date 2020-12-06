import React from 'react'
import UsuarioService from '../services/UsuarioService';

class UserComponent extends React.Component {

    constructor(){
        super()
        this.service = new UsuarioService.service()
        }


    componentDidMount(){
        this.service.obterUsuarios()
            .then((response) => {
                console.log(response.data)
                this.setState( {usuario:response.data}  )
            }).catch (erro =>{
                console.log(erro.response)
            })
    }

    
    render (){
        return (
            <div>
                <h1 className = "text-center"> Users List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> Usuario Matricula</td>
                            <td> Usuario Nome</td>
                            <td> Usuario Email</td>
                            <td> Usuario Tipo</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.usuario.map(
                                usuario => 
                                <tr key = {usuario.matricula}>
                                     <td> {usuario.nome}</td>   
                                     <td> {usuario.email}</td>   
                                     <td> {usuario.tipo}</td>   
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}

export default UserComponent