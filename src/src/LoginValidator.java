import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidator {

    private static final String URL = "jdbc:sqlserver://192.168.1.111:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

    public boolean validateLogin(String email, String senha) {
        String sql = "SELECT * FROM Usuarios WHERE email = 'zaccheuzinho@gmail.com' AND senha = 'AiTigrao'";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Retorna true se encontrar um usuário, false se não encontrar

        } catch (SQLException e) {
            System.out.println("Erro ao validar usuário: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        LoginValidator validator = new LoginValidator();
        String email = "zaccheuzinho@gmail.com";
        String senha = "AiTigrao";

        if (validator.validateLogin(email, senha)) {
            System.out.println("Login válido!");
        } else {
            System.out.println("Login inválido!");
        }
    }
}
