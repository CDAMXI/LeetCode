package DateDifference;
import java.time.*;
import java.util.*;

public class DateDifference1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            LocalDate date1 = askDate(scanner, "first");
            LocalDate date2 = askDate(scanner, "second");

            if (date1.isAfter(date2)) {
                LocalDate temp = date1;
                date1 = date2;
                date2 = temp;
            }

            Period difference = Period.between(date1, date2);
            StringBuilder result = new StringBuilder("Elapsed time: ");
            boolean hasDifference = false;

            if (difference.getYears() != 0) {
                result.append(difference.getYears()).append(difference.getYears() == 1 ? " year" : " years");
                hasDifference = true;
            }
            if (difference.getMonths() != 0) {
                if (hasDifference) result.append(", ");
                result.append(difference.getMonths()).append(difference.getMonths() == 1 ? " month" : " months");
                hasDifference = true;
            }
            if (difference.getDays() != 0) {
                if (hasDifference) result.append(", ");
                result.append(difference.getDays()).append(difference.getDays() == 1 ? " day" : " days");
                hasDifference = true;
            }

            if (!hasDifference) {
                result.append("No difference. Both dates are the same.");
            }

            System.out.println(result);
            System.out.println("________________________________________________________");
        }
    }

    private static LocalDate askDate(Scanner scanner, String order) {
        while (true) {
            try {
                System.out.print("Enter the " + order + " date (DD MM YYYY): ");
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                return LocalDate.of(year, month, day);
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid numbers.");
                scanner.nextLine(); // Clear the buffer
            } catch (DateTimeException e) {
                System.out.println("Error: Invalid date. Please try again.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}
