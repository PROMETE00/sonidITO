package Interfaz;

/**
 *
 * @author prome
 */
public class admin {
    int id_admin;
    String nombre;
    String correo;
    String contrasena;

    public admin(int id_admin, String nombre, String correo, String contrasena) {
        this.id_admin = id_admin;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "\nId_admin\n" + id_admin + "Nombre\n" + nombre + "Correo\n" + correo + "Contrasena\n" + contrasena + "\n";
    }
    
}
