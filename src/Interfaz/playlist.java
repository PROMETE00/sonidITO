package Interfaz;

/**
 *
 * @author prome
 */
public class playlist {
    int id_playlist;
    String nombre;
    String ruta_imagen;
    int  id_cancion;
    int numero_playlist;

    public playlist(int id_playlist, String nombre, String ruta_imagen, int id_cancion, int numero_playlist) {
        this.id_playlist = id_playlist;
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.id_cancion = id_cancion;
        this.numero_playlist = numero_playlist;
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public int getNumero_playlist() {
        return numero_playlist;
    }

    public void setNumero_playlist(int numero_playlist) {
        this.numero_playlist = numero_playlist;
    }

    @Override
    public String toString() {
        return "\nId_playlist\n" + id_playlist + "Nombre\n" + nombre + "Ruta_imagen\n" + ruta_imagen + "Id_cancion\n" + id_cancion + "Numero_playlist\n" + numero_playlist + '\n';
    }
            
    
}
