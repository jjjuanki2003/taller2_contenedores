package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped
public class PedidoService {

    @Inject
    @Named("mail")
    private Notificacion notificacionCorreo;
    
    @Inject 
    @Named("sms")
    private Notificacion notificacionSMS;

    /*
    @Inject
    private MailService mailService;
    */

    /*
     * //Inyección de dependencias por constructor
     * private MailService mailService;
     * 
     * @Inject
     * public PedidoService(MailService mailService) {
     * 
     * this.mailService = mailService;
     * }
     */

    /*
     * //Inyección de dependencia por setter
     * private MailService mailService;
     * 
     * @Inject
     * public void setMailService(MailService mailService) {
     * System.out.
     * println("Se está inyectando el servicio de correo electrónico en PedidoService"
     * );
     * this.mailService = mailService;
     * }
     * //-------------------------------------------------------------------------
     */

    // Lookup de la clase MailService
    public void realizar(Pedido pedido) {
        System.out.println("Realizado pedido...");
        System.out.println("" + pedido.getCliente());
        System.out.println("" + pedido.getProducto());
        System.out.println("" + pedido.getTotal());
        System.out.println("" + pedido.getCorreo());

        String cuerpo = "Estimado" + pedido.getCliente() + ", su pedido de" +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha salido con exito";

        //Notificación de pedido por correo electrónico
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);

        //Notificación de pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);


    }
}
