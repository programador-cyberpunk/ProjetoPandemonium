import br.com.gravador.model.Chamado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instrumentos {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public class PandemoniumClasses {

        public static class Usuario {
            private int id;
            private String senha;
            private String email;
            private int telefone;
            private String nomeMusica;
            private String nomeBanda;

            public Usuario() {
            }

            public Usuario(String senha, String email, int telefone, String nomeMusica, String nomeBanda) {
                this.senha = senha;
                this.email = email;
                this.telefone = telefone;
                this.nomeMusica = nomeMusica;
                this.nomeBanda = nomeBanda;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSenha() {
                return senha;
            }

            public void setSenha(String senha) {
                this.senha = senha;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getTelefone() {
                return telefone;
            }

            public void setTelefone(int telefone) {
                this.telefone = telefone;
            }

            public String getNomeMusica() {
                return nomeMusica;
            }

            public void setNomeMusica(String nomeMusica) {
                this.nomeMusica = nomeMusica;
            }

            public String getNomeBanda() {
                return nomeBanda;
            }

            public void setNomeBanda(String nomeBanda) {
                this.nomeBanda = nomeBanda;
            }
        }
    }
        public static class Instrumento {
            private String guitarra;
            private String baixo;
            private String bateria;
            private String banjo;
            private String teclado;
            private String vocal;
            private String violao;
            private String viola;
            private String sintetizador;
            private String pedal;

            public Instrumento() {}

            public String getGuitarra() { return guitarra; }
            public void setGuitarra(String guitarra) { this.guitarra = guitarra; }
            public String getBaixo() { return baixo; }
            public void setBaixo(String baixo) { this.baixo = baixo; }
            public String getBateria() { return bateria; }
            public void setBateria(String bateria) { this.bateria = bateria; }
            public String getBanjo() { return banjo; }
            public void setBanjo(String banjo) { this.banjo = banjo; }
            public String getTeclado() { return teclado; }
            public void setTeclado(String teclado) { this.teclado = teclado; }
            public String getVocal() { return vocal; }
            public void setVocal(String vocal) { this.vocal = vocal; }
            public String getViolao() { return violao; }
            public void setViolao(String violao) { this.violao = violao; }
            public String getViola() { return viola; }
            public void setViola(String viola) { this.viola = viola; }
            public String getSintetizador() { return sintetizador; }
            public void setSintetizador(String sintetizador) { this.sintetizador = sintetizador; }
            public String getPedal() { return pedal; }
            public void setPedal(String pedal) { this.pedal = pedal; }
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
            public void setDrive(String drive) { this.drive = drive; }
            public String getChaveSeletora() { return chaveSeletora; }
            public void setChaveSeletora(String chaveSeletora) { this.chaveSeletora = chaveSeletora; }
            public Usuario getUsuario() { return usuario; }
            public void setUsuario(Usuario usuario) { this.usuario = usuario; }
        }

        public static class Violao {
            private int id;
            private int qtdCordas;
            private String cordasNome;
            private String tom;
            private Usuario usuario;

            public Violao(int qtdCordas, String cordasNome, String tom, int knobs, int captadores,Usuario usuario) {
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
            public PandemoniumClasses.Usuario getUsuario() { return usuario; }
            public void setUsuario(PandemoniumClasses.Usuario usuario) { this.usuario = usuario; }
        }

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
                            String drive, String chaveSeletora, Usuario usuario) {
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

        }

        public static class Bateria {
            private int id;
            private int qtdPratos;
            private int componentes;
            private String partes;
            private String pedal;
            private String tom;
            private Usuario usuario;

            public Bateria(int id,int Componentes, String Partes, String tom, int qtdPratos,String qtdPedal,Usuario usuario) {
                this.componentes = Componentes;
                this.partes = Partes;
                this.tom = tom;
                this.usuario = usuario;
            }

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }
            public int getComponentes(int Componentes){this.componentes = Componentes; return this.componentes;}
            public void setComponentes(int Componentes){ this.componentes = Componentes; }
            public int getQtdPratos() { return qtdPratos; }
            public void setQtdPratos(int qtdPratos{ this.qtdPratos = qtdPratos;}
            public String getPartes() { return Partes;}
            public void setPartes(String Partes) { this.Partes = Partes;}
            public String getTom() { return tom; }
            public void setqtdPedal(String tom) { this.tom = tom; }
            public String qtdPedal() { return qtdPedal(); }
            public void setqtPedal(String qtdPedal) { this.tom = qtdPedal(); }
            public Instrumentos.PandemoniumClasses.Usuario getUsuario() { return usuario; }
            public void setUsuario(Instrumentos.PandemoniumClasses.Usuario usuario) { this.usuario = usuario; }
        }

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

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }
            public int getQtdCordas() { return qtdCordas; }
            public void setQtdCordas(int qtdCordas) { this.qtdCordas = qtdCordas; }
            public String getCordasNome() { return cordasNome; }
            public void setCordasNome(String cordasNome) { this.cordasNome = cordasNome; }
            public String getTom() { return tom; }
            public void setTom(String tom) { this.tom = tom; }
            public Instrumentos.PandemoniumClasses.Usuario getUsuario() { return usuario; }
            public void setUsuario(Instrumentos.PandemoniumClasses.Usuario usuario) { this.usuario = usuario; }
        }

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
            private Instrumentos.instrumentoRelacionado;

            public Pedal() {}

            public Pedal(String tipo, String nome, String efeitos, String knobs,
                         Usuario usuario, Instrumentos.Instrumento instrumentoRelacionado) {
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

            Usuario usuario = new Usuario("senha123", "musico@email.com", 1199999999, "Sweet Child O'Mine", "Guns N'Roses");

            Guitarra guitarra = new Guitarra(6, "EBGDAE", "E", 4, 2, "S", "5-way", usuario);

            Pedal pedal = new Pedal("Distorção", "Metal Zone", "Gain, Low, Mid, High", "S",
                    usuario, new Instrumento());

            System.out.println("Sistema Pandemonium carregado com sucesso!");
        }
    }
}
