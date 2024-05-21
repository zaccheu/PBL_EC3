package Jframe;

import javax.swing.*;
import java.awt.*;

public class Interface {

    public static void main(String[] args){
        JFrame login = new JFrame();
        login.setTitle("Login");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setSize(1000, 600);
        login.setVisible(true);

        //Imagem do ícone
        ImageIcon logo = new ImageIcon("icon_login.jpg");
        login.setIconImage(logo.getImage());
        login.getContentPane().setBackground(new Color(240, 225, 210));

        //Panel da parte do título
       /* JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.red);
        panelTitle.setBounds(0, 0, 500,150);
        panelTitle.setVisible(true);
        login.add(panelTitle);*/

        //Panel da parte do usuário e senha
       /* JPanel panelData = new JPanel();
        panelData.setBackground(Color.blue);
        panelData.setBounds(0, 150, 500,250);
        panelData.setVisible(true);
        login.add(panelData); */

        //Panel da parte dos botões
        /*JPanel panelButtons = new JPanel();
        panelButtons.setBackground(Color.green);
        panelButtons.setBounds(0, 400, 500,200);
        panelButtons.setVisible(true);
        login.add(panelButtons);*/

        //Panel da parte da imagem
        ImageIcon image = new ImageIcon("imagem1_login.png");
        JLabel labelImage = new JLabel();
        labelImage.setText("vderge");
        labelImage.setIcon(image);
        labelImage.setSize(200, 200);
        labelImage.setVisible(true);
        login.add(labelImage);
    }
}
