import React from 'react' 


function CurriculoTable(props){

	  const row = props.curriculos.map ( Curriculo => {
	  	return(
             <tr key = {Curriculos.id_curriculo}>
                        <td>{Curriculos.escolaridade}</td>
                        <td>{Curriculos.formacao}</td>  
                        <td>{Curriculos.matricula}</td>                  
                        <td>
                            <div class="btn-group">
                                <button onclick="window.location.href=&#39;form_posicao.html&#39;" type="button" class="btn btn-info">Adicionar Posição</button>
                                <button onclick="window.location.href=&#39;form_curriculo.html&#39;" type="button" class="btn btn-warning">Editar</button>
                                <button onclick="button" class="btn btn-danger">Remover</button>
                          </div>                        
                     </td>
               
               </tr>


	  		 )
	  })


      return (
          <table id="example1" {...props}>
                  <thead>
                  <tr>
                    <th>matricula</th>
                    <th>formacao</th>
                    <th>escolaridade</th>
                  </tr>
                  </thead>
                  <tbody>
                       {row}
                  </tbody>

          </table>


      	)

}


export default CurriculoTable