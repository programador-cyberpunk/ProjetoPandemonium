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
import java.io.IOException;
public class UsuariosDAO {

    private HttpClient httpClient = HttpClient.newHttpClient();

    public void apiLogin(String username, String senha) {

        try {
            String json = "{\"username\":\"" + username + "\", \"senha\":\"" + senha + "\"}";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/usuarios/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            // agora esse caralho funciona porra'
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Agora sim o response tem o statusCode() filha da puta da porra
            if (response.statusCode() == 200) {
                System.out.println("Login efetuado com sucesso!");
            } else {
                System.out.println("Deu ruim no login: " + response.statusCode());
            }

        } catch (Exception e) {
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



