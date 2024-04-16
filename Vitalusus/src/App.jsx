import { useState } from 'react'
import './App.css'

function App() {
  const [egua, setEgua] = useState(300)
  const removeEgua = ()=>{
    setEgua(egua-1)
    if (egua<=0) setEgua(0)
  }
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
  )
}

export default App
