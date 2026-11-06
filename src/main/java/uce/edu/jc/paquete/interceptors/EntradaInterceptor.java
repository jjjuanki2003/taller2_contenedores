package uce.edu.jc.paquete.interceptors;

import java.time.LocalDate;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor 
@Entrada 
@Priority(4)
public class EntradaInterceptor {


    private LocalDate fechaEntrada;
    @AroundInvoke 
    public Object registrarEntrada(InvocationContext context) throws Exception {
        
        Object resultado = context.proceed();

        System.out.println("fecha de entrada: " + fechaEntrada.now());
        
        return resultado;

    }
}
