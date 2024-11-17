package Interfaz;

/**
 *
 * @author prome
 */
public class cancion {
    int id_cancion;
    String nombre;
    String autor;
    String album;
    String duracion;
    String genero;
    String ruta_img;
    String ruta_can;

    public cancion(int id_cancion, String nombre, String autor, String album, String duracion, String genero, String ruta_img, String ruta_can) {
        this.id_cancion = id_cancion;
        this.nombre = nombre;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
        this.genero = genero;
        this.ruta_img = ruta_img;
        this.ruta_can = ruta_can;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
    }

    public String getRuta_can() {
        return ruta_can;
    }

    public void setRuta_can(String ruta_can) {
        this.ruta_can = ruta_can;
    }

    @Override
    public String toString() {
        return  "\nId_can\n" + id_cancion + "Nombre\n" + nombre + "Autor\n" + autor + "Album\n" + album + "Duracion\n" + duracion + "Genero\n" + genero + "Ruta_img\n" + ruta_img + "Ruta_can\n" + ruta_can + '\n';
    }
    
}
