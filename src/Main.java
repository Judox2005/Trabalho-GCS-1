import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        App app = new App();
        app.executar();
    }
    private static List<Departamento> departamentos = new ArrayList<>();
    private static void iniciarDepartamento(){
        departamentos.add(new Departamento("Financeiro",1000.0));
        departamentos.add(new Departamento("TI",4000.0));
        departamentos.add(new Departamento("RH",2000.0));
        departamentos.add(new Departamento("Engenharia",1000.0));
        departamentos.add(new Departamento("Manutenção",600.0));    
 }   
    private static void iniciarUsuario(){
        usuarios.add(new Usuario(1,"Arthur","Funcionário",departamentos.get(0))); //Financeiro
        usuarios.add(new Usuario(2,"Arthur","Administrador",departamentos.get(1))); //TI
        usuarios.add(new Usuario(3,"Arthur","Funcionário",departamentos.get(2))); //RH
        usuarios.add(new Usuario(4,"Arthur","Funcionário",departamentos.get(3))); //Engenharia
        usuarios.add(new Usuario(5,"Arthur","Funcionário",departamentos.get(4))); //Manutenção
    }
    private static void registrarNovoPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Novo pedido para "+usuarioAtual.getNome());
        System.out.println("Departamento: "+usuarioAtual.getDepartamento().getNome());
        System.out.println("Limite de cada Departamento: "+usuarioAtual.getDepartamento().getvalorMaximoPedido());

        Pedido novoPedido = new Pedido(Pedido.size()+1,usuarioAtual);
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
            System.out.println("Valor total do pedido até o momento: "+novoPedido.getvalorMaximoPedido());
        } else{
            break;
        } 
     }
            double limiteDepartamento = usuarioAtual.getDepartamento().getvalorMaximoPedido();
            if(novoPedido.getvalorMaximoPedido()>limiteDepartamento){
                System.out.println("O valor do pedido ultrapassa o limite permitido pelo Departamento: "+limiteDepartamento);
                System.out.println("Pedido não registrado!");
            }else{
                System.out.println("Deseja confirmar o pedido? Sim ou não?");
                String confirmacao = scanner.nextLine(); feat
            
                if(confirmacao.equalsIgnoreCase("Sim")){
                    pedido.add(novoPedido);
                    System.out.println("Pedido registrado com sucesso!");
                }else{
                    System.out.println("Pedido cancelado");
                }
            }
    }
}