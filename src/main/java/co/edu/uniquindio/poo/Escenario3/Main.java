package co.edu.uniquindio.poo.Escenario3;

public class Main {

    public static void main(String[] args) {

        SistemaTaxis sistema = new SistemaTaxis();

        sistema.registrarSolicitud(
                new SolicitudViaje(
                        1,
                        "Federico",
                        "Universidad",
                        "Centro"
                )
        );

        sistema.registrarSolicitud(
                new SolicitudViaje(
                        2,
                        "Johan",
                        "Terminal",
                        "Universidad"
                )
        );

        sistema.registrarSolicitud(
                new SolicitudViaje(
                        3,
                        "Adrian",
                        "Centro",
                        "Aeropuerto"
                )
        );

        sistema.mostrarSolicitudes();

        sistema.atenderSolicitud();

        sistema.mostrarSolicitudes();

        sistema.cancelarSolicitud(3);

        sistema.mostrarSolicitudes();
    }
}