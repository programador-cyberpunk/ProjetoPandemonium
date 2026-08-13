import React ,{useState, useEffect} from 'react';
import {apiService} from 'front-desktop-api/services/api';

// vou testar o chamado por enquanto, mas
// honestamente essa eh a parte mais que se foda do
// meu projeto inteiro, a parte daora ainda esta por vir
export default function App(){
    const[chamados, setChamados] = useState([]);
    const[arquivo, setArquivo] = useState(null);
    const[status, setStatus] = useState('Carregando... Guentai');

        useEffect(() =>{
            carregarChamados();
        }, []);

    const carregarChamados = async () =>{
        try{
            const dados = await apiService.listarChamados();
            setChamados(dados);
            setStatus('Conectado a API,gg pa caraio');
        } catch(err){
            setStatus('Deu bosta, erro de conexão no back-end');
        }
    };

    const handleUpload = async(e) =>{
        e.preventDefault();
            if(!arquivo){
                alert('Selecione um audio primeiro');
                return;
            }
    try{
       setStatus('Enviado arquivo...guentai') ;
       await apiService.enviarAudio(arquivo);
       alert('Audio enviado com sucesso!');
       setArquivo(null);
       carregarChamados();
    } catch(err){
      alert('Deu ruim ao enviar o audio');
    }   finally {
       setStatus('Conectado a API, gg pa caraio');
    }
    };
}

// vem o design agora, ta meio generico mas eu vou personalizar
return(
    <div style={styles.container}>
        <header style={styles.header}>
            <h1 style={styles.title}>Pandemonium</h1>
            <span style={styles.statusBadge}>{status}</span>
        </header>

        <main style={styles.grid}>
            
        </main>
    </div>
)