package co.edu.uniquindio.poo.Escenario2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        PlataformaVentas.limpiarEstructuras();
        agregar(new Producto("PROD-1", "Portatil", 2500.0, "Tecnologia"));
        agregar(new Producto("PROD-2", "Sofa", 1800.0, "Hogar"));
        agregar(new Producto("PROD-3", "Camiseta", 45.5, "Ropa"));
        agregar(new Producto("PROD-4", "Arroz", 12.0, "Alimentos"));
        agregar(new Producto("PROD-5", "Celular", 900.0, "Tecnologia"));
        agregar(new Producto("PROD-6", "Mouse", 45.5, "Tecnologia"));

        System.out.println("===== Lista de productos (el mas reciente primero) =====");
        for (Producto p : PlataformaVentas.listaProductos) {
            System.out.println(p);
        }

        System.out.println("\n===== Buscar por codigo =====");
        Producto encontrado = PlataformaVentas.buscarProductoPorCodigo("PROD-5");
        System.out.println("PROD-5 -> " + encontrado);

        Producto noExiste = PlataformaVentas.buscarProductoPorCodigo("PROD-99");
        System.out.println("PROD-99 -> " + (noExiste == null ? "No existe" : noExiste));

        System.out.println("\n===== Ordenados por precio =====");
        for (Map.Entry<Double, List<Producto>> entrada : PlataformaVentas.productosPorPrecio.entrySet()) {
            for (Producto p : entrada.getValue()) {
                System.out.println(p);
            }
        }

        System.out.println("\n===== Filtrar por categoria: Tecnologia =====");
        for (Producto p : PlataformaVentas.filtrarPorCategoria("Tecnologia")) {
            System.out.println(p);
        }

        System.out.println("\n===== Filtrar por categoria: Juguetes (no existe) =====");
        List<Producto> juguetes = PlataformaVentas.filtrarPorCategoria("Juguetes");
        System.out.println("Productos encontrados: " + juguetes.size());
    }

    private static void agregar(Producto producto) {

        PlataformaVentas.listaProductos.addFirst(producto);

        PlataformaVentas.productosPorCodigo.put(producto.getCodigo(), producto);

        List<Producto> listaPorPrecio = PlataformaVentas.productosPorPrecio.get(producto.getPrecio());
        if (listaPorPrecio == null) {
            listaPorPrecio = new ArrayList<>();
            PlataformaVentas.productosPorPrecio.put(producto.getPrecio(), listaPorPrecio);
        }
        listaPorPrecio.add(producto);

        List<Producto> listaPorCategoria = PlataformaVentas.productosPorCategoria.get(producto.getCategoria());
        if (listaPorCategoria == null) {
            listaPorCategoria = new ArrayList<>();
            PlataformaVentas.productosPorCategoria.put(producto.getCategoria(), listaPorCategoria);
        }
        listaPorCategoria.add(producto);
    }
}