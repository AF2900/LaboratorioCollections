package co.edu.uniquindio.poo.Escenario3;

import java.util.LinkedHashMap;

public class SistemaTaxis {

    private LinkedHashMap<Integer, SolicitudViaje> solicitudes;

    public SistemaTaxis() {
        solicitudes = new LinkedHashMap<>();
    }

    public void registrarSolicitud(SolicitudViaje solicitud) {
        solicitudes.put(solicitud.getId(), solicitud);
    }

    public void mostrarSolicitudes() {

        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }

        System.out.println("\nSolicitudes pendientes:");

        for (SolicitudViaje solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }

    public void cancelarSolicitud(int id) {

        SolicitudViaje eliminada = solicitudes.remove(id);

        if (eliminada != null) {
            System.out.println("\nSolicitud " + id + " cancelada.");
        } else {
            System.out.println("\nLa solicitud no existe.");
        }
    }

    public void atenderSolicitud() {

        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }

        Integer primerId = solicitudes.keySet().iterator().next();

        SolicitudViaje atendida = solicitudes.remove(primerId);

        System.out.println("\nSolicitud atendida:");
        System.out.println(atendida);
    }

    public int cantidadSolicitudes() {
        return solicitudes.size();
    }
}