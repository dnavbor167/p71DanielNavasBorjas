/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author daniel
 */
public class EscribirFicheros {

    //EJERCICIO D
    //Crea una clase, para generar ficheros, llamada EscribirFicheros. 
    //Incluye un método en esta clase, que reciba un String con la ruta 
    //y nombre del fichero a crear y un conjunto de String y guarde, 
    //en la raíz del proyecto, en un fichero de texto plano llamado 
    //nombresMayores50.txt, el contenido del conjunto obtenido en 
    //paso anterior de forma que en cada línea del fichero haya un nombre.
    public static void crearFichero(String ruta, Set<String> conjunto) {
        Path file = Paths.get(ruta);
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (IOException e) {
            System.out.println("Problema creando el archivo " + ruta);
            System.out.println("Probablemente la ruta esté mal escrita.");
        }

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            for (String nombre : conjunto) {
                // Verificar si el nombre tiene más de 50 caracteres antes de escribirlo
                flujo.write(nombre);
                flujo.newLine();
            }
            // Guardar los cambios en el disco
            flujo.flush();
        } catch (IOException w) {
            System.out.println(w.getMessage());
        }

    }

    // Crea un método, en la clase EscribirFicheros, que reciba 
    //un nombre de fichero y una lista de donantes y guarde 
    //el contenido de la lista en un fichero json.
    public static void writeJson(String nombreFichero, List<Donantes> lista) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File(nombreFichero), lista);
    }
}
