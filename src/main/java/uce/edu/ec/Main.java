package uce.edu.ec;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.negocio.Cliente;
import uce.edu.ec.negocio.TipoCliente;
import uce.edu.ec.negocio.VentaService;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private VentaService ventaService;
    

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        Cliente juan = new Cliente("Juan", TipoCliente.REGULAR);
        Cliente maria = new Cliente("Maria", TipoCliente.VIP);
        Cliente pedro = new Cliente("Pedro", TipoCliente.REGULAR);
        Cliente ana = new Cliente("Ana", TipoCliente.VIP);

        ventaService.venta(juan, 100);
        ventaService.venta(maria, 200); 
        ventaService.venta(pedro, 150);
        ventaService.venta(ana, 300);
        
        return 0;
    }

}
