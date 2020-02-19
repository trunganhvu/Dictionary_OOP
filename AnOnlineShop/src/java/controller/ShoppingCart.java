/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.BookDao;
import model.ItemOrder;

/**
 *
 * @author vutrunganh
 */
public class ShoppingCart {

    private ArrayList itemsOrdered;

    public ShoppingCart() {
        itemsOrdered = new ArrayList();
    }

    public List getItemsOrdered() {
        return itemsOrdered;
    }

    public synchronized void addItem(String itemID) {
        ItemOrder order;
        for (int i = 0; i < itemsOrdered.size(); i++){
            order = (ItemOrder) itemsOrdered.get(i);
            if (order.getItemID().equals(itemID)){
                order.incrementNumItems();
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(BookDao.getBookById(Integer.parseInt(itemID)));
        itemsOrdered.add(newOrder);
    }
    
    public synchronized void setNumOrdered(String itemID, int numOrdered){
        ItemOrder order;
        for (int i = 0; i < itemsOrdered.size(); i++){
            order = (ItemOrder) itemsOrdered.get(i);
            if (order.getItemID().equals(itemID)){
                if (numOrdered <= 0){
                    itemsOrdered.remove(i);
                }
                else{
                    order.setNumber(numOrdered);
                }
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(BookDao.getBookById(Integer.parseInt(itemID)));
        itemsOrdered.add(newOrder);
    }

}
