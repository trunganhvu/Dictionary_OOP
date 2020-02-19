/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstock;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author vutrunganh
 */
public class Trader implements Comparable<Trader>{
    private String tradeCode;

    public Trader(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    @Override
    public int compareTo(Trader o) {
//        return 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return this.tradeCode;
    }

    
    public static void main(String[] args) {
        Set<String> t = new TreeSet<>();
        t.add("hello");
        t.add("as");
        t.add("hello");
        for (String i : t){
            System.out.println(i);
        }
    }
    
}
