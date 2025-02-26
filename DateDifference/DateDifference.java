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
            
            System.out.println("It has been " + difference.getYears() + " years, " + difference.getMonths() + " months, and " + difference.getDays() + " days.");
            
            scanner.close();
            System.out.println("________________________________________________________");
        }
    }

    private static LocalDate askDate(Scanner scanner, String order) {
        while (true) {
            try {
                System.out.print("Enter " + order + " date (DD MM YYYY): ");
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                return LocalDate.of(year, month, day);
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter only valid numbers.");
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Error: The date is not valid. Try again.");
                scanner.nextLine(); // Clear buffer
            }
        }
    }
}
