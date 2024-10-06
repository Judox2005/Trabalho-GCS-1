import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
public class Registro {
    private ArrayList<Pedido> pedidos;
    public Registro(){
        this.pedidos = new ArrayList<>();

        //[ Piedro ] adicionei alguns pedidos para testar os métodos, se quiser pode remover
        pedidos.add(new Pedido("18/10/2003", new Usuario(1,"João", 1, new Departamento(100, "TI"))));
        pedidos.add(new Pedido("01/01/2021", new Usuario(1,"maira", 1, new Departamento(100, "TI"))));
        pedidos.add(new Pedido("05/05/2021", new Usuario(1,"thiago", 1, new Departamento(100, "TI"))));
        pedidos.add(new Pedido("12/04/2024", new Usuario(1,"larissa", 1, new Departamento(100, "TI"))));
    }

    public void registrarNovoPedido(Usuario usuario){

    }

    //[ Fernando ] adicionei o parametro de usuario, oq nao estava no diagrama
    public boolean excluirPedido(Usuario usuario) {
        Scanner in = new Scanner(System.in);
        int aux = 0;
        for(Pedido p : pedidos) {
            if(p.getUsuario().equals(usuario)) {
                System.out.println(p.toString());
                aux++;
            }
        }
        if(aux == 0) {
            System.out.println("Voce nao tem pedidos");
            return false;
        }
        System.out.println("Digite o id do pedido a ser excluido:");
        int id = in.nextInt();
        for(Pedido p : pedidos) {
            if(p.getId() == id && p.getUsuario().equals(usuario)) {
                pedidos.remove(p);
                System.out.println("Pedido excluido com sucesso!");
                return true;
            }
        }
        System.out.println("Voce nao possui um pedido com este id!");
        System.out.println("Erro ao excluir pedido!");
        return false;
    }

    public boolean editarStatusPeloId(){
        return false;
    } 
    public void listarTodosPedidosEntreDatas() {
        Scanner in = new Scanner(System.in);
        String dataMinima;
        String dataMaxima;
        while(true) {
            try {
                String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
                Pattern pattern = Pattern.compile(regex);
                System.out.println("\fDigite a data mínima da busca no formato DD/MM/AAAA");
                dataMinima = in.nextLine();
                Matcher matcher = pattern.matcher(dataMinima);
                if (!matcher.matches()) { throw new Exception(); }
                System.out.println("Digite a data máxima da busca no formato DD/MM/AAAA");
                dataMaxima = in.nextLine();
                matcher = pattern.matcher(dataMaxima);
                if (!matcher.matches()) { throw new Exception(); }
                break;
            } catch (Exception e) {
                System.out.println("\fData informada não válida, tente novamente.");
            }
        }
        String[] dataMinimaArray = dataMinima.split("/");
        String[] dataMaximaArray = dataMaxima.split("/");
        int diaMin = Integer.parseInt(dataMinimaArray[0]);
        int mesMin = Integer.parseInt(dataMinimaArray[1]);
        int anoMin = Integer.parseInt(dataMinimaArray[2]);
        int diaMax = Integer.parseInt(dataMaximaArray[0]);
        int mesMax = Integer.parseInt(dataMaximaArray[1]);
        int anoMax = Integer.parseInt(dataMaximaArray[2]);
        for (Pedido pedido : pedidos) {
            String[] datas = pedido.getDataInicio().split("/");
            int dia = Integer.parseInt(datas[0]);
            int mes = Integer.parseInt(datas[1]);
            int ano = Integer.parseInt(datas[2]);
            if (ano < anoMin || ano > anoMax) { continue; }
            if (ano == anoMin && mes < mesMin) { continue; }
            if (ano == anoMax && mes > mesMax) { continue; }
            if (ano == anoMin && mes == mesMin && dia < diaMin) { continue; }
            if (ano == anoMax && mes == mesMax && dia > diaMax) { continue; }
            System.out.println(pedido.toString());
        }
        in.close();
    }
    public void buscaPedidosPeloItem(){
    
    }
    public void verDetalhesDoPedido(){

    }
    public void verNumeroTotalDePedidos(){

    }
    public void verDetalhesDoPedidoComMaiorValor(){

    }
    public void verNumeroDePedidoNosUltimos30Dias(){

    }
    public void verNumeroPedidosPorCategoria(){
    }
    public void verPedidosPelaDescricao(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a descrição do item que deseja: ");
        String descricao = in.nextLine();
        int aux = 0;
        in.close();
        for(Pedido p : pedidos) {
            for(Item i : p.getListaItens()) {
                if(i.getDescricao().equals(descricao)) {
                    System.out.println(p.toString());
                    aux++;
                }
            }
        }
        if (aux == 0) {
            System.out.println("Nenhum pedido encontrado com a descrição informada.");
        }
        return;
    }
}