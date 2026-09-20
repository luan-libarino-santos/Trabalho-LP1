package restaurante;

public class Produto {

    private String nome;
    private  double preco;
    private boolean disponivel;

    public Produto (String nome, double preco, boolean disponivel) {
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return this.nome;
    }
    public  double getPreco () {
        return this.preco;
    }
    public  boolean isDisponivel() {
        return this.disponivel;
    }
    public void disponibilizar() {
        this.disponivel = true;
    }
    public  void indisponibilizar() {
        this.disponivel = false;
    }
}
