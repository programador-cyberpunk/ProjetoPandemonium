package ifsp.edu.br.pandemonium-api.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pastas")
@Getter
@Setter
NoArgsConstructor
@AllArgsConstructor
    public class Guardar{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullabe = false)
        private String nome;

        private LocalDateTime dataCriacao = LocalDateTime.now();

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        @OneToMant(mappedBy = "pasta", cascade = CascadeType.ALL)
        private List<Audio> arquivos;
    }