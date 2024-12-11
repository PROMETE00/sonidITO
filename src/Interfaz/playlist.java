package Interfaz;

/**
 *
 * @author prome
 */
public class playlist {

    int id_playlist;
    String nombre;
    String ruta_imagen;
    String descripcion;

    public playlist(int id_playlist, String nombre, String ruta_imagen, String descripcion) {
        this.id_playlist = id_playlist;
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nId_playlist\n" + id_playlist + "Nombre\n" + nombre + "Ruta_imagen\n" + ruta_imagen + "Descripcion\n" + descripcion + '\n';
    }

}
