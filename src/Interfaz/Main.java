package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JPanel pcontenido;
    Color cN = new Color(0, 0, 0);//negro

    public JButton btnPl1 = new JButton();
    public JButton btnPl2 = new JButton();
    public JButton btnPl3 = new JButton();
    public JButton btnPl4 = new JButton();

    public JButton btnPl5 = new JButton();
    public JButton btnPl6 = new JButton();
    public JButton btnPl7 = new JButton();
    public JButton btnPl8 = new JButton();
    
    public JButton btnPl9 = new JButton();
    public JButton btnPl10 = new JButton();
    public JButton btnPl11 = new JButton();
    public JButton btnPl12 = new JButton();
    
    public JButton btnPl13 = new JButton();
    public JButton btnPl14 = new JButton();
    public JButton btnPl15 = new JButton();
    public JButton btnPl16 = new JButton();
    
    public JButton btnPl17 = new JButton();
    public JButton btnPl18 = new JButton();

    public Main() {
        setSize(1650, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        menuPrincipal();
    }
    public void rediIcon(String ruta, int n1 , int n2 ,JButton btn){
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(n1, n2, Image.SCALE_SMOOTH); 
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        btn.setIcon(iconoRedimensionado);
        btn.setIcon(iconoRedimensionado);
    }

    public void menuPrincipal() {

        JPanel pContenido = new JPanel();
        pContenido.setLayout(null); 
        pContenido.setBackground(cN);
        pContenido.setPreferredSize(new Dimension(getWidth(), getHeight()));

        btnPl1.setBounds(50, 120, 60, 60);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/biblioteca.png",98,98, btnPl1);
        btnPl1.setBackground(cN);
        btnPl1.setBorderPainted(false);
        pContenido.add(btnPl1); 

        btnPl2.setBounds(550, 25, 60, 60);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/house-solid.png",61,61, btnPl2);
        btnPl2.setBorderPainted(false);
        btnPl2.setBackground(cN);
        
        pContenido.add(btnPl2);
        btnPl3.setBounds(1535, 25, 60, 60);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/person1.png",89,89, btnPl3);
        pContenido.add(btnPl3);
        
        btnPl4.setBounds(50, 200, 300, 70);//(1  2   3   4)
        pContenido.add(btnPl4);
        
        btnPl5.setBounds(450, 200, 300, 70);
        pContenido.add(btnPl5);
        
        btnPl6.setBounds(890, 200, 300, 70);
        pContenido.add(btnPl6);
        
        btnPl7.setBounds(1290, 200, 300, 70);
        pContenido.add(btnPl7);
        
        btnPl8.setBounds(50, 300, 300, 70);//(5  6   7   8)
        pContenido.add(btnPl8);
        
        btnPl9.setBounds(450, 300, 300, 70);
        pContenido.add(btnPl9);
        
        btnPl10.setBounds(890, 300, 300, 70);
        pContenido.add(btnPl10);
        
        btnPl11.setBounds(1290, 300, 300, 70);
        pContenido.add(btnPl11);
        
        btnPl12.setBounds(50, 450, 225, 220);//1   2   3   4   5   6
        pContenido.add(btnPl12);
        
        btnPl13.setBounds(305, 450, 225, 220);
        pContenido.add(btnPl13);
        
        btnPl14.setBounds(560, 450, 225, 220);
        pContenido.add(btnPl14);
        
        btnPl15.setBounds(850, 450, 225, 220);
        pContenido.add(btnPl15);
        
        btnPl16.setBounds(1105, 450, 225, 220);
        pContenido.add(btnPl16);
        
        btnPl17.setBounds(1360, 450, 225, 220);
        pContenido.add(btnPl17);
        
        btnPl18.setBounds(1450, 396, 135, 45); // ver mas
        pContenido.add(btnPl18);

        add(pContenido);

        // Hacer visible el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
