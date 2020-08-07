
package br.com.vsystem.model;

public class UsuarioModel {
    //Atributos
    private int ususario_id;
    private String nome;
    private String cpf;
    private String senha;
    private String cargo;
    private String nievel_acesso;
    private TelefoneModel telefone;
    private EnderecoModel endereco;
    private String apagado;
    
    //Getters and Setters

    public int getUsusario_id() {
        return ususario_id;
    }

    public void setUsusario_id(int ususario_id) {
        this.ususario_id = ususario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNievel_acesso() {
        return nievel_acesso;
    }

    public void setNievel_acesso(String nievel_acesso) {
        this.nievel_acesso = nievel_acesso;
    }

    public TelefoneModel getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneModel telefone) {
        this.telefone = telefone;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public String getApagado() {
        return apagado;
    }

    public void setApagado(String apagado) {
        this.apagado = apagado;
    }
    
}
