package uce.edu.jc.paquete.interceptors;

import java.lang.reflect.Parameter;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.jc.paquete.AuditoriaService;
import uce.edu.jc.paquete.Pedido;

@Interceptor 
@Auditoria 
@Priority (1)
public class AuditoriaInterceptor {

    @Inject 
    private AuditoriaService auditoriaService;

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
         
        Object[] valores = context.getParameters();

        Pedido pedido = (Pedido)valores[0];
        
        String cliente = pedido.getCliente();
        double total = pedido.getTotal();
        String correo = pedido.getCorreo();
                
        Object resultado = context.proceed(); //ejecuta el método interceptado

        this.auditoriaService.guardarEnLaBase(cliente, total, correo);
 
        return resultado;
    }

}
