/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;


import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Tommmm^^
 */
public class DictionaryManagement {
    Scanner sc = new Scanner(System.in);
     public int getSize(){
        return Dictionary.Words.size();
    }
    public void  insertFromCommandline(){                  
        String word_explain;
        String word_target;
        System.out.print("Nhập số lượng từ muốn thêm: ");
        int number = sc.nextInt();
        sc.nextLine() ;
        for (int i = 0; i < number; i++) {
            System.out.print("Nhập từ và nghĩa muốn thêm : ");
            word_target = sc.nextLine();
            word_explain = sc.nextLine();
            Dictionary.Words.add(new Word(word_target, word_explain));
         }    
    }
    public void insertFromFile() throws IOException{        //trung anh code them doc file
        Scanner inputDic = new Scanner(Paths.get("dictionary.txt"));
        while(inputDic.hasNextLine()){
            String[] temp = inputDic.nextLine().split(":");
            Dictionary.Words.add(new Word(temp[0], temp[1]));
        }
    }
    public void dictionaryLookup() {
        String lookWord = sc.nextLine();
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (lookWord.equals(Dictionary.Words.get(i).getWord_target()))
                System.out.println(Dictionary.Words.get(i).getWord_explain());
                
        }
    }
    public void addWord() {      
        Word addWord = new Word();
        System.out.println("Nhap tu muon them : ");
        addWord.setWord_target(sc.nextLine());
        System.out.println("Nhap nghia muon them : ");
        addWord.setWord_explain(sc.nextLine());
        Dictionary.Words.add(addWord);
        
    }
    public void deleteWord() {
        System.out.println("Nhap tu muon xoa :");
        String deleteWord = sc.nextLine();
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (deleteWord.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Dictionary.Words.remove(i);
            }
        }
   
    }
    public void repairWord() {
       
        System.out.println("Nhap tu muốn sửa : ");
        String str = sc.nextLine();
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (str.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                System.out.print("Từ mới : ");
                Dictionary.Words.get(i).setWord_target(sc.nextLine());
                System.out.print("Nghĩa : ");  
                Dictionary.Words.get(i).setWord_explain(sc.nextLine());
            }
        }
    }
}