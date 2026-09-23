package ifsp.edu.br.pandemonium_api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Audio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeOriginal;

    @Column(nullable = false, unique = true)
    private String nomeArquivoSalvo;
    private String tipoConteudo;
    private Long tamanho;
    private Float duracao;
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String wavefromJson;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pasta_id")
    @JsonIgnoreProperties("audios")
    private Pasta pasta;
};
