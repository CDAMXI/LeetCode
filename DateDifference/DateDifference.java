package DateDifference;
import java.time.*;
import java.util.*;

public class DateDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        LocalDate fecha1 = solicitarFecha(scanner, "primera");
        LocalDate fecha2 = solicitarFecha(scanner, "segunda");
        
        if (fecha1.isAfter(fecha2)) {
            LocalDate temp = fecha1;
            fecha1 = fecha2;
            fecha2 = temp;
        }
        
        Period diferencia = Period.between(fecha1, fecha2);
        
        System.out.println("Han pasado " + diferencia.getYears() + " años, " + diferencia.getMonths() + " meses y " + diferencia.getDays() + " días.");
        
        scanner.close();
    }

    private static LocalDate solicitarFecha(Scanner scanner, String orden) {
        while (true) {
            try {
                System.out.print("Ingrese la " + orden + " fecha (DD MM YYYY): ");
                int dia = scanner.nextInt();
                int mes = scanner.nextInt();
                int anio = scanner.nextInt();
                return LocalDate.of(anio, mes, dia);
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números válidos.");
                scanner.nextLine(); // Limpiar buffer
            } catch (Exception e) {
                System.out.println("Error: Fecha no válida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
}
