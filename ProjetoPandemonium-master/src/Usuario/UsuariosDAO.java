package Usuario;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class UsuariosDAO {

    private HttpClient httpClient = HttpClient.newHttpClient();

    public void apiLogin(String username, String senha) {
        //to chamando a api por essa requisição
        String json = "{\"username\":\"" + username + "\", \"senha\":\"" + senha + "\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/Usuario/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpRequest response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                System.out.println("Login efetuado com sucesso!");
            }else {
                System.out.println("Deu ruim no login: " + response.statusCode());
            }catch(Exception.e){
                e.printStackTrace();
        }
    }
    public void addUsuario(String usuario, String senha){
        try{
            String json = "{\"username\":\"" + usuario + "\", \"senha\":\"" + senha + "\"}";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/Usuarios/add"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }



