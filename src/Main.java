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
}
