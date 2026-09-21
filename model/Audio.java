package ifsp.edu.br.pandemonium_api.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "audios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipoConteudo;
    private Long tamanho;
    private Float duracao;

    @Column(nullable = false, unique = true)
    private String nomeArquivoSalvo;
    private String tipoConteudo;
    private Long tamanho;
    private LocalDateTime dataEnvio;

    @Column(columnDefinition = "TEXT")
    private String wavefromJson;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }


    @ManyToOne
    @JoinColumn(name = "pasta_id")
    @JsonIgnoreProperties("audios")
    private Pasta pasta;
    public Audio(){

    }
    //gett e setter
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNomeOriginal(){
        return nomeOriginal;
    }
    public void setNomeOriginal(String nomeOriginal){
        this.nomeOriginal = nomeOriginal;
    }

    public String getNomeArquivoSalvo(){
        return nomeArquivoSalvo;
    }
    public void setNomeArquivoSalvo(String nomeArquivoSalvo){
        this.nomeArquivoSalvo = nomeArquivoSalvo;
    }

    public String getTipoConteudo(){
        return tipoConteudo;
    }
    public void setTipoConteudo(String tipoConteudo){
        this.tipoConteudo = tipoConteudo;
    }

    public Long getTamanho(){
        return tamanho;
    }
    public void setTamanho(Long tamanho){
        this.tamanho = tamanho;
    }

    public Float getDuracao(){
        return duracao;
    }
    public void setDuracao(Float duracao){
        this.duracao = duracao;
    }

    public String getWavefromJson(){
        return wavefromJson;
    }
    public void setWavefromJson(String wavefromJson){
        this.wavefromJson = wavefromJson;
    }

    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

        public Pasta getPasta(){
        return pasta;
    }
    public void setPasta(Pasta pasta)
    {
            this.pasta = pasta;
    }
}