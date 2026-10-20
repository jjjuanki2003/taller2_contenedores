package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class PedidoService {
    public void     realizar(Pedido pedido ){
        System.out.println("Realizado pedido...");
        System.out.println("Cliente encontrado: " + pedido.getCliente());
        System.out.println("Tipo de camiseta: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo del cliente: " + pedido.getCorreo());

        MailService mailService = new MailService();
        String asunto = "Confirmación de camiseta de " + pedido.getProducto();
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + 
        pedido.getProducto() + " por un total de $" + pedido.getTotal() +
        " ha salido con exito";
        mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }
}
