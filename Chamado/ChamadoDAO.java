// O nome do pacote foi mantido, mas a convenção é usar letras minúsculas (ex: br.com.pandemonium.model)
package Chamado;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO{
    private static List<Chamado> listaChamados = new ArrayList<>();
    private static int proximoId = 1;

    public ChamadoDAO(){}
    public Lis<Chamado> listarTodos(){
        return listaChamados;
    }

}