
package modelo;


public class Vendedor extends Empleado{
    private String localPerteneciente;

    public Vendedor(String localPerteneciente, String nombre, int edad, long cedula, String EPS, boolean estancia, String rol) {
        super(nombre, edad, cedula, EPS, estancia, rol);
        this.localPerteneciente = localPerteneciente;
        salario = 4000;
    }

    public String getLocalPerteneciente() {
        return localPerteneciente;
    }

    public void setLocalPerteneciente(String localPerteneciente) {
        this.localPerteneciente = localPerteneciente;
    }

    @Override
    public boolean registrarEndtradaSalida() {
        return !estancia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Local Perteneciente: " + localPerteneciente + ']';
    }
    
    
}
