import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://192.168.1.111:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

        String insertSql = "INSERT INTO dbo.Usuarios (Nome, Email, Senha) "
                + "VALUES ('Zaccheu', 'zaccheuzinho123@gmail.com', 'AiTigrao123');";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}