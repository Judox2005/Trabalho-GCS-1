public class Pedido{
    private String status;
    private String dataInicio;
    private String dataConclusao;
    private double valorTotal;
    private int id;
    public Pedido(String status, String dataInicio, String dataConclusao, double valorTotal, int id){
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.valorTotal = valorTotal;
        this.id = id;
    }
    

}