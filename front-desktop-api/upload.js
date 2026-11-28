const formUpload = document.getElementById("formUpload");
const statusUpload = document.getElementById("statusUpload");
const btnSeletorJfx = document.getElementById("btnSeletorJfx");

formUpload.addEventListener("submit",async(e) => {
    e.preventDefault();
    statusUpload.textContent = "Ta subindooo....";
    statusUpload.className = "status";
    try{
        const resp = await fetch(`${getApiBase()}/faixas`,{
            method: "POST",
            body: formData
        });
    if(!resp.ok) throw new Error(`HTTP  ${resp.status}`);
    statusUpload.textContent = "Faixa upada È NOIS PORRA!";
    statusUpload.className = "status ok";
    formUpload.reset();
    notifiicaJavaFX("FAIXA_ENVIADA", {ok: true});
    } catch (err){
        statusUpload.textContent = `Falha: ${err.message}`;
        statusUpload.className = "status erro";
    }
});

btnSeletorJfx.addEventListener("click", () =>{
    const enviou = notificaJavaFX("ABRIR_SELETOR_ARQUIVO");
        if(!enviou){
            alert("Essa pagina aqui ta rodando no navegador comum, escolha um arquivo para escolher um arquivo ai");
        }
});