package uce.edu.jc.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.jc.paquete.extensiones.NotificacionExtensionMail;
import uce.edu.jc.paquete.extensiones.NotificacionExtensionSMS;
import uce.edu.jc.paquete.extensiones.NotificacionExtensionWhatsApp;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private CompraService compraService;

    @Inject
    private NotificacionExtensionMail notificacionCorreo;

    @Inject
    private NotificacionExtensionSMS notificacionSMS;

    @Inject
    private NotificacionExtensionWhatsApp notificacionWhatsApp = new NotificacionExtensionWhatsApp();

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        System.out.println("Iniciando la aplicación Quarkus...:");
        Compra compra = new Compra("María","iPhone",1500.50, "");
        Compra compra2 = new Compra("Juan","Samsung",1200.50, "");
        Compra compra3 = new Compra("Pedro","Xiaomi",800.50, "");


        compraService.realizar(compra, this.notificacionCorreo);
        compraService.realizar(compra2, this.notificacionSMS);
        compraService.realizar(compra3, this.notificacionWhatsApp);
    
        return 0;
    
    }

}
