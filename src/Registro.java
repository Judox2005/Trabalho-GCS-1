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

    public void registraNovoPedido(Usuario usuario) {
        System.out.println("Novo pedido para " + usuario.getNome());
        System.out.println("Departamento: " + usuario.getDepartamento().getNome());
        System.out.println("Limite de cada Departamento: " + usuario.getDepartamento().getvalorMaximoPedido());
        System.out.println("Informe a data atual no formato DD/MM/AAAA: ");
        String dataInicio = App.in.nextLine();
        Pedido novoPedido = new Pedido(dataInicio, usuario);
        while(true){
            System.out.println("Deseja adicionar um novo item? Sim ou não?");
            String opcao = App.in.nextLine();

            if(opcao.equalsIgnoreCase("Sim")){
                System.out.println("Descrição do item: ");
                String descricao = App.in.nextLine();
                System.out.println("Valor unitário: ");
                double valorUnitario = App.in.nextDouble();
                System.out.println("Quantidade: ");
                int quantidade = App.in.nextInt();
                App.in.nextLine();

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
            String confirmacao = App.in.nextLine();
        
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
        int aux = 0;
        System.out.println("Seus pedidos:");
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
        int id = App.in.nextInt();
        App.in.nextLine();
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
        String dataMinima;
        String dataMaxima;
        while(true) {
            try {
                String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
                Pattern pattern = Pattern.compile(regex);
                System.out.println("\fDigite a data mínima da busca no formato DD/MM/AAAA");
                dataMinima = App.in.nextLine();
                Matcher matcher = pattern.matcher(dataMinima);
                if (!matcher.matches()) { throw new Exception(); }
                System.out.println("Digite a data máxima da busca no formato DD/MM/AAAA");
                dataMaxima = App.in.nextLine();
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
    }
    public void detalhesDoPedidoDeMaiorValor(){
        Pedido aux1 = null;
        for (int i = 0; i<pedidos.size(); i++){
          if (pedidos.get(i).getStatus().equals("aberto")){
                if(pedidos.get(i).getValorTotal() > aux1.getValorTotal())
                aux1 = pedidos.get(i);
            } 
        }
            System.out.println(aux1.toString());
    }
    public void pedidosDeUmFuncionario(){

        int id ;
        System.out.println("Digite o Id do funcionário para consultar um possível pedido");
        id = App.in.nextInt();
        App.in.nextLine();
        Pedido aux2 = null;
        for (int i = 0; i<pedidos.size(); i++){
            if (pedidos.get(i).getUsuario().getId() == id){
                aux2 = pedidos.get(i);
             System.out.println( aux2.toString() );}
            else 
            System.out.println("Não existem pedidos feitos por esse usuário" );
        }
    }
    public void editarStatus(){
        int id ;
        int opcao ;
        System.out.println("Digite o Id do pedido para aprova-lo ou reprova-lo");
        id = App.in.nextInt();
        App.in.nextLine();
        Pedido aux3 = null;
        for (int i = 0; i<pedidos.size(); i++){
            if (pedidos.get(i).getId() == id && pedidos.get(i).getStatus().equals("aberto")){
                aux3 = pedidos.get(i);
                System.out.println( "digite 1 para aprova-lo ou digite 2 para reprova-lo");
                opcao = App.in.nextInt();
                App.in.nextLine();
                if (opcao == 1){
                    aux3.setStatus("aprovado");
                }
                else if (opcao == 2){
                    aux3.setStatus("reprovado");
                }
                System.out.println(aux3.getStatus() + " " + "Status atualizado com sucesso!" );
                return ;
            }
        }
        System.out.println("erro, retornando ao menu...");
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
        int numPedidos = 0;
        double valorMedio = 0;

        System.out.println("Digite a data atual no formato DD/MM/AAAA:");
        String dataAtual = App.in.nextLine();
        String[] dataAtualArray = dataAtual.split("/");
        int diaA = Integer.parseInt(dataAtualArray[0]);
        int mesA = Integer.parseInt(dataAtualArray[1]);
        int anoA = Integer.parseInt(dataAtualArray[2]);
        LocalDate dAtual = LocalDate.of(anoA, mesA, diaA);
        LocalDate InicioIntervalo = dAtual.minusDays(30);

        for(Pedido p : pedidos) {
            String dataPedido = p.getDataInicio();
            String[] dataPedidoArray = dataPedido.split("/");
            int diaP = Integer.parseInt(dataPedidoArray[0]);
            int mesP = Integer.parseInt(dataPedidoArray[1]);
            int anoP = Integer.parseInt(dataPedidoArray[2]);
            LocalDate dPedido = LocalDate.of(anoP, mesP, diaP);
            if(dPedido.isAfter(InicioIntervalo) && dPedido.isBefore(dAtual.plusDays(1))) {
                numPedidos++;
                valorMedio = (valorMedio + p.getValorTotal())/numPedidos;
            }
        }
        System.out.println("Quantidade de pedidos: " + numPedidos);
        System.out.println("Valor medio: " + valorMedio);
    }
    
    public void verNumeroPedidosPorCategoria(){
        double vtAberto = 0, vtAprovado = 0, vtReprovado = 0;

        System.out.println("Digite a data atual no formato DD/MM/AAAA:");
        String dataAtual = App.in.nextLine();
        String[] dataAtualArray = dataAtual.split("/");
        int diaA = Integer.parseInt(dataAtualArray[0]);
        int mesA = Integer.parseInt(dataAtualArray[1]);
        int anoA = Integer.parseInt(dataAtualArray[2]);
        LocalDate dAtual = LocalDate.of(anoA, mesA, diaA);
        LocalDate InicioIntervalo = dAtual.minusDays(30);

        for(Pedido p : pedidos) {
            String dataPedido = p.getDataInicio();
            String[] dataPedidoArray = dataPedido.split("/");
            int diaP = Integer.parseInt(dataPedidoArray[0]);
            int mesP = Integer.parseInt(dataPedidoArray[1]);
            int anoP = Integer.parseInt(dataPedidoArray[2]);
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
    }
    public void verPedidosPelaDescricao(){
        System.out.println("Digite a descrição do item que deseja: ");
        String descricao = App.in.nextLine();
        int aux = 0;
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