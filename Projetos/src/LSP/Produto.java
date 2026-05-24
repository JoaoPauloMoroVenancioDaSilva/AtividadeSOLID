package LSP;

public abstract class Produto {

    protected String nome;
    protected double preco;
    protected String descricao;

    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public abstract String getDetalhes();

    public boolean isDisponivel(){
        return true;
    }

    public void exibir(){
        System.out.printf("  Produto: %s%n", nome);
        System.out.printf("  Preço: R$ %.2f%n", preco);
        System.out.printf("  Descricao: %s%n", descricao);
        System.out.printf("  Detalhes: %s%n", getDetalhes());
        System.out.printf("  Disponível: %s%n", isDisponivel() ? "Sim" : "Não");
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }


}
