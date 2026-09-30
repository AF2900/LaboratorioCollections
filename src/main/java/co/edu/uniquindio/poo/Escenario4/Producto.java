package co.edu.uniquindio.poo.Escenario4;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(int codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Categoria: " + categoria;
    }
}
