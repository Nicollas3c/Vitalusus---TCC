function Tabela({vetor}) {
  return(
   <table className="table">
    <thead>
        <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Senha</th>
        <th>Foto</th>
        <th>NivelAcesso</th>
        <th>StatusUsuario</th>
        <th>TipoUsuario</th>
        <th>DataCadastro</th>
        </tr>
    </thead>
    <tbody>
        {
            vetor.map((obj) =>(
                <tr>
                    <td>{obj.id}</td>
                    <td>{obj.nome}</td>
                    <td>{obj.email}</td>
                    <td>{obj.senha}</td>
                    <td>{obj.foto}</td>
                    <td>{obj.nivelAcesso}</td>
                    <td>{obj.statusUsuario}</td>
                    <td>{obj.tipoUsuario}</td>
                    <td>{obj.dataCadastro}</td>
                </tr>
            ))
        }
    </tbody>
   </table>
  )
}
export default Tabela;
