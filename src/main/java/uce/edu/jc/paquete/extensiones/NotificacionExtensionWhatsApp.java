package uce.edu.jc.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionExtensionWhatsApp implements NotificacionExtension {

    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando mensaje de WhatsApp a " + destinatario + " con el mensaje: " + mensaje);
        System.out.println("Mensaje de WhatsApp enviado con éxito");
   
    }

}
