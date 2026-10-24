package uce.edu.jc.paquete;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;


//Ámbitos y contextos

@Dependent //Su ámbito es durante la inyección de dependencias, es decir se crea una instancia y se comparte en todos los componentes que la utilizan durante la inyección de dependencias. Cada vez que se inyecte se creará un nuevo objeto
//@Singleton //Mismo ámbito que ApplicationScoped
//@ApplicationScoped //su ámbito es durante toda la aplicación. Es decir, se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan 
//RequestScoped //su ámbito es en aplicaciones web durante la request/petición http. Es decir, se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante la petición http
//@SessionScoped //Su ámbito es en aplicaciones web durante la sesión de usuario, es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante la sesión del usuario
@Named("mail")
public class MailService implements Notificacion {


    private Integer cantidad = 0;
    private String nombre;


    @Override
    public void enviar(String destino, String mensaje) {

        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: \n " + mensaje);
        System.out.println("Enviado correctamente");
        System.out.println("Fin del servicio de correo! ");
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}

