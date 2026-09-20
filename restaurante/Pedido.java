package restaurante;

public class Pedido {
    private Cliente cliente;
    private Mesa mesa;
    private ItemPedido[] itens;
    private int quantidadeItens;
    private boolean ativo;

    public Pedido (Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.mesa.ocupar();
        this.itens = new ItemPedido[100];
        this.quantidadeItens = 0;
        this.ativo = true;
    }
    public void adicionarItem (Produto produto, int quantidade) {
        this.itens[quantidadeItens] = new ItemPedido(produto, quantidade);
        this.quantidadeItens ++;
        
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < this.quantidadeItens; i++) {
            total += this.itens[i].calcularSubtotal();
        }
        return total;
    }

    public void finalizar () {
        this.ativo = false;
        this.mesa.liberar();

    }

    public String getCliente() {
        return this.cliente.getNome();
    }
    public int getMesa() {
        return this.mesa.getNumero();
    }
    public boolean isAtivo() {
        return this.ativo;
    }
    public void exibirItens(int i) {
        if (i >= this.quantidadeItens) {
            return;
        }
        System.out.println(
            this.itens[i].getProduto().getNome() + ": " + this.itens[i].getQuantidade() + " und"
        );
        exibirItens(i+1);
    }
}
