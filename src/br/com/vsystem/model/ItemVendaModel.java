
package br.com.vsystem.model;

public class ItemVendaModel {
    private int itensvenda_id;
    private VendaModel venda;
    private ProdutoModel produto;
    private int qtd;
    private double subtotal;

    public int getItensvenda_id() {
        return itensvenda_id;
    }

    public VendaModel getVenda() {
        return venda;
    }

    public void setVenda(VendaModel venda) {
        this.venda = venda;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public void setItensvenda_id(int itensvenda_id) {
        this.itensvenda_id = itensvenda_id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
