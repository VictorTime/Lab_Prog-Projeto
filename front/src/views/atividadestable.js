import React from 'react' 


function AtividadesTable(props){

	  const row = props.atividades.map ( Atividades => {
	  	return(
             <tr key = {Atividades.id}>
                        <td>{Atividades.nome}</td>
                        <td>{Atividades.qnt_questoes}</td>  
                        <td>{Atividades.data}</td>                  
                        <td>
                            <div class="btn-group">
                                <button onclick="window.location.href=&#39;form_posicao.html&#39;" type="button" class="btn btn-info">Adicionar Posição</button>
                                <button onclick="window.location.href=&#39;form_atividade.html&#39;" type="button" class="btn btn-warning">Editar</button>
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
                    <th>Nome</th>
                    <th>Questoes:</th>
                    <th>Horario (Data)</th>
                    <th>Opções</th>
                  </tr>
                  </thead>
                  <tbody>
                       {row}
                  </tbody>

          </table>


      	)

}


export default AtividadesTable