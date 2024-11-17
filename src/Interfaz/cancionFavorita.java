package Interfaz;

/**
 *
 * @author prome
 */
public class cancionFavorita {
    int id_favorito;
    int id_usuario;
    int id_cancion;

    public cancionFavorita(int id_favorito, int id_usuario, int id_cancion) {
        this.id_favorito = id_favorito;
        this.id_usuario = id_usuario;
        this.id_cancion = id_cancion;
    }

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    @Override
    public String toString() {
        return "\nId_Fav\n" + id_favorito + "Id_User\n" + id_usuario + "Id_Song\n" + id_cancion +"\n";
    }
    
}
