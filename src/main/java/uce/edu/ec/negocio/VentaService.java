package uce.edu.ec.negocio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("venta")
public class VentaService {
    
    @Inject 
    @Named ("regular")
    private CalculadoraDescuento calculadoraDescuentoRegular;

    @Inject
    @Named("vip")
    private CalculadoraDescuento calculadoraDescuentoVIP;

    @Inject
    private Auditoria auditoria;

    private int numeroDeVenta;

    public void venta(Cliente cliente, double monto) {
        numeroDeVenta++;
        double descuento = getDescuento(cliente, monto);
        double total = monto - descuento;

        System.out.println("numero de venta: " + numeroDeVenta);
        System.out.println("Tipo de cliente: " + cliente.getTipoCliente());
        System.out.println("Monto de la venta: " + monto);
        System.out.println("Descuento aplicado: " + mostrarDescuento(cliente, monto));
        System.out.println("Total: " + total);

        auditoria.registrarOperacion(
                "Venta #" + numeroDeVenta
                        + " de " + cliente.getNombre()
                        + ", tipo " + cliente.getTipoCliente()
                        + ", monto " + monto
                        + ", descuento " + descuento
                        + ", total " + total);
    }

    private String mostrarDescuento(Cliente cliente, double monto) {
        if (cliente.getTipoCliente() == TipoCliente.VIP) {
            return "25%";
        } else {
            return "10%";
        }
    }

    private double getDescuento(Cliente cliente, double monto) {
        if (cliente.getTipoCliente() == TipoCliente.VIP) {
            return calculadoraDescuentoVIP.calcularDescuento(monto);
        } else {
            return calculadoraDescuentoRegular.calcularDescuento(monto);
        }
    }

    public int getNumeroDeVenta() {
        return numeroDeVenta;
    }

    public void setNumeroDeVenta(int numeroDeVenta) {
        this.numeroDeVenta = numeroDeVenta;
    }
}
