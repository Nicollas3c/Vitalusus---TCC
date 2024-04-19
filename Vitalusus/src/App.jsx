import { useEffect, useState } from "react";
import "./App.css";
import Tabela from "../Tabela";


function App() {
  const [usuarios, setUsuarios] = useState([])
  useEffect(()=>{
    fetch('http://localhost:8080/vitalusus/usuario/findAll')
    .then(retorno => retorno.json())
    .then(retornoJson => setUsuarios(retornoJson))
  }
<<<<<<< HEAD
  let eguaString = ' QI RESTANTE'
  let mensagem = ''
  let imagem = ''
  let imagemCavalo = document.getElementById('pocoto')

  if (egua==0){
    mensagem = 'Kennedy Invocado!... O que você fez!?'
    imagem = 'kennedy2-removebg-preview.png'
    imagemCavalo.className='cavalo'
  }
  
  if (egua>1 || egua==0)
  eguaString=' QI RESTANTE'


  return(
  <div className='App'>
    <h1>COMO INVOCAR UM KENNEDY, TUTORIAL ATUALIZADO 2024</h1>
    <h3>{egua}{eguaString}</h3>
    <h3>{mensagem}</h3>
    <img id='pocoto' src={imagem}></img>
    <br/>
    <button onClick={removeEgua} className='btn btn-primary'>USAR DORGAS</button>
  </div>
=======
)
  return(
   <div className="App">
    <Tabela vetor = {usuarios}/>
   </div>
>>>>>>> frontend
  )
}

export default App;
