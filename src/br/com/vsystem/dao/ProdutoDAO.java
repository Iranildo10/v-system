
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.FornecedorModel;
import br.com.vsystem.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Cadastrar Produtos
    public void cadastrarProduto(ProdutoModel pro){
        try {
            String sql = "insert into tb_produto(descricao, preco, qtd_estoque, barras, apagado, fornecedor_id) values (?,?,?,?,?,?)";
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, pro.getDescricao());
            stmt.setDouble(2, pro.getPreco());
            stmt.setInt(3, pro.getQtd_estoque());
            stmt.setString(4, pro.getBarras());
            stmt.setString(5, pro.getApagado());
            stmt.setInt(6, pro.getFornecedor().getFornecedor_id());
            
            stmt.execute();
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        
    }
    
    public void alterarProduto(ProdutoModel pro){
        try {
            String sql = "update tb_produto set descricao=?, preco=?, qtd_estoque=?, barras=?, fornecedor_id=? where produto_id=?";
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, pro.getDescricao());
            stmt.setDouble(2, pro.getPreco());
            stmt.setInt(3, pro.getQtd_estoque());
            stmt.setString(4, pro.getBarras());
            stmt.setInt(5, pro.getFornecedor().getFornecedor_id());
            stmt.setInt(6, pro.getProduto_id());
            
            stmt.execute();
            stmt.close();
            
             JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    
    public void excluirProduto(ProdutoModel pro){
         try {
            String sql = "update tb_produto set apagado = ? where produto_id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, pro.getApagado());
            stmt.setInt(2, pro.getProduto_id());
            
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso!!");
        } catch (Exception e) {
        }
    }
    
    
    
    //Listar Produtos
    public List<ProdutoModel> listarTodosProdutos(){
        try {
            List<ProdutoModel> lista = new ArrayList<>();
            
            String sql = "select p.produto_id, p.descricao, p.preco, p.qtd_estoque, p.barras, f.nome_fantasia from tb_produto as p "
                    + "inner join tb_fornecedor as f on (p.fornecedor_id = f.fornecedor_id) where p.apagado = 'N'";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ProdutoModel obj = new ProdutoModel();
                FornecedorModel f =new FornecedorModel();
            
                obj.setProduto_id(rs.getInt("p.produto_id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.qtd_estoque"));
                obj.setBarras(rs.getString("p.barras"));
                
                f.setNome_fantasia(rs.getString("f.nome_fantasia"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + " " + e);
            return null;
        }
    }
    
    public List<ProdutoModel> PesquisarPorDescricao(String descricao){
        try {
            List<ProdutoModel> lista = new ArrayList<>();
            
            String sql = "select p.produto_id, p.descricao, p.preco, p.qtd_estoque, p.barras, f.nome_fantasia from tb_produto as p "
                    + "inner join tb_fornecedor as f on (p.fornecedor_id = f.fornecedor_id) where  p.apagado = 'N' and p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                ProdutoModel obj = new ProdutoModel();
                FornecedorModel f =new FornecedorModel();
            
                obj.setProduto_id(rs.getInt("p.produto_id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.qtd_estoque"));
                obj.setBarras(rs.getString("p.barras"));
                
                f.setNome_fantasia(rs.getString("f.nome_fantasia"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + " " + e);
            return null;
        }
    }
}
