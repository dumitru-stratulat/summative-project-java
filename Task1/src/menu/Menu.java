/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import BookerPrize.BookerPrize;
import static File.LoadFromFile.LoadFromFile;
import java.util.LinkedHashMap;
import java.util.Scanner;
import Utils.Utils;

/**
 *
 * @author dima82.91
 */
public class Menu {

    static LinkedHashMap<String, BookerPrize> bookerPrizeHashMap = LoadFromFile();
    static Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        System.out.println("-----------------");
        System.out.println("Booker prize menu");
        System.out.println("-----------------");
        System.out.println("List............1");
        System.out.println("Select..........2");
        System.out.println("Search..........3");
        System.out.println("Exit............0");
        System.out.println("-----------------");

        int userChoice = Utils.menuInputValidator();
        if (userChoice == 1) {
            BookerPrize.listBookerPrize(bookerPrizeHashMap);
            Menu();
        }
        if (userChoice == 2) {
            System.out.println("Insert year>");
            int yearInsertedByUser = Utils.menuInputValidator();
            BookerPrize.getBookerPrizeInfoByYear(bookerPrizeHashMap, yearInsertedByUser);
            Menu();
        }
        if (userChoice == 3) {
            System.out.print("Insert string to search>");
            String searchString = scanner.next();
            BookerPrize.searchBookerPrize(bookerPrizeHashMap, searchString);
            Menu();
        }
    }
}
