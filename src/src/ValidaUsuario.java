import java.sql.*;


public class ValidaUsuario {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false; trustServerCertificate=true";

        String email = "zaccheuzinho@gmail.com";
        String senha = "AiTigrao";

        try (Connection con = DriverManager.getConnection(connectionUrl);) {
            // Chamar o procedimento armazenado
            boolean usuarioValido = validarUsuario(con, email, senha);
            if (usuarioValido) {
                System.out.println("Usuário válido");
            } else {
                System.out.println("Usuário inválido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean validarUsuario(Connection con, String email, String senha) {
        String sql = "{call ValidaUsuario(?, ?, ?)}";
        try (CallableStatement cstmt = con.prepareCall(sql)) {
            cstmt.setString(1, email);
            cstmt.setString(2, senha);
            cstmt.registerOutParameter(3, Types.BIT);

            cstmt.execute();

            return cstmt.getBoolean(3);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}