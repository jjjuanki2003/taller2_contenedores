package uce.edu.jc.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("sms")
public class SMSService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {

        System.out.println("Enviando SMS a: " + destino);
        System.out.println("Mensaje: \n " + mensaje);
        System.out.println("Enviado correctamente");
        System.out.println("Fin del servicio de SMS! ");
    }
      public Integer getCantidad() {
        return 0;
      }
    public void setCantidad(Integer cantidad) {
        
    }
    
        public String getNombre() {

        return null;
         }
    public void setNombre(String nombre) {

    }

}
