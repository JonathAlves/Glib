import React from 'react'
import './Tela-inicial.css'

export default function ContainerInicio(){
    return (
        <React.Fragment>
            <div className='inicio'>

                <div className='box'>
                    <h1 id='titulo'>GLIB</h1>
                    <h4 id='subtitulo'>Biblioteca de games</h4>
                        <form action='/usuarios' className='forms'>
                            <input type="text" name="email" id="email" placeholder='Digite o usuário ou email'/>
                            <input type="password" name="senha" id="senha" placeholder='Digite sua senha'/>
                            <button className='button' type='submit'>Fazer login</button>
                        </form>
                </div>
            </div>
        </React.Fragment>
    )
}