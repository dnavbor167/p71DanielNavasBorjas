/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author daniel
 */
public class LeerFichero {

    public static ArrayList<Donantes> readJson(String ruta) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        
        ArrayList<Donantes> catalogo = mapeador.readValue(new File(ruta),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Donantes.class)); 
        
        return catalogo;
        
        //DEBERÍA DE HABER SIDO ASÍ:
//        try {
//            ArrayList<Donantes> catalogo = mapeador.readValue(new File(ruta),
//                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Donantes.class)); 
//            return Optional.of(catalogo);
//        } catch (IOException ex) {
//            return Optional.empty();
//        }
        
    }
}
