
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class VendaDAO {
    
    private Connection con;

    public VendaDAO() {
        
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Cadatrar venda
    public void cadastrarVenda(VendaModel obj){
        try {
            
            //STATUS VENDA F = FINALIZADA, C = CANCELADA

            //1 passo - criar o comando sql
            String sql = "insert into tb_venda(cliente_id, usuario_id, data_venda, total_venda, observacoes, desconto, status_venda) "
                    + "values (?,?,?,?,?,?,?) ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getCliente().getCliente_id());
            stmt.setInt(2, obj.getUsuario().getUsusario_id());
            stmt.setString(3, obj.getData_venda());
            stmt.setDouble(4, obj.getTotal_venda());
            stmt.setString(5, obj.getObservacao());
            stmt.setDouble(6, obj.getDesconto());
            stmt.setString(7, obj.getStatus_venda());
          
            
            stmt.execute();
            stmt.close();
            
            
            

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + " " + erro);
        }
    }
    
    //Retorna a ultima venda
    public int retornaUltimaVenda(){
        try {
            int idvenda = 0;
            String sql = "select max(venda_id) id from tb_venda";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                VendaModel p = new VendaModel();
                p.setVenda_id(rs.getInt("id"));
                idvenda = p.getVenda_id();
            }
            
            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
