
package modelo;


public class Administracion extends Empleado{
    private String area;

    public Administracion(String area, String nombre, int edad, long cedula, String EPS, boolean estancia, String rol) {
        super(nombre, edad, cedula, EPS, estancia, rol);
        this.area = area;
        salario = 5000;
    }
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean registrarEndtradaSalida() {
        return !estancia;
    }

    @Override
    public String toString() {
        return super.toString() + ", area: " + area + ']';
    }

    
    
    
}
