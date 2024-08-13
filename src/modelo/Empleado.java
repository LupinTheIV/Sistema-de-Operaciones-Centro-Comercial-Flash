
package modelo;


public abstract class Empleado implements Nomina{
    private String nombre;
    private int edad;
    private long cedula;
    private String EPS;
    protected boolean estancia;
    private String rol;
    protected int salario;

    public Empleado(String nombre, int edad, long cedula, String EPS, boolean estancia, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.EPS = EPS;
        this.estancia = estancia;
        this.rol = rol;        
    }
    
    public abstract boolean registrarEndtradaSalida();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public boolean getEstancia() {
        return estancia;
    }

    public void setEstancia(boolean estancia) {
        this.estancia = estancia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    @Override
    public int calcularSalario(int horas, int salario) {
        // ------------------ ARREGLAR ------------------
        return horas*salario;
    }

    @Override
    public String toString() {        
        String turno = "";
        if (estancia) {
            turno = "Presente";
        }
        else{
            turno = "Ausente";
        }
        return "Empleado[" + "nombre: " + nombre + ", edad: " + edad + ", cedula: " + cedula + ", EPS: " + EPS + ", estancia: " + turno + ", rol: " + rol + ", salario por hora: $" + salario;
    }
    
}
