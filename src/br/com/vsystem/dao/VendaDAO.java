
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.ItemVendaModel;
import br.com.vsystem.model.ProdutoModel;
import br.com.vsystem.model.UsuarioModel;
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
            String sql = "select v.venda_id, DATE_FORMAT(v.data_venda, '%Y/%m/%d %H:%i:%s') as data_venda, c.nome, v.total_venda, v.observacoes, v.desconto, v.status_venda from tb_venda as v \n" +
                         "inner join tb_cliente as c \n" +
                         "on (v.cliente_id = c.cliente_id) where v.data_venda BETWEEN ? AND ?";
            
            //v.data_venda BETWEEN ? AND ?
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data_inicio.toString() + " 00:00:00");
            stmt.setString(2, data_fim.toString() + " 23:59:00 ");
            
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                VendaModel obj = new VendaModel();
                ClienteModel c = new ClienteModel();
                
                obj.setVenda_id(rs.getInt("v.venda_id"));
                
                obj.setData_venda(rs.getString("data_venda"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObservacao(rs.getString("v.observacoes"));
                obj.setStatus_venda(rs.getString("v.status_venda"));
                obj.setCliente(c);
                
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar as vendas : " + " " + e);
            return null;
        }
        
    }
    
    //Listar Itens da venda
    public List<ItemVendaModel> listarItensVenda(int venda_id){
    
        try {
            
            List<ItemVendaModel> lista = new ArrayList<>();
            
            String sql = "select  p.produto_id, p.descricao, p.barras, iv.qtd, iv.subtotal from tb_itensvenda as iv \n" +
                         "inner join tb_venda as v \n" +
                         "inner join tb_produto as p \n" +
                         "on (v.venda_id = iv.venda_id and iv.produto_id = p.produto_id) where v.venda_id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, venda_id);
     
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                ItemVendaModel iv = new ItemVendaModel();
                ProdutoModel p = new ProdutoModel();
                p.setProduto_id(rs.getInt("p.produto_id"));
                p.setDescricao(rs.getString("p.descricao"));
                p.setBarras(rs.getString("p.barras"));
                iv.setQtd(rs.getInt("iv.qtd"));
                iv.setSubtotal(rs.getDouble("iv.subtotal"));
                iv.setProduto(p);
              
                lista.add(iv);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar os itens da venda selecionada : " + " " + e);
            return null;
        }
        
    }
    
    //RELATORIO CLIENTE 
    public List<VendaModel> RelatorioVendasCliente(LocalDate data_inicio, LocalDate data_fim){
    
        try {
            //Criar a lista de produtos que sera alimentada pelo select
            List<VendaModel> lista = new ArrayList<>();
            
            //Criar consulta sql
            String sql = "select c.cliente_id, c.nome, v.total_venda, i.qtd  from tb_venda as v \n" + 
                         "inner join tb_cliente as c \n " +
                         "on (v.cliente_id = c.cliente_id) \n" + 
                         "inner join tb_itensvenda as i \n" +
                         "on (i.venda_id = v.venda_id) \n" +
                         "where v.data_venda BETWEEN ? AND ?";  
      
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data_inicio.toString() + " 00:00:00");
            stmt.setString(2, data_fim.toString() + " 23:59:00 ");
            
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                VendaModel obj = new VendaModel();
                ClienteModel c = new ClienteModel();
                ItemVendaModel i = new ItemVendaModel();
                
               
                
                c.setCliente_id(rs.getInt("c.cliente_id"));
                c.setNome(rs.getString("c.nome"));
                obj.setCliente(c);
                i.setQtd(rs.getInt("i.qtd"));
                obj.setItemvenda(i);
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                
                
                
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar as vendas : " + " " + e);
            return null;
        }
    }
    
    
    //RELATORIO DAS VENDAS REALIZADAS NO DIA 
   public List<VendaModel> RelatorioDiario(){
    
        try {
            //Criar a lista de produtos que sera alimentada pelo select
            List<VendaModel> lista = new ArrayList<>();
            
            //Criar consulta sql
            String sql = "select v.cliente_id, v.total_venda, v.data_venda, u.nome from tb_venda as v \n" +
                    "inner join tb_usuario as u on (u.usuario_id = v.usuario_id )\n" +  
                    "where v.status_venda = 'F' and DATE_FORMAT(data_venda, '%Y-%m-%d') = CURDATE()";
                       
            PreparedStatement stmt = con.prepareStatement(sql);
        
            
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                VendaModel obj = new VendaModel();
                UsuarioModel u = new UsuarioModel();
                ClienteModel c = new ClienteModel();
                
                c.setCliente_id(rs.getInt("v.cliente_id"));
                obj.setCliente(c);
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setData_venda(rs.getString("v.data_venda"));
                u.setNome(rs.getString("u.nome"));
                obj.setUsuario(u);

                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar as vendas : " + " " + e);
            return null;
        }
        
    }
   
   public List<VendaModel> RelatorioVendasProdutos(LocalDate data_inicio, LocalDate data_fim){
    
        try {
            //Criar a lista de produtos que sera alimentada pelo select
            List<VendaModel> lista = new ArrayList<>();
            
            //Criar consulta sql
            String sql = "select i.produto_id, p.descricao, i.qtd  from tb_itensvenda as i \n" +
                         "inner join tb_produto as p \n" +
                         "on (p.produto_id = i.produto_id) \n" + 
                         "inner join tb_venda as v \n "+
                         "on (v.venda_id = i.venda_id) \n" +
                         "where v.data_venda BETWEEN ? AND ? " ;  
      
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data_inicio.toString() + " 00:00:00");
            stmt.setString(2, data_fim.toString() + " 23:59:00 ");
            
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                VendaModel obj = new VendaModel();
                ProdutoModel p = new ProdutoModel();
                ItemVendaModel i = new ItemVendaModel();
                
               
                
                p.setProduto_id(rs.getInt("i.produto_id"));
                p.setDescricao(rs.getString("p.descricao"));
                obj.setProduto(p);
                obj.setItemvenda(i);
                i.setQtd(rs.getInt("i.qtd"));
                
              
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar as vendas : " + " " + e);
            return null;
        }
        
    }
   
    
    //Cancelar venda
    public void cancelarVenda(int venda_id){
        try {
            
            //STATUS VENDA F = FINALIZADA, C = CANCELADA

            //1 passo - criar o comando sql
            String sql = "UPDATE tb_venda SET status_venda = 'C' where venda_id = ? ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, venda_id);
     
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso! ");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro ao cancelar venda. Erro: " + " " + erro);
        }
    }
    
}
