package br.com.gerenciamento;

public class usuario {
    private int id;
    private String nome;
    private String papel; //Pode ser "tecnico" ou "colaborador"

    public usuario(int id, String nome, String papel){
        this.id = id;
        this.nome = nome;
        this.papel = papel;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getPapel(){
        return papel;
    }
}
