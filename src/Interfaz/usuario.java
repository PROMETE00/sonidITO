package Interfaz;

/**
 *
 * @author yael
 */
public class usuario {
    int id_usuario;
    String nombre;
    String apellidos;
    String correo;
    String contrasena;
    String prguntac;
    String isadmin;
    
    public usuario(int id_usuario, String nombre, String apellidos, String correo, String contrasena, String prguntac, String isadmin){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.prguntac = prguntac;
        this.isadmin = isadmin;
    }


    public int getId_usuario(){
        return id_usuario;
    }
    public void setId_usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }
    public String getNombreUsuario(){
        return nombre;
    }
    public void setNombreUsuario (String nombre){
        this.nombre = nombre;
    }
    public String getApellidosUsuario(){
        return apellidos;
    }
    public void setApellidosUsuario(String apellidos){
        this.apellidos = apellidos;
    }
    public String getCorreoUsuario(){
        return correo;
    }
    public void setCorreoUsuario(String correo){
        this.correo = correo;
    }
    public String getContrasenaUsuario(){
        return contrasena;
    }
    public void setContrasenaUsuario(String contrasena){
        this.contrasena = contrasena;
    }
    public String getPrguntacUsuario(){
        return prguntac;
    }
    public void setPrguntacUsuario (String prguntac){
        this.prguntac = prguntac;
    }
    public String getIsadminUsuario(){
        return isadmin;
    }
    public void setisAdminUsuario(String isadmin){
        this.isadmin = isadmin;
    }
    @Override
    public String toString() {
        return  "\nId_usuario:\n" + id_usuario + "\nNombre\n" + nombre + "\nApellidos\n" + apellidos + "\nCorreo\n" + correo + "\nContrasena\n" + contrasena + "\nColor favorito\n" + prguntac + "\nEs admin" + isadmin + "\n";
    }
}
