package uce.edu.ec.negocio;

import jakarta.inject.Singleton;

@Singleton 
public class MailService {
    public void enviar(String correo, String asunto, String cuerpo){
        System.out.println("Enviando correo a: "+ correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo:\n" + cuerpo);
        System.out.println("Correo enviado con exito");
    }
}
