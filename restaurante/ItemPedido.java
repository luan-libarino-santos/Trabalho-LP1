package restaurante;

public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido (Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;

    }

    public Produto getProduto() {
        return this.produto;
    }
    public int getQuantidade() {
        return  this.quantidade;
    }
    public double calcularSubtotal() {
        return this.produto.getPreco() * quantidade;
    }
}
