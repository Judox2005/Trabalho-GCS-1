import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Usuario usuario;
    private Registro registro;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Departamento> departamentos = new ArrayList<>();
    private Scanner in;
    public App(){
        this.usuario = null;
        this.usuarios = new ArrayList<>();
        this.registro = new Registro();
        this.in = new Scanner(System.in);

    }

    public void executar(){
        iniciarDepartamento();
        iniciarUsuario();
        login();
        if(usuario.getTipo()==0) {
            menuAdm();
        } else {
            menu();
        }
    }

    public void login() {
        while(true) {
            System.out.println("LOGIN DE USUARIO:");
            System.out.println("Informe seu id: ");
            int id = in.nextInt();
            for(Usuario u : usuarios) {
            if(u.getId() == id) {
                this.usuario = u;
                break;
            }
        }
        System.out.println("Nao ha usuario com este id, digite novamente!");
        }
    }

    public void menu(){
        int opc = 0;
        while (opc != 4) {
            System.out.println("MENU:");
            System.out.println("Selecione uma opcao:");
            System.out.println("1) Registrar novo pedido");
            System.out.println("2) Excluir pedido");
            System.out.println("3) Alterar conta");
            System.out.println("4) Sair");

            opc = in.nextInt();

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
                    login();
                    break;
                case 4:
                    break;
            
                default:
                    System.out.println("Opcao nao encontrada, digite novamente!");
                    break;
            }
        }

    }
    public void menuAdm(){
        int opc = 0;
        while (opc != 12) {
            System.out.println("MENU DO ADMINISTRADOR:");
            System.out.println("Selecione uma opcao:");
            System.out.println("1) Registrar novo pedido");
            System.out.println("2) Excluir pedido");
            System.out.println("3) Alterar conta");
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
                    login();
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
                    registro.buscaPedidosPeloItem();
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
                    break;
            
                default:
                    System.out.println("Opcao nao encontrada, digite novamente!");
                    break;
            }
        }

    }
    private void iniciarDepartamento(){
        departamentos.add(new Departamento("Financeiro",1000.0));
        departamentos.add(new Departamento("TI",4000.0));
        departamentos.add(new Departamento("RH",2000.0));
        departamentos.add(new Departamento("Engenharia",1000.0));
        departamentos.add(new Departamento("Manutenção",600.0));    
    }   
    private void iniciarUsuario(){
        usuarios.add(new Usuario(1,"Arthur",1,departamentos.get(0))); //Financeiro
        usuarios.add(new Usuario(2,"Arthur",0,departamentos.get(1))); //TI
        usuarios.add(new Usuario(3,"Arthur",0,departamentos.get(2))); //RH
        usuarios.add(new Usuario(4,"Arthur",0,departamentos.get(3))); //Engenharia
        usuarios.add(new Usuario(5,"Arthur",0,departamentos.get(4))); //Manutenção
    }
    
}
