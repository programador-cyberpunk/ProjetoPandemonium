
// package com.Pandemonium.modelos;

public class Instrumentos {

    public static class Usuario {
        private String senha;
        private String email;
        private long telefone;
        private String musicaFavorita;
        private String bandaFavorita;

        public Usuario(String senha, String email, long telefone, String musicaFavorita, String bandaFavorita) {
            this.senha = senha;
            this.email = email;
            this.telefone = telefone;
            this.musicaFavorita = musicaFavorita;
            this.bandaFavorita = bandaFavorita;
        }
    }

    public static class Instrumento {
        private String guitarra;
        private String baixo;
        private String bateria;
        public Instrumento() {}
    }

    public static class Guitarra {
        private int id;
        private int qtdCordas;
        private String cordasNome;
        private String tom;
        private int knobs;
        private int captadores;
        private String drive;
        private String chaveSeletora;
        private Usuario usuario;

        public Guitarra(int qtdCordas, String cordasNome, String tom, int knobs, int captadores,
                        String drive, String chaveSeletora, Usuario usuario) {
            this.qtdCordas = qtdCordas;
            this.cordasNome = cordasNome;
            this.tom = tom;
            this.knobs = knobs;
            this.captadores = captadores;
            this.drive = drive;
            this.chaveSeletora = chaveSeletora;
            this.usuario = usuario;
        }
    }

    public static class Violao {
        private int id;
        private int qtdCordas;
        private String cordasNome;
        private String tom;
        private Usuario usuario;

        public Violao(int qtdCordas, String cordasNome, String tom, Usuario usuario) {
            this.qtdCordas = qtdCordas;
            this.cordasNome = cordasNome;
            this.tom = tom;
            this.usuario = usuario;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public int getQtdCordas() { return qtdCordas; }
        public void setQtdCordas(int qtdCordas) { this.qtdCordas = qtdCordas; }
        public String getCordasNome() { return cordasNome; }
        public void setCordasNome(String cordasNome) { this.cordasNome = cordasNome; }
        public String getTom() { return tom; }
        public void setTom(String tom) { this.tom = tom; }
        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

    public static class Baixo {
        private int id;
        private int qtdCordas;
        private String cordasNome;
        private String tom;
        private int knobs;
        private int captadores;
        private String drive;
        private Usuario usuario;

        public Baixo(int qtdCordas, String cordasNome, String tom, int knobs, int captadores,
                     String drive, Usuario usuario) {
            this.qtdCordas = qtdCordas;
            this.cordasNome = cordasNome;
            this.tom = tom;
            this.knobs = knobs;
            this.captadores = captadores;
            this.drive = drive;
            this.usuario = usuario;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public int getQtdCordas() { return qtdCordas; }
        public void setQtdCordas(int qtdCordas) { this.qtdCordas = qtdCordas; }
        public String getCordasNome() { return cordasNome; }
        public void setCordasNome(String cordasNome) { this.cordasNome = cordasNome; }
        public String getTom() { return tom; }
        public void setTom(String tom) { this.tom = tom; }
        public int getKnobs() { return knobs; }
        public void setKnobs(int knobs) { this.knobs = knobs; }
        public int getCaptadores() { return captadores; }
        public void setCaptadores(int captadores) { this.captadores = captadores; }
        public String getDrive() { return drive; }
        public void setDrive(String drive) { this.drive = drive;}
        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

    public static class Banjo {
        private int id;
        private int qtdCordas;
        private String cordasNome;
        private String tom;
        private Usuario usuario;

        public Banjo(int qtdCordas, String cordasNome, String tom, Usuario usuario) {
            this.qtdCordas = qtdCordas;
            this.cordasNome = cordasNome;
            this.tom = tom;
            this.usuario = usuario;
        }
        // ... getters e setters
    }

    public static class Bateria {
        private int id;
        private int qtdPratos;
        private int componentes;
        private String partes;
        private String pedal; // 5. O campo se chamava "pedal", não "qtdPedal".
        private String tom;
        private Usuario usuario;

        public Bateria(int componentes, String partes, String tom, int qtdPratos, String pedal, Usuario usuario) {
            this.componentes = componentes;
            this.partes = partes;
            this.tom = tom;
            this.qtdPratos = qtdPratos;
            this.pedal = pedal;
            this.usuario = usuario;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getComponentes() { return componentes; }
        public void setComponentes(int componentes) { this.componentes = componentes; }

        public int getQtdPratos() { return qtdPratos; }
        public void setQtdPratos(int qtdPratos) { this.qtdPratos = qtdPratos; }

        public String getPartes() { return partes; }
        public void setPartes(String partes) { this.partes = partes; }

        public String getTom() { return tom; }
        public void setTom(String tom) { this.tom = tom; }

        public String getPedal() { return pedal; }
        public void setPedal(String pedal) { this.pedal = pedal; }

        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

    public static class Viola {
        private int id;
        private int qtdCordas;
        private String cordasNome;
        private String tom;
        private Usuario usuario;

        public Viola(int qtdCordas, String cordasNome, String tom, Usuario usuario) {
            this.qtdCordas = qtdCordas;
            this.cordasNome = cordasNome;
            this.tom = tom;
            this.usuario = usuario;
        }

        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

    public static class Teclado {
        private int id;
        private int qtdTeclas;
        private String qtdOitavas;
        private String tom;
        private Usuario usuario;
        public Teclado() {}
    }

    public static class Pedal {
        private int id;
        private String tipo;
        private String nome;
        private String efeitos;
        private String knobs;
        private Usuario usuario;
        private Instrumento instrumentoRelacionado;

        public Pedal() {}

        public Pedal(String tipo, String nome, String efeitos, String knobs,
                     Usuario usuario, Instrumento instrumentoRelacionado) {
            this.tipo = tipo;
            this.nome = nome;
            this.efeitos = efeitos;
            this.knobs = knobs;
            this.usuario = usuario;
            this.instrumentoRelacionado = instrumentoRelacionado;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public String getEfeitos() { return efeitos; }
        public void setEfeitos(String efeitos) { this.efeitos = efeitos; }
        public String getKnobs() { return knobs; }
        public void setKnobs(String knobs) { this.knobs = knobs; }
        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
        public Instrumento getInstrumentoRelacionado() { return instrumentoRelacionado; }
        public void setInstrumentoRelacionado(Instrumento instrumentoRelacionado) {
            this.instrumentoRelacionado = instrumentoRelacionado;
        }
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario("senha123", "musico@email.com", 11999999999L, "Sweet Child O'Mine", "Guns N'Roses");
        Guitarra guitarra = new Guitarra(6, "EBGDAE", "E", 4, 2, "S", "5-way", usuario);

        Pedal pedal = new Pedal("Distorção", "Metal Zone", "Distorção overdrive", "Gain, Low, Mid, High", usuario, new Instrumento());

        System.out.println("Sistema Pandemonium carregado com sucesso!");
    }
}