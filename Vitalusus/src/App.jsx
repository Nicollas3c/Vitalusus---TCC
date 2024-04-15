import { useState } from 'react'
import './App.css'

function App() {
  const [egua, setEgua] = useState(300)
  const removeEgua = ()=>{
    setEgua(egua-1)
    if (egua<=0) setEgua(0)
  }
  let eguaString = ' POCOTÓ RESTANTE'
  let mensagem = ''
  let imagem = ''
  let imagemCavalo = document.getElementById('pocoto')

  if (egua==0){
    mensagem = 'Jumpscare de égua!'
    imagem = 'https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia16043/caracteristicas-cavalos-saudaveis-artigos-cursos-cpt.jpg'
    imagemCavalo.className='cavalo'
  }
  
  if (egua>1 || egua==0)
  eguaString=' POCOTÓS RESTANTES'


  return(
  <div className='App'>
    <h1>INVOCAÇÃO DE ÉGUAS</h1>
    <h3>{egua}{eguaString}</h3>
    <h3>{mensagem}</h3>
    <img id='pocoto' src={imagem}></img>
    <br/>
    <button onClick={removeEgua} className='btn btn-primary'>POCOTÓ</button>
  </div>
  )
}

export default App
