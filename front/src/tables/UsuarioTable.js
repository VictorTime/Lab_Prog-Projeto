import React from 'react' 

function UsuariosTable(props){

	  const row = props.Usuarios.map ( Usuarios => {
	  	return(
             <tr key = {Usuarios.matricula}>
                        <td>{Usuarios.nome}</td>
                        <td>{Usuarios.email}</td>  
                        <td>{Usuarios.tipo}</td>                  
                        <td>
                            <div class="btn-group">
                                <button onclick="window.location.href=&#39;#/usuario&#39;" type="button" class="btn btn-info">Adicionar Posição</button>
                                <button onclick="window.location.href=&#39;#/usuario&#39;" type="button" class="btn btn-warning">Editar</button>
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


export default UsuariosTable