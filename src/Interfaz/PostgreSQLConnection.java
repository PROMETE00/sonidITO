package Interfaz;

import Interfaz.playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLConnection {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "98127463";

    public List<String[]> obtenerTodasCanciones() {
        List<String[]> canciones = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT * FROM cancion";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

                while (rs.next()) {
                    String[] cancion = new String[8]; // Cambia el tamaño si hay más/menos columnas en tu tabla
                    cancion[0] = String.valueOf(rs.getInt("id_cancion")); // Convertir ID a String
                    cancion[1] = rs.getString("nombre");
                    cancion[2] = rs.getString("artista");
                    cancion[3] = rs.getString("album");
                    cancion[4] = rs.getString("duracion");
                    cancion[5] = rs.getString("ruta_imagen");
                    cancion[6] = rs.getString("ruta_cancion");
                    cancion[7] = rs.getString("genero");

                    // Agregar el arreglo a la lista
                    canciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones\n" + e.getMessage());
        }

        return canciones;
    }

    public List<String[]> filtrarPorColumna(String columna, String valor) {
        String consulta = "SELECT id_cancion, ruta_imagen, ruta_cancion,duracion, " + columna + " FROM cancion WHERE " + columna + " ~ ?";
        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, valor);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idCancion = rs.getInt("id_cancion");
                    String rutaImagen = rs.getString("ruta_imagen");
                    String rutaCancion = rs.getString("ruta_cancion");
                    String duracion = rs.getString("duracion");
                    String texto = rs.getString(columna);

                    // Incluye ruta_imagen y ruta_cancion
                    resultados.add(new String[]{String.valueOf(idCancion), rutaImagen, rutaCancion, texto, duracion});
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }

        return resultados;
    }

    public List<String[]> buscarEnTodas(String valor) {
//        String[] columnas = {"autor", "nombre", "album"};
        String[] columnas = {"nombre"};
        List<String[]> resultados = new ArrayList<>();

        for (String columna : columnas) {
            List<String[]> resultadosParciales = filtrarPorColumna(columna, valor);
            resultados.addAll(resultadosParciales);
        }

        return resultados;
    }

    public void obtenerFavoritos() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT * FROM favoritosusuario";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

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

        try (Connection conn = DriverManager.getConnection(url, nombre, contrasena); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public List<String[]> obtenerPlaylistExistentes() {
        String consulta = "SELECT id_playlist, nombre_playlist, ruta_imagen , descripcion FROM playlist_existente";
        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idPlaylist = rs.getInt("id_playlist");
                    String nombrePlaylist = rs.getString("nombre_playlist");
                    String rutaImagen = rs.getString("ruta_imagen");
                    String descripcion = rs.getString("descripcion");
                    resultados.add(new String[]{
                        String.valueOf(idPlaylist), nombrePlaylist, rutaImagen, descripcion
                    });
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las playlists\n" + e.getMessage());
        }

        return resultados;
    }

    public List<String[]> obtenerPlaylistUsuario(int idUsuario) {
        String consulta = "SELECT p.nombre_playlist, p.ruta_imagen FROM mis_playlist m "
                + "INNER JOIN playlist_existente p ON m.id_playlist = p.id_playlist "
                + "WHERE m.id_usuario = ?";
        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String nombrePlaylist = rs.getString("nombre_playlist");
                    String rutaImagen = rs.getString("ruta_imagen");
                    resultados.add(new String[]{nombrePlaylist, rutaImagen});
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las playlists del usuario\n" + e.getMessage());
        }

        return resultados;
    }

    public int obtenerMisPlaylistCantidad(int usr) {
        int totalPlaylists = 0;
        String consulta = "SELECT COUNT(*) AS total FROM \"misPlaylist\" WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setInt(1, usr);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { // Solo hay una fila con el resultado de COUNT
                    totalPlaylists = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
        return totalPlaylists;
    }

    public playlist_cancion obtenerCancionesPlaylist(int id_playlist) {
        playlist_cancion ps = new playlist_cancion(0, 0);
        String consulta = "SELECT * FROM playlist_cancion WHERE id_playlist= ?";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setInt(1, id_playlist);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idPlaylist = rs.getInt("id_playlist");
                    int idCancion = rs.getInt("id_cancion");
                    ps.setId_playlist(id_playlist);
                    ps.setId_cancion(idCancion);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
        return ps;
    }

   

    public void ordenarAutorDisponible() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String consulta = "SELECT id_cancion ,autor FROM cancion";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {

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

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public void filtrarAlbum(String name_album) {
        String consulta = "SELECT id_cancion,album  FROM cancion WHERE album ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public void filtrarGenero(String name_genero) {
        String consulta = "SELECT id_cancion,genero  FROM cancion WHERE genero ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public void ordenarNombreDisponible() {
        String consulta = "SELECT id_cancion,nombre  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public void ordenarAlbumDisponible() {
        String consulta = "SELECT id_cancion,album  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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

    public void ordenarDuracion() {
        String consulta = "SELECT id_cancion,duracion  FROM cancion";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

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
        String consulta = "SELECT *  FROM playlist_existente WHERE nombre ~ ?";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            pstmt.setString(1, n_Playlist);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_playlist = rs.getInt("id_playlist");
                    String nombre = rs.getString("nombre_playlist");

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
        int usr = cndb.obtenerMisPlaylistCantidad(1);
        System.out.println(usr);
    }
}
