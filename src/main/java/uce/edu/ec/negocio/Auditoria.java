package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Auditoria {

    public void registrarOperacion(String operacion) {
        System.out.println("Auditoría: " + operacion);
    }
}
