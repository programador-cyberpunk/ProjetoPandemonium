import { useState, useEffect } from 'react';
import { apiService } from './api';
//inicio dos bang
export function App() {
    const [audios, setAudios] = useState([]);
    const [titulo, setTitulo] = useState('');
    const [arquivo, setArquivo] = useState(null);
    const [loading, setLoading] = useState(false);
    const [erro, setErro] = useState('');

    //tudo setado, hora de por a mão na massa
    useEffect(() => {
        carregarAudios();
    }, []);

    async function carregarAudios() {
        try {
            setLoading(true);
            setErro('');
            const dados = await apiService.listarAudios();
            setAudios(dados);
        } catch (err) {
            setErro('Deu ruim ao conectar o backend Spring Boot (porta 8080).');
            console.error(err);
        } finally {
            setLoading(false);
        }
    }

    async function handleUpload(e) {
        e.preventDefault();
        if (!arquivo) {
            alert('Selecione algo ai mane!');
            return;
        }

        const formData = new FormData();
        formData.append('file', arquivo);
        formData.append('titulo', titulo);

        try {
            setLoading(true);
            await apiService.enviarAudio(formData);
            setTitulo('');
            setArquivo(null);
            e.target.reset();
            await carregarAudios();
        } catch (err) {
            setErro('Deu Boxta.');
            console.error(err);
        } finally {
            setLoading(false);
        }
    }

    return (
        <div style={{ maxWidth: '800px', margin: '40px auto', fontFamily: 'sans-serif', padding: '0 20px' }}>
            <h1>COMEÇA O PANDEMONIUM</h1>

            {erro && (
                <div style={{ background: '#ffdddd', color: '#b70000', padding: '10px', borderRadius: '4px', marginBottom: '20px' }}>
                    {erro}
                </div>
            )}

            <section style={{ background: '#f4f4f9', padding: '20px', borderRadius: '8px', marginBottom: '30px' }}>
                <h2>Uploads</h2>
                <form onSubmit={handleUpload} style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
                    <div>
                        <label style={{ display: 'block', marginBottom: '4px' }}>Título do Áudio:</label>
                        <input
                            type="text"
                            value={titulo}
                            onChange={(e) => setTitulo(e.target.value)}
                            placeholder="Ex: Riff de Guitarra #1"
                            required
                            style={{ width: '100%', padding: '8px', borderRadius: '4px', border: '1px solid #ccc' }}
                        />
                    </div>

                    <div>
                        <label style={{ display: 'block', marginBottom: '4px' }}>Arquivo (.mp3, .wav):</label>
                        <input
                            type="file"
                            accept="audio/*"
                            onChange={(e) => setArquivo(e.target.files[0])}
                            required
                        />
                    </div>

                    <button
                        type="submit"
                        disabled={loading}
                        style={{
                            padding: '10px 15px',
                            background: loading ? '#ccc' : '#28a745',
                            color: '#fff',
                            border: 'none',
                            borderRadius: '4px',
                            cursor: loading ? 'not-allowed' : 'pointer',
                            fontWeight: 'bold'
                        }}
                    >
                        {loading ? 'Enviando...Guentai mane' : 'Manda bala'}
                    </button>
                </form>
            </section>

            <section>
                <h2>Biblioteca de Podreiras</h2>
                {loading && audios.length === 0 && <p>Carregando guentai...</p>}

                {!loading && audios.length === 0 && <p>Nada aqui. De o primeiro passo topeira!</p>}

                <ul style={{ listStyle: 'none', padding: 0 }}>
                    {audios.map((audio) => (
                        <li
                            key={audio.id || audio.url}
                            style={{
                                border: '1px solid #ddd',
                                borderRadius: '6px',
                                padding: '15px',
                                marginBottom: '10px',
                                display: 'flex',
                                flexDirection: 'column',
                                gap: '8px'
                            }}
                        >
                            <strong>{audio.titulo || audio.nomeOriginal || 'Sem título'}</strong>
                            <audio controls src={audio.url || `http://localhost:8080/api/audios/stream/${audio.id}`}>
                                Seu navegador não suporta a tag "audio",em suma, se fudeu.
                            </audio>
                        </li>
                    ))}
                </ul>
            </section>
        </div>
    );
}

export default App;