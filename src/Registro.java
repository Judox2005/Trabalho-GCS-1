import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.time.LocalDate;
public class Registro {
    private ArrayList<Pedido> pedidos;
    public Registro(){
        this.pedidos = new ArrayList<>();

        //[ Piedro ] adicionei alguns pedidos para testar os métodos, se quiser pode remover
        pedidos.add(new Pedido("18/10/2003", new Usuario(1,"João", 1, new Departamento("TI", 100))));
        pedidos.add(new Pedido("01/01/2021", new Usuario(1,"maira", 1, new Departamento("TI", 100))));
        pedidos.add(new Pedido("05/05/2021", new Usuario(1,"thiago", 1, new Departamento( "TI", 100))));
        pedidos.add(new Pedido("12/04/2024", new Usuario(1,"larissa", 1, new Departamento("TI", 100))));
    }

    private void registraNovoPedido(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Novo pedido para " + usuario.getNome());
        System.out.println("Departamento: " + usuario.getDepartamento().getNome());
        System.out.println("Limite de cada Departamento: " + usuario.getDepartamento().getvalorMaximoPedido());
        System.out.println("Informe a data atual no formato DD/MM/AAAA: ");
        String data = scanner.nextLine();
        Pedido novoPedido = new Pedido(data, usuario);
        while(true){
            System.out.println("Deseja adicionar um novo item? Sim ou não?");
            String opcao = scanner.nextLine();

        if(opcao.equalsIgnoreCase("Sim")){
            System.out.println("Descrição do item: ");
            String descricao = scanner.nextLine();
            System.out.println("Valor unitário: ");
            double valorUnitario = scanner.nextDouble();
            System.out.println("Quantidade: ");
            int quantidade = scanner.nextInt();

            Item item = new Item(descricao, valorUnitario, quantidade);
            novoPedido.adicionarItem(item);
            System.out.println("Item adicionado com sucesso");
            System.out.println("Valor total do pedido até o momento: " + novoPedido.getValorTotal());
            } else{
                break;
            } 
        }

        double limiteDepartamento = usuario.getDepartamento().getvalorMaximoPedido();
        if(novoPedido.getValorTotal() > limiteDepartamento){
            System.out.println("O valor do pedido ultrapassa o limite permitido pelo Departamento: " + limiteDepartamento);
            System.out.println("Pedido não registrado!");
        }else{
            System.out.println("Deseja confirmar o pedido? Sim ou não?");
            String confirmacao = scanner.nextLine();
        
            if(confirmacao.equalsIgnoreCase("Sim")){
                pedidos.add(novoPedido);
                System.out.println("Pedido registrado com sucesso!");
            }else{
                System.out.println("Pedido cancelado");
            }
        }
    }

    //[ Fernando ] adicionei o parametro de usuario, oq nao estava no diagrama
    // [TODO] tratar excecoes
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
            in.close();
            return false;
        }
        System.out.println("Digite o id do pedido a ser excluido:");
        int id = in.nextInt();
        for(Pedido p : pedidos) {
            if(p.getId() == id && p.getUsuario().equals(usuario)) {
                pedidos.remove(p);
                System.out.println("Pedido excluido com sucesso!");
                in.close();
                return true;
            }
        }
        System.out.println("Voce nao possui um pedido com este id!");
        System.out.println("Erro ao excluir pedido!");
        in.close();
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
        int total = 0, aberto = 0, aprovado = 0, reprovado = 0;
        for(Pedido p : pedidos) {
            total++;
            if(p.getStatus().equalsIgnoreCase("aberto")) {
                aberto++;
            }
            if(p.getStatus().equalsIgnoreCase("aprovado")) {
                aprovado++;
            }
            if(p.getStatus().equalsIgnoreCase("reprovado")) {
                reprovado++;
            }
        }
        System.out.format("+-----------+-----+-----+");
        System.out.format("| categoria | qtd |  %  |");
        System.out.format("+-----------+-----+-----+");
        System.out.format("| aberto    | %3d | %3d |", aberto, (total / 100) * aberto);
        System.out.format("| aprovado  | %3d | %3d |", aprovado, (total / 100) * aprovado);
        System.out.format("| reprovado | %3d | %3d |", reprovado, (total / 100) * reprovado);
    }
    public void verDetalhesDoPedidoComMaiorValor(){

    }

    // [TODO] tratar excecoes
    public void verNumeroDePedidoNosUltimos30Dias(){
        Scanner in = new Scanner(System.in);
        int numPedidos = 0;
        double valorMedio = 0;

        System.out.println("Digite a data atual no formato DD/MM/AAAA:");
        String dataAtual = in.nextLine();
        int diaA = Integer.parseInt(String.valueOf(dataAtual.charAt(0)+dataAtual.charAt(1)));
        int mesA = Integer.parseInt(String.valueOf(dataAtual.charAt(3)+dataAtual.charAt(4)));
        int anoA = Integer.parseInt(String.valueOf(dataAtual.charAt(6)+dataAtual.charAt(7)+dataAtual.charAt(8)+dataAtual.charAt(9)));
        LocalDate dAtual = LocalDate.of(anoA, mesA, diaA);
        LocalDate InicioIntervalo = dAtual.minusDays(30);

        for(Pedido p : pedidos) {
            String dataPedido = p.getDataInicio();
            int diaP = Integer.parseInt(String.valueOf(dataPedido.charAt(0)+dataPedido.charAt(1)));
            int mesP = Integer.parseInt(String.valueOf(dataPedido.charAt(3)+dataPedido.charAt(4)));
            int anoP = Integer.parseInt(String.valueOf(dataPedido.charAt(6)+dataPedido.charAt(7)+dataPedido.charAt(8)+dataPedido.charAt(9)));
            LocalDate dPedido = LocalDate.of(anoP, mesP, diaP);
            if(dPedido.isAfter(InicioIntervalo) && dPedido.isBefore(dAtual.plusDays(1))) {
                numPedidos++;
                valorMedio = (valorMedio + p.getValorTotal())/numPedidos;
            }
        }
        System.out.println("Quantidade de pedidos: " + numPedidos);
        System.out.println("Valor medio: " + valorMedio);
        in.close();
    }
    
    public void verNumeroPedidosPorCategoria(){
        Scanner in = new Scanner(System.in);
        double vtAberto = 0, vtAprovado = 0, vtReprovado = 0;

        System.out.println("Digite a data atual no formato DD/MM/AAAA:");
        String dataAtual = in.nextLine();
        int diaA = Integer.parseInt(String.valueOf(dataAtual.charAt(0)+dataAtual.charAt(1)));
        int mesA = Integer.parseInt(String.valueOf(dataAtual.charAt(3)+dataAtual.charAt(4)));
        int anoA = Integer.parseInt(String.valueOf(dataAtual.charAt(6)+dataAtual.charAt(7)+dataAtual.charAt(8)+dataAtual.charAt(9)));
        LocalDate dAtual = LocalDate.of(anoA, mesA, diaA);
        LocalDate InicioIntervalo = dAtual.minusDays(30);

        for(Pedido p : pedidos) {
            String dataPedido = p.getDataInicio();
            int diaP = Integer.parseInt(String.valueOf(dataPedido.charAt(0)+dataPedido.charAt(1)));
            int mesP = Integer.parseInt(String.valueOf(dataPedido.charAt(3)+dataPedido.charAt(4)));
            int anoP = Integer.parseInt(String.valueOf(dataPedido.charAt(6)+dataPedido.charAt(7)+dataPedido.charAt(8)+dataPedido.charAt(9)));
            LocalDate dPedido = LocalDate.of(anoP, mesP, diaP);
            if(dPedido.isAfter(InicioIntervalo) && dPedido.isBefore(dAtual.plusDays(1))) {
                if(p.getStatus().equalsIgnoreCase("aberto")) {
                    vtAberto += p.getValorTotal();
                }
                if(p.getStatus().equalsIgnoreCase("aprovado")) {
                    vtAprovado += p.getValorTotal();
                }
                if(p.getStatus().equalsIgnoreCase("reprovado")) {
                    vtReprovado += p.getValorTotal();
                }
            }
        }
        System.out.println("aberto: " + vtAberto);
        System.out.println("aprovado: " + vtAprovado);
        System.out.println("reprovado: " + vtReprovado);
        in.close();
    }
}