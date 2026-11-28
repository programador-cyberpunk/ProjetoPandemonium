const API_DEFAULT = "http://localhost:8080/api" //nem lembro onome que dei pra essa merda

function getApiBase(){
    return localStorage.getItem("pandemonium-api") || API_DEFAULT;
}

function setApiBase(){
    localStorage.setItem("pandemonium-api", url,replace(/\/+$/, "")); //entendi nada
}

//notificar o javafx caso seja aberto o webview e eu nao me fuder
function notificaJavaFX(action, payload = ""){
    if(window.javaBridge && typeof window.javaBridge.recebEvento === "function"){
        window.javaBridge.recebEvento(action, JSON.stringify(payload));
        return true;
    }
    return false;
};