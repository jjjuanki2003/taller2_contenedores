package uce.edu.ec.negocio;

import java.time.LocalDate;

import jakarta.inject.Singleton;

@Singleton 
public class AuditoriaService {

    public void auditar(String nombre, String apellido, String curso) {
        System.out.println("Se ha auditorizado la matrícula del estudiante: " + nombre + " " + apellido + " en el curso: " + curso);
        System.out.println("Fecha: " + LocalDate.now());
    
    
    }
}
