package uce.edu.ec;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.negocio.Pedido;
import uce.edu.ec.negocio.PedidoService;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;
    public static void main(String[] args) {

        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
       
        Pedido pedido = new Pedido("Juan", "laptop", 1500.0, "juan@gmail.com");

        pedidoService.realizar(pedido);

        return 0;
    }

    
}
