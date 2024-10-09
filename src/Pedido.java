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
  
  public void adicionarItem(Item item){
    this.listaItens.add(item);
    this.valorTotal += item.getValor() * item.getQuantidade();
  }

  public ArrayList<Item> getListaItens() { return this.listaItens; }

  public String getDataInicio() { return this.dataInicio; } 

  public String getDataConclusao() { return this.dataConclusao; }
  
  public Usuario getUsuario() { return this.usuario; }

  public int getId() { return this.id; }

  public double getValorTotal() { return this.valorTotal; }

  public String getStatus() { return this.status; }

  public void setStatus(String status) { this.status = status; }

  public void setDataConclusao(String dataConclusao) { this.dataConclusao = dataConclusao; }

  //[TODO] Implementar toString
  public String toString() { return "\nid: " + this.id + "\nDono do pedido: " + this.usuario.getNome() + "\nstatus: " + this.status;}
}