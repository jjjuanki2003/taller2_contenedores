package uce.edu.ec.negocio;

public class Cliente {

    private String nombre;
    private TipoCliente tipoCliente;

    public Cliente(String nombre, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
