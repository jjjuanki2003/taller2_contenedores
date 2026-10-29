package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.jc.paquete.interceptors.Auditoria;

@ApplicationScoped
public class PedidoService {

   
    @Auditoria 
    public String realizar(Pedido pedido, String valor1) {
        System.out.println("Realizado pedido...");
        System.out.println("Pedido realizado para: " + pedido.getCliente());
        System.out.println("Producto" + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());


        return "Pedido realizado con éxito";

    }
}
