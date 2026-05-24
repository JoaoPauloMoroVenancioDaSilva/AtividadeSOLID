package LSP;

public class Pizza extends Produto {

    private String tamanho;
    private String[] adicionais;

    public Pizza(String nome, double preco, String tamanho, String[] adicionais) {
        super(nome, preco, "Pizza artesanal massa fina");
        this.tamanho = tamanho;
        this.adicionais = adicionais;
    }


    @Override
    public String getDetalhes() {
        String extras = adicionais.length > 0
                ? String.join(", ", adicionais)
                : "sem adicionais";
        return String.format("Tamanho: %s | Adicionais: %s", tamanho, extras);
    }

    public String getTamanho() {
        return tamanho;
    }
}
