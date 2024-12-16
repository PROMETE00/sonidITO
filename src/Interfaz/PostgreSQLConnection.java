package Interfaz;

import Interfaz.playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

    public usuario validarCredenciales(String correo, String contrasena) {
        String sql = "SELECT id_usuario, nombre, apellidos, correo, contrasena, isadmin,preguntac FROM usuario WHERE correo = ? AND contrasena = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Si se encuentra un usuario con esas credenciales
            if (rs.next()) {
                // Crear un objeto usuario con los datos obtenidos de la base de datos
                return new usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("preguntac"),
                        rs.getString("isadmin")
                );
            } else {
                // Si no se encuentra el usuario o las credenciales son incorrectas
                JOptionPane.showMessageDialog(null, "El correo o la contraseña son incorrectos.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
            return null;
        }
    }

    public List<String[]> obtenrUsuarios() {
        List<String[]> usuarios = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos"); // Verifica la conexión

            String consulta = "SELECT * FROM usuario ORDER BY id_usuario ASC";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(consulta)) {
                while (rs.next()) {
                    System.out.println("Se encontró una usuario: " + rs.getString("nombre")); // Depura los datos que se obtienen

                    String[] fila = new String[]{
                        String.valueOf(rs.getInt("id_usuario")),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("isadmin"),
                        rs.getString("preguntac")
                    };
                    usuarios.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener canciones: " + e.getMessage());
        }

        System.out.println("Canciones encontradas: " + usuarios.size()); // Verifica el tamaño de la lista
        return usuarios;
    }

    public boolean insertarCancion(String nombre, String autor, String album, String duracion, String genero, String rutaImagen, String rutaCancion) {
        String sql = "INSERT INTO cancion ( nombre, autor, album, duracion, genero, ruta_imagen, ruta_cancion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); // Llama al método conectar()
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurar los valores en la consulta
            stmt.setString(1, nombre);
            stmt.setString(2, autor);
            stmt.setString(3, album);
            stmt.setString(4, duracion);
            stmt.setString(5, genero);
            stmt.setString(6, rutaImagen);
            stmt.setString(7, rutaCancion);

            // Ejecutar la consulta y verificar si se insertó correctamente
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarFav(int id_usuario, int id_cancion) {
        // Consulta SQL para insertar en la tabla 'favoritosusuario'
        String sql = "INSERT INTO favoritosusuario (id_usuario, id_cancion) VALUES (?, ?)";

        try (Connection conn = conectar(); // Llama al método conectar()
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignar valores a los parámetros de la consulta
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_cancion);

            // Ejecutar la consulta y verificar si se insertó correctamente
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeFav(int id_usuario, int id_cancion) {
        String sql = "SELECT 1 FROM favoritosusuario WHERE id_usuario = ? AND id_cancion = ? LIMIT 1";

        try (Connection conn = conectar(); // Conexión a la base de datos
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignar valores a los parámetros de la consulta
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_cancion);

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true si hay una fila, false si no
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre algún error
        }
    }

    public playlist obtenerPlaylistPorId(int id_playlist) {
        String sql = "SELECT id_playlist, nombre_playlist, ruta_imagen, descripcion "
                + "FROM playlist_existente WHERE id_playlist = ?";
        try (Connection conn = conectar(); // Conexión a la base de datos
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignar valor al parámetro
            stmt.setInt(1, id_playlist);

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // Si hay resultados
                    // Crear y retornar un objeto Playlist
                    return new playlist(
                            rs.getInt("id_playlist"),
                            rs.getString("nombre_playlist"),
                            rs.getString("ruta_imagen"),
                            rs.getString("descripcion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encontró la playlist
    }

    public List<Integer> obtenerCancionesFavoritas(int id_usuario) {
        List<Integer> cancionesFavoritas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Consulta para obtener todos los id_cancion que coincidan con el id_usuario dado
            String consulta = "SELECT id_cancion FROM favoritosusuario WHERE id_usuario = ?";
            try (PreparedStatement stmt = conn.prepareStatement(consulta)) {

                // Asignar el parámetro de id_usuario a la consulta
                stmt.setInt(1, id_usuario);

                // Ejecutar la consulta
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        // Obtener id_cancion y agregarlo a la lista como Integer
                        cancionesFavoritas.add(rs.getInt("id_cancion"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener las canciones favoritas\n" + e.getMessage());
        }

        return cancionesFavoritas;
    }

    public List<cancion> obtenerDetallesCancionesFavoritas(List<Integer> idsCanciones) {
        List<cancion> detallesCanciones = new ArrayList<>();

        if (idsCanciones.isEmpty()) {
            return detallesCanciones; // Retorna una lista vacía si no hay IDs
        }

        // Construir la consulta con IN (?, ?, ...)
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < idsCanciones.size(); i++) {
            placeholders.append("?");
            if (i < idsCanciones.size() - 1) {
                placeholders.append(", ");
            }
        }

        String consulta = "SELECT id_cancion, nombre, artista, album, duracion, ruta_imagen, ruta_cancion, genero "
                + "FROM cancion WHERE id_cancion IN (" + placeholders + ")";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement stmt = conn.prepareStatement(consulta)) {

            // Asignar los valores de los IDs a los placeholders
            for (int i = 0; i < idsCanciones.size(); i++) {
                stmt.setInt(i + 1, idsCanciones.get(i));
            }

            // Ejecutar la consulta y procesar los resultados
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cancion cancion = new cancion(
                            rs.getInt("id_cancion"),
                            rs.getString("nombre"),
                            rs.getString("artista"),
                            rs.getString("album"),
                            rs.getString("duracion"),
                            rs.getString("ruta_imagen"),
                            rs.getString("ruta_cancion"),
                            rs.getString("genero")
                    );
                    detallesCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener detalles de las canciones\n" + e.getMessage());
        }

        return detallesCanciones;
    }

    public boolean eliminarFav(int id_usuario, int id_cancion) {
        String sql = "DELETE FROM favoritosusuario WHERE id_usuario = ? AND id_cancion = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_cancion);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> obtenerDetallesCancionPorNombre(String nombreCancion) {
        String sql = "SELECT id_cancion, nombre, artista, album, duracion, ruta_imagen, ruta_cancion, genero "
                + "FROM cancion WHERE nombre = ?";

        List<String> detallesCancion = new ArrayList<>();

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreCancion);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Agregar los detalles a la lista en orden
                    detallesCancion.add(String.valueOf(rs.getInt("id_cancion")));  // Convertir el ID a String
                    detallesCancion.add(rs.getString("nombre"));
                    detallesCancion.add(rs.getString("artista"));
                    detallesCancion.add(rs.getString("album"));
                    detallesCancion.add(rs.getString("duracion"));
                    detallesCancion.add(rs.getString("ruta_imagen"));
                    detallesCancion.add(rs.getString("ruta_cancion"));
                    detallesCancion.add(rs.getString("genero"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Si no se encontraron resultados, la lista estará vacía
        return detallesCancion;
    }

    public boolean eliminarPorId(String id) {
        String sql = "DELETE FROM cancion WHERE id_cancion = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int idEntero = Integer.parseInt(id);
            stmt.setInt(1, idEntero);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarUsuarios(String nombre, String apellidos, String correo, String contrasena, String isadmin, String preguntac) {
        String sql = "INSERT INTO usuario ( nombre, apellidos, correo, contrasena, isadmin, preguntac) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); // Llama al método conectar()
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurar los valores en la consulta
            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, correo);
            stmt.setString(4, contrasena);
            stmt.setString(5, isadmin);
            stmt.setString(6, preguntac);

            // Ejecutar la consulta y verificar si se insertó correctamente
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(usuario usuario) {
        String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, correo = ?, contrasena = ?,isadmin = ?, preguntac = ?  WHERE id_usuario = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Establecer los valores de las columnas usando los métodos getter de la clase Uusario
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getApellidosUsuario());
            stmt.setString(3, usuario.getCorreoUsuario());
            stmt.setString(4, usuario.getContrasenaUsuario());
            stmt.setString(5, usuario.getIsadminUsuario());
            stmt.setString(6, usuario.getPrguntacUsuario());
            stmt.setInt(7, usuario.getId_usuario());

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Si se actualizó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPorIdUsuario(String id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int idEnterou = Integer.parseInt(id);
            stmt.setInt(1, idEnterou);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection conectar() {
        try {

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarCancion(cancion cancion) {
        String sql = "UPDATE cancion SET nombre = ?, autor = ?, album = ?, duracion = ?, genero = ?, ruta_imagen = ?, ruta_cancion = ? WHERE id_cancion = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Establecer los valores de las columnas usando los métodos getter de la clase Cancion
            stmt.setString(1, cancion.getNombre());
            stmt.setString(2, cancion.getArtista());
            stmt.setString(3, cancion.getAlbum());
            stmt.setString(4, cancion.getDuracion());
            stmt.setString(5, cancion.getGenero());
            stmt.setString(6, cancion.getRuta_img());
            stmt.setString(7, cancion.getRuta_can());
            stmt.setInt(8, cancion.getId_cancion()); // El ID de la canción

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Si se actualizó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

                    String[] playlist = new String[8]; // Cambia el tamaño si hay más/menos columnas en tu tabla
                    playlist[0] = String.valueOf(rs.getInt("id_playlist")); // Convertir ID a String
                    playlist[1] = rs.getString("nombre_playlist");
                    playlist[2] = rs.getString("ruta_imagen");
                    playlist[3] = rs.getString("descripcion");
                    resultados.add(playlist);
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

    public List<String[]> obtenerCancionesPlaylist(int id_playlist) {
        String consulta = "SELECT * FROM playlist_cancion WHERE id_playlist= ?";
        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String[] playlist = new String[8]; // Cambia el tamaño si hay más/menos columnas en tu tabla
                    playlist[0] = String.valueOf(rs.getInt("id_playlist")); // Convertir ID a String
                    playlist[1] = rs.getString("nombre_playlist");
                    playlist[2] = rs.getString("ruta_imagen");
                    playlist[3] = rs.getString("descripcion");
                    resultados.add(playlist);
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudieron obtener los datos\n" + e.getMessage());
        }
        return resultados;
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
//        int usr = cndb.obtenerMisPlaylistCantidad(1);
        System.out.println();
    }
}
