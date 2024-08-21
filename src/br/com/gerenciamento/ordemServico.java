package br.com.gerenciamento;

import java.time.LocalDate;

public class ordemServico {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private usuario criador;//Colaborador que criou a ordem
    private usuario tecnico;//Técnico que gerencia a ordem

    // Construtor
    public ordemServico(int id, String titulo, String descricao, usuario criador) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = "Aberta"; // Status inicial
        this.criador = criador;
        this.tecnico = null; //tecnico atribuído inicialmente é null
    }

    public ordemServico(int id, String titulo, String descricao, String status, LocalDate data) {
    }

    // Métodos Getters e Setters

    public void atribuirTecnico(usuario tecnico){
        this.tecnico = tecnico;
        this.status = "Em andamento";
    }
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para imprimir detalhes da ordem
    public void imprimirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("Criado por: " + criador.getNome());
        if (tecnico != null){
            System.out.println("Gerenciado por: " + tecnico.getNome());
        }
    }
}
