package uce.edu.jc.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.jc.paquete.SMSService;

@Interceptor 
@SMS
@Priority (2)
public class SMSInterceptor {

    @Inject 
    SMSService smsService;
    
    @AroundInvoke 
    public Object enviarSMS(InvocationContext context) throws Exception {

        Object resultado = context.proceed(); //ejecuta el método interceptado

        smsService.enviar("0995706120", "completa tu inscripción a jóvenes en acción en el siguiente link");

        return resultado;
    }

}
