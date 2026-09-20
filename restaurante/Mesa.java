package restaurante;

public class Mesa {
    private int numero;
    private boolean disponivel;

    public Mesa(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return this.numero;
    }
    public boolean isDisponivel() {
        return  this.disponivel;
    }
    public void ocupar () {
        this.disponivel = false;
    }
    public void liberar () {
        this.disponivel = true;
    }

}
