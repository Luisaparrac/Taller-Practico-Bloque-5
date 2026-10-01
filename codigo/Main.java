import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1085123456", "Laura Gomez", "laura.gomez@universidad.edu.co",
                "2023115001", "Ingenieria de Sistemas");
        Ejemplar ejemplar = new Ejemplar("EJ-001");
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 7));

        System.out.println("--- Prueba 1: renovacion valida ---");
        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su prestamo fue renovado.");
        System.out.println("Nueva fecha prevista: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());

        System.out.println();
        System.out.println("--- Prueba 2: renovacion invalida ---");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazada: " + e.getMessage());
        }
        System.out.println("Fecha prevista sin cambios: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());
    }
}
