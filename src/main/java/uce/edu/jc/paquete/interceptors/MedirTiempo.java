package uce.edu.jc.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor 
@medTiempo 
@Priority(0)
public class MedirTiempo {

    @AroundInvoke
    public Object medirTiempo(InvocationContext context) throws Exception {


        long tiempoInicio = System.currentTimeMillis();
        Object resultado = context.proceed(); //ejecuta el método interceptado

        long fin = System.currentTimeMillis();
        long tiempoEjecucion = fin - tiempoInicio;
        System.out.println("Tiempo de ejecución del método " + context.getMethod().getName() + ": " + tiempoEjecucion + " ms");
        return resultado;
    }

}
