package Interfaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "root";
        String password = "98127463";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conexión exitosa al servidor PostgreSQL.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL.");
            e.printStackTrace();
        }
    }
}
