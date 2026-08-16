const API_BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

    export const apiService = {
        async listarChamados(){
            const response = await fetch(`${API_BASE_URL}/chamados`);
            if(!response.ok) throw new Error('Deu ruim ao buscar o chamado');
            return response.json();
        },

        async enviarAudio(formData){
            const response = await fetch(`${API_BASE_URL}/upload` , {
            method: 'POST', body: formData,});
            if(!response.ok) throw new Error('Erro no upload');// pro tauri
            return response.json();
        }
    };