package br.com.gerenciamento;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
            try{
                Connection conn = conexaoBD.conectar();
                if (conn != null) {
                    System.out.println("Conexão estabelecida com sucesso!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }





        gerenciadorOrdemServico gerenciador = new gerenciadorOrdemServico();

        // Criação de usuários colaboradores
        usuario colaborador1 = new usuario(1, "João", "colaborador");
        usuario colaborador2 = new usuario(2, "Maria", "colaborador");


        // Criação ordens de serviço
        ordemServico ordem1 = new ordemServico(1, "Instalar Antivírus", "Instalar Antivírus em todos os computadores.", colaborador1 );
        ordemServico ordem2 = new ordemServico(2, "Atualizar Sistema", "Atualizar sistema operacional para versão mais recente.", colaborador2);

        gerenciador.adicionarOrdem(ordem1);
        gerenciador.adicionarOrdem(ordem2);

        gerenciador.listarOrdens();

        gerenciador.atualizarStatus(1, "Em andamento");

        gerenciador.removerOrdem(2);

        gerenciador.listarOrdens();
    }
}