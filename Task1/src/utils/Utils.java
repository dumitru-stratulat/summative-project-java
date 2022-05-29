
package Utils;
import java.util.Scanner;

/**
 *
 * @author dima82.91
 */
public class Utils {

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
}
