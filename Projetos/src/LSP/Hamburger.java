package LSP;

public class Hamburger extends Produto{

    private String tipoPao;
    private int gramas;
    private String acompanhamento;

    public Hamburger(String nome, double preco, String tipoPao, int gramas, String acompanhamento) {
        super(nome, preco, "Hamburger artesanal grelhado");
        this.tipoPao = tipoPao;
        this.gramas = gramas;
        this.acompanhamento = acompanhamento;
    }

    @Override
    public String getDetalhes() {
        return String.format("Pão: %s | %dg | Acompanhamento: %s",
                tipoPao, gramas, acompanhamento);
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }
}
