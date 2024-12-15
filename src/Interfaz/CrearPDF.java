/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author yael
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CrearPDF {
    public static void main(String[] args) {
        // Nombre del usuario
        String nombreUsuario = "Juan Pérez";
        
        // Ruta donde se generará el PDF
        String rutaPDF = "Usuario_" + nombreUsuario.replace(" ", "_") + ".pdf";

        // Crear un nuevo documento PDF
        Document documento = new Document();

        try {
            // Crear escritor para el PDF
            PdfWriter.getInstance(documento, new FileOutputStream(rutaPDF));

            // Abrir el documento
            documento.open();

            // Agregar contenido al PDF
            documento.add(new Paragraph("Bienvenido, " + nombreUsuario));
            documento.add(new Paragraph("Este PDF fue generado automáticamente."));
            documento.add(new Paragraph("Gracias por registrarte."));

            System.out.println("PDF creado con éxito en: " + rutaPDF);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            documento.close();
        }
    }
}

