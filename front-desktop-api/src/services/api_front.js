const PANDEMONIUM_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export const apiService = {
    async listarAudios(){
        const response = await fetch(`${PANDEMONIUM_URL}/api/audios`);
        if(!response.ok) trhow new Error("Deu bosta na busca,guenta ai...");
        return response.json();
    },
    async enviarAudio(formData){
        const response = await fetch(`${PANDERMONIUM_API_URL}/api/audios/upload`, {
            method: 'POST',
            body: formData,
        });
        if(!response.ok) throw new Error('Erro no upload');
        return response.json();
    }
};