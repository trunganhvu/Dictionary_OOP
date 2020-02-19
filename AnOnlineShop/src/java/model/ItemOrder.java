/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vutrunganh
 */
public class ItemOrder {
    private Book book;
    private int number;
    public ItemOrder(Book b){
        setBook(b);
        setNumber(1);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getItemID(){
        return Integer.toString(getBook().getId());
    }
    public String getCategory(){
        return getBook().getCategory();
    }
    
    public String getName(){
        return getBook().getName();
    }
    
    public String getDescription(){
        return getBook().getDescription();
    }
    
    public String getContent(){
        return getBook().getContent();
    }
    
    public void incrementNumItems(){
        setNumber(getNumber()+1);
    }
    
    public void cancelOrder(){
        setNumber(0);
    }
}
