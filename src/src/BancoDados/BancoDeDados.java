package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static final String CONNECTION_URL = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false;trustServerCertificate=true";

    // Atributos para inserir e validar usuário
    private String usuario;
    private String senha;

    // Método para inserir usuário
    public boolean inserirUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;

        String insertSql = "DECLARE @SenhaDecripto VARBINARY(MAX);\n" +
                "SET @SenhaDecripto = CONVERT(VARBINARY(MAX), '"+senha+"');\n" +
                "EXEC InserirUsuario @Email = '"+usuario+"', @Senha = @SenhaDecripto;";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.execute();
            System.out.println("Usuário inserido com sucesso.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para inserir simulação
    public void inserirSimulacao(String email, float freqInicial, float ampSenoidal, float velRelativa, float distInicial, float tempoSimul, float freqObservada, String caminhoArquivo) {
        String insertSql = "EXEC InserirSimulacao ?, ?, ?, ?, ?, ?, ?, ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.setString(1, email);
            prepsInsertProduct.setFloat(2, freqInicial);
            prepsInsertProduct.setFloat(3, ampSenoidal);
            prepsInsertProduct.setFloat(4, velRelativa);
            prepsInsertProduct.setFloat(5, distInicial);
            prepsInsertProduct.setFloat(6, tempoSimul);
            prepsInsertProduct.setFloat(7, freqObservada);
            prepsInsertProduct.setString(8, caminhoArquivo);

            ResultSet resultSet = prepsInsertProduct.executeQuery();

            if (resultSet.next()) {
                int novoSimulacaoID = resultSet.getInt("NovoSimulacaoID");
                System.out.println("Simulação inserida com sucesso. Novo SimulacaoID: " + novoSimulacaoID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para buscar dados do histórico
    public List<Simulacao> buscarSimulacoesPorUsuario(String email) {
        List<Simulacao> simulacoes = new ArrayList<>();

        String selectSql = "SELECT * FROM Simulacoes WHERE UsuarioID = (SELECT UsuarioID FROM Usuarios WHERE Email = ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql);) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Simulacao simulacao = new Simulacao(
                        resultSet.getInt("UsuarioID"),
                        resultSet.getFloat("FrequenciaInicial"),
                        resultSet.getFloat("AmplitudeSenoidal"),
                        resultSet.getFloat("VelocidadeRelativa"),
                        resultSet.getFloat("DistanciaInicial"),
                        resultSet.getFloat("TempoSimulacao"),
                        resultSet.getFloat("FreqObservado")
                );
                simulacoes.add(simulacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return simulacoes;
    }

    // Método para validar usuário
    public boolean validarUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;

        String insertSql = "DECLARE @Email VARCHAR(30) = ?;\n" +
                "DECLARE @Senha VARCHAR(50) = ?;\n" +
                "EXEC VerificarSenha @Email, @Senha;";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
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

    // Método para conversão de km/h para m/s
    public float functionConversao(float kmPh) {
        String selectSql = "SELECT dbo.ConvertToMs(?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement prepsSelect = connection.prepareStatement(selectSql)) {

            prepsSelect.setFloat(1, kmPh);
            ResultSet resultSet = prepsSelect.executeQuery();

            if (resultSet.next()) {
                return resultSet.getFloat(1);
            } else {
                throw new RuntimeException("Erro ao converter a velocidade.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
        }
    }
}
