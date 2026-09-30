package co.edu.uniquindio.poo.Escenario4;

public class Main {

    public static void main(String[] args) {

        CatalogoProductos catalogo = new CatalogoProductos();

        Producto producto1 = new Producto(
                101,
                "Mouse",
                50000,
                "Tecnologia"
        );

        Producto producto2 = new Producto(
                102,
                "Teclado",
                85000,
                "Tecnologia"
        );

        Producto producto3 = new Producto(
                104,
                "Audifonos",
                120000,
                "Tecnologia"
        );

        Producto producto4 = new Producto(
                103,
                "Monitor",
                650000,
                "Tecnologia"
        );

        catalogo.agregarProducto(producto1);
        catalogo.agregarProducto(producto2);
        catalogo.agregarProducto(producto3);
        catalogo.agregarProducto(producto4);

        System.out.println("Busqueda por codigo:");

        Producto encontrado = catalogo.buscarPorCodigo(103);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }

        catalogo.mostrarOrdenadosPorPrecio();
    }
}