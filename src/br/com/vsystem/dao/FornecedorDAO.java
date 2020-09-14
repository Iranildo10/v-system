
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.EnderecoModel;
import br.com.vsystem.model.FornecedorModel;
import br.com.vsystem.model.TelefoneModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {
    
    private Connection con;

    public FornecedorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo Cadastrar Fornecedores
    public void cadastrarCliente(FornecedorModel forn, EnderecoModel end, TelefoneModel tel){
        
    
        try {
     
            String sqlEndereco = "insert into tb_endereco (cep, endereco, numero,complemento, bairro, cidade, estado, apagado)"
                    +"values (?,?,?,?,?,?,?,?)";
            String sqlTelefone = "insert into tb_telefone (celular, telefone, apagado) values (?,?,?)";
            String sqlFornecedor = "insert into tb_fornecedor (nome_fantasia, razao_social, cnpj, email, apagado, telefone_id, endereco_id) values (?,?,?,?,?,?,?)";
            
            //Cadastrar endereco
            
            PreparedStatement stmt = con.prepareStatement(sqlEndereco);
            
            stmt.setString(1, end.getCep());
            stmt.setString(2, end.getEndereco());
            stmt.setString(3, end.getNumero());
            stmt.setString(4, end.getComplemento());
            stmt.setString(5, end.getBairro());
            stmt.setString(6, end.getCidade());
            stmt.setString(7, end.getEstado());
            stmt.setString(8, end.getApagado());
            
            stmt.execute();
            stmt.close();
            
            //Retornar ID do ultimo endereco cadastrado
            
            int idEndereco = 0;
            String sql = "select max(endereco_id) endereco_id from tb_endereco";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                EnderecoModel e = new EnderecoModel();
                e.setEndereco_id(rs.getInt("endereco_id"));
                idEndereco = e.getEndereco_id();
            }
            
            //Cadastrar Telefone
            stmt = con.prepareStatement(sqlTelefone);
            
            stmt.setString(1, tel.getCelular());
            stmt.setString(2, tel.getTelefone());
            stmt.setString(3, tel.getApagado());
            
            stmt.execute();
            stmt.close();
            
            //Retorna ID do ultimo endereco
            int idTelefone = 0;
            sql = "select max(telefone_id) telefone_id from tb_telefone";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                TelefoneModel t = new TelefoneModel();
                t.setTelefone_id(rs.getInt("telefone_id"));
                idTelefone = t.getTelefone_id();
            }
            
            //Cadastrar Fornecedor
            stmt = con.prepareStatement(sqlFornecedor);
            
            //nome_fantasia, razao_social, cnpj, email, apagado, telefone_id, endereco_id
            stmt.setString(1, forn.getNome_fantasia());
            stmt.setString(2, forn.getRazao_social());
            stmt.setString(3, forn.getCnpj());
            stmt.setString(4, forn.getEmail());
            stmt.setString(5, forn.getApagado());
            stmt.setInt(6, idTelefone);
            stmt.setInt(7, idEndereco);
            
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        
    }
    
    //Metodo alterar Fornecedor
    public void alterarFornecedor(FornecedorModel forn, EnderecoModel end, TelefoneModel tel){
        
        try {
            
    
            String sqlFornecedor = "update tb_fornecedor set nome_fantasia = ?, razao_social = ?,  cnpj = ?, email = ? where fornecedor_id = ?";
            String sqlTelefone = "update tb_telefone set celular = ?, telefone = ? where telefone_id = ?";
            String sqlEndereco = "update tb_endereco set cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ? where endereco_id = ?";
            
            int idTelefone = 0;
            String sql =  "select telefone_id from tb_fornecedor where fornecedor_id = " + forn.getFornecedor_id();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TelefoneModel t = new TelefoneModel();
                t.setTelefone_id(rs.getInt("telefone_id"));
                idTelefone = t.getTelefone_id();
            }
            
            int idEndereco = 0;
            sql = "select endereco_id from tb_fornecedor where fornecedor_id = " + forn.getFornecedor_id();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                EnderecoModel e = new EnderecoModel();
                e.setEndereco_id(rs.getInt("endereco_id"));
                idEndereco = e.getEndereco_id();
            }
            
           
            
            PreparedStatement stmt = con.prepareStatement(sqlFornecedor);
           
            //Alterar fornecedor
            stmt = con.prepareStatement(sqlFornecedor);
            //update tb_fornecedor set nome_fantasia = ?, razao_social = ?,  cnpj = ?, email = ? where fornecedor_id = ?
            stmt.setString(1, forn.getNome_fantasia());
            stmt.setString(2, forn.getRazao_social());
            stmt.setString(3, forn.getCnpj());
            stmt.setString(4, forn.getEmail());
            stmt.setInt(5, forn.getFornecedor_id());
            
            
            stmt.execute();
            stmt.close();
            
            
  
            stmt = con.prepareStatement(sqlTelefone);
            
            stmt.setString(1, tel.getCelular());
            stmt.setString(2, tel.getTelefone());
            stmt.setInt(3, idTelefone);
         
            
            stmt.execute();
            stmt.close();
            
            stmt = con.prepareStatement(sqlEndereco);
            
            stmt.setString(1, end.getCep());
            stmt.setString(2, end.getEndereco());
            stmt.setString(3, end.getNumero());
            stmt.setString(4, end.getComplemento());
            stmt.setString(5, end.getBairro());
            stmt.setString(6, end.getCidade());
            stmt.setString(7, end.getEstado());
            stmt.setInt(8, idEndereco);
            
            
            stmt.execute();
            stmt.close();
            
            
            
    
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    
    //Metodo Excluir Fornecedor
    public void excluirFornecedor(FornecedorModel forn){
        
         try {
            
            String sqlFornecedor = "update tb_fornecedor set apagado = ? where fornecedor_id = ?";
            
             PreparedStatement stmt = con.prepareStatement(sqlFornecedor);
           
            //Excluir fornecedor
            stmt = con.prepareStatement(sqlFornecedor);
            
            stmt.setString(1, forn.getApagado());
            stmt.setInt(2, forn.getFornecedor_id());
           
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Fornecedor excluido com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    
    
    //Listar todos
    public List<FornecedorModel> listarTodos(){
        
        try {

            //1 passo - criar a lista
            List<FornecedorModel> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e executar
            String sql = "select f.fornecedor_id, f.nome_fantasia, f.razao_social, f.cnpj, f.email, t.celular, t.telefone, e.cep, e.cidade,  e.endereco, e.numero, e.estado, e.bairro, e.complemento from tb_fornecedor as f \n" +
                            "inner join tb_endereco as e \n" +
                            "on (f.endereco_id = e.endereco_id ) \n" +
                            "inner join tb_telefone as t \n" +
                            "on (f.telefone_id = t.telefone_id) \n" +
                             "where f.apagado = 'N' ";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

           while(rs.next()){
                FornecedorModel forn = new FornecedorModel();
                EnderecoModel end = new EnderecoModel();
                TelefoneModel tel = new TelefoneModel();
                
                forn.setFornecedor_id(rs.getInt("f.fornecedor_id"));
                forn.setNome_fantasia(rs.getString("f.nome_fantasia"));
                forn.setRazao_social(rs.getString("f.razao_social"));
                forn.setCnpj(rs.getString("f.cnpj"));
                forn.setEmail(rs.getString("f.email"));
                tel.setCelular(rs.getString("t.celular"));
                tel.setTelefone(rs.getString("t.telefone"));
                forn.setTelefone(tel);
                end.setCep(rs.getString("e.cep"));
                end.setCidade(rs.getString("e.cidade"));
                end.setEndereco(rs.getString("e.endereco"));
                end.setNumero(rs.getString("e.numero"));
                end.setEstado(rs.getString("e.estado"));
                end.setBairro(rs.getString("e.bairro"));
                end.setComplemento(rs.getString("e.complemento"));
                forn.setEndereco(end);
                
                lista.add(forn);
                
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + " " + erro);
            return null;

        }
        
    }
    
    
}
