package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento{

    @Override
    public double calcularDescuento(double monto) {
    
        return monto* 0.10; //Acá calculamos descuento del 10%
    

    }
}