import React ,{useState, useEffect} from 'react';
import {apiService} from 'front-desktop-api/services/api';

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