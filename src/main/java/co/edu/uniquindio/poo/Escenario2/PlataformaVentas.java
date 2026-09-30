package co.edu.uniquindio.poo.Escenario2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlataformaVentas {

    // HashMap para buscar productos por codigo
    static HashMap<String, Producto> productosPorCodigo = new HashMap<>();

    // LinkedList porque los productos nuevos se insertan al inicio
    static LinkedList<Producto> listaProductos = new LinkedList<>();

    // TreeMap para mantener los productos ordenados por precio
    static TreeMap<Double, List<Producto>> productosPorPrecio = new TreeMap<>();

    // HashMap para agrupar los productos por categoria
    static HashMap<String, List<Producto>> productosPorCategoria = new HashMap<>();

    public static void main(String[] args) {

        int[] tamanos = {100, 1000, 10000, 100000};

        for (int i = 0; i < tamanos.length; i++) {
            int tamano = tamanos[i];
            limpiarEstructuras();

            System.out.println("----- Probando con " + tamano + " productos -----");

            long inicioInsercion = System.nanoTime();
            insertarProductos(tamano);
            long finInsercion = System.nanoTime();
            System.out.println("Tiempo de insercion: " + (finInsercion - inicioInsercion) / 1000000.0 + " ms");

            long inicioBusqueda = System.nanoTime();
            Producto encontrado = buscarProductoPorCodigo("PROD-1");
            long finBusqueda = System.nanoTime();
            System.out.println("Tiempo de busqueda: " + (finBusqueda - inicioBusqueda) / 1000000.0 + " ms");

            long inicioOrden = System.nanoTime();
            mostrarPrimerosPorPrecio(5);
            long finOrden = System.nanoTime();
            System.out.println("Tiempo en mostrar ordenado por precio: " + (finOrden - inicioOrden) / 1000000.0 + " ms");

            long inicioFiltro = System.nanoTime();
            filtrarPorCategoria("Tecnologia");
            long finFiltro = System.nanoTime();
            System.out.println("Tiempo en filtrar por categoria: " + (finFiltro - inicioFiltro) / 1000000.0 + " ms");

            mostrarMemoriaAproximada();
            System.out.println();
        }
    }

    // Insertar productos nuevos al inicio de la lista
    public static void insertarProductos(int cantidad) {
        String[] categorias = {"Tecnologia", "Hogar", "Ropa", "Alimentos"};

        for (int i = 0; i < cantidad; i++) {
            String codigo = "PROD-" + i;
            double precio = Math.random() * 1000;
            String categoria = categorias[i % categorias.length];

            Producto producto = new Producto(codigo, "Producto " + i, precio, categoria);

            // Insertar al inicio de la lista enlazada
            listaProductos.addFirst(producto);

            // Guardar en el HashMap para busqueda rapida por codigo
            productosPorCodigo.put(codigo, producto);

            // Guardar en el TreeMap para que quede ordenado por precio
            List<Producto> listaPorPrecio = productosPorPrecio.get(precio);
            if (listaPorPrecio == null) {
                listaPorPrecio = new ArrayList<>();
                productosPorPrecio.put(precio, listaPorPrecio);
            }
            listaPorPrecio.add(producto);

            // Guardar en el HashMap agrupado por categoria
            List<Producto> listaPorCategoria = productosPorCategoria.get(categoria);
            if (listaPorCategoria == null) {
                listaPorCategoria = new ArrayList<>();
                productosPorCategoria.put(categoria, listaPorCategoria);
            }
            listaPorCategoria.add(producto);
        }
    }

    // Buscar un producto por su codigo
    public static Producto buscarProductoPorCodigo(String codigo) {
        return productosPorCodigo.get(codigo);
    }

    // Mostrar los primeros N productos ordenados por precio (de menor a mayor)
    public static void mostrarPrimerosPorPrecio(int cantidad) {
        int contador = 0;
        for (Map.Entry<Double, List<Producto>> entrada : productosPorPrecio.entrySet()) {
            List<Producto> productos = entrada.getValue();
            for (int i = 0; i < productos.size(); i++) {
                if (contador >= cantidad) {
                    return;
                }
                contador++;
            }
        }
    }

    // Filtrar productos por categoria
    public static List<Producto> filtrarPorCategoria(String categoria) {
        List<Producto> resultado = productosPorCategoria.get(categoria);
        if (resultado == null) {
            resultado = new ArrayList<>();
        }
        return resultado;
    }

    // Medir de forma aproximada la memoria usada despues de cada prueba
    public static void mostrarMemoriaAproximada() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria aproximada usada: " + (memoriaUsada / 1024 / 1024) + " MB");
    }

    // Limpiar todas las estructuras antes de cada prueba con un tamano distinto
    public static void limpiarEstructuras() {
        productosPorCodigo.clear();
        listaProductos.clear();
        productosPorPrecio.clear();
        productosPorCategoria.clear();
    }
}