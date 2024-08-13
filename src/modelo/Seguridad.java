
package modelo;


public class Seguridad extends Empleado{
    private String horario;

    public Seguridad(String horario, String nombre, int edad, long cedula, String EPS, boolean estancia, String rol) {
        super(nombre, edad, cedula, EPS, estancia, rol);
        this.horario = horario;
        salario = 3500;
    }

    @Override
    public boolean registrarEndtradaSalida() {
        return !estancia;
    }

    @Override
    public String toString() {
        return super.toString() + ", horario: " + horario + ']';
    }
    
    
}
