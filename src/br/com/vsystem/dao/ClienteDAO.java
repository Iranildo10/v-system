
package br.com.vsystem.dao;

import br.com.vsystem.jdbc.ConnectionFactory;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.EnderecoModel;
import br.com.vsystem.model.TelefoneModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    //Metodo Cadastrar Clientes
    public void cadastraCliente(ClienteModel cli, EnderecoModel end, TelefoneModel tel){
        try {
            
            
            String sqlEndereco = "insert into tb_endereco (cep, endereco, numero,complemento, bairro, cidade, estado, apagado)"
                    +"values (?,?,?,?,?,?,?,?)";
            String sqlTelefone = "insert into tb_cliente (celular, telefone, apagado) values (?,?,?)";
            String sqlCliente = "insert into tb_cliente (nome, cpf, apagado, telefone_id, endereco_id) values (?,?,?,?,?)";
            
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
            String sql = "select max(id) id from tb_endereco";
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
            sql = "select max(id) id from tb_telefone";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                TelefoneModel t = new TelefoneModel();
                t.setTelefone_id(rs.getInt("telefone_id"));
                idTelefone = t.getTelefone_id();
            }
            
            //Cadastrar cliente
            stmt = con.prepareStatement(sqlCliente);
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getApagado());
            stmt.setInt(4, idTelefone);
            stmt.setInt(5, idEndereco);
            
            stmt.execute();
            stmt.close();
            
    
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    
    //Metodo alterar Clientes
    public void alterarClientes(ClienteModel obj){
    
    }
    
    //Metodo Exlucir Cliente
    public void excluirClientes(ClienteModel obj){
    
    }
}
