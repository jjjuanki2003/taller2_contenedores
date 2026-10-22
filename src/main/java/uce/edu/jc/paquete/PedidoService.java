package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped 
public class PedidoService {

    /*
    @Inject
    private MailService mailService;
    */

    /*
    //Inyección de dependencias por constructor
    private MailService mailService;
    @Inject 
    public PedidoService(MailService mailService) {

        this.mailService = mailService;
    }
     */

    
    
/*
    //Inyección de dependencia por setter
    private MailService mailService;

    @Inject 
    public void setMailService(MailService mailService) {
    System.out.println("Se está inyectando el servicio de correo electrónico en PedidoService");
        this.mailService = mailService;
    }
//-------------------------------------------------------------------------
   */  

//Lookup de la clase MailService


MailService mailService = CDI.current().select(MailService.class).get();

public void realizar(Pedido pedido) {
        System.out.println("Realizado pedido...");
        System.out.println("" + pedido.getCliente());
        System.out.println("" + pedido.getProducto());
        System.out.println("" + pedido.getTotal());
        System.out.println("" + pedido.getCorreo());

        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado" + pedido.getCliente() + ", su pedido de" +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha salido con exito";

        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);

    }
}
