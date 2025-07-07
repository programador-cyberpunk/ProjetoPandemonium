// package br.com.gravador;

import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true); // Torna a janela de login visível
            }
        });
    }
}