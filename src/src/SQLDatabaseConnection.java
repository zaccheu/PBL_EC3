import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

        String insertSql = "select * from usuarios;";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getResultSet();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3)); //aqui ele tá puxando o índice da coluna que ele puxa pra printar, se vc colocou * no select e 1 aqui, ele mostra só a primeira coluna, se 2, a segunda, etc, só temos que ver como mudar isso
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}