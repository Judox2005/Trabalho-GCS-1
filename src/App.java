import java.util.ArrayList;

public class App {
    private Usuario usuario;
    private Registro registro;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Departamento> departamentos = new ArrayList<>();
    public App(){
        this.usuario = null;
        this.usuarios = new ArrayList<>();
        this.registro = new Registro();

    }

    public void executar(){
        iniciarDepartamento();
        iniciarUsuario();
        this.registro = new Registro();
    }
    public void menu(){

    }
    public void menuAdm(){

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
