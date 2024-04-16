/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author daniel
 */
public class Programa {

    public static void main(String[] args) throws IOException {
        //Procedemos a leer el fichero y lo guardamos en una lista
        List<Donantes> listaDonantes = LeerFichero.readJson("donantes.json");
        for (Donantes listaDonante : listaDonantes) {
            
        }

        //mostramos la lista de donantes por consola
        listaDonantes.forEach(System.out::println);
        
        System.out.println("\nEJERCICIO B\n");
        //EJERCICIO B
        //mostramos la lista de donantes ordenada por el numero de donaciones
        //y squipeamos las 100 primeras
        listaOrdenadaNumDonantes(listaDonantes);
        
        System.out.println("\nEJERCICIO C\n");
        //EJERCICIO C
        //llamamos al metodo del ejercicio C y lo mostramos
        Set<String> conjunto = listaConjuntoDonantesMayor(listaDonantes);
        conjunto.forEach(System.out::println);
        
        System.out.println("\nEJERCICIO D\n");
        //creamos el fichero
        EscribirFicheros.crearFichero("./nombresMayores50.txt", conjunto);
        
        System.out.println("\nEJERCICIO E\n");
        //List<Donantes> listaPorId = listaDonantesId(listaDonantes, 461857526);
        
        System.out.println("\nEJERCICIO F\n");
        EscribirFicheros.writeJson("listaDonantes.json", listaDonantes);
        
    }

    //EJERCICIO B
    //creamos un método que reciba la lista de objetos y usando API Stream, 
    //ordena el Stream por número de donaciones e imprime por consola el 
    //número de donantes que hay en total, sin tener en cuenta los 100 primeros registros.
    public static void listaOrdenadaNumDonantes(List<Donantes> lista) {
        lista.stream()
                .sorted((d1, d2) -> Integer.compare(d1.numeroDonaciones(), d2.numeroDonaciones()))
                .skip(100)
                .forEach(System.out::println);
    }

    
//    EJERCICIO C
//    Crea un método en la clase Programa que reciba la lista de objetos 
//    y usando API Stream, devuelve un conjunto de nombres diferentes 
//    de donantes mayores de 50 años, ordenados alfabéticamente. 
//    Llama al método en el main y muestra por consola el resultado
    public static Set<String> listaConjuntoDonantesMayor(List<Donantes> lista) {
        return lista.stream()
                .filter(p -> Period.between(p.transformarFecha(), LocalDate.now()).getYears() > 50)
                .map((p)->p.nombre())
                .collect(Collectors.toSet());
    }

    //EJERCIO E
    // Crea un método en la clase Programa que reciba la lista de objetos 
    //original y un id de donante y devuelva una lista de registros 
    //con los donantes compatibles para ese donante.
    //
//    public static List<Donantes> listaDonantesId(List<Donantes> lista, int idDonante) {
//        return lista.stream()
//                .filter(p->p.id_paciente())
//                .collect(Collectors.toList());
//    }
}
