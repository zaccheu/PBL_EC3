package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class validaUsuario {
    private String usuario;
    private String senha;

    public boolean validarUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;


        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false;trustServerCertificate=true";

        String insertSql = "DECLARE @Email VARCHAR(30) = ?;\n" +
                "DECLARE @Senha VARCHAR(50) = ?;\n" +
                "EXEC VerificarSenha @Email, @Senha;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.setString(1, usuario);
            prepsInsertProduct.setString(2, senha);

            try (ResultSet resultSet = prepsInsertProduct.executeQuery()) {
                if (resultSet.next()) {
                    int resultado = resultSet.getInt("Resultado");
                    if (resultado == 1) {
                        System.out.println("Senha válida.");
                        return true;
                    } else {
                        System.out.println("Senha inválida.");
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


}


