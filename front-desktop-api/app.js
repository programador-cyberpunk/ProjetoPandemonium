const apiUrlInput =document.getElementById("apiUrl");
const btnCarregar = document.getElementById("btnCarregar");
const listaFaixas = document.getElementById("btnCarregar");
const player = document.getElementById("player");
const statusEl = document.getElementById("status");

    function setStatus(texto, tipo){
        statusEl.textContent = texto;
        statusEl.className = `status ${tipo || ""}`;
    }
  async function carregarAudios() {
        const url = apiUrlInput.value.trim();
        if(!url) return;
        setStatus("Conectando, guentai....", "");
        listaFaixas.innerHTML = "";
            try{
                const resp = await fetch(url);
                 if(!resp.ok){
                     throw new Error(`HTTP ${resp.status}`);
                 }
        const dados = await resp.json();
                 setStatus("Conectando, deu bom");
                 if(!Array.isArray(dados) || dados.length === 0){
                     listaFaixas.innerHTML = '<li class="item">Nenhuma faixa retornada,se fudeu....</li>';
                     return;
                 }
        dados.forEach((faixa)=>{
                     const li = document.createElement("li");
                     li.className = "item";
                 const titulo = faixa.titulo || faixa.nome || `Faoxa #${faixa.id ?? "?"}`;
                 const audioUrl = faixa.urlAudio || faixa.streamUrl || "";
                 const span = document.createElement("span");
                 span.textContent = titulo;

                 const btnPlay = document.createElement("button");
                 btnPlay.type = "button";
                 btnPlay.textContent = "Tocar";
                 btnPlay.disable = !audioUrl;
                }
            });
  }