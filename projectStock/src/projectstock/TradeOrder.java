/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstock;

/**
 *
 * @author vutrunganh
 */
public class TradeOrder implements Comparable<TradeOrder>{
    private String type;
    private Trader trade;
    private Integer quantity;
    private Double price;
    private String name;
    private String name2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
    
    public Trader getTrade() {
        return trade;
    }

    public void setTrade(Trader trade) {
        this.trade = trade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TradeOrder(String type, Trader trade, Integer quantity, Double price, String name) {
        this.type = type;
        this.trade = trade;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public TradeOrder(String type, Integer quantity, Double price, String name) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public TradeOrder(Trader trade, Integer quantity, Double price, String name, String name2) {
        this.trade = trade;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.name2 = name2;
    }

    @Override
    public int compareTo(TradeOrder o) {
        return this.price.compareTo(o.getPrice());
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return "[Type: " + this.type + ", trade: " + this.trade + " , price: " 
                + this.price + " ,quantity: " + this.quantity + " ,name: " + this.name +"]\n";
    }
    
}
