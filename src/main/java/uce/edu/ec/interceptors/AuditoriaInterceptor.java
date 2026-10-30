package uce.edu.ec.interceptors;

import java.lang.reflect.Parameter;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.modelo.Matricula;
import uce.edu.ec.negocio.AuditoriaService;

@Auditoria 
@Interceptor 
public class AuditoriaInterceptor {

    
    @Inject
    private AuditoriaService auditoriaService;
    
    @AroundInvoke 
    public Object intercept(InvocationContext context) throws Exception {
        Object resultado = context.proceed(); //ejecuto el método

        Object[] valores =  context.getParameters(); //agarro los parámetros del método
        Matricula matricula = (Matricula) valores[0]; //Guardo el primer parámetro en una variable de tipo Matricula
        String nombre = matricula.getNombre();
        String apellido = matricula.getApellido();
        String curso = matricula.getCurso();
        this.auditoriaService.auditar(nombre, apellido, curso);
        System.out.println("retorno: " + resultado);
        return resultado;
    }

}
