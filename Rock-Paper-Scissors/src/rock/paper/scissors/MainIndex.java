/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors;

import java.util.Scanner;

/**
 *
 * @author vutrunganh
 */
public class MainIndex {
    static Scanner sc = new Scanner(System.in);
    static int player = 5;
    public static void main(String[] args) throws InterruptedException {
        init();
    }
    static void init() throws InterruptedException{
        Machine machine;
        int countTurn = 5;
        String againPlay;
        do{
            countTurn = 5;
            while(countTurn>0){
                String myTurn = sc.nextLine();
                int numberRandom = (int)(Math.random()*100)+1;
                machine = new Machine(numberRandom);
                String word = machine.Turn(numberRandom);
                String result = getReslut(myTurn, word);
                System.out.println(result);
                CountWin(result);
                countTurn--;
            }
            System.out.println(getWinner());
            System.out.println("Do you want to play again:[y/n]");
            againPlay = sc.nextLine();
        }while(againPlay.equals("y"));
    }
    static String getReslut(String myTurn, String word) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println(word);
        if((myTurn.equals("bao") && word.equals("bao")) 
            || (myTurn.equals("dam") && word.equals("dam"))
            || myTurn.equals("kim") && word.equals("kim")){
            return "========HOA========";
        }
        else if((myTurn.equals("bao") && word.equals("dam")) 
            || (myTurn.equals("dam") && word.equals("kim"))
            || myTurn.equals("kim") && word.equals("bao")){
            return "========You Win========";
        }
        else if((myTurn.equals("bao") && word.equals("kim")) 
            || (myTurn.equals("dam") && word.equals("bao"))
            || myTurn.equals("kim") && word.equals("dam")){
            return "========You Lose========";
        }
        else return "Wrong";
    }
    static String getWinner(){
        if (player > 5) return "You is Winner";
        else if (player < 5) return "You is Loser";
        return "same";
    }
    static void CountWin(String winner){
        if (winner.equals("You Win")) {
            player ++;
//            return player;
        }
        else if (winner.equals("You Lose")){
            player--;
//            return player;
        }
//        return player;
    }
}
