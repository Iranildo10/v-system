
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.AlteracaoEstoqueModel;
import br.com.vsystem.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class AlteracaoEstoqueDAO {
    
    private Connection con;
    
    public AlteracaoEstoqueDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarAlteracaoEstoque(AlteracaoEstoqueModel altEstoque){
        try {
            String sql = "insert into tb_alteracaoEstoque(data_alteracao, qtd_inicial, qtd_adicionada, usuario_alteracao_id, produto_id, motivo_alteracao) values (?,?,?,?,?,?)";
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, altEstoque.getData_alteracao());
            stmt.setInt(2, altEstoque.getQtd_inicial());
            stmt.setInt(3, altEstoque.getQtd_adicionada());
            stmt.setInt(4, altEstoque.getUsuario().getUsusario_id());
            stmt.setInt(5, altEstoque.getProduto().getProduto_id());
            stmt.setString(6, altEstoque.getMotivo_alteracao());
            
            stmt.execute();
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Alteração de estoque realizada com sucesso!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        
    }
    
}
