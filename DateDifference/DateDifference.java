package DateDifference;
import java.time.*;
import java.util.*;

public class DateDifference {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
        
            LocalDate date1 = askDate(scanner, "first");
            LocalDate date2 = askDate(scanner, "second");
            
            if (date1.isAfter(date2)) {
                /**
                 * A temporary LocalDate variable used to store the value of date1.
                 */
                LocalDate temp = date1;
                date1 = date2;
                date2 = temp;
            }
            
            Period difference = Period.between(date1, date2);
            
            System.out.println("Han pasado " + difference.getYears() + " años, " + difference.getMonths() + " meses y " + difference.getDays() + " días.");
            
            scanner.close();
            System.out.println("________________________________________________________");
        }
    }

    private static LocalDate askDate(Scanner scanner, String orden) {
        while (true) {
            try {
                System.out.print("Put " + orden + " date (DD MM YYYY): ");
                int dia = scanner.nextInt();
                int mes = scanner.nextInt();
                int anio = scanner.nextInt();
                return LocalDate.of(anio, mes, dia);
            } catch (InputMismatchException e) {
                System.out.println("Error: Put only valid numbers.");
                scanner.nextLine(); // Limpiar buffer
            } catch (Exception e) {
                System.out.println("Error: Date is not valid. Try again.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
}
