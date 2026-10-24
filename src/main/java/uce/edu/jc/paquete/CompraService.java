package uce.edu.jc.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CompraService {

    @Inject 
    @Named("mail")
    private Notificacion notificacionCorreo;

    public void realizar(Compra compra) {
        System.out.println("Realizado compra...");
        System.out.println("Cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());

        String cuerpo = "Estimado" + compra.getCliente() + ", su compra de" +
                compra.getProducto() + " por un total de $" + compra.getTotal() +
                " ha salido con exito";

        //Notificación de pedido por correo electrónico
        this.notificacionCorreo.enviar(compra.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad() + 1);
        System.out.println("Cantidad de correos enviados en compra: " + this.notificacionCorreo.getCantidad());
        System.out.println("Nombre del servicio: " + this.notificacionCorreo.getNombre());
    }
}
