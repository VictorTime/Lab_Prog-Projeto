import React from 'react' 


function AtividadesTable(props){

	  const row = props.atividades.map ( Atividades => {
	  	return(
             <tr key = {Atividades.id_atv}>
                        <td>{Atividades.tipo_atv}</td>
                        <td>{Atividades.resumo}</td>  
                        <td>{Atividades.link}</td>
                        <td>{Atividades.titulo}</td>                  
                        <td>                   
                     </td>
               
               </tr>


	  		 )
	  })


      return (
          <table id="example1" {...props}>
                  <thead>
                  <tr>
                    <th>Tipo de Atividade</th>
                    <th>Resumo </th>
                    <th>Link </th>
                    <th>Titulo </th>
                  </tr>
                  </thead>
                  <tbody>
                       {row}
                  </tbody>

          </table>


      	)

}


export default AtividadesTable