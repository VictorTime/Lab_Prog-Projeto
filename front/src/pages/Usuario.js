
import React from 'react'
import UsuarioService from '../services/UsuarioService';


class Usuario extends React.Component {

    constructor(props){
        super(props)
        this.service = new UsuarioService()
        this.state={
            usuario:[]
            }
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
            <div className="content-wrapper">
                <h1 className = "text-center">Lista de Usuarios</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Nome</td>
                            <td> Email</td>
                            <td> Tipo</td>
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

export default Usuario