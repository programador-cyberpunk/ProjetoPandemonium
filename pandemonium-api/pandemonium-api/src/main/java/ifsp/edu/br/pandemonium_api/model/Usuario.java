package ifsp.edu.br.pandemonium_api.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import lombok.Data;
@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
// novo prano
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        @Column(unique = true, nullable = false)
        private String username;
        private LocalDateTime dataUpload = LocalDateTime.now();

        @Column(nullable = false)
        private int idUsuario;
        private String senha;
        private String nome;
        private String email;


}
