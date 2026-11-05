package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.jc.paquete.interceptors.Auditoria;
import uce.edu.jc.paquete.interceptors.Mail;
import uce.edu.jc.paquete.interceptors.SMS;
import uce.edu.jc.paquete.interceptors.medTiempo;

@ApplicationScoped
public class PedidoService {

   
    @medTiempo 
    @Auditoria 
    @Mail 
    @SMS 
    public String realizar(Pedido pedido, String valor1) {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Realizado pedido...");
        System.out.println("Pedido realizado para: " + pedido.getCliente());
        System.out.println("Producto" + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());


        return "Pedido realizado con éxito";

    }
}
