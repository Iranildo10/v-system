package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.UsuarioModel;
import br.com.vsystem.model.EnderecoModel;
import br.com.vsystem.model.TelefoneModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    //Conexão
    private Connection con;

    public UsuarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo Cadastrar Usuario
    public void cadastrarUsuario(UsuarioModel fun, EnderecoModel end, TelefoneModel tel){
        
    
        try {
     
            String sqlEndereco = "insert into tb_endereco (cep, endereco, numero,complemento, bairro, cidade, estado, apagado)"
                    +"values (?,?,?,?,?,?,?,?)";
            String sqlTelefone = "insert into tb_telefone (celular, telefone, apagado) values (?,?,?)";
            String sqlUsuario = "insert into tb_usuario (nome, cpf, senha, cargo, nivel_acesso, telefone_id, endereco_id,apagado) values (?,?,?,?,?,?,?,?)";
            
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
            
            //Cadastrar usuario
            stmt = con.prepareStatement(sqlUsuario);
            
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getCpf());
            stmt.setString(3, fun.getSenha());
            stmt.setString(4, fun.getCargo());
            stmt.setString(5, fun.getNievel_acesso());
            stmt.setInt(6, idTelefone);
            stmt.setInt(7, idEndereco);
            stmt.setString(8, fun.getApagado());
            
            
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        
    }  
    
     public void alterarUsuario(UsuarioModel fun, EnderecoModel end, TelefoneModel tel){
        
        try {
            
    
            String sqlUsuario = "update tb_usuario set nome = ?, cpf = ?, senha = ?, cargo = ?, nivel_acesso = ? where usuario_id = ?";
            String sqlTelefone = "update tb_telefone set celular = ?, telefone = ? where telefone_id = ?";
            String sqlEndereco = "update tb_endereco set cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ? where endereco_id = ?";
            
            int idTelefone = 0;
            String sql =  "select telefone_id from tb_usuario where usuario_id = " + fun.getUsusario_id();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TelefoneModel t = new TelefoneModel();
                t.setTelefone_id(rs.getInt("telefone_id"));
                idTelefone = t.getTelefone_id();
            }
            
            int idEndereco = 0;
            sql = "select endereco_id from tb_usuario where usuario_id = " + fun.getUsusario_id();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                EnderecoModel e = new EnderecoModel();
                e.setEndereco_id(rs.getInt("endereco_id"));
                idEndereco = e.getEndereco_id();
            }
            
            //Cadastrar endereco
            
            PreparedStatement stmt = con.prepareStatement(sqlUsuario);
           
            //Alterar Funcionario
            stmt = con.prepareStatement(sqlUsuario);
            
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getCpf());
            stmt.setString(3, fun.getSenha());
            stmt.setString(4, fun.getCargo());
            stmt.setString(5, fun.getNievel_acesso());
            stmt.setInt(6, fun.getUsusario_id());
            
            
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
      
    //Excluir Funcionario
    public void excluirUsuario(UsuarioModel fun){
        
         try {

            String sqlUsuario = "update tb_usuario set apagado = ? where usuario_id = ?";
            
             PreparedStatement stmt = con.prepareStatement(sqlUsuario);
           
            //Alterar cliente
            stmt = con.prepareStatement(sqlUsuario);
            
            stmt.setString(1, fun.getApagado());
            stmt.setInt(2, fun.getUsusario_id());
           
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Funcionário excluido com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    //Listar Todos Funcionarios
    public List<UsuarioModel> listarTodos(){
        
        try {

            //1 passo - criar a lista
            List<UsuarioModel> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e executar
            String sql = "select u.usuario_id, u.nome, u.cpf, u.senha, u.cargo, u.nivel_acesso, t.celular, t.telefone, e.cep, e.cidade,  e.endereco, e.numero, e.estado, e.bairro, e.complemento from tb_usuario as u \n" +
                            "inner join tb_endereco as e \n" +
                            "on (u.endereco_id = e.endereco_id ) \n" +
                            "inner join tb_telefone as t \n" +
                            "on (u.telefone_id = t.telefone_id) \n" +
                             "where u.apagado = 'N' ";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

           while(rs.next()){
                UsuarioModel fun = new UsuarioModel();
                EnderecoModel end = new EnderecoModel();
                TelefoneModel tel = new TelefoneModel();
                
                fun.setUsusario_id(rs.getInt("u.usuario_id"));
                fun.setNome(rs.getString("u.nome"));
                fun.setCpf(rs.getString("u.cpf"));
                fun.setSenha(rs.getString("u.senha"));
                fun.setCargo(rs.getString("u.cargo"));
                fun.setNievel_acesso(rs.getString("u.nivel_acesso"));
                tel.setCelular(rs.getString("t.celular"));
                tel.setTelefone(rs.getString("t.telefone"));
                fun.setTelefone(tel);
                end.setCep(rs.getString("e.cep"));
                end.setCidade(rs.getString("e.cidade"));
                end.setEndereco(rs.getString("e.endereco"));
                end.setNumero(rs.getString("e.numero"));
                end.setEstado(rs.getString("e.estado"));
                end.setBairro(rs.getString("e.bairro"));
                end.setComplemento(rs.getString("e.complemento"));
                fun.setEndereco(end);
                
                lista.add(fun);
                
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + " " + erro);
            return null;

        }
        
    }
    
    //Método efetua login
    public boolean efetuaLogin(String codigo, String senha){
        try {
            //1 passo -SQl
            String sql = "select * from tb_usuario where usuario_id = ? and senha = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, codigo);
            stmt.setString(2, senha );
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja bem vido ao sistema :)");
                //FrmMenu tela = new FrmMenu();
                //tela.usuariologado = rs.getString("nome");
                //tela.setVisible(true);
                
                return true;
                
                
            }
            else
                JOptionPane.showMessageDialog(null, "Nao foi possivel logar no sistema :/");
                
                return false;
            
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro: " + erro);
           
             return false;
        }
    }
    
    
}
