package Interfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.Timer;
import javazoom.jl.player.Player;

public class ReproductorMP3 {

    private Player player;
    private Timer timer;
    private int duracionSegundos;
    private boolean isPlaying = false;
    private int currentPosition = 0;  // Variable para almacenar la posición de la canción

    /**
     * Reproduce o pausa una canción MP3 desde la ruta especificada y actualiza
     * un JLabel con la duración restante.
     *
     * @param rutaCancion Ruta del archivo MP3.
     * @param duracionLabel JLabel para mostrar la duración restante.
     */
    public void reproducirPausar(String rutaCancion, JLabel duracionLabel) {
        if (isPlaying) {
            // Pausar la canción si está reproduciéndose
            pausar();
        } else {
            // Reproducir la canción si no está reproduciéndose
            reproducir(rutaCancion, duracionLabel);
        }
    }

    /**
     * Reproduce una canción MP3 desde la ruta especificada y actualiza un
     * JLabel con la duración restante.
     *
     * @param rutaCancion Ruta del archivo MP3.
     * @param duracionLabel JLabel para mostrar la duración restante.
     */
    public void reproducir(String rutaCancion, JLabel duracionLabel) {
        if (!esArchivoValido(rutaCancion)) {
            System.err.println("El archivo no es válido o no existe: " + rutaCancion);
            return;
        }

        // Verificar si ya está reproduciéndose una canción
        if (isPlaying) {
            System.out.println("Ya está reproduciendo una canción. No se puede iniciar otra.");
            return; // Evitar iniciar una nueva reproducción si ya hay una en curso
        }

        isPlaying = true;
        try {
            // Si hay una posición guardada, reproducir desde esa posición
            InputStream is = new FileInputStream(rutaCancion);
            player = new Player(is);

            // Obtener duración simulada
            duracionSegundos = obtenerDuracion(rutaCancion);

            // Crear un temporizador para actualizar la UI
            timer = new Timer(1000, e -> {
                if (duracionSegundos > 0) {
                    duracionSegundos--;
                    int minutos = duracionSegundos / 60;
                    int segundos = duracionSegundos % 60;
                    duracionLabel.setText(String.format("%02d:%02d", minutos, segundos));
                } else {
                    timer.stop();
                    detener();
                }
            });
            timer.start();

            // Reproducir la canción en un hilo separado
            new Thread(() -> {
                try {
                    if (currentPosition > 0) {
                        // Reanudar desde la posición guardada
                        player.close();
                        InputStream isResumido = new FileInputStream(rutaCancion);
                        player = new Player(isResumido);
                        player.close();
                    }
                    player.play();
                } catch (Exception ex) {
                    System.err.println("Error al reproducir la canción: " + ex.getMessage());
                } finally {
                    detener();
                }
            }).start();

        } catch (Exception e) {
            System.err.println("Error al intentar reproducir el archivo: " + e.getMessage());
            detener();
        }
    }

    /**
     * Pausa la reproducción de la canción actual.
     */
    public void pausar() {
        if (player != null) {
            // Obtener la posición actual antes de pausar
            currentPosition = player.getPosition();  // Método ficticio: personaliza según tu librería
            player.close();
            player = null;
        }
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        isPlaying = false;
    }

    /**
     * Detiene la reproducción de la canción y restablece todo.
     */
    public void detener() {
        if (player != null) {
            player.close();
            player = null;
        }
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        isPlaying = false;
        currentPosition = 0;  // Resetear la posición cuando se detiene
    }

    /**
     * Verifica si un archivo es válido y existe.
     *
     * @param rutaCancion Ruta del archivo a verificar.
     * @return true si el archivo es válido, false en caso contrario.
     */
    private boolean esArchivoValido(String rutaCancion) {
        File archivo = new File(rutaCancion);
        return archivo.exists() && archivo.isFile() && rutaCancion.toLowerCase().endsWith(".mp3");
    }

    /**
     * Simula la obtención de la duración de una canción MP3. En una
     * implementación real, puedes usar una biblioteca para extraer metadatos.
     *
     * @param rutaCancion Ruta del archivo MP3.
     * @return Duración simulada en segundos.
     */
    private int obtenerDuracion(String rutaCancion) {
        // Simulación: Retornar siempre 180 segundos (3 minutos).
        return 180;
    }
}
