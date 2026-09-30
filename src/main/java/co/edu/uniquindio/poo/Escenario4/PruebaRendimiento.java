package co.edu.uniquindio.poo.Escenario4;

public class PruebaRendimiento {

    public static void main(String[] args) {

        probar(100);
        probar(1000);
        probar(10000);
        probar(100000);
    }

    public static void probar(int cantidad) {

        CatalogoProductos catalogo = new CatalogoProductos();

        Runtime runtime = Runtime.getRuntime();

        long memoriaInicial =
                runtime.totalMemory() - runtime.freeMemory();

        long inicioInsercion = System.nanoTime();

        for (int i = 1; i <= cantidad; i++) {

            Producto producto = new Producto(
                    i,
                    "Producto " + i,
                    1000 + i,
                    "Categoria"
            );

            catalogo.agregarProducto(producto);
        }

        long finInsercion = System.nanoTime();

        long inicioBusqueda = System.nanoTime();

        Producto encontrado =
                catalogo.buscarPorCodigo(cantidad / 2);

        long finBusqueda = System.nanoTime();

        long memoriaFinal =
                runtime.totalMemory() - runtime.freeMemory();

        double tiempoInsercion =
                (finInsercion - inicioInsercion)
                        / 1_000_000.0;

        double tiempoBusqueda =
                (finBusqueda - inicioBusqueda)
                        / 1_000_000.0;

        double memoriaMB =
                (memoriaFinal - memoriaInicial)
                        / (1024.0 * 1024.0);

        System.out.println("\n--------------------");

        System.out.println(
                "Cantidad de productos: " + cantidad
        );

        System.out.println(
                "Tiempo de insercion: "
                        + tiempoInsercion + " ms"
        );

        System.out.println(
                "Tiempo de busqueda: "
                        + tiempoBusqueda + " ms"
        );

        System.out.println(
                "Memoria aproximada: "
                        + memoriaMB + " MB"
        );

        if (encontrado != null) {
            System.out.println(
                    "Producto encontrado correctamente."
            );
        }
    }
}