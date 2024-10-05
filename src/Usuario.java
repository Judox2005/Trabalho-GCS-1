public class Usuario { 
    private int id;
    private String nome;
    private int tipo;
    private Departamento departamento;

    public Usuario (int id, String nome, int tipo, Departamento departamento){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo; 
        this.departamento = departamento;
        
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
}
