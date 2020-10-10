
package br.com.vsystem.model;


public class VendaModel {
    private int venda_id;
    private ClienteModel cliente;
    private UsuarioModel usuario;
    private ItemVendaModel itemvenda;
    private ProdutoModel produto;
    private String data_venda;
    private String observacao;
    private double total_venda;
    private double desconto;

    public int getVenda_id() {
        return venda_id;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public ItemVendaModel getItemvenda() {
        return itemvenda;
    }

    public void setItemvenda(ItemVendaModel itemvenda) {
        this.itemvenda = itemvenda;
    }

    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getStatus_venda() {
        return status_venda;
    }

    public void setStatus_venda(String status_venda) {
        this.status_venda = status_venda;
    }
    private String status_venda;
    
}
