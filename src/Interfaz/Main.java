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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
//    List<String> rutas = Arrays.asList("ruta1.png", "ruta2.png", "ruta3.png", "ruta4.png", "ruta5.png", "ruta6.png", "ruta7.png", "ruta8.png", "ruta9.png", "ruta10.png", "ruta11.png", "ruta12.png");
//    List<String> nombresP = Arrays.asList("ruta1.png", "ruta2.png", "ruta3.png", "ruta4.png", "ruta5.png", "ruta6.png", "ruta7.png", "ruta8.png", "ruta9.png", "ruta10.png", "ruta11.png", "ruta12.png");
    private ReproductorMP3 reproductor = new ReproductorMP3();

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

        misPlaylist(1);
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

    public void misPlaylist(int idUsuario) {
        List<String[]> playlists = cndb.obtenerPlaylistUsuario(idUsuario);

        List<String> nombresPlaylists = new ArrayList<>();
        List<String> rutas = new ArrayList<>();

        // Separar nombres y rutas
        for (String[] playlist : playlists) {
            nombresPlaylists.add(playlist[0]);
            rutas.add(playlist[1]);
        }

        int filas = 3; // Número de filas
        int columnas = 4; // Número de columnas
        int espacioX = 400; // Espaciado horizontal entre playlists
        int espacioY = 100; // Espaciado vertical entre filas
        int inicioX = 190; // Posición inicial X
        int inicioY = 150; // Posición inicial Y
        int cantidad = Math.min(playlists.size(), 11); // Máximo de playlists dinámicas (11)

        // Crear y posicionar la playlist especial "Mis Me Gustas"
        int x = inicioX;
        int y = inicioY;

        // Fondo para "Mis Me Gustas"
        JLabel fondoMisMeGustas = new JLabel();
        fondoMisMeGustas.setOpaque(true);
        fondoMisMeGustas.setBackground(cg);
        fondoMisMeGustas.setBounds(x + 10, y, 280, 70);

        // Icono de "Mis Me Gustas"
        JLabel lblF2 = new JLabel();
        img(rutaAB + "src/img/lke.png", 31, 31, lblF2); // Cargar la imagen en lblF2
        lblF2.setBounds(x + 25, y + 10, 60, 60);

        // Texto de "Mis Me Gustas" en un botón invisible
        JButton botonMisMeGustas = new JButton("Mis Me Gustas");
        botonMisMeGustas.setBounds(x + 70, y + 15, 220, 40);
        botonMisMeGustas.setFocusPainted(false);
        botonMisMeGustas.setContentAreaFilled(false);
        botonMisMeGustas.setBorderPainted(false);
        botonMisMeGustas.setForeground(cB); // Texto blanco
        botonMisMeGustas.setFont(new Font("Arial", Font.BOLD, 14));

        botonMisMeGustas.addActionListener(e -> {
            System.out.println("Playlist seleccionada: Mis Me Gustas");
        });

        // Agregar componentes al contenedor
        pContenido.add(fondoMisMeGustas);
        pContenido.add(lblF2);
        pContenido.add(botonMisMeGustas);

        // Agregar playlists dinámicas
        for (int i = 0; i < cantidad; i++) {
            int fila = (i + 1) / columnas; // Desplazar una posición por "Mis Me Gustas"
            int columna = (i + 1) % columnas;

            x = inicioX + columna * espacioX;
            y = inicioY + fila * espacioY;

            // Fondo de playlist (debe empezar después del icono)
            JLabel fondo = new JLabel();
            fondo.setOpaque(true);
            fondo.setBackground(cg);
            fondo.setBounds(x + 70, y, 220, 70); // Ajuste aquí para que el fondo empiece después del icono

            // Crear etiqueta para la imagen
            JLabel imagen = new JLabel();
            if (i < rutas.size()) {
                ImageIcon icon = new ImageIcon(rutas.get(i));
                Image img = icon.getImage().getScaledInstance(65, 70, Image.SCALE_SMOOTH);
                imagen.setIcon(new ImageIcon(img));
                imagen.setBounds(x + 10, y, 60, 70); // El icono permanece en su lugar
            }

            // Crear botón y agregar texto
            JButton boton = new JButton(nombresPlaylists.get(i));
            boton.setBounds(x + 70, y + 15, 220, 40); // El botón también se mantiene donde está
            boton.setFocusPainted(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.setForeground(cB); // Texto blanco
            boton.setFont(new Font("Arial", Font.PLAIN, 14));

            // Acción al hacer clic en el botón
            String nombre = nombresPlaylists.get(i);
            String ruta = rutas.get(i);
            boton.addActionListener(e -> {
                System.out.println("Playlist seleccionada:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Ruta: " + ruta);
            });

            // Agregar componentes al contenedor
            pContenido.add(fondo);
            pContenido.add(imagen);
            pContenido.add(boton);

            pContenido.setComponentZOrder(fondo, 30);
            pContenido.setComponentZOrder(imagen, 29);
            pContenido.setComponentZOrder(boton, 28);
            pContenido.setComponentZOrder(lblF2, 27);
            pContenido.setComponentZOrder(botonMisMeGustas, 26);
        }

        // Actualizar el contenedor
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
//                System.out.println("Botón " + (indice + 1) + " presionado");
//                System.out.println("Datos de la canción: " + Arrays.toString(datos));
//                System.out.println("Datos de la canción: " + "4:" + datos[2] + "3\n:" + datos[3] + "1:" + datos[1]);
                barraReproduccion(ruta, datos[4], datos[5], rutaAB + datos[3]);
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

        JLabel duracionLabel = new JLabel(duracion);
        duracionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        duracionLabel.setForeground(cB);
        duracionLabel.setBounds(1750, 980, 100, 80);
        pContenido.add(duracionLabel);
        System.out.println("Ruta completa del archivo: " + rutaCancion);

        btnCReproducir.addActionListener(e -> reproductor.reproducir(rutaCancion, duracionLabel));

        btnCAtras.addActionListener(e -> reproductor.pausar());

        btnCSiguiente.addActionListener(e -> reproductor.detener());

        fondoReproduccion();

        // Elimina componentes anteriores
        pContenido.remove(fondoImg);
        pContenido.remove(nombreC);
        pContenido.remove(duracionC);
        pContenido.remove(btnCAtras);
        pContenido.remove(btnCReproducir);
        pContenido.remove(btnCSiguiente);
        pContenido.remove(btnCFavorito);
        pContenido.remove(btnCAñadir);

        // Configura los componentes de la barra de reproducción
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
        btnCReproducir.setBackground(inv);
        btnCReproducir.setFocusPainted(false);
        btnCReproducir.setBorder(BorderFactory.createEmptyBorder());
        btnCReproducir.setContentAreaFilled(false);
        btnCReproducir.setBounds(928, 990, 60, 60);
        pContenido.add(btnCReproducir);

        rediIcon(rutaAB + "adelante3.png", 60, 60, btnCSiguiente);
        btnCSiguiente.setBackground(inv);
        btnCSiguiente.setFocusPainted(false);
        btnCSiguiente.setBorder(BorderFactory.createEmptyBorder());
        btnCSiguiente.setContentAreaFilled(false);
        btnCSiguiente.setBounds(1028, 990, 60, 60);
        pContenido.add(btnCSiguiente);

        if (!isFavorito) {
            rediIcon(rutaAB + "corazon_vacio.png", 40, 40, btnCFavorito);
        } else {
            rediIcon(rutaAB + "corazon_lleno.png", 40, 40, btnCFavorito);
        }
        btnCFavorito.setBounds(1528, 1000, 40, 40);
        btnCFavorito.setBackground(inv);
        btnCFavorito.setFocusPainted(false);
        btnCFavorito.setBorder(BorderFactory.createEmptyBorder());
        btnCFavorito.setContentAreaFilled(false);
        pContenido.add(btnCFavorito);

        rediIcon(rutaAB + "playlist1.png", 40, 40, btnCAñadir);
        btnCAñadir.setBackground(inv);
        btnCAñadir.setFocusPainted(false);
        btnCAñadir.setBorder(BorderFactory.createEmptyBorder());
        btnCAñadir.setContentAreaFilled(false);
        btnCAñadir.setBounds(1628, 1000, 40, 40);
        pContenido.add(btnCAñadir);

        // Ajusta el orden de los componentes para que el fondo esté detrás
        pContenido.setComponentZOrder(fondoImg, 1); // Imagen encima del fondo
        pContenido.setComponentZOrder(nombreC, 0);
        pContenido.setComponentZOrder(duracionC, 0);
        pContenido.setComponentZOrder(btnCAtras, 0);
        pContenido.setComponentZOrder(btnCReproducir, 0);
        pContenido.setComponentZOrder(btnCSiguiente, 0);
        pContenido.setComponentZOrder(btnCFavorito, 0);
        pContenido.setComponentZOrder(btnCAñadir, 0);

        pContenido.revalidate();
        pContenido.repaint();
    }

    public void fondoReproduccion() {
        RoundTextField reproduccion = new RoundTextField(1, 30); // 1 columna, radio 30
        pContenido.remove(reproduccion);
        reproduccion.setFont(new Font("Arial", Font.PLAIN, 20));
        reproduccion.setEditable(false);
        reproduccion.setForeground(cB); // Letra blanca
        reproduccion.setBackground(verdeB); // Fondo negro
        reproduccion.setCaretColor(inv); // Cursor blanco
        reproduccion.setBounds(50, 970, 1815, 100);
        pContenido.add(reproduccion);
    }

    public List<String[]> filtrar(String txt) {
        PostgreSQLConnection csl = new PostgreSQLConnection();
        String valorBusqueda = ".*" + txt + ".*";

        List<String[]> resultados = csl.buscarEnTodas(valorBusqueda);

        Set<String> resultadosUnicos = new HashSet<>();
        List<String[]> resultadosEnumerados = new ArrayList<>();
        int indice = 1; // Inicializar el índice

        for (String[] resultado : resultados) {
            // Modificar clave única para incluir duración (posición 4)
            String claveUnica = resultado[0] + "|" + resultado[1] + "|" + resultado[2] + "|" + resultado[3] + "|" + resultado[4];
            if (resultadosUnicos.add(claveUnica)) { // Agregar al Set y verificar si es único
                String[] partes = claveUnica.split("\\|");
                resultadosEnumerados.add(new String[]{
                    String.valueOf(indice++), // Índice
                    partes[0], // ID de la canción
                    partes[1], // Ruta de la imagen
                    partes[2], // Ruta de la canción
                    partes[3], // Texto
                    partes[4] // Duración
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
        botonPlaylist(190, 70, 60, 60, rutaAB + "", 98, 98, btnPl1, false);
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
        List<String[]> canciones = cndb.obtenerTodasCanciones();

        if (canciones.size() < 6) {
            System.err.println("No hay suficientes canciones para asignar a los botones.");
            return;
        }

        JLabel canRec = new JLabel();
        canRec.setText("CANCIONES RECOMENDADAS");
        canRec.setBounds(180, 526, 435, 95);
        canRec.setForeground(cB);
        canRec.setFont(new Font("Arial", Font.PLAIN, 25));
        pContenido.add(canRec);

        JButton[] botones = {btnPl16, btnPl17, btnPl18, btnPl19, btnPl20, btnPl21};
        JLabel[] etiquetas = new JLabel[6]; // Arreglo de etiquetas para los nombres

        // Método para actualizar las canciones
        Runnable actualizarCanciones = () -> {
            Collections.shuffle(canciones); // Revolver las canciones
            List<String[]> seleccionadas = canciones.subList(0, 6);

            for (int i = 0; i < seleccionadas.size(); i++) {
                String[] cancion = seleccionadas.get(i); // Cada canción es un arreglo de String
                JButton boton = botones[i];

                // Configurar el botón con la portada como ícono
                rediIcon(rutaAB + cancion[5], 225, 225, boton);

                // Configurar posición del botón
                boton.setBounds(185 + (260 * i), 625, 225, 225);
                pContenido.add(boton);

                // Crear y configurar una etiqueta para el nombre de la canción
                if (etiquetas[i] != null) {
                    pContenido.remove(etiquetas[i]); // Eliminar la etiqueta previa si existe
                }
                JLabel etiqueta = new JLabel(cancion[1], SwingConstants.CENTER); // Texto centrado
                etiqueta.setBounds(185 + (260 * i), 855, 225, 20); // Colocar debajo del botón
                etiqueta.setForeground(cB); // Configurar el color del texto
                etiquetas[i] = etiqueta;
                pContenido.add(etiqueta);

                boton.addActionListener(e -> {
                    String portada = rutaAB + cancion[5];
                    String nombreCancion = cancion[1];
                    String duracion = cancion[4];
                    String rutaCancion = cancion[6];
                    barraReproduccion(portada, nombreCancion, duracion, rutaCancion);
                });
            }
            pContenido.revalidate();
            pContenido.repaint();
        };

        // Ejecutar la primera actualización de canciones
        actualizarCanciones.run();

        // Configurar el botón "VER MÁS"
        btnPl22.setBounds(1590, 546, 135, 45);
        btnPl22.setText("VER MÁS");
        btnPl22.addActionListener(e -> actualizarCanciones.run());
        btnPl22.setForeground(cN);
        pContenido.add(btnPl22);

        // Configurar la barra de reproducción inicial
        barraReproduccion(rutaAB + "lp_7550766.png", "No se esta reproduciendo contenido", "0:00", rutaAB + "canciones/Pop/pop5.mp3");

        // Configuración final del panel
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
