package Interfaz;

import java.awt.Color;
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
    Color inv = new Color(0, 0, 0, 0);
    Color verdeB = new Color(31, 157, 62);
    private int currentPosition = 0;  // Variable para almacenar la posición de la canción

    public void reproducirPausar(String rutaCancion, JLabel duracionLabel) {
        if (isPlaying) {
            pausar();
        } else {
            reproducir(rutaCancion, duracionLabel);
        }
    }

    public void reproducir(String rutaCancion, JLabel duracionLabel) {
        if (!esArchivoValido(rutaCancion)) {
            System.err.println("El archivo no es válido o no existe: " + rutaCancion);
            return;
        }

        if (isPlaying) {
            System.out.println("Ya está reproduciendo una canción. No se puede iniciar otra.");
            return;
        }

        isPlaying = true;
        try {
            InputStream is = new FileInputStream(rutaCancion);
            player = new Player(is);

            duracionSegundos = obtenerDuracion(rutaCancion);

            if (timer != null) {
                timer.stop();
                timer = null;
            }

            timer = new Timer(1000, e -> {
                if (duracionSegundos > 0) {
                    duracionSegundos--;
                    int minutos = duracionSegundos / 60;
                    int segundos = duracionSegundos % 60;
                    duracionLabel.setOpaque(true);
                    duracionLabel.setBackground(verdeB);
                    duracionLabel.setForeground(Color.white);
                    duracionLabel.setText(String.format("%02d:%02d", minutos, segundos));
                } else {
                    timer.stop();
                    duracionLabel.setText("0:00");
                    detener(); // Al finalizar la canción
                }
            });
            timer.start();

            new Thread(() -> {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.err.println("Error al reproducir la canción: " + ex.getMessage());
                } finally {
                    detener(); // Al finalizar el thread de reproducción
                }
            }).start();

        } catch (Exception e) {
            System.err.println("Error al intentar reproducir el archivo: " + e.getMessage());
            detener(); // Al ocurrir un error general
        }
    }

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
        duracionSegundos = 0;
        currentPosition = 0; // Reiniciar posición
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

    private int obtenerDuracion(String rutaCancion) {
        return 180;
    }
}
