package LSP;

public class Bebida extends Produto{

    private double volume;
    private boolean gelada;
    private boolean disponivel;

    public Bebida(String nome, double preco, double volume, boolean gelada) {
        super(nome,preco, "Bebida refrescante");
        this.volume = volume;
        this.gelada = gelada;
        this.disponivel = true;
    }

    @Override
    public String getDetalhes() {
        return String.format("Volume: %.0fml | %s", volume, gelada ? "Gelada" : "Natural");
    }

    @Override
    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}