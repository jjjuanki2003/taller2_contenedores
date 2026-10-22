package uce.edu.jc.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("mail")
public class MailService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {

        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: \n " + mensaje);
        System.out.println("Enviado correctamente");
        System.out.println("Fin del servicio de correo! ");
    }
}
