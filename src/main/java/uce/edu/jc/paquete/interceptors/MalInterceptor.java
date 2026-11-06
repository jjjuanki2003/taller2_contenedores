package uce.edu.jc.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.jc.paquete.MailService;

@Interceptor 
@Mail 
@Priority(3)

public class MalInterceptor {

    @Inject 
    MailService mailService;

    @AroundInvoke
    public Object enviarMail(InvocationContext context) throws Exception {
        Object resultado = context.proceed(); //ejecuta el método interceptado
        mailService.enviar("jcaranqui@uce.edu.ec", "Problema de verificación de tu cuenta");
        return resultado;
    }
}
