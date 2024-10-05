import java.util.ArrayList;

public class Departamento {
    private int valorMaximoPedido;
    private String nome;
    private ArrayList<Usuario> membrosDepartamento;

    public Departamento(int valorMaximoPedido, String nome) {
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
