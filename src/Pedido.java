import java.util.ArrayList;

public class Pedido{
  private static int idCounter = 0;
  private int id;
  private Usuario usuario;
  private String status;
  private String dataInicio;
  private String dataConclusao;
  private double valorTotal;
  private ArrayList<Item> listaItens;

  public Pedido(String dataInicio, Usuario usuario){
      this.status = "aberto";
      this.dataInicio = dataInicio;
      this.dataConclusao = null;
      this.valorTotal = 0;
      this.usuario = usuario;
      Pedido.idCounter++;
      this.id = Pedido.idCounter;
      this.listaItens = new ArrayList<Item>();
  }

  public String getDataInicio() { return this.dataInicio; } 

  //[TODO] Implementar toString
  public String toString() { return "\nid: " + this.id + "\nDono do pedido: " + this.usuario.getNome() + "\nstatus: " + this.status;}
}