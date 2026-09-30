package co.edu.uniquindio.poo.Escenario4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class CatalogoProductos {

    private HashMap<Integer, Producto> productosPorCodigo;

    private TreeMap<Double, List<Producto>> productosPorPrecio;

    public CatalogoProductos() {

        productosPorCodigo = new HashMap<>();
        productosPorPrecio = new TreeMap<>();
    }

    public void agregarProducto(Producto producto) {

        if (productosPorCodigo.containsKey(producto.getCodigo())) {
            System.out.println("Ya existe un producto con ese codigo.");
            return;
        }

        productosPorCodigo.put(
                producto.getCodigo(),
                producto
        );

        productosPorPrecio
                .computeIfAbsent(
                        producto.getPrecio(),
                        precio -> new ArrayList<>()
                )
                .add(producto);
    }

    public Producto buscarPorCodigo(int codigo) {

        return productosPorCodigo.get(codigo);
    }

    public void mostrarOrdenadosPorPrecio() {

        System.out.println("\nProductos ordenados por precio:");

        for (List<Producto> lista : productosPorPrecio.values()) {

            for (Producto producto : lista) {
                System.out.println(producto);
            }
        }
    }

    public int cantidadProductos() {

        return productosPorCodigo.size();
    }
}