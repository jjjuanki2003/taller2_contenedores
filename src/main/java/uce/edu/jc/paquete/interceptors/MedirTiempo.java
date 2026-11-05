package uce.edu.jc.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor 
@medTiempo 
@Priority(Interceptor.Priority.APPLICATION)
public class MedirTiempo {

    @AroundInvoke
    public Object medirTiempo(InvocationContext context) throws Exception {


        Object resultado = context.proceed(); //ejecuta el método interceptado

        long tiempoInicio = System.currentTimeMillis();
    
        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - tiempoInicio;
        System.out.println("Tiempo de ejecución del método " + context.getMethod().getName() + ": " + tiempoEjecucion + " ms");
        return resultado;
    }

}
