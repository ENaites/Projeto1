package br.com.gerenciamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/gerenciamento_ordem_servico";
    private static final String USUARIO = "root";
    private static final String SENHA = "********";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL_MYSQL, USUARIO, SENHA);
    }

}
