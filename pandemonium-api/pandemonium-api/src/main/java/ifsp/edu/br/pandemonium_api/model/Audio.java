package ifsp.edu.br.pandemonium_api.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    @Column(nullable = false, unique = true)
    private String nomeArquivoSalvo;
    private String tipoConteudo;
    private Long tamanhoBytes;
    private LocalDateTime dataEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}