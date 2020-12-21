import React, { Component } from 'react'
import AtividadeService from '../services/AtividadeService'

export default class RemoverAtv extends Component {
    constructor(props){
        super(props)
        this.service = new AtividadeService()
        this.state = {
            id:"",
        }
        this.handleChangeId =  this.handleChangeId.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeId(event) {
        this.setState({id: event.target.value});
    }
    
    handleSubmit(event) {

        let isMounted = true;
        const atv ={
            id:this.state.id
        }
        this.service.remover(atv)
            .then((response) => {
                console.log(response.data)
                alert("Atividade removido");
                event.preventDefault();

            }).catch ((erro) =>{
              alert("Id Invalido");
              event.preventDefault();
              console.log(erro)
              window.document.location='#/atividades' 
            })
            window.document.location='#/atividades' 
        isMounted = false;  
    
      }

    render() {
        <body className="hold-transition register-page" data-new-gr-c-s-check-loaded="14.987.0" data-gr-ext-installed=""></body>
        return (
            <div>
                <div className ="content-wrapper">
               <section className="content-header">
                    <div className="container-fluid">
                        <div className="row">
                        <div className="card">
                        <div className="card-body register-card-body">
                            <p className="login-box-msg">Pagina de Remoção de Atividade</p>
                        </div>

                        <form action="#/atividades" onSubmit={this.handleSubmit}>
                            <div className="input-group mb-3">
                            <input type="number" className="form-control" placeholder="ID da Atividade" 
                            value ={this.state.id} onChange={this.handleChangeId}/>
                            <div className="input-group-append">
                                <div className="input-group-text">
                                <span className="fas fa-envelope"></span>
                                </div>
                            </div>
                            </div>
                            <div className="row">
                            <div className="col-4">
                                <button type="submit" className="btn btn-primary btn-block">Registrar</button>
                            </div>
                            </div>
                        </form>
                        </div>
                        </div>
                    </div>
                </section>
            </div>
                        
            </div>
        )
    }
}
