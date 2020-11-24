
package br.com.vsystem.jdbc;

import br.com.vsystem.view.frmLogin;
import javax.swing.JOptionPane;


public class TestaConexao {
    
    public static void main(String[] args) {
            
        try {
            new ConnectionFactory().getConnection();
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            frmLogin tela = new frmLogin();
            tela.setVisible(true);
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!");
        }
    }
}
