/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author daniel
 */
public record Donantes(int id_paciente, String nombre, String fechaNacimiento,
        String grupoSanguineo, char rh, int numeroDonaciones) {

    public LocalDate transformarFecha() {
        //le damos un formato a la fecha de (día/mes/año)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        //creamos la fecha, le pasamos el string de la fecha y el formatter
        //creado anterior
        return LocalDate.parse(this.fechaNacimiento, formatter);
    }
    
}
