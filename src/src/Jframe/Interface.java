package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BancoDados.Armazem;
import BancoDados.BancoDeDados;

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
        ImageIcon logo = new ImageIcon(getClass().getResource("/Jframe/imagens/icon_login.jpg"));
        login.setIconImage(logo.getImage());
        login.getContentPane().setBackground(new Color(240, 225, 210));

        // Carregar e redimensionar a imagem
        ImageIcon imagemPrincipal = new ImageIcon(getClass().getResource("/Jframe/imagens/imagem1_login.png"));
        Image imagemPrincipalRedimensionada = imagemPrincipal.getImage();
        Image resizedImage = imagemPrincipalRedimensionada.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        // JLabel para colocar a imagem
        JLabel labelImagemPrincipal = new JLabel();
        labelImagemPrincipal.setIcon(resizedImageIcon);
        labelImagemPrincipal.setHorizontalAlignment(JLabel.CENTER);
        labelImagemPrincipal.setVerticalAlignment(JLabel.CENTER);

        // Painel direito para a imagem
        JPanel painelDireito = new JPanel(new BorderLayout());
        painelDireito.setBackground(new Color(240, 225, 210));
        painelDireito.add(labelImagemPrincipal, BorderLayout.CENTER);

        // Painel de dados
        JPanel painelDeDados = new JPanel();
        painelDeDados.setLayout(new BoxLayout(painelDeDados, BoxLayout.Y_AXIS));
        painelDeDados.setBackground(new Color(240, 225, 210));

        JLabel tituloPrincipal = new JLabel("EcoDoppler");
        tituloPrincipal.setFont(new Font("Century Gothic", Font.BOLD, 50));
        tituloPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 24));
        labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textBoxUsuario = new JTextField();
        textBoxUsuario.setPreferredSize(new Dimension(400, 30));

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setFont(new Font("Century Gothic", Font.PLAIN, 24));
        labelSenha.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField textBoxSenha = new JPasswordField();
        textBoxSenha.setPreferredSize(new Dimension(400, 30));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(240, 225, 210));
        JButton botaoLogin = new JButton("Entrar");
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = textBoxUsuario.getText();
                senha = new String(textBoxSenha.getPassword()); // Use getPassword() para obter a senha corretamente
                boolean verificacao = validaUsuaruio(usuario, senha);

                if (verificacao) {
                    Armazem.getInstance().setUsuario(usuario);
                    new ScreenMenu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoLogin.setPreferredSize(new Dimension(120, 35));
        botaoCadastrar.setPreferredSize(new Dimension(120, 35));
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoCadastrar);

        // ação do botão register
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = textBoxUsuario.getText();
                senha = new String(textBoxSenha.getPassword()); // Use getPassword() para obter a senha corretamente
                BancoDeDados cadastro = new BancoDeDados();
                boolean sucesso = cadastro.inserirUsuario(usuario, senha);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir usuário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando componentes ao painel de dados
        painelDeDados.add(tituloPrincipal);
        painelDeDados.add(Box.createRigidArea(new Dimension(0, 75))); // Espaçamento entre o título e os campos
        painelDeDados.add(labelUsuario);
        painelDeDados.add(textBoxUsuario);
        painelDeDados.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos
        painelDeDados.add(labelSenha);
        painelDeDados.add(textBoxSenha);
        painelDeDados.add(Box.createRigidArea(new Dimension(0, 75))); // Espaçamento entre os campos e os botões
        painelDeDados.add(painelBotoes);

        // Painel esquerdo para centralizar o painel de dados
        JPanel painelEsquerdo = new JPanel(new GridBagLayout());
        painelEsquerdo.setBackground(new Color(240, 225, 210));
        painelEsquerdo.add(painelDeDados, new GridBagConstraints());

        // Painel principal para dividir a janela em metades
        JPanel painelPrincipal = new JPanel(new GridLayout(1, 2));
        painelPrincipal.setBackground(new Color(240, 225, 210));
        painelPrincipal.add(painelEsquerdo);
        painelPrincipal.add(painelDireito);

        // Adicionando o painel principal ao JFrame
        login.add(painelPrincipal);

        // Tornar o frame visível no final
        login.setVisible(true);
    }

    public void inserirUsuaruio(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        BancoDeDados inserir = new BancoDeDados();
        inserir.inserirUsuario(usuario, senha);
    }

    public boolean validaUsuaruio(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        BancoDeDados validar = new BancoDeDados();
        return validar.validarUsuario(usuario, senha);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
