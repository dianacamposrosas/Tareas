package libreria.Usuarios;
import utils.Rol;
import java.time.LocalDate;
import libreria.Usuario;

public class Cliente extends Usuario {
    private String fechaUnion;
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono, Rol.CLIENTE);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }
    @Override
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }
//    @Override //Indica que se está sobre escribiendo un método, por eso sale
                //el simbolito de crculitos azules..
}
