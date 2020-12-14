import React from 'react' 


function CurriculoTable(props){

	  const row = props.curriculo.map ( Curriculo => {
	  	return(
             <tr key = {Curriculo.id_curriculo}>
                        <td>{Curriculo.escolaridade}</td>
                        <td>{Curriculo.formacao}</td>  
                        <td>{Curriculo.matricula}</td>                  
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