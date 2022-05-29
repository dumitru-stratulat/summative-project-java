/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;
/**
 *
 * @author dima82.91
 */
public class Book  {
    private final String title;
    private final String author;
    private final String publisher;
    
    public Book(String title,String author,String publisher){
        
        this.title = title;
        this.author = author;
        this.publisher = publisher;
       
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    @Override
    public String toString(){
        String bookInfo = title + " |" + author + " |" + " ";
        return bookInfo;
    };
}
