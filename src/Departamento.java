import java.util.ArrayList;

public class Departamento {
    private double valorMaximoPedido;
    private String nome;

    public Departamento(String nome, double valorMaximoPedido) {
        this.valorMaximoPedido = valorMaximoPedido;
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public double getvalorMaximoPedido(){
        return valorMaximoPedido;
    }
}
