
package br.com.vsystem.model;

public class ItensVenda {
    private int itensvenda_id;
    private VendaModel venda_id;
    private ProdutoModel produto_id;
    private int qtd;
    private double subtotal;

    public int getItensvenda_id() {
        return itensvenda_id;
    }

    public void setItensvenda_id(int itensvenda_id) {
        this.itensvenda_id = itensvenda_id;
    }

    public VendaModel getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(VendaModel venda_id) {
        this.venda_id = venda_id;
    }

    public ProdutoModel getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(ProdutoModel produto_id) {
        this.produto_id = produto_id;
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
