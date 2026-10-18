package uce.edu.ec;

import uce.edu.ec.negocio.Pedido;
import uce.edu.ec.negocio.PedidoService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        
        Pedido pedido = new Pedido("Juan", "Envangelion design 100% algodón", 14, "jfcaranqui@uce.edu.ec");
        PedidoService pedidoService = new PedidoService();
        pedidoService.realizar(pedido);

    }
}
