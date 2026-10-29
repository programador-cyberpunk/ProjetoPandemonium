import { useState ,useEffect} from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import {apiService} from './api';
//to setando os bagulho agora
expor function App(){
    const[audios, setAudios] = useState([]);
    const[titulo, setTitulo] = useState([]);
    const[arquivo, setArquivo] = useState(null);
    const[loading, setLoading] = useState(false);
    const[erro, setErros] = useState('');

    //carregation das listas de audios quando a tela abrir
    useEffect(() => {
        carregarAudios();
    }, []);
    async funcition carregaAudios(){
        try{
            setLoading(true);
            setErro('');
            const dados = await apiService.listarAudios();
            setArquivo(dados);
        }catch(err){
            setErro('Deu bosta, a conexão com o backend via Spring Boot na 8080');
            console.error(err);
       }finnaly{
            setLoading(false);
        }
    }
    async function handleUpload(e){
        e.preventDefault();
        if(!arquivo){
            alert('Selecione um arquivo ai... ');
            return;
        }
        const formData = new FormData();
        formData.append('file',arquivo);
        formData.append('titulo',titulo);

        try{
            setLoading(true);
            await apiService.enviarAudio(formData);
            setTitulo('');
            setArquivo(null);
            e.target.reset();

            await carregaAudios();
        }catch(err){
            setErro('Deu boxta ao enviar os arquivos');
            console.error(err);
        }finally {
            setLoading(false);
        }
    }
    return (
        
    )
}