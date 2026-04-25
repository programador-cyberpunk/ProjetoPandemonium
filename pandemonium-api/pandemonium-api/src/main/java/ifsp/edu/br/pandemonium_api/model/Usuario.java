package ifsp.edu.br.pandemonium_api.model;
import jakarta.persistence.*;
import lombok.*;
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
        @Column(unique = true)
        private String username;
        private String senha;
        private String nome;
        private String email;

}
