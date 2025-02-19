package DateDifference;
import java.time.*;
import java.util.*;

public class DateDifference {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
        
            LocalDate date1 = solicitarFecha(scanner, "primera");
            LocalDate date2 = solicitarFecha(scanner, "segunda");
            
            if (date1.isAfter(date2)) {
                /**
                 * A temporary LocalDate variable used to store the value of date1.
                 */
                LocalDate temp = date1;
                date1 = date2;
                date2 = temp;
            }
            
            Period diferencia = Period.between(date1, date2);
            
            System.out.println("Han pasado " + diferencia.getYears() + " años, " + diferencia.getMonths() + " meses y " + diferencia.getDays() + " días.");
            
            scanner.close();
            System.out.println("________________________________________________________");
        }
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
