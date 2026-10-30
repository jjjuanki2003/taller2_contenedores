package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.ec.interceptors.Auditoria;
import uce.edu.ec.modelo.Matricula;

@ApplicationScoped 
public class MatriculaService {


    @Auditoria 
    public String matricular(Matricula matricula){

        System.out.println("Empezando matrícula");
        System.out.println("Nombre: " + matricula.getNombre());
        System.out.println("Apellido: " + matricula.getApellido());
        System.out.println("Curso: " + matricula.getCurso());

        return "Matrícula exitosa";
    }
}
