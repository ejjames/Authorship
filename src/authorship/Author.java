/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorship;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lindz
 */
public class Author{
    private String name;
    List<Book> books;
    private ArrayList<String> titleNew = new ArrayList<>();

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
        books = new ArrayList<>();

    }

    public Author() {
        books = new ArrayList<>();
    }
    
    public void setTitle(String newTitle) {
        titleNew.add(newTitle);
    }

    public ArrayList<String> getTitle() {
        return titleNew;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }
   
    
}
