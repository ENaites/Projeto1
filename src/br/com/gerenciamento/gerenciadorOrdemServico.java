package br.com.gerenciamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.gerenciamento.ordemServico;

public class gerenciadorOrdemServico {
    private List<ordemServico> ordensServico;

    //Constructor
    public gerenciadorOrdemServico () {
        this.ordensServico = new ArrayList<>();
    }

    // Método para adicionar uma nova ordem de serviço
    public void adicionarOrdem(ordemServico ordem) {
        ordensServico.add(ordem);
    }

    //Método para listar todas as ordens de serviço
    public void listarOrdens() {
        for (ordemServico ordem : ordensServico) {
            ordem.imprimirDetalhes();
            System.out.println("---------------");
        }
    }

    //Método para atualizar o status de uma ordem de serviço
    public void atualizarStatus (int id, String novoStatus){
        for (ordemServico ordem : ordensServico) {
            if (ordem.getId() == id) {
                ordem.setStatus(novoStatus);
                System.out.println("Status da Ordem de Serviço ID " + id + "atualizado para: " + novoStatus);
                return;
            }
        }
        System.out.println("Ordem de Serviço com ID " + id + " não encontrada.");
    }

    //Método para remover uma ordem de serviço
    public void removerOrdem(int id){
        ordensServico.removeIf (ordem -> ordem.getId() == id);
        System.out.println("Ordem de Serviço com ID " + id + " removida.");
    }

    //Método para atribuir técnico
    public void atribuirTecnico(int id, usuario tecnico) {
        for (ordemServico ordem : ordensServico) {
            if (ordem.getId() == id){
                ordem.atribuirTecnico(tecnico);
                System.out.println("Tecnico " + tecnico.getNome() + " atribuido à Ordem de Serviço ID " + id);
                return;
            }
        }
        System.out.println("Ordem de Serviço com ID" + id + " não encontrada");
    }

    //Método para implementação de data para a geração de relatório
    public List<ordemServico> buscarOrdensPorPeriodo(LocalDate startDate, LocalDate endDate) {
        List<ordemServico> ordens = new ArrayList<>();
        String sql = "SELECT * FROM ordens_servico WHERE data BETWEEN ? AND ?";
        try (Connection conn = conexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDate(1, java.sql.Date.valueOf(startDate));
            stmt.setDate(2, java.sql.Date.valueOf(endDate));
            ResultSet rs =stmt.executeQuery();
            while (rs.next()) {
                ordemServico ordem = new ordemServico(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getDate("data").toLocalDate()
                        //Adicione os objetos de criador e tecnico de acordo com os IDs
                );
                ordens.add(ordem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordens;
    }

}
