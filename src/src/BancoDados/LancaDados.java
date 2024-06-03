package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LancaDados {

    public void inserirSimulacao(String email, float freqInicial, float ampSenoidal, float velRelativa, float distInicial, float tempoSimul, float freqObservada) {
        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false;trustServerCertificate=true";

        String insertSql = "EXEC InserirSimulacao ?, ?, ?, ?, ?, ?, ?";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            prepsInsertProduct.setString(1, email);
            prepsInsertProduct.setFloat(2, freqInicial);
            prepsInsertProduct.setFloat(3, ampSenoidal);
            prepsInsertProduct.setFloat(4, velRelativa);
            prepsInsertProduct.setFloat(5, distInicial);
            prepsInsertProduct.setFloat(6, tempoSimul);
            prepsInsertProduct.setFloat(7, freqObservada);

            ResultSet resultSet = prepsInsertProduct.executeQuery();

            if (resultSet.next()) {
                int novoSimulacaoID = resultSet.getInt("NovoSimulacaoID");
                System.out.println("Simulação inserida com sucesso. Novo SimulacaoID: " + novoSimulacaoID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Simulacao> buscarSimulacoesPorUsuario(String email) {
        List<Simulacao> simulacoes = new ArrayList<>();
        String connectionUrl = "jdbc:sqlserver://26.90.38.31:1433;databaseName=PBL_EC3;user=patati;password=Bruce2023;encrypt=false;trustServerCertificate=true";

        String selectSql = "SELECT * FROM Simulacoes WHERE UsuarioID = (SELECT UsuarioID FROM Usuarios WHERE Email = ?)";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql);) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Simulacao simulacao = new Simulacao(
                        resultSet.getInt("SimulacaoID"),
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
}
