
package br.com.vsystem.model;

public class ProdutoModel {
    //Atributos
    private int produto_id;
    private String descricao;
    private double preco;
    private int qtd_estoque;
    private String barras;
    private FornecedorModel fornecedor;
    private String apagado;
    
    //Getters and Setters

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getApagado() {
        return apagado;
    }

    public void setApagado(String apagado) {
        this.apagado = apagado;
    }
    
}
