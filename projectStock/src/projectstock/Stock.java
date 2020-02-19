/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstock;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author vutrunganh
 */
public class Stock {
    
    private String tradeCode;
    private Double PriceMax, PriceMin;
    private  PriorityQueue<TradeOrder> listStock = new PriorityQueue<>();
    private  PriorityQueue<TradeOrder> buy = new PriorityQueue<>(Collections.reverseOrder());
    private  PriorityQueue<TradeOrder> sell = new PriorityQueue<>();

    public PriorityQueue<TradeOrder> getListStock() {
        return listStock;
    }

    public void setListStock(PriorityQueue<TradeOrder> listStock) {
        this.listStock = listStock;
    }

    public PriorityQueue<TradeOrder> getBuy() {
        return buy;
    }

    public void setBuy(PriorityQueue<TradeOrder> buy) {
        this.buy = buy;
    }
    public void setBuy(String type, String tradeCode, String quantity, String price, String name){
//        buy.add(new TradeOrder(type, new Trader(tradeCode), 10, (double)Double.parseDouble(price), name));
        buy.add(new TradeOrder(type, new Trader(tradeCode),Integer.parseInt(quantity), (double)Double.parseDouble(price), name));
    }
    

    public PriorityQueue<TradeOrder> getSell() {
        return sell;
    }

    public void setSell(PriorityQueue<TradeOrder> sell) {
        this.sell = sell;
    }

    public void setSell(String type, String tradeCode, String quantity, String price, String name){
//        buy.add(new TradeOrder(type, new Trader(tradeCode), 10, (double)Double.parseDouble(price), name));
        sell.add(new TradeOrder(type, new Trader(tradeCode),Integer.parseInt(quantity), (double)Double.parseDouble(price), name));
    }
    public Stock(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    
    
    public static void main(String[] args) {
        Stock s = new Stock("test");
        s.init();
    }

    void init() {
        buy.add(new TradeOrder("buy", new Trader("ma01"), 20, (double) 100, "buy1"));
        buy.add(new TradeOrder("buy", new Trader("ma01"), 60, (double) 300, "buy2"));
        sell.add(new TradeOrder("sell", new Trader("ma01"), 40, (double) 100, "sell1"));
        sell.add(new TradeOrder("sell", new Trader("ma01"), 20, (double) 200, "sell2"));
        sell.add(new TradeOrder("sell", new Trader("ma01"), 10, (double) 300, "sell2"));

        logic1();
        while (!buy.isEmpty()) {
            System.out.print("buy: " + buy.poll().toString());
        }
        System.out.println("=========");
        while (!sell.isEmpty()) {
            System.out.print("sell: " + sell.poll().toString());
        }
        System.out.println("========");
        while (!listStock.isEmpty()) {
            TradeOrder t = listStock.poll();
            System.out.println(t.getName() + " " + t.getName2() + " " +t.getTrade() + " "+t.getPrice() + " "+ t.getQuantity());
        }
    }

    public void print(){
        while (!buy.isEmpty()) {
            System.out.print("buy: " + buy.poll().toString());
        }
        System.out.println("=========");
        while (!sell.isEmpty()) {
            System.out.print("sell: " + sell.poll().toString());
        }
        System.out.println("========");
        while (!listStock.isEmpty()) {
            TradeOrder t = listStock.poll();
            System.out.println(t.getName() + " " + t.getName2() + " " +t.getTrade() + " "+t.getPrice() + " "+ t.getQuantity());
        }
    }
    public void logic() {
        boolean check = true;
        while (!sell.isEmpty() && !buy.isEmpty()) {
            TradeOrder tradeIsBuy = buy.poll();
            Integer soLuong = tradeIsBuy.getQuantity();
            while (!sell.isEmpty()) {
                TradeOrder tradeIsSell = sell.poll();
                if (tradeIsBuy.getPrice() >= tradeIsSell.getPrice()) {
                    if (soLuong >= tradeIsSell.getQuantity()) {
                        soLuong -= tradeIsSell.getQuantity();
                    } else if (soLuong < tradeIsSell.getQuantity() && soLuong >= 0) {
                        Integer soLuongConLai = tradeIsSell.getQuantity() - soLuong;
                        soLuong = 0;
                        sell.add(new TradeOrder(tradeIsSell.getType(), tradeIsSell.getTrade(),
                                soLuongConLai, tradeIsSell.getPrice(), tradeIsSell.getName()));
                        break;
                    } else break;
                } else if (tradeIsBuy.getPrice() < tradeIsSell.getPrice()) {
                    sell.add(tradeIsSell);
                    check = false;
                    break;
                }

            }
            if (soLuong > 0) {
                buy.add(new TradeOrder(tradeIsBuy.getType(), tradeIsBuy.getTrade(),
                        soLuong, tradeIsBuy.getPrice(), tradeIsBuy.getName()));
            }
            if (check == false){
                break;
            }
        }
        
    }
    public void logic1() {
        boolean check = true;
        while (!sell.isEmpty() && !buy.isEmpty()) {
            TradeOrder tradeIsBuy = buy.poll();
            Integer soLuong = tradeIsBuy.getQuantity();
            while (!sell.isEmpty()) {
                TradeOrder tradeIsSell = sell.poll();
                if (tradeIsBuy.getPrice() >= tradeIsSell.getPrice()) {
                    if (soLuong >= tradeIsSell.getQuantity()) {
                        soLuong -= tradeIsSell.getQuantity();
//                        listStock.add(tradeIsSell);
//                        listStock.add(new TradeOrder(tradeIsSell.getType(), tradeIsSell.getTrade(),
//                                tradeIsSell.getQuantity(), tradeIsSell.getPrice(), tradeIsSell.getName()));
                        listStock.add(new TradeOrder(tradeIsSell.getTrade(), tradeIsSell.getQuantity(),
                                    tradeIsSell.getPrice(), tradeIsBuy.getName(), tradeIsSell.getName()));
                    } else if (soLuong < tradeIsSell.getQuantity() && soLuong >= 0) {
                        Integer soLuongConLai = tradeIsSell.getQuantity() - soLuong;
                        if (soLuong != 0){
//                            listStock.add(new TradeOrder(tradeIsBuy.getType(), tradeIsBuy.getTrade(),
//                                soLuong, tradeIsBuy.getPrice(), tradeIsBuy.getName()));
                            listStock.add(new TradeOrder(tradeIsBuy.getTrade(), soLuong, 
                                    tradeIsSell.getPrice(), tradeIsBuy.getName(), tradeIsSell.getName()));
                        }
                        soLuong = 0;
                        sell.add(new TradeOrder(tradeIsSell.getType(), tradeIsSell.getTrade(),
                                soLuongConLai, tradeIsSell.getPrice(), tradeIsSell.getName()));
                        break;
                    } else break;
                } else if (tradeIsBuy.getPrice() < tradeIsSell.getPrice()) {
                    sell.add(tradeIsSell);
                    check = false;
                    break;
                }

            }
            if (soLuong > 0) {
                buy.add(new TradeOrder(tradeIsBuy.getType(), tradeIsBuy.getTrade(),
                        soLuong, tradeIsBuy.getPrice(), tradeIsBuy.getName()));
            }
            if (check == false){
                break;
            }
        }
    }
}
