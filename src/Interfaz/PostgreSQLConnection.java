package Interfaz;

import java.sql.*;

public class PostgreSQLConnection {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "98127463";

    public void obtenerTodasCanciones() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT * FROM cancion";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(consulta)) {

                while (rs.next()) {
                    int id = rs.getInt("id_cancion");
                    String nombre = rs.getString("nombre");
                    String autor = rs.getString("autor");
                    String album = rs.getString("album");
                    String duracion = rs.getString("duracion");
                    String genero = rs.getString("genero");
                    String ruta_portada = rs.getString("ruta_imagen");
                    String ruta_cancion = rs.getString("ruta_cancion");
                    System.out.println("\nID:\n" + id
                            + "\nNombre:\n" + nombre
                            + "\nAutor:\n" + autor
                            + "\nAlbum:\n" + album
                            + "\nDuracion\n" + duracion
                            + "\nGenero:\n" + genero
                            + "\nPortada:\n" + ruta_portada
                            + "\nCancion:\n" + ruta_cancion
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones\n" + e.getMessage());
        }
    }

    public void obtenerFavoritos() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT * FROM favoritosusuario";
            try (Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery(consulta)) {

                while (rs.next()) {
                    int id_favorito = rs.getInt("id_favorito");
                    int id_usuario = rs.getInt("id_usuario");
                    int id_cancion = rs.getInt("id_cancion");

                    System.out.println("\nID_Favorito:\n" + id_favorito
                            + "\nID_Usuario:\n" + id_usuario
                            + "\nID_Cancion:\n" + id_cancion
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones\n" + e.getMessage());
        }
    }

    public void misDatos(String nombre, String contrasena) {

        String consulta = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?";

        try (Connection conn = DriverManager.getConnection(url, nombre, contrasena); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String correo = rs.getString("correo");

                    System.out.println("\nNombre:\n" + name
                            + "\nApellidos:\n" + apellidos
                            + "\nCorreo:\n" + correo);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void obtenerPlaylist() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT * FROM playlist";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(consulta)) {

                while (rs.next()) {
                    int id_Playlist = rs.getInt("id_playlist");
                    String name_playlist = rs.getString("nombre");
                    String ruta_imagen = rs.getString("rutaimagen");
                    String id_cancion = rs.getString("id_cancion");
                    String numero_playlist = rs.getString("numero_playlist");

                    System.out.println("\nID_Playlist:\n" + id_Playlist
                            + "\nNombre_Playlist:\n" + name_playlist
                            + "\nRuta_Imagen:\n" + ruta_imagen
                            + "\nID_Cancion:\n" + id_cancion
                            + "\nNumero_Playlist:\n" + numero_playlist
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones\n" + e.getMessage());
        }
    }

    public void ordenarAutorDisponible() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT id_cancion ,autor FROM cancion";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(consulta)) {

                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String autor = rs.getString("autor");

                    System.out.println("\nAutor:\n" + autor);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones\n" + e.getMessage());
        }
    }
    
    public void filtrarAutor(String name_autor) {
        String consulta = "SELECT id_cancion,autor  FROM cancion WHERE autor ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, name_autor);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String autor = rs.getString("autor");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nAutor:\n" + autor);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void filtrarNombre(String name_song) {
        String consulta = "SELECT id_cancion,nombre  FROM cancion WHERE nombre ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, name_song);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String name_s = rs.getString("nombre");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nNombre_Cancion:\n" + name_s);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }
    
    public void ordenarNombreDisponible() {
        String consulta = "SELECT id_cancion,nombre  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String name_s = rs.getString("nombre");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nNombre_Cancion:\n" + name_s);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void filtrarAlbum(String name_album) {
        String consulta = "SELECT id_cancion,album  FROM cancion WHERE album ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, name_album);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String name_a = rs.getString("album");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nAlbum:\n" + name_a);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }
    
    public void ordenarAlbumDisponible() {
        String consulta = "SELECT id_cancion,album  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String name_s = rs.getString("album");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nAlbum:\n" + name_s);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void filtrarGenero(String name_genero) {
            String consulta = "SELECT id_cancion,genero  FROM cancion WHERE genero ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, name_genero);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String name_g = rs.getString("genero");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nGenero:\n" + name_g);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void ordenarDuracion() {
            String consulta = "SELECT id_cancion,duracion  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {


            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_cancion = rs.getInt("id_cancion");
                    String tiempo = rs.getString("duracion");

                    System.out.println("\nID_Cancion:\n" + id_cancion
                            + "\nDuracion:\n" + tiempo);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void obtenerNombrePlaylist(String n_Playlist) {
          String consulta = "SELECT *  FROM playlist WHERE nombre ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user,password ); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, n_Playlist);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_playlist = rs.getInt("id_playlist");
                    String nombre = rs.getString("nombre");

                    System.out.println("\nID_Cancion:\n" + id_playlist
                            + "\nNombre_Playlist:\n" + nombre);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
    }

    public void restablecerContrasena() {

    }

    public void restablecerNombre() {

    }

    public void restablecerApellidos() {

    }

    public static void main(String[] args) {
        PostgreSQLConnection cndb = new PostgreSQLConnection();
        cndb.obtenerNombrePlaylist("p");
    }
}
