package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BancoDados.Armazem;
import BancoDados.CadastraUsuario;
import BancoDados.ValidaUsuario;
import JframeAtt.ScreenMenu;

public class Interface {
    private String usuario;
    private String senha;

    public Interface() {
        JFrame login = new JFrame();
        login.setTitle("Simulação Efeito Doppler");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setSize(1000, 600);
        login.setLocationRelativeTo(null);

        // Imagem do ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Jframe/icon_login.jpg"));
        login.setIconImage(logo.getImage());
        login.getContentPane().setBackground(new Color(240, 225, 210));

        // Carregar e redimensionar a imagem
        ImageIcon originalImageIcon = new ImageIcon(getClass().getResource("/Jframe/imagem1_login.png"));
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        // JLabel para colocar a imagem
        JLabel labelImage = new JLabel();
        labelImage.setIcon(resizedImageIcon);
        labelImage.setHorizontalAlignment(JLabel.CENTER);
        labelImage.setVerticalAlignment(JLabel.CENTER);

        // Painel direito para a imagem
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(240, 225, 210));
        rightPanel.add(labelImage, BorderLayout.CENTER);

        // Painel de dados
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBackground(new Color(240, 225, 210));

        JLabel titleLabel = new JLabel("EcoDoppler");
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(400, 30));

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(400, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 225, 210));
        JButton loginButton = new JButton("Entrar");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = userField.getText();
                senha = new String(passwordField.getPassword()); // Use getPassword() para obter a senha corretamente
                boolean verificacao = validaUsuaruio(usuario, senha);

                if (verificacao) {
                    Armazem.getInstance().setUsuario(usuario);
                    new ScreenMenu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton registerButton = new JButton("Cadastrar");
        loginButton.setPreferredSize(new Dimension(120, 35));
        registerButton.setPreferredSize(new Dimension(120, 35));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // ação do botão register
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = userField.getText();
                senha = new String(passwordField.getPassword()); // Use getPassword() para obter a senha corretamente
                CadastraUsuario cadastro = new CadastraUsuario();
                boolean sucesso = cadastro.inserirUsuario(usuario, senha);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir usuário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando componentes ao painel de dados
        dataPanel.add(titleLabel);
        dataPanel.add(Box.createRigidArea(new Dimension(0, 75))); // Espaçamento entre o título e os campos
        dataPanel.add(userLabel);
        dataPanel.add(userField);
        dataPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos
        dataPanel.add(passwordLabel);
        dataPanel.add(passwordField);
        dataPanel.add(Box.createRigidArea(new Dimension(0, 75))); // Espaçamento entre os campos e os botões
        dataPanel.add(buttonPanel);

        // Painel esquerdo para centralizar o painel de dados
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(240, 225, 210));
        leftPanel.add(dataPanel, new GridBagConstraints());

        // Painel principal para dividir a janela em metades
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBackground(new Color(240, 225, 210));
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Adicionando o painel principal ao JFrame
        login.add(mainPanel);

        // Tornar o frame visível no final
        login.setVisible(true);
    }

    public void inserirUsuaruio(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        CadastraUsuario inserir = new CadastraUsuario();
        inserir.inserirUsuario(usuario, senha);
    }

    public boolean validaUsuaruio(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        ValidaUsuario validar = new ValidaUsuario();
        return validar.validarUsuario(usuario, senha);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
