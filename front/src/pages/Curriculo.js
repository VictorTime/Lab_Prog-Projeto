import React from 'react'
import CurriculoService from '../services/CurriculoService'


class Curriculo extends React.Component {

    constructor() {
        super()
        this.service = new CurriculoService()
        this.state = {
            curriculo :[]
        }
    }

    componentDidMount(){
        
        var store = require('store')
        
        if(store.get('usuario')!=null){
            this.service.obterCurriculo(store.get('usuario'))
            .then((response) => {
                console.log(response.data)
                this.setState( {curriculo:response.data} )
              
                store.set('curriculo',response.data)
               
               
            }).catch (erro =>{
                console.log(erro.response)
            })
        }else{
            alert('Login não iniciado');
            window.document.location='#/cadastrocurriculo'
        }

        console.log(this.state.curriculo)

            
    }


	render() {

        return (
            <div className="content-wrapper">
                <h1 className = "text-center">Curriculo</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> Formação</td>
                            <td> Escolaridade</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.curriculo.map(
                                curriculo => 
                                <tr key = {curriculo.id_curriculo}>
                                    <td> {curriculo.formacao}</td>   
                                    <td> {curriculo.escolaridade}</td>   
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>
        )
    }
}



export default Curriculo
