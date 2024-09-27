public class Item {
    private String descricao;
    private double valor;
    private int quantidade;

    public Item(String descricao, double valor, int quantidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Descricao: " + descricao + "\n" + "Valor: " + valor + "\n" + "Quantidade: " + quantidade;
    }
}