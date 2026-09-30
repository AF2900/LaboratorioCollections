package co.edu.uniquindio.poo.Escenario3;

public class PruebaRendimiento {

    public static void main(String[] args) {

        probar(100);
        probar(1000);
        probar(10000);
        probar(100000);
    }

    public static void probar(int cantidad) {

        SistemaTaxis sistema = new SistemaTaxis();

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoriaAntes =
                runtime.totalMemory() - runtime.freeMemory();

        long tiempoInicio = System.nanoTime();

        for (int i = 1; i <= cantidad; i++) {

            SolicitudViaje solicitud = new SolicitudViaje(
                    i,
                    "Usuario " + i,
                    "Origen " + i,
                    "Destino " + i
            );

            sistema.registrarSolicitud(solicitud);
        }

        long tiempoFin = System.nanoTime();

        long memoriaDespues =
                runtime.totalMemory() - runtime.freeMemory();

        double tiempoMs =
                (tiempoFin - tiempoInicio) / 1_000_000.0;

        double memoriaMB =
                (memoriaDespues - memoriaAntes)
                        / (1024.0 * 1024.0);

        System.out.println("--------------------");
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Tiempo: " + tiempoMs + " ms");
        System.out.println("Memoria aproximada: "
                + memoriaMB + " MB");
    }
}