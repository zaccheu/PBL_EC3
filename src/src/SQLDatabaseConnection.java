import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials

    public static void main(String[] args) {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
        String connectionUrl = "jdbc:sqlserver://192.168.1.111:1433instance=PC-GUSTAVO;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

        String insertSql = "select * from usuarios";
=======
        String connectionUrl = "jdbc:sqlserver://192.168.56.1:1433;instance=HPFS-CE-LAB6734;databaseName=PBL_TESTE;user=sa;password=123456;encrypt=false; trustServerCertificate=true";

        String insertSql = "insert into Clientes (Nome, senha) values ('gugu123', 'senhaboba123')";
>>>>>>> Stashed changes
=======
        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;instance=PC-GUSTAVO;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

        String insertSql = "select Nome from usuarios;";
>>>>>>> Stashed changes
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getResultSet();

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