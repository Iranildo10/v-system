
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ItemVendaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
    
    private Connection con;

    public ItemVendaDAO() {
        
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo que cadastra Itens
    public void cadastraItem(ItemVendaModel obj){
        try {

            //1 passo - criar o comando sql
            String sql = "insert into tb_itensvenda(venda_id, produto_id, qtd, subtotal) "
                    + "values (?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getVenda_id());
            stmt.setInt(2, obj.getProduto().getProduto_id());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
          

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + " " + erro);
        }
    }
    
    
    
}
