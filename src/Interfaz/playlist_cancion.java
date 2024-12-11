package Interfaz;

/**
 *
 * @author prome
 */
public class playlist_cancion {
    
    int id_playlist;
    int id_cancion;

    public playlist_cancion(int id_playlist, int id_cancion) {
        this.id_playlist = id_playlist;
        this.id_cancion = id_cancion;
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    @Override
    public String toString() {
        return "Id_playlist=" + id_playlist + ", id_cancion=" + id_cancion + '}';
    }
    
}
