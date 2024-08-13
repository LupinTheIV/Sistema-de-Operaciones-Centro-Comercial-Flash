package modelo;

public class Local {
    private int id;
    private String nombre;
    private String producto;

    public Local(int id, String nombre, String producto) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Local "+ id + " [nombre: " + nombre + ", producto: " + producto + ']';
    }
    
    
    
}