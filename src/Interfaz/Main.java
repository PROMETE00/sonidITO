package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main extends JFrame {

    private JPanel pcontenido;
    Color cN = new Color(0, 0, 0);//negro
    Color cB = new Color(255, 255, 255);//Blanco
    Color cg = new Color(116, 116, 116);
    Color cn1 = new Color(76, 43, 11); // café
    Color cn2 = new Color(204, 204, 204); // gris
    Color cn3 = new Color(118, 92, 166); // morado
    Color cn4 = new Color(255, 255, 255); // blanco
    Color cn5 = new Color(0, 0, 0); // negro
    Color cn6 = new Color(172, 237, 255); // azul claro
    Color cn7 = new Color(64, 55, 34); // café 2
    Color cn8 = new Color(0, 168, 45); // verde
    Color cn9 = new Color(203, 115, 91); // café claro
    Color cn10 = new Color(127, 250, 91); // verde claro
    Color cn11 = new Color(108, 186, 118); // 
    Color cn12 = new Color(91, 156, 135); // 
    Color cn13 = new Color(123, 211, 134); // 
    Color cn14 = new Color(71, 122, 106); // 
    Color cn15 = new Color(45, 83, 25);//verde mas oscuro
    Color cn16 = new Color(12, 51, 13);//
    Color cn17 = new Color(54, 98, 30);//
    Color cn18 = new Color(14, 66, 15);//
    Color cn19 = new Color(92, 114, 68);//
    Color cn20 = new Color(7, 100, 44);//
    Color cn21 = new Color(3, 52, 41);//
    Color cn22 = new Color(172, 159, 60);//
    Color cn23 = new Color(188, 170, 164);
    Color cn24 = new Color(75, 90, 64);
    Color cn25 = new Color(0, 95, 126);
    Color cn26 = new Color(0, 70, 94);
    Color inv = new Color(0, 0, 0, 0);
    Color verdeB = new Color(31, 157, 62);
    Color azulF = new Color(31, 157, 62);
    Color nF = new Color(31, 31, 31);

    public JLabel lblF1 = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint degradado = new GradientPaint(
                    0, 0, Color.BLUE, // Color inicial
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
    public JLabel lblF15 = new JLabel() {
        @Override
        protected void paintComponent(Graphics g) {
            Color cln1 = new Color(30, 26, 163);
            Color cln2 = new Color(0, 98, 147);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint degradado = new GradientPaint(
                    0, 0, cln2, // Color inicial
                    getWidth(), getHeight(), cln1 // Color final
            );
            g2d.setPaint(degradado);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponent(g);
        }
    };

    public JLabel lblF16 = new JLabel();
    public JLabel lblF17 = new JLabel();
    public JLabel lblF18 = new JLabel();

    public JLabel lblF19 = new JLabel();
    public JLabel lblF20 = new JLabel();
    public JLabel lblF21 = new JLabel();
    public JLabel lblF22 = new JLabel();
    public JLabel lblF23 = new JLabel();
    public JLabel lblF24 = new JLabel();
    public JLabel fondoImg = new JLabel();
    public JLabel nombreC = new JLabel();
    public JLabel duracionC = new JLabel();

    public JButton btnCAtras = new JButton();
    public JButton btnCReproducir = new JButton();
    public JButton btnCSiguiente = new JButton();
    public JButton btnCFavorito = new JButton();
    public JButton btnCAñadir = new JButton();
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

    public RoundButton btnPl16 = new RoundButton(20);
    public RoundButton btnPl17 = new RoundButton(20);
    public RoundButton btnPl18 = new RoundButton(20);
    public RoundButton btnPl19 = new RoundButton(20);
    public RoundButton btnPl20 = new RoundButton(20);
    public RoundButton btnPl21 = new RoundButton(20);
    public RoundButton btnPl22 = new RoundButton(20);
    public JButton btnS = new JButton();
    public JButton btnIniciarS = new JButton();
    public JButton btnCrearC = new JButton();
    public JTextField tFIS = new JTextField();
    public JTextField tFCC = new JTextField();
    public JPanel pContenido = new JPanel();
    PostgreSQLConnection cndb = new PostgreSQLConnection();
    public String rutaAB = "/home/prome/NetBeansProjects/sonidITO/";

    public Main() {
        //frame principal 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pContenido.setLayout(null);
        pContenido.setBackground(nF);
        pContenido.setPreferredSize(new Dimension(getWidth(), getHeight()));
        ImageIcon icon = new ImageIcon(rutaAB + "sonidITO.jpg");  // Especifica la ruta de tu ícono
        setIconImage(icon.getImage());
        componentesActuales();
        add(pContenido);
    }

    public void componentesActuales() {
        botonesMenuPrincipal();
        barraBusqueda();
        fondoPlaylist(); // Fondo primero
        botonesPrincipal();
        misPlaylist(1, rutaAB + "src/img/lke.png", "", "", "", "", "", "", "", "", "", "", "");
        ordenamiento();
        barraBusqueda();
    }

    public void pintarBoton(JButton nombreBoton, String txt, Color c1, Color c2, Color c3) {
        nombreBoton.setText(txt);
        nombreBoton.setFocusPainted(false);
        nombreBoton.setBackground(c1);
        nombreBoton.setBorder(new LineBorder(c2, 2));
        nombreBoton.setForeground(c3);
    }

    public void ordenamiento() {
        if (!pContenido.isAncestorOf(lblF15)) {
            pContenido.add(lblF15);
        }
        if (!pContenido.isAncestorOf(lblF1)) {
            pContenido.add(lblF1);
        }
        if (!pContenido.isAncestorOf(lblF2)) {
            pContenido.add(lblF2);
        }
        if (!pContenido.isAncestorOf(lblF3)) {
            pContenido.add(lblF3);
        }
        if (!pContenido.isAncestorOf(lblF16)) {
            pContenido.add(lblF16);
        }

        pContenido.setComponentZOrder(lblF15, pContenido.getComponentCount() - 1); // Fondo al fondo
        pContenido.setComponentZOrder(lblF1, pContenido.getComponentCount() - 2);
        pContenido.setComponentZOrder(lblF2, pContenido.getComponentCount() - 3);
        pContenido.setComponentZOrder(lblF3, pContenido.getComponentCount() - 4);
        pContenido.setComponentZOrder(lblF16, pContenido.getComponentCount() - 5);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void fondoPlaylist() {
        if (!pContenido.isAncestorOf(lblF15)) {
            lblF15.setOpaque(false); // Hacemos el fondo transparente si es necesario
            lblF15.setBounds(0, 0, getWidth(), 500); // Tamaño inicial del fondo
            pContenido.add(lblF15); // Añadir fondo al panel
            pContenido.revalidate();
            pContenido.repaint();

        }
        pContenido.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                lblF15.setBounds(0, 0, pContenido.getWidth(), 500);
            }
        });
    }

    public void rediIcon(String ruta, int n1, int n2, JButton btn) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(n1, n2, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        btn.setIcon(iconoRedimensionado);
    }

    public void img(String ruta, int n1, int n2, JLabel lb) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(n1, n2, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        lb.setIcon(iconoRedimensionado);
    }

    public void misMeGusta() {

    }

    public void iconoPlaylist(String rt, int n1, int n2, JLabel lbl, int x, int y, int width, int height) {
        img(rt, n1, n2, lbl);
        lbl.setBounds(x, y, width, height);
        pContenido.add(lbl);
        add(pContenido);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void misPlaylist(int id_Usuario, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        int cantidad = cndb.obtenerMisPlaylistCantidad(id_Usuario);
        int cantida = 12;

        lblF1.setBounds(190, 150, 70, 70);
        lblF1.setOpaque(false);
        pContenido.add(lblF1);
        img(rutaAB + "src/img/lke.png", 31, 31, lblF2);
        lblF2.setBounds(210, 157, 60, 60);
        pContenido.add(lblF2);
        sombraPlaylist(btnPl4, 190, 150, 300, 70, false, false, false, lblF3, 259, 150, 230, 70, true, cg);

        switch (cantida) {
            case 1:
                //iconoPlaylist(r1, 31, 31, lblF16, 590, 50, 60, 60);//1
                //pContenido.add(lblF16);
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                break;
            case 2:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                break;
            case 3:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                break;
            case 4:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                break;
            case 5:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                break;
            case 6:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                break;
            case 7:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, false, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                break;
            case 8:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, false, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl12, 190, 350, 300, 70, false, false, false, lblF11, 259, 350, 230, 70, true, cg);
                break;
            case 9:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, false, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl12, 190, 350, 300, 70, false, false, false, lblF11, 259, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl13, 590, 350, 300, 70, false, false, false, lblF12, 659, 350, 230, 70, true, cg);
                break;
            case 10:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, false, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl12, 190, 350, 300, 70, false, false, false, lblF11, 259, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl13, 590, 350, 300, 70, false, false, false, lblF12, 659, 350, 230, 70, true, cg);
                break;
            case 11:
                sombraPlaylist(btnPl5, 590, 150, 300, 70, false, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, false, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, false, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, false, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, false, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, false, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, false, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl12, 190, 350, 300, 70, false, false, false, lblF11, 259, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl13, 590, 350, 300, 70, false, false, false, lblF12, 659, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl14, 1030, 350, 300, 70, false, false, false, lblF13, 1100, 350, 230, 70, true, cg);
                break;
            case 12:
                //iconoPlaylist(r1, 31, 31, lblF16, 590, 50, 60, 60);//1
                sombraPlaylist(btnPl5, 590, 150, 300, 70, true, false, false, lblF4, 659, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl6, 1030, 150, 300, 70, true, false, false, lblF5, 1100, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl7, 1430, 150, 300, 70, true, false, false, lblF6, 1500, 150, 230, 70, true, cg);
                sombraPlaylist(btnPl8, 190, 250, 300, 70, true, false, false, lblF7, 259, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl9, 590, 250, 300, 70, true, false, false, lblF8, 659, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl10, 1030, 250, 300, 70, true, false, false, lblF9, 1100, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl11, 1430, 250, 300, 70, true, false, false, lblF10, 1500, 250, 230, 70, true, cg);
                sombraPlaylist(btnPl12, 190, 350, 300, 70, true, false, false, lblF11, 259, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl13, 590, 350, 300, 70, true, false, false, lblF12, 659, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl14, 1030, 350, 300, 70, true, false, false, lblF13, 1100, 350, 230, 70, true, cg);
                sombraPlaylist(btnPl15, 1430, 350, 300, 70, true, false, false, lblF14, 1500, 350, 230, 70, true, cg);
                break;
            default:
                break;
        }
        Re();
        pContenido.setComponentZOrder(btnPl5, pContenido.getComponentCount() - 5);
        pContenido.setComponentZOrder(btnPl6, pContenido.getComponentCount() - 6);
        pContenido.setComponentZOrder(btnPl7, pContenido.getComponentCount() - 7);
        pContenido.setComponentZOrder(btnPl8, pContenido.getComponentCount() - 8);
        pContenido.setComponentZOrder(btnPl9, pContenido.getComponentCount() - 9);
        pContenido.setComponentZOrder(btnPl10, pContenido.getComponentCount() - 10);
        pContenido.setComponentZOrder(btnPl11, pContenido.getComponentCount() - 11);
        pContenido.setComponentZOrder(btnPl12, pContenido.getComponentCount() - 12);
        pContenido.setComponentZOrder(btnPl13, pContenido.getComponentCount() - 13);
        pContenido.setComponentZOrder(btnPl14, pContenido.getComponentCount() - 14);
        pContenido.setComponentZOrder(btnPl15, pContenido.getComponentCount() - 15);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void sombraPlaylist(JButton btn, int x, int y, int width, int height, Boolean b1, Boolean b2, Boolean b3, JLabel lbl, int x2, int y2, int width2, int height2, Boolean b4, Color cl) {
        LineBorder b = new LineBorder(cg);
        btn.setBounds(x, y, width, height);
        btn.setBorderPainted(b1);
        btn.setBorder(b);
        btn.setFocusPainted(b2);
        btn.setContentAreaFilled(b3);
        pContenido.add(btn);
        lbl.setBounds(x2, y2, width2, height2);
        lbl.setOpaque(b4);
        lbl.setBackground(cl);
        pContenido.add(lbl);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void barraBusqueda() {
        // Crear o configurar el campo de texto solo una vez
        RoundTextField txtInput = new RoundTextField(1, 30);
        txtInput.setFont(new Font("Arial", Font.PLAIN, 20));
        txtInput.setForeground(cB);
        txtInput.setBackground(cN);
        txtInput.setCaretColor(cB);
        txtInput.setBounds(700, 25, 600, 40);
        txtInput.setName("barraBusqueda"); // Identificador para evitar duplicación
        pContenido.add(txtInput);

        // Listener para cambios en el texto
        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarResultados(txtInput.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarResultados(txtInput.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        pContenido.revalidate();
        pContenido.repaint();

    }

    private void actualizarResultados(String textoBusqueda) {
        // Validar si el texto está vacío o contiene solo espacios
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            // Eliminar cualquier resultado previo, si existen
            Component[] componentes = pContenido.getComponents();
            for (Component comp : componentes) {
                if ("resultado".equals(comp.getName())) {
                    pContenido.remove(comp);
                }
            }
            // Revalidar y repintar para limpiar la pantalla
            pContenido.revalidate();
            pContenido.repaint();
            return; // No hacer nada más si el texto está vacío
        }

        // Eliminar componentes relacionados con los resultados, pero conservar otros
        Component[] componentes = pContenido.getComponents();
        for (Component comp : componentes) {
            if ("resultado".equals(comp.getName())) {
                pContenido.remove(comp);
            }
        }

        // Obtener resultados y mostrarlos
        List<String[]> resultados = filtrar(textoBusqueda);
        obtenerBusqueda(resultados);

        // Revalidar y repintar después de actualizar los resultados
        pContenido.revalidate();
        pContenido.repaint();
        pContenido.paintImmediately(pContenido.getBounds()); // Fuerza el repintado inmediato
    }

    public void obtenerBusqueda(List<String[]> resultados) {
        // Crear y configurar botones dinámicos según los resultados
        for (int i = 0; i < Math.min(resultados.size(), 7); i++) {
            String[] datos = resultados.get(i);

            // Configurar botón
            RoundButton boton = new RoundButton(20);
            boton.setName("resultado"); // Asignar identificador
            int yPos = 74 + i * 60; // Posición vertical dinámica
            btnRedondeado(boton, 20, 20, cB, inv, 705, yPos, 590, 50);

            // Crear JLabel para la imagen y el texto
            JLabel lblImagen = new JLabel();
            JLabel lblTexto = new JLabel(datos[4]); // Texto de la posición [4]
            lblTexto.setFont(new Font("Arial", Font.PLAIN, 14));
            lblTexto.setForeground(cB);

            String ruta = rutaAB + datos[2];
            img(ruta, 30, 30, lblImagen); // Imagen desde la posición [2]
            lblImagen.setBounds(20, 10, 30, 30);
            lblTexto.setBounds(70, 15, 500, 20);

            // Configuración del botón
            boton.setLayout(null);
            boton.setBackground(cN);
            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.add(lblImagen);
            boton.add(lblTexto);

            // Acción del botón
            int indice = i;
            boton.addActionListener(e -> {
                System.out.println("Botón " + (indice + 1) + " presionado");
                System.out.println("Datos de la canción: " + Arrays.toString(datos));
                System.out.println("Datos de la canción: " + "4:" + datos[2] + "3:" + datos[3] + "1:" + datos[1]);

                barraReproduccion(ruta, datos[4], datos[1], datos[3]);
            });

            // Agregar el botón al panel
            pContenido.add(boton);
            boton.setVisible(true);
            pContenido.setComponentZOrder(boton, pContenido.getComponentCount() - 30);

        }

        // Revalidar y repintar nuevamente después de agregar los botones
        pContenido.revalidate();
        pContenido.repaint();
    }

    public void barraReproduccion(String portada, String nombreCancion, String duracion, String rutaCancion) {

        Boolean isFavorito = true;

        img(portada, 60, 60, fondoImg);
        fondoImg.setBounds(80, 990, 60, 60);
        pContenido.add(fondoImg);
        nombreC.setText(nombreCancion);
        nombreC.setFont(new Font("Arial", Font.PLAIN, 24));
        nombreC.setForeground(cB);
        nombreC.setBounds(160, 980, 650, 80);
        nombreC.setBackground(inv);
        pContenido.add(nombreC);

        duracionC.setText(duracion);
        duracionC.setFont(new Font("Arial", Font.PLAIN, 24));
        duracionC.setForeground(cB);
        duracionC.setBounds(1750, 980, 100, 80);
        duracionC.setBackground(inv);
        pContenido.add(duracionC);

        rediIcon(rutaAB + "atras3.png", 60, 60, btnCAtras);
        btnCAtras.setBackground(inv);
        btnCAtras.setFocusPainted(false);
        btnCAtras.setBorder(BorderFactory.createEmptyBorder());
        btnCAtras.setContentAreaFilled(false);
        btnCAtras.setBounds(828, 990, 60, 60);
        pContenido.add(btnCAtras);

        rediIcon(rutaAB + "playPause4.png", 60, 60, btnCReproducir);
        btnCReproducir.setBounds(928, 990, 60, 60);
        btnCReproducir.setBackground(inv);
        btnCReproducir.setFocusPainted(false);
        btnCReproducir.setBorder(BorderFactory.createEmptyBorder());
        btnCReproducir.setContentAreaFilled(false);
        pContenido.add(btnCReproducir);

        rediIcon(rutaAB + "adelante3.png", 60, 60, btnCSiguiente);
        btnCSiguiente.setBounds(1028, 990, 60, 60);
        btnCSiguiente.setBackground(inv);
        btnCSiguiente.setFocusPainted(false);
        btnCSiguiente.setBorder(BorderFactory.createEmptyBorder());
        btnCSiguiente.setContentAreaFilled(false);
        pContenido.add(btnCSiguiente);

        if (!isFavorito) {
            rediIcon(rutaAB + "corazon_vacio.png", 40, 40, btnCFavorito);
        } else {
            rediIcon(rutaAB + "corazon_lleno.png", 40, 40, btnCFavorito);

        }
        btnCFavorito.setBackground(inv);
        btnCFavorito.setFocusPainted(false);
        btnCFavorito.setBorder(BorderFactory.createEmptyBorder());
        btnCFavorito.setContentAreaFilled(false);
        btnCFavorito.setBounds(1528, 1000, 40, 40);
        pContenido.add(btnCFavorito);

        rediIcon(rutaAB + "playlist1.png", 40, 40, btnCAñadir);
        btnCAñadir.setBounds(1628, 1000, 40, 40);
        btnCAñadir.setBackground(inv);
        btnCAñadir.setFocusPainted(false);
        btnCAñadir.setBorder(BorderFactory.createEmptyBorder());
        btnCAñadir.setContentAreaFilled(false);
        pContenido.add(btnCAñadir);

        RoundTextField reproduccion = new RoundTextField(1, 30); // 1 columna, radio 30
        reproduccion.setFont(new Font("Arial", Font.PLAIN, 20));
        reproduccion.setEditable(false);
        reproduccion.setForeground(cB); // Letra blanca
        reproduccion.setBackground(verdeB); // Fondo negro
        reproduccion.setCaretColor(inv); // Cursor blanco
        reproduccion.setBounds(50, 970, 1815, 100);
        pContenido.add(reproduccion);
        pContenido.revalidate();
        pContenido.repaint();
        pContenido.setComponentZOrder(fondoImg, pContenido.getComponentCount() - 10);
        pContenido.setComponentZOrder(nombreC, pContenido.getComponentCount() - 5);
        pContenido.setComponentZOrder(duracionC, pContenido.getComponentCount() - 6);
        pContenido.setComponentZOrder(btnCAtras, pContenido.getComponentCount() - 7);
        pContenido.setComponentZOrder(btnCReproducir, pContenido.getComponentCount() - 8);
        pContenido.setComponentZOrder(btnCSiguiente, pContenido.getComponentCount() - 9);
        pContenido.setComponentZOrder(btnCFavorito, pContenido.getComponentCount() - 10);
        pContenido.setComponentZOrder(btnCAñadir, pContenido.getComponentCount() - 11);

    }

    public List<String[]> filtrar(String txt) {
        PostgreSQLConnection csl = new PostgreSQLConnection();
        String valorBusqueda = ".*" + txt + ".*";

        List<String[]> resultados = csl.buscarEnTodas(valorBusqueda);

        Set<String> resultadosUnicos = new HashSet<>();
        List<String[]> resultadosEnumerados = new ArrayList<>();
        int indice = 1; // Inicializar el índice

        for (String[] resultado : resultados) {
            String claveUnica = resultado[0] + "|" + resultado[1] + "|" + resultado[2] + "|" + resultado[3];
            if (resultadosUnicos.add(claveUnica)) { // Agregar al Set y verificar si es único
                String[] partes = claveUnica.split("\\|");
                resultadosEnumerados.add(new String[]{
                    String.valueOf(indice++), // Índice
                    partes[0], // ID de la canción
                    partes[1], // Ruta de la imagen
                    partes[2], // Ruta de la canción
                    partes[3] // Texto
                });
            }
        }
        pContenido.revalidate();
        pContenido.repaint();
        return resultadosEnumerados; // Retornar la lista enumerada
    }

    public void btnRedondeado(RoundButton nombre, int corner, int size, Color Foreground, Color Background, int x, int y, int width, int height) {
        nombre.setFont(new Font("Arial", Font.PLAIN, size));
        nombre.setForeground(Foreground);
        nombre.setBackground(Background);
        nombre.setBounds(x, y, width, height);
    }

    public void botonesPrincipal() {
        botonPlaylist(630, 17, 64, 64, rutaAB + "searching.png", 64, 64, btnS, false);
        pContenido.add(btnS);
        barraBusqueda();
        botonPlaylist(190, 70, 60, 60, rutaAB + "src/img/biblioteca.png", 98, 98, btnPl1, false);
        botonPlaylist(550, 25, 40, 40, rutaAB + "src/img/house-solid.png", 40, 40, btnPl2, false);
        botonPlaylist(1835, 25, 60, 60, rutaAB + "src/img/person1.png", 89, 89, btnPl3, false);
        pContenido.add(lblF15);
        Re();
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void botonPlaylist(int x, int y, int width, int height, String ruta, int n1, int n2, JButton btn, Boolean bl) {
        btn.setBounds(x, y, width, height);
        rediIcon(ruta, n1, n2, btn);
        btn.setOpaque(false);
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        pContenido.add(btn);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public void Re() {
        pContenido.repaint();
        pContenido.revalidate();
    }

    public void botonesMenuPrincipal() {
        
        cndb.obtenerPlaylistExistentes();
        btnPl16.setBounds(185, 625, 225, 220);//1   2   3   4   5   6
        btnPl17.setForeground(cN);
        btnPl16.setText("PLAYLIST RECOMENDADA 1");

        pContenido.add(btnPl16);
        btnPl17.setBounds(445, 625, 225, 220);
        btnPl17.setText("PLAYLIST RECOMENDADA 2");
        btnPl17.setForeground(cN);
        pContenido.add(btnPl17);

        btnPl18.setBounds(700, 625, 225, 220);
        btnPl18.setText("PLAYLIST RECOMENDADA 3");
        btnPl18.setForeground(cN);
        pContenido.add(btnPl18);

        btnPl19.setBounds(990, 625, 225, 220);
        btnPl19.setText("PLAYLIST RECOMENDADA 4");
        btnPl19.setForeground(cN);
        pContenido.add(btnPl19);

        btnPl20.setBounds(1245, 625, 225, 220);
        btnPl20.setText("PLAYLIST RECOMENDADA 5");
        btnPl20.setForeground(cN);
        pContenido.add(btnPl20);

        btnPl21.setBounds(1500, 625, 225, 220);
        btnPl21.setText("PLAYLIST RECOMENDADA 6");
        btnPl21.setForeground(cN);
        pContenido.add(btnPl21);

        btnPl22.setBounds(1590, 546, 135, 45);
        btnPl22.setText("VER MAS");
        btnPl22.setForeground(cN);
        pContenido.add(btnPl22);

        barraReproduccion(rutaAB + "portadas/ER1.jpeg", "HERE COMES THE SUN", "3:00", "");

        add(pContenido);
        setVisible(true);
        pContenido.revalidate();
        pContenido.repaint();

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
