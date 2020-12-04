import React from 'react'


import AtividadesTable from '../views/atividadestable'
import SectionContent from '../views/sectioncontent'

class Atividades extends React.Component{
	render(){

        const data = [
        	{id: 1, nome: 'atividade 1', qnt_questoes: '5', data: '12/10/2020'},
            {id: 2, nome: 'atividade 2', qnt_questoes: '3', data: '20/10/2020'},
        		
        ]

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
				             </div> 
				             </div>    
				              
				            <SectionContent>  
					            <div className="card-body">
					                <div className="box-header">
					                        <button type="submit" className="btn btn-primary">Adicionar novo investimento</button>
					                </div>
					  
					            </div>

					                <atividadestable 

	                                      className = "table table-bordered table-hover"
					                      atividades = {data} />

				            </SectionContent>
				     
             	</div>
			</div>
		)
	}
} 

export default Atividades
