package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named ("vip")
public class DescuentoVIP implements CalculadoraDescuento{

    @Override
    public double calcularDescuento(double monto) {

        return monto * 0.25; //Acá aplicamos descuento del 25%

    }   
}