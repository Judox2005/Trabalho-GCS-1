import java.util.ArrayList;

public class Departamento {
    private double valorMaximoPedido;
    private String nome;
    private ArrayList<Usuario> membrosDepartamento;

    public Departamento(String nome, double valorMaximoPedido) {
        this.valorMaximoPedido = valorMaximoPedido;
        this.nome = nome;
        this.membrosDepartamento = new ArrayList<>();
    }
    public String getNome(){
        return nome;
    }
    public double getvalorMaximoPedido(){
        return valorMaximoPedido;
    }
}
