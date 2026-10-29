package uce.edu.jc.paquete.interceptors;

import java.lang.reflect.Parameter;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.jc.paquete.AuditoriaService;
import uce.edu.jc.paquete.Pedido;

@Auditoria 
@Interceptor 
public class AuditoriaInterceptor {

    @Inject 
    private AuditoriaService auditoriaService;

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
         
        //todo lo que está arriba se ejecuta antes de ejecutar el método interceptado
        Object resultado = context.proceed(); //ejecuta el método interceptado
        System.out.println("Retorno: " + resultado);
    
        System.out.println("Mensaje luego de que se ejecuta el método");
        
         
        String nombreMetodo = context.getMethod().getName(); //guardamos el nombre del método
        System.out.println("AuditoriaInterceptor: Antes de ejecutar el método " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");
        
        Parameter[] parametros =context.getMethod().getParameters();
        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();

        Pedido pedido = (Pedido)valores[0];
        
        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();


        this.auditoriaService.guardarEnLaBase(cliente, total, correo); 
        return resultado;
    }

}
