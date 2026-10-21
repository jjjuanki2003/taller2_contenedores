package uce.edu.jc.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;
    public static void main(String[] args) {
        
        Quarkus.run(Main.class, args);
        
    }

    @Override 
    public int run(String... args) {

        Pedido pedido = new Pedido("Juan", "laptop", 15000.0, "juan@gmail.com");
        this.pedidoService.realizar(pedido);
    

        return 0;
    }

    
}
