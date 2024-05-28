package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CadastraUsuario {
    private String usuario;
    private String senha;

    public boolean inserirUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;

        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false;trustServerCertificate=true";

        String insertSql = "DECLARE @SenhaDecripto VARBINARY(MAX);\n" +
                "SET @SenhaDecripto = CONVERT(VARBINARY(MAX), '"+senha+"');\n" +
                "EXEC InserirUsuario @Email = '"+usuario+"', @Senha = @SenhaDecripto;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.execute();
            System.out.println("Usuário inserido com sucesso.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
