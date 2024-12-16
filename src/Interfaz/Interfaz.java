/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Interfaz.playlist;
import java.awt.GridLayout;
import java.io.File;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 *
 * @author mendo
 */
public class Interfaz extends javax.swing.JFrame {
   
    public String url = "jdbc:postgresql://localhost:5432/sonido";
    public String user = "postgres";
    public String password = "passwor";
   

    /**
     * Creates new form Interfaz
     */
    Color inv = new Color(0,0,0,0);
        
    
    CardLayout card;
    public Interfaz() {
        initComponents();
        configurarTablaCanciones();
        configurarTablaUsuarios();
        btnrestablecerC.setVisible(FALSE);
        btnEliminarAUsuario.setVisible(FALSE);
        bntAceptarAUsuario.setVisible(FALSE);
        btnCancelarAUsuario.setVisible(FALSE);
        TxtBuscarUsuario.setVisible(FALSE);
        jButton17usuario.setVisible(FALSE);
        TxtBuscarUsuario.setVisible(FALSE);
        jButton17usuario.setVisible(FALSE);
       
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //inicio seccion
        textoSombra correoe = new textoSombra (" correoejemplo@gmail.com",txtCorreoInicioS);
        textoSombra corrcontra = new textoSombra (" Contraseña",txtContraseñaInicio);
        //crear usuario
        textoSombra correo2 = new textoSombra (" Nombres",txtNombres);
        textoSombra apellidos = new textoSombra (" Apellidos",txtApellidos);
        textoSombra correocrear = new textoSombra (" correoejemplo@gmail.com",txtCorreoCrearCuenta);
        textoSombra contracrear = new textoSombra (" Contraseña",txtContraseñaCrearCuenta);
        textoSombra contracrearconformar = new textoSombra (" Confirmar Contraseña",txtConfirmarCC);
        //Restablecer Contraseña  
        textoSombra correorecu = new textoSombra ("correoejemplo@gmail.com",correorecuperarcontra);
        
        
        //botones invisibles
        btnrestablecerC.setBackground(inv);
        btnrestablecerC.setFocusPainted(false);
        botonx.setBackground(inv);
        botonx1.setFocusPainted(false);
        botonx1.setBackground(inv);
        botonx.setFocusPainted(false);
        flecha1.setBackground(inv);
        flecha1.setFocusPainted(false);
        flecha2.setBackground(inv);
        flecha2.setFocusPainted(false);
        flecha3.setBackground(inv);
        flecha3.setFocusPainted(false);
        flecha4.setBackground(inv);
        flecha4.setFocusPainted(false);
        regresarInicioAdmin.setBackground(inv);
        regresarInicioAdmin.setFocusPainted(false);
        btnEliminarA.setBackground(inv);
        btnEliminarA.setFocusPainted(false);
        bntAceptarA.setBackground(inv);
        bntAceptarA.setFocusPainted(false);
        btnAgregarFormulario.setBackground(inv);
        btnAgregarFormulario.setFocusPainted(false);
        btnAgregarFormulario1.setBackground(inv);
        btnAgregarFormulario1.setFocusPainted(false);
        jbLp.setBackground(inv);
        jbLp.setFocusPainted(false);
        jbLp1.setBackground(inv);
        jbLp1.setFocusPainted(false);
        atrasMAbtn.setBackground(inv);
        atrasMAbtn.setFocusPainted(false);
        atrasMAbtn1.setBackground(inv);
        atrasMAbtn1.setFocusPainted(false);
        btnCancelarA.setBackground(inv);
        btnCancelarA.setFocusPainted(false);
        btnEliminarAUsuario.setBackground(inv);
        btnEliminarAUsuario.setFocusPainted(false);
        bntAceptarAUsuario.setBackground(inv);
        bntAceptarAUsuario.setFocusPainted(false);
        btnCancelarAUsuario.setBackground(inv);
        btnCancelarAUsuario.setFocusPainted(false);    
    }
    
    //configurar tablas
    /*Tabla de caniones*/
    private void configurarTablaCanciones() {
    DefaultTableModel modeloTabla = new DefaultTableModel(
        new String[]{"ID", "Nombre", "Artista", "Álbum", "Duración", "Género", "Ruta Imagen", "Ruta Canción"},
        0
    );
    jTResultados.setModel(modeloTabla);
    }
    //Tabla Uusarios
    private void configurarTablaUsuarios() {
    DefaultTableModel modeloTablaUs = new DefaultTableModel(
        new String[]{"ID", "Nombre", "Apellidos", "Correo", "Contraseña", "Admin"},
        0
    );
    jTResultados.setModel(modeloTablaUs);
    }
    private void generarPDFUsuario(String nombre, String apellidos, String correo) {
    // Nombre dinámico para el PDF basado en el nombre del usuario
    String rutaPDF = "Usuario_" + nombre.replace(" ", "_") + ".pdf";

    // Crear un nuevo documento PDF
    Document documento = new Document();

    try {
        // Crear escritor para el PDF
        PdfWriter.getInstance(documento, new FileOutputStream(rutaPDF));

        // Abrir el documento
        documento.open();

        // Agregar contenido al PDF
        documento.add(new Paragraph("Bienvenido, " + nombre + " " + apellidos + "!"));
        documento.add(new Paragraph("Correo registrado: " + correo));
        documento.add(new Paragraph("Gracias por registrarte en nuestro sistema."));
        documento.add(new Paragraph("Este PDF fue generado automáticamente."));

        // Mensaje de éxito
        JOptionPane.showMessageDialog(this, "PDF generado correctamente: " + rutaPDF);

    } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el PDF.");
    } finally {
        // Cerrar el documento
        documento.close();
    }
}

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        panelprincipal = new javax.swing.JPanel();
        inicioseccion = new javax.swing.JPanel();
        jpini = new javax.swing.JPanel();
        txtCorreoInicioS = new javax.swing.JTextField();
        btnInicioSeccion = new javax.swing.JButton();
        btnInicioSeccion1 = new javax.swing.JButton();
        btnrestablecerC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtContraseñaInicio = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        img = new javax.swing.JLabel();
        CrearUsuario = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtApellidos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtCorreoCrearCuenta = new javax.swing.JTextField();
        rbAceptaTerminos = new javax.swing.JRadioButton();
        btnCrearCuenta = new javax.swing.JButton();
        txtContraseñaCrearCuenta = new javax.swing.JPasswordField();
        txtConfirmarCC = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        flecha1 = new javax.swing.JButton();
        RestablecerContra = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        correorecuperarcontra = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        flecha2 = new javax.swing.JButton();
        Codigo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        preguntac = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        flecha3 = new javax.swing.JButton();
        NuevaC = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nuevaContrauno = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        nuevaContraConfirmar = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        flecha4 = new javax.swing.JButton();
        MenuAdministrador = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        verUsuarios = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        regresarInicioAdmin = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        btnEliminarA = new javax.swing.JButton();
        bntAceptarA = new javax.swing.JButton();
        btnCancelarA = new javax.swing.JButton();
        TxtBuscarCancioes = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnEliminarAUsuario = new javax.swing.JButton();
        bntAceptarAUsuario = new javax.swing.JButton();
        btnCancelarAUsuario = new javax.swing.JButton();
        TxtBuscarUsuario = new javax.swing.JTextField();
        jButton17usuario = new javax.swing.JButton();
        AgregrarCancion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        atrasMAbtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtArtistaISC = new javax.swing.JTextField();
        txtNombreISC = new javax.swing.JTextField();
        txtAlbumISC = new javax.swing.JTextField();
        txtDuracionISC = new javax.swing.JTextField();
        txtRutadeCancionISC = new javax.swing.JTextField();
        txtRutaDePortadaISC = new javax.swing.JTextField();
        btnAgregarFormulario = new javax.swing.JButton();
        jbLp = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboGeneroISC = new javax.swing.JComboBox<>();
        rcancion = new javax.swing.JButton();
        rportada = new javax.swing.JButton();
        AgregarUsuario = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jbLp1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtIsAdminusuarios = new javax.swing.JComboBox<>();
        atrasMAbtn1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtNombreusuarios = new javax.swing.JTextField();
        txtApellidosusuarios = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCorreousuarios = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtContrasenausuarios = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtConfirmarContrasenausuarios = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnAgregarFormulario1 = new javax.swing.JButton();
        AgregarPlaylist = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        botonx = new javax.swing.JButton();
        todaslasc = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultadoArea = new javax.swing.JTextArea();
        CrearNuevaPlaylist = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        botonx1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelprincipal.setBackground(new java.awt.Color(0, 51, 255));
        panelprincipal.setLayout(new java.awt.CardLayout());

        inicioseccion.setBackground(new java.awt.Color(13, 11, 66));

        jpini.setBackground(new java.awt.Color(255, 255, 255));

        txtCorreoInicioS.setForeground(new java.awt.Color(72, 71, 113));
        txtCorreoInicioS.setBorder(null);
        txtCorreoInicioS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoInicioSActionPerformed(evt);
            }
        });

        btnInicioSeccion.setBackground(new java.awt.Color(72, 71, 113));
        btnInicioSeccion.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnInicioSeccion.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioSeccion.setText("Iniciar Sesion");
        btnInicioSeccion.setBorder(null);
        btnInicioSeccion.setMaximumSize(new java.awt.Dimension(76, 16));
        btnInicioSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSeccionActionPerformed(evt);
            }
        });

        btnInicioSeccion1.setBackground(new java.awt.Color(72, 71, 113));
        btnInicioSeccion1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnInicioSeccion1.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioSeccion1.setText("Crear Cuenta");
        btnInicioSeccion1.setBorder(null);
        btnInicioSeccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSeccion1ActionPerformed(evt);
            }
        });

        btnrestablecerC.setForeground(new java.awt.Color(72, 71, 113));
        btnrestablecerC.setText("¿Olvidaste tu contraseña?");
        btnrestablecerC.setBorder(null);
        btnrestablecerC.setFocusPainted(false);
        btnrestablecerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestablecerCActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(72, 71, 113));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(72, 71, 113));
        jLabel2.setText("INICIA SESION");

        txtContraseñaInicio.setForeground(new java.awt.Color(72, 71, 113));
        txtContraseñaInicio.setBorder(null);

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(72, 71, 113));
        jLabel22.setText("Correo:");

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(72, 71, 113));
        jLabel23.setText("Contraseña:");

        javax.swing.GroupLayout jpiniLayout = new javax.swing.GroupLayout(jpini);
        jpini.setLayout(jpiniLayout);
        jpiniLayout.setHorizontalGroup(
            jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpiniLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpiniLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnrestablecerC)
                        .addGap(140, 140, 140))
                    .addGroup(jpiniLayout.createSequentialGroup()
                        .addGroup(jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpiniLayout.createSequentialGroup()
                                .addComponent(btnInicioSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInicioSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addGroup(jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreoInicioS, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
            .addGroup(jpiniLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpiniLayout.setVerticalGroup(
            jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpiniLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(txtCorreoInicioS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(txtContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jpiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicioSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicioSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnrestablecerC)
                .addGap(41, 41, 41))
        );

        img.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/servicio-al-cliente.png"))); // NOI18N

        javax.swing.GroupLayout inicioseccionLayout = new javax.swing.GroupLayout(inicioseccion);
        inicioseccion.setLayout(inicioseccionLayout);
        inicioseccionLayout.setHorizontalGroup(
            inicioseccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioseccionLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(jpini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        inicioseccionLayout.setVerticalGroup(
            inicioseccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioseccionLayout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addGroup(inicioseccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        panelprincipal.add(inicioseccion, "cardInicio");

        CrearUsuario.setBackground(new java.awt.Color(13, 11, 66));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtApellidos.setForeground(new java.awt.Color(13, 11, 66));
        txtApellidos.setBorder(null);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 11, 66));
        jLabel1.setText("CREAR CUENTA");

        txtNombres.setForeground(new java.awt.Color(13, 11, 66));
        txtNombres.setBorder(null);
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtCorreoCrearCuenta.setForeground(new java.awt.Color(13, 11, 66));
        txtCorreoCrearCuenta.setBorder(null);
        txtCorreoCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoCrearCuentaActionPerformed(evt);
            }
        });

        rbAceptaTerminos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        rbAceptaTerminos.setForeground(new java.awt.Color(72, 71, 113));
        rbAceptaTerminos.setText("Acepto todos los terminos y condiciones");

        btnCrearCuenta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        txtContraseñaCrearCuenta.setForeground(new java.awt.Color(13, 11, 66));
        txtContraseñaCrearCuenta.setBorder(null);
        txtContraseñaCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaCrearCuentaActionPerformed(evt);
            }
        });

        txtConfirmarCC.setForeground(new java.awt.Color(13, 11, 66));
        txtConfirmarCC.setBorder(null);

        jSeparator3.setForeground(new java.awt.Color(72, 71, 113));

        jSeparator4.setForeground(new java.awt.Color(72, 71, 113));

        jSeparator5.setForeground(new java.awt.Color(72, 71, 113));

        jSeparator6.setForeground(new java.awt.Color(72, 71, 113));

        jSeparator7.setForeground(new java.awt.Color(72, 71, 113));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCorreoCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbAceptaTerminos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtContraseñaCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtCorreoCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtContraseñaCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtConfirmarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(rbAceptaTerminos)
                .addGap(83, 83, 83)
                .addComponent(btnCrearCuenta)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        flecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        flecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flecha1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearUsuarioLayout = new javax.swing.GroupLayout(CrearUsuario);
        CrearUsuario.setLayout(CrearUsuarioLayout);
        CrearUsuarioLayout.setHorizontalGroup(
            CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CrearUsuarioLayout.setVerticalGroup(
            CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(flecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        panelprincipal.add(CrearUsuario, "cardCrearU");

        RestablecerContra.setBackground(new java.awt.Color(72, 71, 113));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(72, 71, 113));
        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 71, 113));
        jLabel3.setText("RESTABLECER CONTRASEÑA");

        correorecuperarcontra.setForeground(new java.awt.Color(72, 71, 113));
        correorecuperarcontra.setBorder(null);
        correorecuperarcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correorecuperarcontraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(72, 71, 113));
        jLabel4.setText("Ingresa el correo con el creaste tu cuenta");

        jButton2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(72, 71, 113));
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(correorecuperarcontra)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(correorecuperarcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton2)
                .addGap(168, 168, 168))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pensando.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        flecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flecha2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RestablecerContraLayout = new javax.swing.GroupLayout(RestablecerContra);
        RestablecerContra.setLayout(RestablecerContraLayout);
        RestablecerContraLayout.setHorizontalGroup(
            RestablecerContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RestablecerContraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RestablecerContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RestablecerContraLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(flecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RestablecerContraLayout.setVerticalGroup(
            RestablecerContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RestablecerContraLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(flecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RestablecerContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        panelprincipal.add(RestablecerContra, "cardRestablecerC");

        Codigo.setBackground(new java.awt.Color(72, 71, 113));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(72, 71, 113));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(72, 71, 113));
        jLabel6.setText("PREGUNTA DE VERIFICACION");

        preguntac.setForeground(new java.awt.Color(72, 71, 113));
        preguntac.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(72, 71, 113));
        jLabel7.setText("Esta pregunta fue hecha cuando se creo la cuenta");

        jButton3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(72, 71, 113));
        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preguntac, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel7))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(preguntac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        flecha3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        flecha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flecha3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CodigoLayout = new javax.swing.GroupLayout(Codigo);
        Codigo.setLayout(CodigoLayout);
        CodigoLayout.setHorizontalGroup(
            CodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CodigoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CodigoLayout.setVerticalGroup(
            CodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CodigoLayout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(flecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        panelprincipal.add(Codigo, "cardPregunta");

        NuevaC.setBackground(new java.awt.Color(72, 71, 113));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(72, 71, 113));
        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(72, 71, 113));
        jLabel8.setText("CREA UNA NUEVA CONTRASEÑA");

        nuevaContrauno.setForeground(new java.awt.Color(72, 71, 113));
        nuevaContrauno.setBorder(null);

        jLabel55.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(72, 71, 113));
        jLabel55.setText("Se recomienda que tenga por lo menos un numero");

        jButton11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(72, 71, 113));
        jButton11.setText("Aceptar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        nuevaContraConfirmar.setForeground(new java.awt.Color(72, 71, 113));
        nuevaContraConfirmar.setBorder(null);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nuevaContraConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)))
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nuevaContrauno, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(5, 5, 5)))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel55)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevaContrauno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevaContraConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        flecha4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        flecha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flecha4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NuevaCLayout = new javax.swing.GroupLayout(NuevaC);
        NuevaC.setLayout(NuevaCLayout);
        NuevaCLayout.setHorizontalGroup(
            NuevaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NuevaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NuevaCLayout.setVerticalGroup(
            NuevaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaCLayout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(flecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        panelprincipal.add(NuevaC, "cardNuevaContra");

        MenuAdministrador.setBackground(new java.awt.Color(215, 208, 177));

        jPanel3.setBackground(new java.awt.Color(136, 111, 70));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(215, 208, 177));
        jLabel17.setText("BIENVENIDO");

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(215, 208, 177));
        jLabel18.setText("ADMINISTRADOR");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("¿Que desea hacer Hoy?");

        jButton6.setBackground(new java.awt.Color(215, 208, 177));
        jButton6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(159, 135, 83));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver.png"))); // NOI18N
        jButton6.setText("Vista Usuario");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(215, 208, 177));
        jButton8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(159, 135, 83));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nota-musical.png"))); // NOI18N
        jButton8.setText("Agregar Cancion");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(215, 208, 177));
        jButton10.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(159, 135, 83));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/multitarea.png"))); // NOI18N
        jButton10.setText("Editar Canciones");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        verUsuarios.setBackground(new java.awt.Color(215, 208, 177));
        verUsuarios.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        verUsuarios.setForeground(new java.awt.Color(159, 135, 83));
        verUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png"))); // NOI18N
        verUsuarios.setText("Editar Usarios");
        verUsuarios.setBorder(null);
        verUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verUsuariosActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(215, 208, 177));
        jButton9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(159, 135, 83));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuariosss.png"))); // NOI18N
        jButton9.setText("Agregar Usuarios");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        regresarInicioAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        regresarInicioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarInicioAdminActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(136, 111, 70));

        jTResultados.setBackground(new java.awt.Color(159, 135, 83));
        jTResultados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Cancion", "Titulo", "Artista", "Album", "Duracion", "Genero", "ruta_portada", "ruta_cancion"
            }
        ));
        jScrollPane4.setViewportView(jTResultados);

        btnEliminarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarA.setBorder(null);
        btnEliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAActionPerformed(evt);
            }
        });

        bntAceptarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cheque.png"))); // NOI18N
        bntAceptarA.setBorder(null);
        bntAceptarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAceptarAActionPerformed(evt);
            }
        });

        btnCancelarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar-a-la-izquierda.png"))); // NOI18N
        btnCancelarA.setBorder(null);
        btnCancelarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAActionPerformed(evt);
            }
        });

        TxtBuscarCancioes.setBackground(new java.awt.Color(159, 135, 83));
        TxtBuscarCancioes.setBorder(null);

        jButton16.setBackground(new java.awt.Color(159, 135, 83));
        jButton16.setForeground(new java.awt.Color(159, 135, 83));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton16.setBorder(null);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel20.setText("Buscar por nombre:");

        btnEliminarAUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarAUsuario.setBorder(null);
        btnEliminarAUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAUsuarioActionPerformed(evt);
            }
        });

        bntAceptarAUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cheque.png"))); // NOI18N
        bntAceptarAUsuario.setBorder(null);
        bntAceptarAUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAceptarAUsuarioActionPerformed(evt);
            }
        });

        btnCancelarAUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar-a-la-izquierda.png"))); // NOI18N
        btnCancelarAUsuario.setBorder(null);
        btnCancelarAUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAUsuarioActionPerformed(evt);
            }
        });

        TxtBuscarUsuario.setBackground(new java.awt.Color(159, 135, 83));
        TxtBuscarUsuario.setBorder(null);

        jButton17usuario.setBackground(new java.awt.Color(159, 135, 83));
        jButton17usuario.setForeground(new java.awt.Color(159, 135, 83));
        jButton17usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton17usuario.setBorder(null);
        jButton17usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarA)
                            .addComponent(btnEliminarAUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(bntAceptarA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnCancelarA))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(bntAceptarAUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnCancelarAUsuario)))
                        .addGap(294, 294, 294)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton17usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtBuscarCancioes, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtBuscarCancioes)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarA)
                            .addComponent(bntAceptarA)
                            .addComponent(btnCancelarA))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarAUsuario)
                            .addComponent(bntAceptarAUsuario)
                            .addComponent(btnCancelarAUsuario))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton17usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout MenuAdministradorLayout = new javax.swing.GroupLayout(MenuAdministrador);
        MenuAdministrador.setLayout(MenuAdministradorLayout);
        MenuAdministradorLayout.setHorizontalGroup(
            MenuAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAdministradorLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(MenuAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regresarInicioAdmin)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        MenuAdministradorLayout.setVerticalGroup(
            MenuAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuAdministradorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresarInicioAdmin)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelprincipal.add(MenuAdministrador, "cardVentacaMAdmin");

        AgregrarCancion.setBackground(new java.awt.Color(215, 208, 177));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(136, 111, 70));
        jLabel9.setText("Artista:");

        jLabel10.setBackground(new java.awt.Color(136, 111, 70));
        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(136, 111, 70));
        jLabel10.setText("INSERTAR CANCIONES");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(136, 111, 70));
        jLabel11.setText("Nombre:");

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(136, 111, 70));
        jLabel12.setText("Album:");

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(136, 111, 70));
        jLabel13.setText("Genero:");

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(136, 111, 70));
        jLabel14.setText("Duracion:");

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(136, 111, 70));
        jLabel15.setText("Ruta de Portada");

        atrasMAbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        atrasMAbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasMAbtnActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(136, 111, 70));
        jLabel21.setText("Ruta de Cancion:");

        txtArtistaISC.setBackground(new java.awt.Color(136, 111, 70));
        txtArtistaISC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtistaISCActionPerformed(evt);
            }
        });

        txtNombreISC.setBackground(new java.awt.Color(136, 111, 70));

        txtAlbumISC.setBackground(new java.awt.Color(136, 111, 70));

        txtDuracionISC.setBackground(new java.awt.Color(136, 111, 70));

        txtRutadeCancionISC.setBackground(new java.awt.Color(136, 111, 70));

        txtRutaDePortadaISC.setBackground(new java.awt.Color(136, 111, 70));

        btnAgregarFormulario.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarFormulario.setBorder(null);
        btnAgregarFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFormularioActionPerformed(evt);
            }
        });

        jbLp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpieza-de-datos.png"))); // NOI18N
        jbLp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLpActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(136, 111, 70));
        jLabel16.setText("LIMPIAR FORMULARIO");

        jLabel24.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(136, 111, 70));
        jLabel24.setText("AGREGAR");

        comboGeneroISC.setBackground(new java.awt.Color(136, 111, 70));
        comboGeneroISC.setEditable(true);
        comboGeneroISC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        rcancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/subir.png"))); // NOI18N
        rcancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcancionActionPerformed(evt);
            }
        });

        rportada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/subir.png"))); // NOI18N
        rportada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rportadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AgregrarCancionLayout = new javax.swing.GroupLayout(AgregrarCancion);
        AgregrarCancion.setLayout(AgregrarCancionLayout);
        AgregrarCancionLayout.setHorizontalGroup(
            AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregrarCancionLayout.createSequentialGroup()
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addGap(83, 83, 83)
                                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombreISC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAlbumISC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtArtistaISC, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDuracionISC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboGeneroISC, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregrarCancionLayout.createSequentialGroup()
                                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rcancion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rportada, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55)
                                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtRutadeCancionISC, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                            .addComponent(txtRutaDePortadaISC))))))
                        .addGap(74, 74, 74)
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jbLp)
                                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel16))
                                    .addComponent(btnAgregarFormulario)))
                            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel24))))
                    .addGroup(AgregrarCancionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(62, 62, 62)
                        .addComponent(atrasMAbtn)))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        AgregrarCancionLayout.setVerticalGroup(
            AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atrasMAbtn)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregrarCancionLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLp))
                    .addGroup(AgregrarCancionLayout.createSequentialGroup()
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArtistaISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlbumISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboGeneroISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracionISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(rcancion))
                            .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRutadeCancionISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregrarCancionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rportada))
                            .addGroup(AgregrarCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRutaDePortadaISC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 142, Short.MAX_VALUE))
        );

        panelprincipal.add(AgregrarCancion, "cardAgregarCancion");

        AgregarUsuario.setBackground(new java.awt.Color(215, 208, 177));

        jLabel25.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(136, 111, 70));
        jLabel25.setText("Contraseña");

        jbLp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpieza-de-datos.png"))); // NOI18N
        jbLp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLp1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(136, 111, 70));
        jLabel26.setText("LIMPIAR FORMULARIO");

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(136, 111, 70));
        jLabel27.setText("AGREGAR");

        txtIsAdminusuarios.setBackground(new java.awt.Color(136, 111, 70));
        txtIsAdminusuarios.setEditable(true);
        txtIsAdminusuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "false", "true" }));

        atrasMAbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        atrasMAbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasMAbtn1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(136, 111, 70));
        jLabel28.setText("Confirmar Contraseña:");

        txtNombreusuarios.setBackground(new java.awt.Color(136, 111, 70));
        txtNombreusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreusuariosActionPerformed(evt);
            }
        });

        txtApellidosusuarios.setBackground(new java.awt.Color(136, 111, 70));

        jLabel29.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(136, 111, 70));
        jLabel29.setText("Nombre:");

        txtCorreousuarios.setBackground(new java.awt.Color(136, 111, 70));

        jLabel30.setBackground(new java.awt.Color(136, 111, 70));
        jLabel30.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(136, 111, 70));
        jLabel30.setText("INSERTAR USUARIOS");

        txtContrasenausuarios.setBackground(new java.awt.Color(136, 111, 70));

        jLabel31.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(136, 111, 70));
        jLabel31.setText("Apellidos");

        txtConfirmarContrasenausuarios.setBackground(new java.awt.Color(136, 111, 70));

        jLabel32.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(136, 111, 70));
        jLabel32.setText("Correo:");

        jLabel33.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(136, 111, 70));
        jLabel33.setText("Es Admin:");

        btnAgregarFormulario1.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarFormulario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-contacto.png"))); // NOI18N
        btnAgregarFormulario1.setBorder(null);
        btnAgregarFormulario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFormulario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AgregarUsuarioLayout = new javax.swing.GroupLayout(AgregarUsuario);
        AgregarUsuario.setLayout(AgregarUsuarioLayout);
        AgregarUsuarioLayout.setHorizontalGroup(
            AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(26, 26, 26)
                .addComponent(atrasMAbtn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarUsuarioLayout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32)
                    .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addComponent(jLabel33)))
                .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIsAdminusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreousuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenausuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConfirmarContrasenausuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 205, Short.MAX_VALUE)
                .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbLp1)
                    .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel27))
                        .addComponent(btnAgregarFormulario1)
                        .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel26))))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        AgregarUsuarioLayout.setVerticalGroup(
            AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarUsuarioLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atrasMAbtn1))
                .addGap(34, 34, 34)
                .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreousuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIsAdminusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AgregarUsuarioLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtContrasenausuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(AgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmarContrasenausuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AgregarUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarFormulario1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLp1)))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        panelprincipal.add(AgregarUsuario, "cardAgregaruA");

        AgregarPlaylist.setBackground(new java.awt.Color(158, 145, 145));

        jLabel45.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("AGREGAR A PLAYLIST");

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(51, 51, 51));
        jButton13.setText("Nueva Playlist");
        jButton13.setBorder(null);

        jLabel46.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Playlist Existentes:");

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setOpaque(true);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setOpaque(true);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setOpaque(true);

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setOpaque(true);

        jLabel51.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setText("Playlist 2");

        jLabel52.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("Playlist 1");

        jLabel53.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Playlist 3");

        jLabel54.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("Playlist 4");

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(51, 51, 51));
        jButton14.setText("Finalizar");
        jButton14.setBorder(null);

        botonx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x 5% .png"))); // NOI18N
        botonx.setBorder(null);
        botonx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AgregarPlaylistLayout = new javax.swing.GroupLayout(AgregarPlaylist);
        AgregarPlaylist.setLayout(AgregarPlaylistLayout);
        AgregarPlaylistLayout.setHorizontalGroup(
            AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarPlaylistLayout.createSequentialGroup()
                .addGap(0, 537, Short.MAX_VALUE)
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(223, 223, 223))
            .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                        .addGap(543, 543, 543)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        AgregarPlaylistLayout.setVerticalGroup(
            AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AgregarPlaylistLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(botonx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AgregarPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        panelprincipal.add(AgregarPlaylist, "card9");

        todaslasc.setBackground(new java.awt.Color(44, 0, 118));
        todaslasc.setForeground(new java.awt.Color(75, 5, 173));

        jLabel39.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(75, 5, 173));
        jLabel39.setText("TODAS LAS CANCIONES");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel40.setText("#Titulo");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel41.setText("Autor");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel42.setText("Album");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel43.setText("Genero");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel44.setText("Duracion");

        resultadoArea.setEditable(false);
        resultadoArea.setBackground(new java.awt.Color(44, 0, 118));
        resultadoArea.setColumns(20);
        resultadoArea.setRows(5);
        resultadoArea.setBorder(null);
        jScrollPane3.setViewportView(resultadoArea);

        javax.swing.GroupLayout todaslascLayout = new javax.swing.GroupLayout(todaslasc);
        todaslasc.setLayout(todaslascLayout);
        todaslascLayout.setHorizontalGroup(
            todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todaslascLayout.createSequentialGroup()
                .addGroup(todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todaslascLayout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jLabel39))
                    .addGroup(todaslascLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel40)
                        .addGap(196, 196, 196)
                        .addComponent(jLabel41)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel42)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel43)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel44)))
                .addGap(0, 694, Short.MAX_VALUE))
            .addGroup(todaslascLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        todaslascLayout.setVerticalGroup(
            todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todaslascLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(jLabel44)
                        .addComponent(jLabel42))
                    .addGroup(todaslascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40)
                        .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        );

        panelprincipal.add(todaslasc, "card8");

        CrearNuevaPlaylist.setBackground(new java.awt.Color(115, 99, 104));

        jLabel56.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("CREAR UNA NUEVA PLAYLIST");

        jLabel57.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Nombre");

        jTextField7.setBackground(new java.awt.Color(212, 205, 205));

        jButton1.setBackground(new java.awt.Color(212, 205, 205));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/subir.png"))); // NOI18N
        jButton1.setBorder(null);

        jLabel58.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Importar Portada");

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("CREAR PLAYLIST");
        jButton12.setBorder(null);

        botonx1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x 5% .png"))); // NOI18N
        botonx1.setBorder(null);
        botonx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonx1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearNuevaPlaylistLayout = new javax.swing.GroupLayout(CrearNuevaPlaylist);
        CrearNuevaPlaylist.setLayout(CrearNuevaPlaylistLayout);
        CrearNuevaPlaylistLayout.setHorizontalGroup(
            CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearNuevaPlaylistLayout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonx1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addGroup(CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField7)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(jLabel57)))
                        .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                            .addGap(198, 198, 198)
                            .addGroup(CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(185, 185, 185))))
                .addContainerGap(718, Short.MAX_VALUE))
        );
        CrearNuevaPlaylistLayout.setVerticalGroup(
            CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                .addGroup(CrearNuevaPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CrearNuevaPlaylistLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(botonx1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        panelprincipal.add(CrearNuevaPlaylist, "card11");

        jPanel10.setBackground(new java.awt.Color(44, 0, 118));

        jLabel59.setBackground(new java.awt.Color(153, 153, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lke.png"))); // NOI18N
        jLabel59.setOpaque(true);

        jLabel60.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel60.setText("MUSICA QUE TE GUSTO");

        jLabel61.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel61.setText("Autor");

        jLabel62.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel62.setText("#Titulo");

        jLabel63.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel63.setText("Album");

        jLabel64.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel64.setText("Genero");

        jLabel65.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel65.setText("Duracion");

        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel60)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        panelprincipal.add(jPanel10, "card12");

        getContentPane().add(panelprincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoInicioSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoInicioSActionPerformed

                
    }//GEN-LAST:event_txtCorreoInicioSActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCorreoCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoCrearCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoCrearCuentaActionPerformed

    private void btnInicioSeccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSeccion1ActionPerformed
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardCrearU");
    }//GEN-LAST:event_btnInicioSeccion1ActionPerformed

    private void flecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flecha1ActionPerformed
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardInicio");
    }//GEN-LAST:event_flecha1ActionPerformed

    private void btnInicioSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSeccionActionPerformed
    String correo = txtCorreoInicioS.getText();
    String contrasena = new String(txtContraseñaInicio.getPassword()); // Convertir de JPasswordField a String

    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
    usuario usuario = baseDeDatos.validarCredenciales(correo, contrasena);

    if (usuario != null) {
        // Verificar el rol del usuario
        if ("true".equalsIgnoreCase(usuario.getIsadminUsuario())) {
            card = (CardLayout)this.panelprincipal.getLayout();
            card.show(panelprincipal, "cardVentacaMAdmin"); // Ventana de administrador
            JOptionPane.showMessageDialog(this, "Bienvenido, Administrador");
        } else if ("false".equalsIgnoreCase(usuario.getIsadminUsuario())) {
            new Main(usuario).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Rol desconocido. Contacta al administrador.");
        }
    }
        

    }//GEN-LAST:event_btnInicioSeccionActionPerformed

    private void txtContraseñaCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaCrearCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaCrearCuentaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardPregunta");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnrestablecerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestablecerCActionPerformed
        // TODO add your handling code here:
        
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardRestablecerC");
    }//GEN-LAST:event_btnrestablecerCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardNuevaContra");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void flecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flecha2ActionPerformed
        // TODO add your handling code here:
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardInicio");
    }//GEN-LAST:event_flecha2ActionPerformed

    private void flecha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flecha3ActionPerformed
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardRestablecerC");
    }//GEN-LAST:event_flecha3ActionPerformed

    private void correorecuperarcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correorecuperarcontraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correorecuperarcontraActionPerformed

    private void botonxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonxActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void flecha4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flecha4ActionPerformed
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardPregunta");
    }//GEN-LAST:event_flecha4ActionPerformed

    private void botonx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonx1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonx1ActionPerformed

    private void regresarInicioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarInicioAdminActionPerformed
        // TODO add your handling code here:
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardInicio");
    }//GEN-LAST:event_regresarInicioAdminActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardAgregarCancion");
        //cardAgregarCancion
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    // Crear instancia de la clase que contiene el método obtenerTodasCanciones
    TxtBuscarCancioes.setVisible(TRUE);
    jButton16.setVisible(TRUE);
    TxtBuscarUsuario.setVisible(FALSE);
    jButton17usuario.setVisible(FALSE);
    btnEliminarAUsuario.setVisible(FALSE);
    bntAceptarAUsuario.setVisible(FALSE);
    btnCancelarAUsuario.setVisible(FALSE);
    btnEliminarA.setVisible(TRUE);
    bntAceptarA.setVisible(TRUE);
    btnCancelarA.setVisible(TRUE);
   
    configurarTablaCanciones();
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection(); 

    // Llamar al método obtenerTodasCanciones
    List<String[]> canciones = baseDeDatos.obtenerTodasCanciones();

    // Obtener el modelo de la tabla
    DefaultTableModel modeloTabla = (DefaultTableModel) jTResultados.getModel();

    // Limpiar la tabla antes de llenar con nuevos datos
    modeloTabla.setRowCount(0);

    // Agregar los datos obtenidos a la tabla
    for (String[] fila : canciones) {
        modeloTabla.addRow(fila);
    }

    // Opcional: Mensaje si no se encontraron resultados
    if (canciones.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron Usuarios en la base de datos.");
    }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void verUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verUsuariosActionPerformed
    TxtBuscarCancioes.setVisible(FALSE);
    jButton16.setVisible(FALSE);
    TxtBuscarUsuario.setVisible(TRUE);
    jButton17usuario.setVisible(TRUE);
    btnEliminarAUsuario.setVisible(TRUE);
    bntAceptarAUsuario.setVisible(TRUE);
    btnCancelarAUsuario.setVisible(TRUE);
    btnEliminarA.setVisible(FALSE);
    bntAceptarA.setVisible(FALSE);
    btnCancelarA.setVisible(FALSE);
       
       
    configurarTablaUsuarios();
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection(); 

    // Llamar al método obtenerTodasCanciones
    List<String[]> Usuarios = baseDeDatos.obtenrUsuarios();

    // Obtener el modelo de la tabla
    DefaultTableModel modeloTablaUs = (DefaultTableModel) jTResultados.getModel();

    // Limpiar la tabla antes de llenar con nuevos datos
    modeloTablaUs.setRowCount(0);

    // Agregar los datos obtenidos a la tabla
    for (String[] fila : Usuarios) {
        modeloTablaUs.addRow(fila);
    }

    // Opcional: Mensaje si no se encontraron resultados
    if (Usuarios.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron Uusarios en la base de datos.");
    }
    }//GEN-LAST:event_verUsuariosActionPerformed
    //Editar Usuarios
    private void bntAceptarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAceptarAActionPerformed
    int filaSeleccionada = jTResultados.getSelectedRow();

    if (filaSeleccionada != -1) {
        // Obtener los valores de la fila seleccionada
        int idCancion = Integer.parseInt(jTResultados.getValueAt(filaSeleccionada, 0).toString());
        String nombre = jTResultados.getValueAt(filaSeleccionada, 1).toString();
        String artista = jTResultados.getValueAt(filaSeleccionada, 2).toString();
        String album = jTResultados.getValueAt(filaSeleccionada, 3).toString();
        String duracion = jTResultados.getValueAt(filaSeleccionada, 4).toString();
        int genero = Integer.parseInt(jTResultados.getValueAt(filaSeleccionada, 5).toString());
        String rutaImagen = jTResultados.getValueAt(filaSeleccionada, 6).toString();
        String rutaCancion = jTResultados.getValueAt(filaSeleccionada, 7).toString();

        // Crear un objeto Cancion con los valores obtenidos
        cancion ncancion = new cancion(idCancion, nombre, artista, album, duracion, genero, rutaImagen, rutaCancion);

        // Crear instancia de la clase de conexión a la base de datos
        PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();

        // Llamar al método para actualizar la canción en la base de datos
        boolean exito = baseDeDatos.actualizarCancion(ncancion);

        if (exito) {
            // Actualizar la fila en el JTable con los nuevos valores
            DefaultTableModel modeloTabla = (DefaultTableModel) jTResultados.getModel();
            modeloTabla.setValueAt(nombre, filaSeleccionada, 1); // Actualizar la columna "Nombre"
            modeloTabla.setValueAt(artista, filaSeleccionada, 2);  // Actualizar la columna "Autor"
            modeloTabla.setValueAt(album, filaSeleccionada, 3);  // Actualizar la columna "Álbum"
            modeloTabla.setValueAt(duracion, filaSeleccionada, 4); // Actualizar la columna "Duración"
            modeloTabla.setValueAt(genero, filaSeleccionada, 5);  // Actualizar la columna "Género"
            modeloTabla.setValueAt(rutaImagen, filaSeleccionada, 6); // Actualizar la columna "Ruta Imagen"
            modeloTabla.setValueAt(rutaCancion, filaSeleccionada, 7); // Actualizar la columna "Ruta Canción"

            JOptionPane.showMessageDialog(this, "Canción actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la canción.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.");
    }
    }//GEN-LAST:event_bntAceptarAActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        ///*
        // Obtener el texto que el usuario ingresó en TxtBuscarCanciones
    String nombreCancion = TxtBuscarCancioes.getText().trim();
    
    // Validar que el campo no esté vacío
    if (nombreCancion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para buscar.");
        return;
    }
    
    // Limpiar la tabla antes de mostrar los nuevos resultados
    DefaultTableModel modeloTabla = (DefaultTableModel) jTResultados.getModel();
    modeloTabla.setRowCount(0);

    // Llamar al método de búsqueda en la base de datos
    List<String[]> canciones = buscarCancionesPorNombre(nombreCancion);

    // Si no se encontraron canciones
    if (canciones.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron canciones con ese nombre.");
    } else {
        // Agregar los resultados a la tabla jTResultados
        for (String[] cancion : canciones) {
            modeloTabla.addRow(cancion);
        }
    }
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void atrasMAbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasMAbtnActionPerformed
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardVentacaMAdmin");
    }//GEN-LAST:event_atrasMAbtnActionPerformed

    private void btnAgregarFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFormularioActionPerformed
    
    String nombre = txtNombreISC.getText();  
    String artista = txtArtistaISC.getText();         
    String album = txtAlbumISC.getText();        
    String duracion = txtDuracionISC.getText();    
    String rutaImagen = txtRutaDePortadaISC.getText();
    String rutaCancion = txtRutadeCancionISC.getText();

    // Obtener el valor seleccionado del ComboBox
    String valorSeleccionado = comboGeneroISC.getSelectedItem().toString();

    // Convertir el valor a un entero
    int genero = 0;
    try {
        genero = Integer.parseInt(valorSeleccionado);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El género seleccionado no es un número válido.");
        return;
    }

    // Verificar que todos los campos estén completos
    if (nombre.isEmpty() || artista.isEmpty() || album.isEmpty() || duracion.isEmpty() || rutaImagen.isEmpty() || rutaCancion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
        return;
    }

    // Crear la conexión a la base de datos
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
    boolean exito = baseDeDatos.insertarCancion(nombre, artista, album, duracion, genero, rutaImagen, rutaCancion);

    if (exito) {
        JOptionPane.showMessageDialog(this, "Canción agregada correctamente.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar la canción a la base de datos.");
    }
        
       
    }//GEN-LAST:event_btnAgregarFormularioActionPerformed

    private void jbLpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLpActionPerformed
        //
        txtArtistaISC.setText("");
        txtNombreISC.setText("");
        txtAlbumISC.setText("");
        txtDuracionISC.setText("");
        txtRutadeCancionISC.setText("");
        txtRutaDePortadaISC.setText("");
        
    }//GEN-LAST:event_jbLpActionPerformed

    private void btnEliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAActionPerformed
       
    int filaSeleccionada = jTResultados.getSelectedRow();
    int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Estás seguro de que deseas eliminar este registro?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );
    if (respuesta == JOptionPane.YES_OPTION) {
   
        if (filaSeleccionada != -1) {
            // Obtener el ID de la fila seleccionada (suponiendo que está en la primera columna)
            String id = jTResultados.getValueAt(filaSeleccionada, 0).toString();

            // Eliminar el registro de la base de datos
            PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
            boolean exito = baseDeDatos.eliminarPorId(id); // Implementa este método en tu clase de conexión

            if (exito) {
                // Eliminar la fila del JTable
                DefaultTableModel modelo = (DefaultTableModel) jTResultados.getModel();
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Fila eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la fila de la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }  
    }//GEN-LAST:event_btnEliminarAActionPerformed

    private void btnCancelarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAActionPerformed
    configurarTablaCanciones();
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection(); 

    // Llamar al método obtenerTodasCanciones
    List<String[]> canciones = baseDeDatos.obtenerTodasCanciones();

    // Obtener el modelo de la tabla
    DefaultTableModel modeloTabla = (DefaultTableModel) jTResultados.getModel();

    // Limpiar la tabla antes de llenar con nuevos datos
    modeloTabla.setRowCount(0);

    // Agregar los datos obtenidos a la tabla
    for (String[] fila : canciones) {
        modeloTabla.addRow(fila);
    }

    // Opcional: Mensaje si no se encontraron resultados
    if (canciones.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron Usuarios en la base de datos.");
    }
    }//GEN-LAST:event_btnCancelarAActionPerformed

    private void btnEliminarAUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAUsuarioActionPerformed
       
    int filaSeleccionada = jTResultados.getSelectedRow();
    int respuesta = JOptionPane.showConfirmDialog(
            this, 
            "¿Estás seguro de que deseas eliminar este registro?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );
    if (respuesta == JOptionPane.YES_OPTION) {
   
        if (filaSeleccionada != -1) {
            // Obtener el ID de la fila seleccionada (suponiendo que está en la primera columna)
            String id = jTResultados.getValueAt(filaSeleccionada, 0).toString();

            // Eliminar el registro de la base de datos
            PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
            boolean exito = baseDeDatos.eliminarPorIdUsuario(id); // Implementa este método en tu clase de conexión

            if (exito) {
                // Eliminar la fila del JTable
                DefaultTableModel modelo = (DefaultTableModel) jTResultados.getModel();
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Fila eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la fila de la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }  
    }//GEN-LAST:event_btnEliminarAUsuarioActionPerformed

    private void bntAceptarAUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAceptarAUsuarioActionPerformed
        int filaSeleccionada = jTResultados.getSelectedRow();
        if (filaSeleccionada != -1) {
        // Obtener los valores de la fila seleccionada
        int idUsuario = Integer.parseInt(jTResultados.getValueAt(filaSeleccionada, 0).toString());
        String nombre = jTResultados.getValueAt(filaSeleccionada, 1).toString();
        String apellidos = jTResultados.getValueAt(filaSeleccionada, 2).toString();
        String correo = jTResultados.getValueAt(filaSeleccionada, 3).toString();
        String contrasena = jTResultados.getValueAt(filaSeleccionada, 4).toString();
        String isadmin = jTResultados.getValueAt(filaSeleccionada, 5).toString();
        String prguntac = jTResultados.getValueAt(filaSeleccionada, 6).toString();
        

        // Crear un objeto 
        usuario nusuario = new usuario(idUsuario, nombre, apellidos, correo, contrasena, isadmin);

        // Crear instancia de la clase de conexión a la base de datos
        PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();

        // Llamar al método para actualizar la canción en la base de datos
        boolean exito = baseDeDatos.actualizarUsuario(nusuario);

        if (exito) {
            // Actualizar la fila en el JTable con los nuevos valores
            DefaultTableModel modeloTablaUs = (DefaultTableModel) jTResultados.getModel();
            modeloTablaUs.setValueAt(nombre, filaSeleccionada, 1); 
            modeloTablaUs.setValueAt(apellidos, filaSeleccionada, 2);  
            modeloTablaUs.setValueAt(correo, filaSeleccionada, 3);  
            modeloTablaUs.setValueAt(contrasena, filaSeleccionada, 4); 
            modeloTablaUs.setValueAt(isadmin, filaSeleccionada, 5);  
            modeloTablaUs.setValueAt(prguntac, filaSeleccionada, 6); 

            JOptionPane.showMessageDialog(this, "Usuario actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.");
    }
    }//GEN-LAST:event_bntAceptarAUsuarioActionPerformed

    private void btnCancelarAUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAUsuarioActionPerformed
        // TODO add your handling code here:
        configurarTablaUsuarios();
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection(); 

    // Llamar al método obtenerTodasCanciones
    List<String[]> Usuarios = baseDeDatos.obtenrUsuarios();

    // Obtener el modelo de la tabla
    DefaultTableModel modeloTablaUs = (DefaultTableModel) jTResultados.getModel();

    // Limpiar la tabla antes de llenar con nuevos datos
    modeloTablaUs.setRowCount(0);

    // Agregar los datos obtenidos a la tabla
    for (String[] fila : Usuarios) {
        modeloTablaUs.addRow(fila);
    }

    // Opcional: Mensaje si no se encontraron resultados
    if (Usuarios.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron Uusarios en la base de datos.");
    }
        
    }//GEN-LAST:event_btnCancelarAUsuarioActionPerformed

    private void jButton17usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17usuarioActionPerformed
        // TxtBuscarUsuario
         String nombreUsuario = TxtBuscarUsuario.getText().trim();
    
    // Validar que el campo no esté vacío
    if (nombreUsuario.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para buscar.");
        return;
    }
    
    // Limpiar la tabla antes de mostrar los nuevos resultados
    DefaultTableModel modeloTablaUs = (DefaultTableModel) jTResultados.getModel();
    modeloTablaUs.setRowCount(0);

    // Llamar al método de búsqueda en la base de datos
    List<String[]> usuarios = buscarUsuarioPorNombre(nombreUsuario );

    // Si no se encontraron canciones
    if (usuarios.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron canciones con ese nombre.");
    } else {
        // Agregar los resultados a la tabla jTResultados
        for (String[] usuario : usuarios) {
            modeloTablaUs.addRow(usuario);
        }
    }
    }//GEN-LAST:event_jButton17usuarioActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardAgregaruA");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtArtistaISCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtistaISCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArtistaISCActionPerformed

    private void jbLp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLp1ActionPerformed
        // TODO add your handling code here:
        txtNombreusuarios.setText("");
        txtApellidosusuarios.setText("");
        txtCorreousuarios.setText("");
        txtContrasenausuarios.setText(" ");
        txtConfirmarContrasenausuarios.setText(" ");
       
    }//GEN-LAST:event_jbLp1ActionPerformed

    private void atrasMAbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasMAbtn1ActionPerformed
        // cardVentacaMAdmin
        card = (CardLayout)this.panelprincipal.getLayout();
        card.show(panelprincipal,"cardVentacaMAdmin");
    }//GEN-LAST:event_atrasMAbtn1ActionPerformed

    private void txtNombreusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreusuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreusuariosActionPerformed

    private void btnAgregarFormulario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFormulario1ActionPerformed
        // TODO add your handling code here:
        // Obtener los valores de los campos de texto
    String nombre = txtNombreusuarios.getText();
    String apellidos = txtApellidosusuarios.getText();
    String correo = txtCorreousuarios.getText();
    String contrasena = txtContrasenausuarios.getText();
    String confirmarContrasena = txtConfirmarContrasenausuarios.getText(); 
    String isadmin = txtIsAdminusuarios.getSelectedItem().toString();
   

    // Validar que las contraseñas coincidan
    if (!contrasena.equals(confirmarContrasena)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Por favor, verifica.");
        return;
    }

    // Validar que los demás campos no estén vacíos
    if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || isadmin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos antes de insertar.");
        return;
    }

    // Llamar al método de inserción
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
    boolean exito = baseDeDatos.insertarUsuarios(nombre, apellidos, correo, contrasena, isadmin);

    // Mostrar mensaje según el resultado
    if (exito) {
        JOptionPane.showMessageDialog(this, "Usuario insertado correctamente.");
        generarPDFUsuario(nombre, apellidos, correo);
       
    } else {
        JOptionPane.showMessageDialog(this, "Error al insertar el usuario.");
    }
    }//GEN-LAST:event_btnAgregarFormulario1ActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // rbTerminos
        // Validar que el RadioButton esté seleccionado
    if (!rbAceptaTerminos.isSelected()) {
        JOptionPane.showMessageDialog(this, "Debes aceptar los términos y condiciones para continuar.");
        return; // Detener la ejecución si no está seleccionado
    }

    // Obtener los valores de los campos de texto
    String nombre = txtNombres.getText();
    String apellidos = txtApellidos.getText();
    String correo = txtCorreoCrearCuenta.getText();
    String contrasena = txtContraseñaCrearCuenta.getText();
    String confirmarContrasena = txtConfirmarCC.getText(); // Campo de confirmación
    

    // Validar que las contraseñas coincidan
    if (!contrasena.equals(confirmarContrasena)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Por favor, verifica.");
        return;
    }

    // Validar que los demás campos no estén vacíos
    if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos antes de insertar.");
        return;
    }

    // Establecer isadmin directamente en false
    String isadmin = "false"; // Siempre será false

    // Llamar al método de inserción
    PostgreSQLConnection baseDeDatos = new PostgreSQLConnection();
    boolean exito = baseDeDatos.insertarUsuarios(nombre, apellidos, correo, contrasena, isadmin);

    // Mostrar mensaje según el resultado
    if (exito) {
        JOptionPane.showMessageDialog(this, "Usuario insertado correctamente.");
        // Generar el PDF para el usuario creado
        generarPDFUsuario(nombre, apellidos, correo);
        
    } else {
        JOptionPane.showMessageDialog(this, "Error al insertar el usuario.");
    }
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void rcancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcancionActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar Canción");
    
    // Permite seleccionar solo archivos (no directorios)
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
    // Mostrar el cuadro de diálogo
    int result = fileChooser.showOpenDialog(this);
    
    // Si se selecciona un archivo
    if (result == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        File archivoSeleccionado = fileChooser.getSelectedFile();
        
        // Obtener la ruta del archivo seleccionado
        String rutaCancion = archivoSeleccionado.getAbsolutePath();
        
        // Colocar la ruta en el JTextField correspondiente
        txtRutadeCancionISC.setText(rutaCancion);
    }
        
    }//GEN-LAST:event_rcancionActionPerformed

    private void rportadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rportadaActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar Portada");
    
    // Permite seleccionar solo archivos (no directorios)
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
    // Mostrar el cuadro de diálogo
    int result = fileChooser.showOpenDialog(this);
    
    // Si se selecciona un archivo
    if (result == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        File archivoSeleccionado = fileChooser.getSelectedFile();
        
        // Obtener la ruta del archivo seleccionado
        String rutaPortada = archivoSeleccionado.getAbsolutePath();
        
        // Colocar la ruta en el JTextField correspondiente
        txtRutaDePortadaISC.setText(rutaPortada);
    }

    }//GEN-LAST:event_rportadaActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    ///clase rdondear paneles
    public List<String[]> buscarCancionesPorNombre(String nombreCancion) {
    List<String[]> canciones = new ArrayList<>();
    String consulta = "SELECT * FROM cancion WHERE nombre LIKE ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(consulta)) {

        // Usamos el parámetro para hacer la búsqueda de canciones que contienen el nombre proporcionado
        stmt.setString(1, "%" + nombreCancion + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String[] fila = new String[]{
                    String.valueOf(rs.getInt("id_cancion")),
                    rs.getString("nombre"),
                    rs.getString("artista"),
                    rs.getString("album"),
                    rs.getString("duracion"),
                    rs.getString("genero"),
                    rs.getString("ruta_imagen"),
                    rs.getString("ruta_cancion")
                };
                canciones.add(fila);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar canciones por nombre: " + e.getMessage());
    }
    return canciones;
}
    public List<String[]> buscarUsuarioPorNombre(String nombreUsuario) {
    List<String[]> usuarios = new ArrayList<>();
    String consulta = "SELECT * FROM usuario WHERE nombre LIKE ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(consulta)) {

        // Usamos el parámetro para hacer la búsqueda de canciones que contienen el nombre proporcionado
        stmt.setString(1, "%" + nombreUsuario + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String[] fila = new String[]{
                    String.valueOf(rs.getInt("id_usuario")),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("isadmin")
                };
                usuarios.add(fila);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar Usuarios por nombre: " + e.getMessage());
    }
    return usuarios;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgregarPlaylist;
    private javax.swing.JPanel AgregarUsuario;
    private javax.swing.JPanel AgregrarCancion;
    private javax.swing.JPanel Codigo;
    private javax.swing.JPanel CrearNuevaPlaylist;
    private javax.swing.JPanel CrearUsuario;
    private javax.swing.JPanel MenuAdministrador;
    private javax.swing.JPanel NuevaC;
    private javax.swing.JPanel RestablecerContra;
    private javax.swing.JTextField TxtBuscarCancioes;
    private javax.swing.JTextField TxtBuscarUsuario;
    private javax.swing.JButton atrasMAbtn;
    private javax.swing.JButton atrasMAbtn1;
    private javax.swing.JButton bntAceptarA;
    private javax.swing.JButton bntAceptarAUsuario;
    private javax.swing.JButton botonx;
    private javax.swing.JButton botonx1;
    private javax.swing.JButton btnAgregarFormulario;
    private javax.swing.JButton btnAgregarFormulario1;
    private javax.swing.JButton btnCancelarA;
    private javax.swing.JButton btnCancelarAUsuario;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnEliminarA;
    private javax.swing.JButton btnEliminarAUsuario;
    private javax.swing.JButton btnInicioSeccion;
    private javax.swing.JButton btnInicioSeccion1;
    private javax.swing.JButton btnrestablecerC;
    private javax.swing.JComboBox<String> comboGeneroISC;
    private javax.swing.JTextField correorecuperarcontra;
    private javax.swing.JButton flecha1;
    private javax.swing.JButton flecha2;
    private javax.swing.JButton flecha3;
    private javax.swing.JButton flecha4;
    private javax.swing.JLabel img;
    private javax.swing.JPanel inicioseccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17usuario;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTResultados;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton jbLp;
    private javax.swing.JButton jbLp1;
    private javax.swing.JPanel jpini;
    private javax.swing.JTextField nuevaContraConfirmar;
    private javax.swing.JTextField nuevaContrauno;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JTextField preguntac;
    private javax.swing.JRadioButton rbAceptaTerminos;
    private javax.swing.JButton rcancion;
    private javax.swing.JButton regresarInicioAdmin;
    private javax.swing.JTextArea resultadoArea;
    private javax.swing.JButton rportada;
    private javax.swing.JPanel todaslasc;
    private javax.swing.JTextField txtAlbumISC;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosusuarios;
    private javax.swing.JTextField txtArtistaISC;
    private javax.swing.JPasswordField txtConfirmarCC;
    private javax.swing.JTextField txtConfirmarContrasenausuarios;
    private javax.swing.JTextField txtContrasenausuarios;
    private javax.swing.JPasswordField txtContraseñaCrearCuenta;
    private javax.swing.JPasswordField txtContraseñaInicio;
    private javax.swing.JTextField txtCorreoCrearCuenta;
    private javax.swing.JTextField txtCorreoInicioS;
    private javax.swing.JTextField txtCorreousuarios;
    private javax.swing.JTextField txtDuracionISC;
    private javax.swing.JComboBox<String> txtIsAdminusuarios;
    private javax.swing.JTextField txtNombreISC;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombreusuarios;
    private javax.swing.JTextField txtRutaDePortadaISC;
    private javax.swing.JTextField txtRutadeCancionISC;
    private javax.swing.JButton verUsuarios;
    // End of variables declaration//GEN-END:variables

}
