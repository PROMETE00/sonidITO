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
    PostgreSQLConnection cndb = new PostgreSQLConnection();
  
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pContenido.setLayout(null); 
        pContenido.setBackground(cN);
        pContenido.setPreferredSize(new Dimension(getWidth(), getHeight()));
        botonesPrincipal();
        misPlaylist(1,"/home/prome/NetBeansProjects/sonidITO/src/img/lke.png","","","","","","","","","","","");
        //menuPrincipal();
//        botonesMenuPrincipal ();
       
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

    public void misMeGusta() {
       
        
    }
    
    public void iconoPlaylist(String rt,int n1 ,int n2, JLabel lbl ,int x ,int y , int width , int height){
        img(rt,n1,n2, lbl);
        lbl.setBounds(x, y, width, height);
        pContenido.add(lbl);
        add(pContenido);
    }
    
    public void misPlaylist(int id_Usuario,String r1,String r2,String r3,String r4,String r5,String r6,String r7,String r8,String r9,String r10,String r11,String r12){
        int cantidad = cndb.obtenerMisPlaylistCantidad(id_Usuario); 
        int cantida = 12;
        
        Color cg = new Color(255,255,255,70);
        img("/home/prome/NetBeansProjects/sonidITO/src/img/lke.png",31,31, lblF2);
        lblF2.setBounds(210, 157, 60, 60);
        pContenido.add(lblF2);
        lblF1.setBounds(190, 150, 69, 69);
        lblF1.setOpaque(false);
        pContenido.add(lblF1);
        sombraPlaylist(btnPl4,190,150,300,70,false,false,false,lblF3,259,150,230,70,true,cg );
        
         switch (cantida) {
            case 1:
                 iconoPlaylist(r1,31,31,lblF5,590,150,60,60);//1
                 sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                break;
            case 2:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                break;
            case 3:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                break;
            case 4:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                break;
            case 5:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                break;
            case 6:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                break;
            case 7:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,false,false,false,lblF16,1500,250,230,70,true,cg );
                break;
            case 8:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,false,false,false,lblF16,1500,250,230,70,true,cg );
                sombraPlaylist(btnPl12,190,350,300,70,false,false,false,lblF18,259,350,230,70,true,cg );
                break;
            case 9:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,false,false,false,lblF16,1500,250,230,70,true,cg );
                sombraPlaylist(btnPl12,190,350,300,70,false,false,false,lblF18,259,350,230,70,true,cg );
                sombraPlaylist(btnPl13,590,350,300,70,false,false,false,lblF20,659,350,230,70,true,cg );
                break;
            case 10:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,false,false,false,lblF16,1500,250,230,70,true,cg );
                sombraPlaylist(btnPl12,190,350,300,70,false,false,false,lblF18,259,350,230,70,true,cg );
                sombraPlaylist(btnPl13,590,350,300,70,false,false,false,lblF20,659,350,230,70,true,cg );
                break;
            case 11:
                sombraPlaylist(btnPl5,590,150,300,70,false,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,false,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,false,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,false,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,false,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,false,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,false,false,false,lblF16,1500,250,230,70,true,cg );
                sombraPlaylist(btnPl12,190,350,300,70,false,false,false,lblF18,259,350,230,70,true,cg );
                sombraPlaylist(btnPl13,590,350,300,70,false,false,false,lblF20,659,350,230,70,true,cg );
                sombraPlaylist(btnPl14,1030,350,300,70,false,false,false,lblF22,1100,350,230,70,true,cg );
                break;
            case 12:
                sombraPlaylist(btnPl5,590,150,300,70,true,false,false,lblF4,659,150,230,70,true,cg );
                sombraPlaylist(btnPl6,1030,150,300,70,true,false,false,lblF6,1100,150,230,70,true,cg );
                sombraPlaylist(btnPl7,1430,150,300,70,true,false,false,lblF8,1500,150,230,70,true,cg );
                sombraPlaylist(btnPl8,190,250,300,70,true,false,false,lblF10,259,250,230,70,true,cg );
                sombraPlaylist(btnPl9,590,250,300,70,true,false,false,lblF12,659,250,230,70,true,cg );
                sombraPlaylist(btnPl10,1030,250,300,70,true,false,false,lblF14,1100,250,230,70,true,cg );
                sombraPlaylist(btnPl11,1430,250,300,70,true,false,false,lblF16,1500,250,230,70,true,cg );
                sombraPlaylist(btnPl12,190,350,300,70,true,false,false,lblF18,259,350,230,70,true,cg );
                sombraPlaylist(btnPl13,590,350,300,70,true,false,false,lblF20,659,350,230,70,true,cg );
                sombraPlaylist(btnPl14,1030,350,300,70,true,false,false,lblF22,1100,350,230,70,true,cg );
                sombraPlaylist(btnPl15,1430,350,300,70,true,false,false,lblF24,1500,350,230,70,true,cg );
                break;
            default:
                break;
        }
        add(pContenido);

    }
    
    public void sombraPlaylist(JButton btn ,int x ,int y ,int width, int height, Boolean b1 , Boolean b2 , Boolean b3, JLabel lbl, int x2, int y2,int width2,int height2 , Boolean b4, Color cl){
        btn.setBounds(x, y,width,height);
        btn.setBorderPainted(b1);
        btn.setFocusPainted(b2);
        btn.setContentAreaFilled(b3);
        pContenido.add(btn);
        lbl.setBounds(x2, y2, width2, height2);
        lbl.setOpaque(b4);
        lbl.setBackground(cl);
        pContenido.add(lbl);
    }
    
    public void botonesPrincipal(){
        botonPlaylist(190,70,60,60,"/home/prome/NetBeansProjects/sonidITO/src/img/biblioteca.png",98,98, btnPl1,cN,false);
        botonPlaylist(550,25,40,40,"/home/prome/NetBeansProjects/sonidITO/src/img/house-solid.png",41,41, btnPl2,cN,false);
        botonPlaylist(1835,25,60,60,"/home/prome/NetBeansProjects/sonidITO/src/img/person1.png",89,89, btnPl3,cN,false);
        add(pContenido);
    }
    
    public void botonPlaylist(int x , int y , int width, int height, String ruta, int n1, int n2 , JButton btn, Color cl, Boolean bl){
    btn.setBounds(x, y, width, height);
    rediIcon(ruta ,n1, n2,btn);
    btn.setBackground(cl);
    btn.setBorderPainted(bl);
    pContenido.add(btn);
    }
    
    public void botonesMenuPrincipal (){
      
        
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
