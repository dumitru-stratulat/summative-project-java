/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Book.Book;
import BookerPrize.BookerPrize;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dima82.91
 */
public class LoadFromFile {

    static public LinkedHashMap<String, BookerPrize> map = new LinkedHashMap<>();

    public static LinkedHashMap<String, BookerPrize> LoadFromFile() {

        String winningNominee;
        String chair = null;
        String dataFile = System.getProperty("user.dir") + File.separator + "booker-data.txt";
        try {
            File wordFile = new File(dataFile);//relative link
            Scanner myReader = new Scanner(wordFile);
            while (myReader.hasNextLine()) {
                List<Book> temporaryList = new ArrayList<>();
                List<String> panelList = new ArrayList<>();
                winningNominee = myReader.nextLine();
                //add books in array
                String[] winningNomineeInfoArray = winningNominee.split("[;,:,()]");
                if (myReader.hasNextLine()) {
                    String booksLine = myReader.nextLine();
                    String booksArray[] = booksLine.split("[|]");
                    //finding words that are splited by , () ] characters
                    for (String bookInfoLine : booksArray) {
                        String bookInfoArray[] = bookInfoLine.split("[,,()]");
                        temporaryList.add(new Book(bookInfoArray[1], bookInfoArray[0], bookInfoArray[2]));
                    }
                }
                if (myReader.hasNextLine()) {
                    String panelLine = myReader.nextLine();
                    //add panels in array
                    String panelArray[] = panelLine.split("[,]");
                    for (String panel : panelArray) {
                        if (panel.contains("(chair)")) {
                            String[] chairArray = panel.split("[(]");

                            chair = chairArray[0];
                        } else {
                            panelList.add(panel);
                        }
                    }
                }
                //saving info in objects
                Book winnerBook = new Book(winningNomineeInfoArray[2], winningNomineeInfoArray[1], winningNomineeInfoArray[3]);

                BookerPrize bookerPrize = new BookerPrize(Integer.valueOf(winningNomineeInfoArray[0]), winnerBook, chair, temporaryList, panelList);
                map.put(bookerPrize.getYear().toString(), bookerPrize);
            }
            myReader.close();
        } catch (java.io.IOException e) {
            System.out.println("error" + e);
        }
        return map;
    }
}
