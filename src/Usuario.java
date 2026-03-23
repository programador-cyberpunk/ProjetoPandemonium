public class Usuario {

        private int id;
        private String username;
        private String senha;
        private String nome;
        private String email;

        public Usuario(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.senha = senha;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return senha;
        }

        public void setPassword(String password) {
            this.senha = senha;
        }
    }
