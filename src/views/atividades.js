import React from 'react'

import NavBar from '../views/navbar'
import Sidebar from '../views/sidebar'
import AtividadesTable from '../views/atividadestable'

class Usuario extends React.Component{
	render(){
		return (
			<div>
                <NavBar href = "#" label = "Home" />
                <Sidebar/>


              <div className="content-wrapper">
                  <section className="content-header">
                  <div className="container-fluid">
                     <div className="row mb-2">
                     <div className="col-sm-6">
                        <h1>Atividades</h1>
                     </div>
                     </div>
                   </div>
                   </section>
              </div>

              <section className="content">
              <div class="container-fluid">
                    <div className="row">
                    <div className="col-12">

			            <div className="card">
			              <div className="card-header">
			                <h3 className="card-title"></h3>

			                <div className="card-tools">
			                   <button type="button" className="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
			                        <i className="fas fa-minus"></i></button>
			                   <button type="button" className="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
			                        <i className="fas fa-times"></i></button>
			                </div>
			              </div>        
			              
			            <div className="card-body">
			                <div className="box-header">
			                        <button type="submit" className="btn btn-primary">Adicionar novo investimento</button>
			                </div>
			  
			            </div>
			            </div>
			        </div>
			        </div>
			   </div>
			   </section>

			</div>
		)
	}
} 

export default Usuario
