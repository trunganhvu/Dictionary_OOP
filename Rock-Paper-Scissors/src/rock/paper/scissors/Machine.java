/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors;

/**
 *
 * @author vutrunganh
 */
public class Machine {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Machine(int number) {
        this.number = number;
    }
    public static String Turn(int number){
        if (number % 3 == 0 ) return "bao";
        else if (number % 3 == 1) return "dam";
        else return "kim";
    }
}
