
package br.com.vsystem.model;


public class AlteracaoEstoqueModel {
    private int alteracaoestoque_id;
    private UsuarioModel usuario;
    private ProdutoModel produto;
    private String data_alteracao;
    private String motivo_alteracao;
    private int qtd_inicial;
    private int qtd_adicionada;

    public int getAlteracaoestoque_id() {
        return alteracaoestoque_id;
    }

    public void setAlteracaoestoque_id(int alteracaoestoque_id) {
        this.alteracaoestoque_id = alteracaoestoque_id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public String getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(String data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public String getMotivo_alteracao() {
        return motivo_alteracao;
    }

    public void setMotivo_alteracao(String motivo_alteracao) {
        this.motivo_alteracao = motivo_alteracao;
    }

    public int getQtd_inicial() {
        return qtd_inicial;
    }

    public void setQtd_inicial(int qtd_inicial) {
        this.qtd_inicial = qtd_inicial;
    }

    public int getQtd_adicionada() {
        return qtd_adicionada;
    }

    public void setQtd_adicionada(int qtd_adicionada) {
        this.qtd_adicionada = qtd_adicionada;
    }
    
    
    
    
}
