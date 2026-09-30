package co.edu.uniquindio.poo.Escenario3;

public class SolicitudViaje {

    private int id;
    private String usuario;
    private String origen;
    private String destino;

    public SolicitudViaje(int id, String usuario, String origen, String destino) {
        this.id = id;
        this.usuario = usuario;
        this.origen = origen;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Solicitud " + id +
                " | Usuario: " + usuario +
                " | Origen: " + origen +
                " | Destino: " + destino;
    }
}