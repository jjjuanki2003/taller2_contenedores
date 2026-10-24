package uce.edu.jc.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    @Inject 
    private CompraService compraService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        Pedido pedido = new Pedido("Juan", "laptop", 15000.0, "juan@gmail.com");
        pedido.setTelefono("0995706120");
        this.pedidoService.realizar(pedido);

        Compra compra = new Compra("Juanki", "ASUS", 1500.0, "jjjuanki2003@gmail.com");
        compra.setTelefono("0995706120");
        this.compraService.realizar(compra);

        return 0;
    }

    


}
