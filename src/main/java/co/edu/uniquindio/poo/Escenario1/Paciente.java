package co.edu.uniquindio.poo.Escenario1;

public class Paciente {
    private String documento;
    private String nombre;

    public Paciente(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Paciente{" + "Documento='" + documento + '\'' + ", Nombre='" + nombre + '\'' + '}';
    }
}