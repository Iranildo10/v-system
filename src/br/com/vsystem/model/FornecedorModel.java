
package br.com.vsystem.model;


public class FornecedorModel {
    private int fornecedor_id;
    private String nome_fantasia;
    private String razao_social;
    private String cnpj;
    private String email;
    private TelefoneModel telefone;
    private EnderecoModel endereco;
    private String apagado;

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    @Override
    public String toString(){
        return this.getNome_fantasia();
    }
    
}
