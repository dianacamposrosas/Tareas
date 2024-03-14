package tarea7.u2;
public class cuentaBanco {
    
    private long numCuenta;
    private char tipo;
    private double cantidad;
    
    public cuentaBanco(long numCuenta, char tipo) {
        this.numCuenta= numCuenta;
        this.tipo = Character.toUpperCase(tipo);
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    

}
