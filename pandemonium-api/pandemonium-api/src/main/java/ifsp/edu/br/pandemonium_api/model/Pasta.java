package ifsp.edu.br.pandemonium_api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "pastas")
public class Pasta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "pasta", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("pasta")
        private List<Audio> audios = new ArrayList<>();
            public Pasta(){
                this.dataCriacao = LocalDateTime.now();
            }
            public Pasta(Long id, String nome, String descricao, Usuario usuario){
                this.id = id;
                this.nome = nome;
                this.descricao = descricao;
                this.dataCriacao = LocalDateTime.now();
            }

        public Long getId(){
           return id;
    }public void setId(long id){
                this.id = id;
        }

        public String getNome(){
                return nome;
        }public void setNome(String nome){
                this.nome = nome;
        }

        public String getDescricao(){
                return descricao;
        } public void setDescricao(String descricao){
                this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao(){
                return dataCriacao;
    }public void setDataCriacao(LocalDateTime dataCriacao){
                this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario(){
                return usuario;
    }public void setUsuario(Usuario usuario){
                this.usuario = usuario;
    }

    public List<Audio> getAudios(){
                return audios;
    }public void setAudios(List<Audio> audios){
                this.audios = audios;
    }

}