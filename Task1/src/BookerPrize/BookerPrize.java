/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookerPrize;

import Book.Book;
import static File.LoadFromFile.LoadFromFile;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author dima82.91
 */
public class BookerPrize {

    private Integer year;
    private Book winner;
    private List<Book> shortList;
    private List<String> panel;
    private String chairPerson;

    public BookerPrize(Integer year, Book winner, String chairPerson, List<Book> shortList, List<String> panel) {
        this.year = year;
        this.winner = winner;
        this.chairPerson = chairPerson;
        this.shortList = shortList;
        this.panel = panel;
    }

    public Integer getYear() {
        return year;
    }

    public Book getWinner() {
        return winner;
    }

    public List<Book> getShortList() {
        return shortList;
    }

    public List<String> getPanel() {
        return panel;
    }

    ;
    public String getChairPerson() {
        return chairPerson;
    }

    public static void listBookerPrize(LinkedHashMap<String, BookerPrize> bookerPrizeHashMap) {
        bookerPrizeHashMap.forEach((key, BookerPrize) -> {
            System.out.format("%-10d%-40s%-30s%-30s",
                    BookerPrize.getYear(),
                    BookerPrize.getWinner().getTitle(),
                    BookerPrize.getWinner().getAuthor(),
                    BookerPrize.getWinner().getPublisher());
            System.out.println();
        });
    }

    public static void getBookerPrizeInfoByYear(LinkedHashMap<String, BookerPrize> bookerPrizeHashMap, int yearInsertedByUser) {
        //using linked hashmap to keep the order
        LinkedHashMap<String, BookerPrize> BookerPrizeMap = LoadFromFile();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-30s%-50s%-30s%-30s%-30s\n",
                "|    " + "Author",
                "|    " + "Book title",
                "|    " + "Publisher",
                "|    " + "Panel",
                "|    " + "Chair|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        BookerPrizeMap.forEach((key, BookerPrize) -> {
            if (BookerPrize.getYear() == yearInsertedByUser) {
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                System.out.format("%-30s%-50s%-30s%-10s\n",
                        "|    " + BookerPrize.getWinner().getAuthor(),
                        "|    " + BookerPrize.getWinner().getTitle(),
                        "|    " + BookerPrize.getWinner().getPublisher(),
                        "|");
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                int panelIndex = 0;
                for (Book book : BookerPrize.getShortList()) {
                    System.out.format("%-30s%-50s%-30s",
                            "|    " + book.getAuthor(),
                            "|    " + book.getTitle(),
                            "|    " + book.getPublisher());
                    if (panelIndex <= 3) {
                        System.out.format("%-30s", "|    " + BookerPrize.getPanel().get(panelIndex));
                    }
                    //formating the output in table to dispplay chair person
                    System.out.print("|");
                    if (panelIndex == 1) {
                        System.out.print(BookerPrize.getChairPerson());
                    }
                    System.out.println();
                    panelIndex++;
                };
            }
        });
    }

    public static void searchBookerPrize(LinkedHashMap<String, BookerPrize> bookerPrizeHashMap, String searchString) {
        //iterate hashmap
        bookerPrizeHashMap.forEach((key, BookerPrize) -> {
            if (BookerPrize.getWinner().getTitle().toLowerCase().contains(searchString.toLowerCase())) {
                System.out.print(BookerPrize.getWinner().toString());
                System.out.println(BookerPrize.getYear());
            }
            //iterate booker prize shortlist
            BookerPrize.getShortList().forEach((book) -> {

                if (book.getTitle().toLowerCase().contains(searchString.toLowerCase())) {
                    System.out.print(book.toString());
                    System.out.println(BookerPrize.getYear());
                }
            });
        });
    }
}
