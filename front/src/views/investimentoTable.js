import React from 'react'

function InvestimentoTable(props) {

    const row = props.investimentos.map ( investimento => {
        return (
            <tr key={investimento.id}>
                <td>{investimento.nome}</td>
                <td>
                    <div className="btn-group">
                        <button  type="button" className="btn btn-info">Adicionar Posição</button>
                        <button  type="button" className="btn btn-warning">Editar</button>
                        <button  type="button" className="btn btn-danger">Remover</button>
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
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
                {row}
            </tbody>
        </table>
    )
}

export default InvestimentoTable