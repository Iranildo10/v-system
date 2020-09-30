
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    
    //Filtrar vendas por data
    public List<VendaModel> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim){
    
        try {
            //Criar a lista de produtos que sera alimentada pelo select
            List<VendaModel> lista = new ArrayList<>();
            
            //Criar consulta sql
            String sql = "select v.venda_id, v.data_venda, c.nome, v.total_venda, v.observacoes, v.desconto from tb_venda as v \n" +
                         "inner join tb_cliente as c \n" +
                         "on (v.cliente_id = c.cliente_id) where v.venda_id = 8";
            
            //v.data_venda BETWEEN ? AND ?
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            
            ResultSet rs = stmt.executeQuery();
            
            //Formatar a data que vem do MYSQL
            SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy hh/mm/ss");
            
            
            while(rs.next()){
                VendaModel obj = new VendaModel();
                ClienteModel c = new ClienteModel();
                
                obj.setVenda_id(rs.getInt("v.venda_id"));
                
                //String dataformatada = dataBr.format(rs.getString("v.data_venda"));
                
                obj.setData_venda(rs.getString("v.data_venda"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObservacao(rs.getString("v.observacoes"));
                obj.setCliente(c);
                
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar as vendas : " + " " + e);
            return null;
        }
        
    }
    
}
