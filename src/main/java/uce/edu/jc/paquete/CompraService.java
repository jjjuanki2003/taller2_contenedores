package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.jc.paquete.extensiones.NotificacionExtension;

@ApplicationScoped
public class CompraService {


    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {

        System.out.println("Realizado compra...");
        System.out.println("Cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Compra realizada con éxito");

        //Aquí voy a programar el envío de la notificación
        //Debo recibir como parámetro una implementación de la interfaz. 
        //Argumento de método o constructor
        notificacionExtension.enviar("Su compra se ha realizado con éxito",  compra.getCliente());

        
    }
}
