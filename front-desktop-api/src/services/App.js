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
            {/* Primeiro, o mais importante, upar essas porra*/}

            <section style={styles.card}>
                <h2 style={styles.cardTitle}Upload de som></h2>
                <form onSubmit={handleUpload}>
                    <input type="file" accept="audio/*" onChange={(e)=>
                        setArquivo(e.target.files[0])} style={styles.fileInput}/>
                <button type={"submit"} style={styles.button}> Enviar O Som</button>
                </form>
            </section>

            {/* Agora,vem as porra dos chamado que eu nem se quer lembrava que tinha feito*/}
            <section style={styles.card}>
                <h2 style={styles.cardTitle}>Gerenciador de Chamados</h2>
                {chamados.length === 0 ? (
                    <p style={{color: '#8D8D99'}}> Nenhum chamado encontrado por hora </p>
                ): (
                    <ul style={styles.list}>
                        {chamados.map((item) => (
                            <li key={item.id} style{styles.listItem}>
                                <strong>#{item.id} - {item.titulo}</strong>
                                <span style={styles.statusTag}>{item.status}</span>
                            </li>
                            ))}
                    </ul>
                )}
            </section>
        </main>
    </div>
);
    //agora vem a boniteza
    const styles = {
        container: {
            backgroundColor: '#1211214',
            color: '#E1E1E6',
            minHeight: '100vh',
            padding: '20px',
            fontFamily: 'Segoe UI, Tahoma, Geneva, Verdana, sans-serif'
        },
        header: {
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center',
            borderBottom: '15px',
            marginBottom: '20px'
        },
        title: {
            color: '#00B37E',
            fontSize: '1.7rem',
            margin: 0
        },
        statusBadge: {
            backgroundColor: '#202024',
            padding: '6px 12px',
            borderRadius: '20px',
            fontSize: '0.85rem',
            border: '1px solid #323238'
        },
        grid: {
            display: 'grid',
            gridTemplateColumns: 'repeat(auto-fix, minmax(300px, 1fr))',
            gap: '20px'
        },
        card: {
            backgroundColor: '#202024',
            padding: '20px',
            borderRadius: '8px',
            border: '1px solid #323238'
        },
        cardTitle: {
            marginTop: 0,
            fontSize: '1.2rem',
            borderBottom: '1px solid #323238',
            paddingBottom: '10px'
        },
        fileInput: {
            display: 'block',
            width: '100%',
            marginBottom: '15px',
            color: '#8D8D99'
        },
        button: {
            backgroundColor: '#00875F',
            color: '#FFF',
            border: 'none',
            padding: '12px',
            borderRadius: '4px',
            cursor: 'pointer',
            width: '100%',
            fontWeight: 'bold'
        },
        list: {
            listStyle: 'none',
            padding: 0,
            margin: 0
        },
        listItem: {
            backgroundColor: '#121214',
            padding: '12px',
            borderRadius: '4px',
            marginBottom: '8px',
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center'
        },
        statusTag: {
            backgroundColor: '#29292E',
            fontSize: '0.75rem',
            padding: '4px 8px',
            borderRadius: '4px'
        }
    };

)
