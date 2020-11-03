
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.AlteracaoEstoqueModel;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.ProdutoModel;
import br.com.vsystem.model.UsuarioModel;
import br.com.vsystem.model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public List<AlteracaoEstoqueModel> listarAlteracoesEstoque(LocalDate data_inicio, LocalDate data_fim){
    
        try {
            //Criar a lista de produtos que sera alimentada pelo select
            List<AlteracaoEstoqueModel> lista = new ArrayList<>();
            
            //Criar consulta sql
            String sql = "SELECT DATE_FORMAT(ae.data_alteracao, '%Y/%m/%d %H:%i:%s') as data_alteracao, ae.qtd_inicial, ae.qtd_adicionada, ae.usuario_alteracao_id, ae.produto_id, ae.motivo_alteracao \n" +
                         "FROM tb_alteracaoestoque as ae \n" +
                         "WHERE ae.data_alteracao BETWEEN ? AND ?";
            
            //v.data_venda BETWEEN ? AND ?
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data_inicio.toString() + " 00:00:00");
            stmt.setString(2, data_fim.toString() + " 23:59:00 ");
            
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                AlteracaoEstoqueModel obj = new AlteracaoEstoqueModel();
                
                obj.setData_alteracao(rs.getString("data_alteracao"));
                obj.setQtd_inicial(rs.getInt("ae.qtd_inicial"));
                obj.setQtd_adicionada(rs.getInt("ae.qtd_adicionada"));
                UsuarioModel u = new UsuarioModel();
                u.setUsusario_id(rs.getInt("ae.usuario_alteracao_id"));
                obj.setUsuario(u);
                ProdutoModel p = new ProdutoModel();
                p.setProduto_id(rs.getInt("ae.produto_id"));
                obj.setProduto(p);
                obj.setMotivo_alteracao(rs.getString("ae.motivo_alteracao"));
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o Histórico de Alteração: " + " " + e);
            return null;
        }
        
    }
    
}
