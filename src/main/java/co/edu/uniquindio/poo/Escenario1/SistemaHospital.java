package co.edu.uniquindio.poo.Escenario1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaHospital {

    public static void main(String[] args) {
        SistemaHospital hospital = new SistemaHospital();

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        System.out.println("==================================================");
        System.out.println(" ¡BIENVENIDO AL SISTEMA DE URGENCIAS DEL HOSPITAL! ");
        System.out.println("==================================================");

        while (opcion != 5) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Registrar paciente nuevo");
            System.out.println("2. Buscar paciente por documento");
            System.out.println("3. Ver lista en orden de llegada");
            System.out.println("4. Pruebas con muchos datos");
            System.out.println("5. Salir del programa");
            System.out.print("Escribe el número de la opción que deseas: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\n Digita el documento/cédula del paciente: ");
                    String doc = teclado.nextLine();
                    System.out.print(" Digita el nombre completo del paciente: ");
                    String nombre = teclado.nextLine();

                    if (hospital.registrarPaciente(doc, nombre)) {
                        System.out.println("Paciente registrado exitosamente.");
                    } else {
                        System.out.println("Error: Paciente con documento " + doc + " ya está registrado.");
                    }
                    break;

                case 2:
                    System.out.print("\n Digita el documento a buscar: ");
                    String docBuscar = teclado.nextLine();

                    Paciente buscado = hospital.buscarPaciente(docBuscar);
                    if (buscado != null) {
                        System.out.println("Paciente encontrado: " + buscado);
                    } else {
                        System.out.println("No se encontró ningún paciente con el documento: " + docBuscar);
                    }
                    break;

                case 3:
                    hospital.mostrarOrdenLlegada();
                    break;

                case 4:
                    System.out.print("\n Escribe cuántos pacientes deseas simular (ej: 100, 1000, 10000, 100000): ");
                    int cantidad = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("\n Insertando " + cantidad + " pacientes...");
                    long inicioInsercion = System.currentTimeMillis();

                    for (int i = 1; i <= cantidad; i++) {
                        hospital.registrarPaciente("DOC_" + i, "Paciente Numero " + i);
                    }

                    long finInsercion = System.currentTimeMillis();
                    System.out.println("¡Éxito! " + cantidad + " pacientes guardados en "
                            + (finInsercion - inicioInsercion) + " ms");

                    System.out.println("Probando velocidad de búsqueda del último paciente (DOC_" + cantidad + ")...");
                    long inicioBusqueda = System.nanoTime();

                    hospital.buscarPaciente("DOC_" + cantidad);

                    long finBusqueda = System.nanoTime();
                    System.out.println("Tiempo exacto de búsqueda: " + (finBusqueda - inicioBusqueda)
                            + " nanosegundos (⚡ Instantáneo)");
                    break;

                case 5:
                    System.out.println("\n Saliendo del sistema... ¡Que tengas un excelente día!");
                    break;

                default:
                    System.out.println(" Opción no válida. Por favor digita un número del 1 al 5.");
            }
        }

        teclado.close();
    }

    private Map<String, Paciente> RegistroPacientes;

    public SistemaHospital() {
        this.RegistroPacientes = new LinkedHashMap<>();
    }

    public boolean registrarPaciente(String documento, String nombre) {
        if (RegistroPacientes.containsKey(documento)) {
            return false;
        }

        Paciente nuevoPaciente = new Paciente(documento, nombre);
        RegistroPacientes.put(documento, nuevoPaciente);
        return true;
    }

    public Paciente buscarPaciente(String documento) {
        return RegistroPacientes.get(documento);
    }

    public void mostrarOrdenLlegada() {
        if (RegistroPacientes.isEmpty()) {
            System.out.println("La lista de espera está vacía.");
        } else {
            System.out.println("Pacientes en orden de llegada:");
            for (Paciente paciente : RegistroPacientes.values()) {
                System.out.println(paciente);
            }
        }
    }

}