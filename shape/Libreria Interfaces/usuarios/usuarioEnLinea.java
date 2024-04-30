package usuarios;
public class usuarioEnLinea {
    
    private static usuarioEnLinea instancia;
    private Usuario usuarioActual;

    private usuarioEnLinea() {
    }

    public static usuarioEnLinea obtenerInstancia() {
        if(instancia == null) {
            instancia = new usuarioEnLinea();
        }

        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }

    public void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }
}
