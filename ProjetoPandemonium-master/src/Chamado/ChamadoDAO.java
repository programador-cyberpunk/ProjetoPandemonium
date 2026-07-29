// O nome do pacote foi mantido, mas a convenção é usar letras minúsculas (ex: br.com.pandemonium.model)
package Chamado;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO{
    private static List<Chamado> listaChamados = new ArrayList<>();
    private static int proximoId = 1;

    public ChamadoDAO(){}
    public List<Chamado> listarTodos(){
        return listaChamados;
    }

    // ta no  nome ne porra
    public boolean addChamado(Chamado chamado){
        if(chamado != null){
            chamado.setId(proximoId++);
            listaChamados.add(chamado);
            return true;
        }
        return false;
    }
// atualiozar
    public boolean atualizarChamado(Chamado chamadoAtualizado){
        for(int i = 0; i < listaChamados.size(); i++){
            if(listaChamados.get(i).getId() == chamadoAtualizado.getId()){
                listaChamados.set(i, chamadoAtualizado);
                return true;
            }
        }
        return false;
    }
    //delete
    public boolean deletarChamado(int id){
        return listaChamados.removeIf(chamado -> chamado.getId() == id);
    }
}