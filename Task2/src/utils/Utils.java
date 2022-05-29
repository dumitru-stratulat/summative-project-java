package utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author dima82.91
 */
public class Utils {

    public static LocalDateTime dateTimeHandler() {
        int monthNr = LocalDateTime.now().getMonthValue();
        System.out.println("Insert date and time available to make booking ");
        System.out.println("Insert date up to one week; 0 - 31");
        Scanner scanner = new Scanner(System.in);
        //if user not entered int
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter nr between 0 - 31");
            scanner.next();
        }
        int dateNrInsertedByUser = scanner.nextInt();
        //handler if user entered nr outside of 0 - 31 range
        while (dateNrInsertedByUser < 0 || dateNrInsertedByUser > 31) {
            System.out.println("Please enter nr between 0 - 31");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter nr between 0 - 31");
                scanner.next();
            }
            dateNrInsertedByUser = scanner.nextInt();
        }
        //handle if input is not integer
        System.out.println("Insert time that is hour between 9 - 18!");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter nr between 9 - 18");
            scanner.next();
        }
        int hourNrInsertedByUser = scanner.nextInt();
        //handle if user inserted hour outside 9 - 18 range
        while (hourNrInsertedByUser < 9 || hourNrInsertedByUser > 18) {
            System.out.println("Please enter nr between 9 - 18");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter nr between 9 - 18");
                scanner.next();
            }
            hourNrInsertedByUser = scanner.nextInt();
        }
        //checking if next inserted day of the month is not in the past
        if (LocalDateTime.now().withDayOfMonth(dateNrInsertedByUser).isBefore(LocalDateTime.now())) {
            monthNr += 1;
        }
        //save insrted time by user in variable
        LocalDateTime dateAndTimeIsertedByUser = LocalDateTime.now()
                .truncatedTo(ChronoUnit.HOURS)
                .withDayOfMonth(dateNrInsertedByUser)
                .withHour(hourNrInsertedByUser)
                .withMonth(monthNr);
        return dateAndTimeIsertedByUser;
    }

    public static int menuInputValidator() {
        Scanner scanner = new Scanner(System.in);
        boolean validated = false;

        int menuChoice = -1;

        while (!validated) {
            System.out.println("Please enter a number ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number");
                scanner.next();
            }
            menuChoice = scanner.nextInt();
            validated = true;
        }
        return menuChoice;
    }

    public static String localDateTimeFormatter(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,
                FormatStyle.SHORT);
        String dateTimeFormatted = dateTimeFormatter.format(localDateTime);
        return dateTimeFormatted;
    }

}
