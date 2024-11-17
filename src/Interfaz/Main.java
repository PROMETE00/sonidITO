package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JPanel pcontenido;
    Color cN = new Color(0, 0, 0);//negro
    Color cB = new Color(255,255,255);//Blanco
    
    public JLabel lblF1 = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint degradado = new GradientPaint(
                0, 0, Color.BLUE,        // Color inicial
                getWidth(), getHeight(), Color.WHITE // Color final
            );
            g2d.setPaint(degradado);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponent(g);
        }
    };
    public JLabel lblF2 = new JLabel();
    public JLabel lblF3 = new JLabel();
    
    public JLabel lblF4 = new JLabel();
    public JLabel lblF5 = new JLabel();
    public JLabel lblF6 = new JLabel();
    
    public JLabel lblF7 = new JLabel();
    public JLabel lblF8 = new JLabel();
    public JLabel lblF9 = new JLabel();
    
    public JLabel lblF10 = new JLabel();
    public JLabel lblF11 = new JLabel();
    public JLabel lblF12 = new JLabel();
    
    public JLabel lblF13 = new JLabel();
    public JLabel lblF14 = new JLabel();
    public JLabel lblF915 = new JLabel();
    
    public JLabel lblF16 = new JLabel();
    public JLabel lblF17 = new JLabel();
    public JLabel lblF18 = new JLabel();
    
    public JLabel lblF19 = new JLabel();
    public JLabel lblF20 = new JLabel();
    public JLabel lblF21 = new JLabel();
    public JLabel lblF22 = new JLabel();
    public JLabel lblF23 = new JLabel();
    public JLabel lblF24 = new JLabel();

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
    
    
    public JPanel pContenido = new JPanel();
  
    public Main() {
        setSize(1650, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pContenido.setLayout(null); 
        pContenido.setBackground(cN);
        pContenido.setPreferredSize(new Dimension(getWidth(), getHeight()));
        menuPrincipal();
        botonesMenuPrincipal ();
    }
    public void rediIcon(String ruta, int n1 , int n2 ,JButton btn){
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(n1, n2, Image.SCALE_SMOOTH); 
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        btn.setIcon(iconoRedimensionado);
    }
    public void img (String ruta , int n1, int n2 , JLabel lb){
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(n1, n2, Image.SCALE_SMOOTH); 
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada); 
        lb.setIcon(iconoRedimensionado);
    }

    public void menuPrincipal() {


        
    }
    
    public void botonesMenuPrincipal (){
        btnPl1.setBounds(50, 120, 60, 60);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/biblioteca.png",98,98, btnPl1);
        btnPl1.setBackground(cN);
        btnPl1.setBorderPainted(false);
        pContenido.add(btnPl1); 

        btnPl2.setBounds(550, 25, 40, 40);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/house-solid.png",41,41, btnPl2);
        btnPl2.setBorderPainted(false);
        btnPl2.setBackground(cN);
        pContenido.add(btnPl2);
        
        btnPl3.setBounds(1535, 25, 60, 60);
        rediIcon("/home/prome/NetBeansProjects/sonidITO/src/img/person1.png",89,89, btnPl3);
        btnPl3.setBorderPainted(false);
        btnPl3.setBackground(cN);
        pContenido.add(btnPl3);
        
        btnPl4.setBounds(50, 200, 300, 70);//(1  2   3   4)
        btnPl4.setBorderPainted(false);
        btnPl4.setFocusPainted(false);
        btnPl4.setContentAreaFilled(false);
        pContenido.add(btnPl4);
        lblF3.setBounds(119, 200, 230, 70);
        lblF3.setOpaque(true);
        lblF3.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF3);
        img("/home/prome/NetBeansProjects/sonidITO/src/img/lke.png",31,31, lblF2);
        lblF2.setBounds(70, 207, 60, 60);
        pContenido.add(lblF2);
        lblF1.setBounds(50, 200, 69, 69);
        lblF1.setOpaque(false);
        pContenido.add(lblF1);
        
        
        btnPl5.setBounds(450, 200, 300, 70);
        btnPl5.setBorderPainted(false);
        btnPl5.setFocusPainted(false);
        btnPl5.setContentAreaFilled(false);
        pContenido.add(btnPl5);
        lblF4.setBounds(519, 200, 230, 70);
        lblF4.setOpaque(true);
        lblF4.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF4);
        
        btnPl6.setBounds(890, 200, 300, 70);
        btnPl6.setBorderPainted(false);
        btnPl6.setFocusPainted(false);
        btnPl6.setContentAreaFilled(false);
        pContenido.add(btnPl6);
        lblF6.setBounds(960, 200, 230, 70);
        lblF6.setOpaque(true);
        lblF6.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF6);
        
        btnPl7.setBounds(1290, 200, 300, 70);
        btnPl7.setBorderPainted(false);
        btnPl7.setFocusPainted(false);
        btnPl7.setContentAreaFilled(false);
        pContenido.add(btnPl7);
        lblF8.setBounds(1360, 200, 230, 70);
        lblF8.setOpaque(true);
        lblF8.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF8);
        
        btnPl8.setBounds(50, 300, 300, 70);//(5  6   7   8)
        btnPl8.setBorderPainted(false);
        btnPl8.setFocusPainted(false);
        btnPl8.setContentAreaFilled(false);
        pContenido.add(btnPl8);
        lblF10.setBounds(120, 300, 230, 70);
        lblF10.setOpaque(true);
        lblF10.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF10);
        
        btnPl9.setBounds(450, 300, 300, 70);
        btnPl9.setBorderPainted(false);
        btnPl9.setFocusPainted(false);
        btnPl9.setContentAreaFilled(false);
        pContenido.add(btnPl9);
        lblF12.setBounds(520, 300, 230, 70);
        lblF12.setOpaque(true);
        lblF12.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF12);
        
        btnPl10.setBounds(890, 300, 300, 70);
        btnPl10.setBorderPainted(false);
        btnPl10.setFocusPainted(false);
        btnPl10.setContentAreaFilled(false);
        pContenido.add(btnPl10);
        lblF14.setBounds(960, 300, 230, 70);
        lblF14.setOpaque(true);
        lblF14.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF14);
        
        btnPl11.setBounds(1290, 300, 300, 70);
        btnPl11.setBorderPainted(false);
        btnPl11.setFocusPainted(false);
        btnPl11.setContentAreaFilled(false);
        pContenido.add(btnPl11);
        lblF16.setBounds(1360, 300, 230, 70);
        lblF16.setOpaque(true);
        lblF16.setBackground(new Color(255,255,255,70));
        pContenido.add(lblF16);
        
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

        setVisible(true);
    
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
