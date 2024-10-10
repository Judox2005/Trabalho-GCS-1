import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner in = new Scanner(System.in);
    private Usuario usuario;
    private Registro registro;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Departamento> departamentos = new ArrayList<>();
    private int opc = 0;
    public App(){
        this.usuario = null;
        this.usuarios = new ArrayList<>();
        this.registro = new Registro();
    }

    public void executar(){
        iniciarDepartamento();
        iniciarUsuario();
        this.usuario = usuarios.get(1);
        System.out.println("Bem vindo, " + usuario.getNome() + "!");

        while (true) {
            if(usuario.getTipo() == 0){
                if(opc == 12){
                    break;
                }
                menuAdm();
            }else{
                if(opc == 4){ break;}
                menu();
            }
        }
    }

    public void alterarUsuarioAtual() {
        
        while(true) {
            System.out.println("ALTERAR USUARIO ATUAL:");
            System.out.println("Informe seu primeiro nome: ");
            String nome = in.nextLine();
            System.out.println("Informe as suas iniciais em maiúsculo: ");
            String iniciais = in.nextLine();

            for(Usuario u : usuarios) {
                String[]n = u.getNome().split(" ");
                
                if(n[0].equalsIgnoreCase(nome)
                && (n[0].charAt(0) == iniciais.charAt(0)) && (n[1].charAt(0) == iniciais.charAt(1 ))) {
                    this.usuario = u;
                    System.out.println("Bem vindo, " + usuario.getNome() + "!");
                    return;
                }

            }
            System.out.println("Nao ha usuario com este id ou nome, digite novamente!");
        }
    }
    

    public void menu(){

        System.out.println("MENU:");
        System.out.println("Selecione uma opcao:");
        System.out.println("1) Registrar novo pedido");
        System.out.println("2) Excluir pedido");
        System.out.println("3) Alterar usuario atual");
        System.out.println("4) Sair");

        this.opc = in.nextInt();
        in.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Registrar novo pedido:");
                registro.registraNovoPedido(usuario);
                break;
            case 2:
                System.out.println("Excluir pedido:");
                registro.excluirPedido(usuario);
                break;
            case 3:
                alterarUsuarioAtual();
                break;
            case 4:
                return;
        
            default:
                System.out.println("Opcao nao encontrada, digite novamente!");
                break;
        }
        System.out.println("Pressione ENTER para prosseguir");
        in.nextLine();
        System.out.print("\n");

    }
    public void menuAdm(){
        System.out.println("MENU DO ADMINISTRADOR:");
        System.out.println("Selecione uma opcao:");
        System.out.println("1) Registrar novo pedido");
        System.out.println("2) Excluir pedido");
        System.out.println("3) Alterar usuario atual");
        System.out.println("4) Listar todos os pedidos entre datas");
        System.out.println("5) Listar todos os pedidos de um certo funcionario");
        System.out.println("6) Listar todos os pedidos pela descricao do item");
        System.out.println("7) Editar status");
        System.out.println("8) Numero de pedidos total, divididos entre aprovados e reprovados");
        System.out.println("9) Numero de pedidos nos ultimos 30 dias e seu valor medio");
        System.out.println("10) Valor total de cada categoria nos últimos 30 dias");
        System.out.println("11) Detalhes do pedido de aquisição de maior valor ainda aberto");
        System.out.println("12) Sair");
        opc = in.nextInt();
        in.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Registrar novo pedido:");
                registro.registraNovoPedido(usuario);
                break;
            case 2:
                System.out.println("Excluir pedido:");
                registro.excluirPedido(usuario);
                break;
            case 3:
                alterarUsuarioAtual();
                break;
            case 4:
                System.out.println("Listar todos os pedidos entre datas:");
                registro.listarTodosPedidosEntreDatas();
                break;
            case 5:
                System.out.println("Listar todos os pedidos de um certo funcionario:");
                registro.pedidosDeUmFuncionario();
                break;
            case 6:
                System.out.println("Listar todos os pedidos pela descricao do item:");
                registro.verPedidosPelaDescricao();
                break;
            case 7:
                System.out.println("Editar status:");
                registro.editarStatus();
                break;
            case 8:
                System.out.println("Numero de pedidos total, divididos entre aprovados e reprovados:");
                registro.verNumeroTotalDePedidos();
                break;
            case 9:
                System.out.println("Numero de pedidos nos ultimos 30 dias e seu valor medio:");
                registro.verNumeroDePedidoNosUltimos30Dias();
                break;
            case 10:
                System.out.println("Valor total de cada categoria nos últimos 30 dias:");
                registro.verNumeroPedidosPorCategoria();
                break;
            case 11:
                System.out.println("Detalhes do pedido de aquisição de maior valor ainda aberto:");
                registro.detalhesDoPedidoDeMaiorValor();
                break;
            case 12:
                return;
        
            default:
                System.out.println("Opcao nao encontrada, digite novamente!");
                break;
        }
        System.out.println("Pressione ENTER para prosseguir");
        in.nextLine();
        System.out.print("\n");
    }
    private void iniciarDepartamento(){
        departamentos.add(new Departamento("Financeiro",1000.0));
        departamentos.add(new Departamento("TI",4000.0));
        departamentos.add(new Departamento("RH",2000.0));
        departamentos.add(new Departamento("Engenharia",1000.0));
        departamentos.add(new Departamento("Manutenção",600.0));    
    }   
    private void iniciarUsuario(){
        usuarios.add(new Usuario(1,"Arthur Faleiro",1,departamentos.get(0))); //Financeiro
        usuarios.add(new Usuario(2,"Fernando Lau",0,departamentos.get(1))); //TI
        usuarios.add(new Usuario(3,"Antonio Vicente",1,departamentos.get(2))); //RH
        usuarios.add(new Usuario(4,"Piedro Nunes",0,departamentos.get(3))); //Engenharia
        usuarios.add(new Usuario(5,"Enrico Goggia",1,departamentos.get(4))); //Manutenção
    }
    
}
