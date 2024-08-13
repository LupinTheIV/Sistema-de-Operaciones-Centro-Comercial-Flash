
package modelo;


public class Aseo extends Empleado{

    public Aseo(String nombre, int edad, long cedula, String EPS, boolean estancia, String rol) {
        super(nombre, edad, cedula, EPS, estancia, rol);
        salario = 2500;
    }

    @Override
    public boolean registrarEndtradaSalida() {
        return !estancia;
    }

    @Override
    public String toString() {
        return super.toString() + ']';
    }
    
    
}
