package model.bean;

/**
 * Item de uma compra (tabela NxN compra_produto).
 */
public class CompraProduto {
    private Compra compra;
    private Produto produto;
    private int quantidade;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
