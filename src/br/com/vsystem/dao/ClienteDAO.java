
package br.com.vsystem.dao;

import br.com.vsystem.model.ClienteModel;
import javax.swing.JOptionPane;

public class ClienteDAO {
    //Metodo Cadastrar Clientes
    public void cadastraCliente(ClienteModel obj){
        try {
            String sqlEndereco = "insert into tb_endereco (cep, endereco, numero,complemento, bairro, cidade, estado, apagado)"
                    +"values (?,?,?,?,?,?,?,?)";
            String sqlTelefone = "insert into tb_cliente (celular, telefone, apagado) values (?,?,?)";
            String sqlCliente = "insert into tb_cliente (nome, cpf, apagado) values (?,?,?)";
            
            
            
            
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
