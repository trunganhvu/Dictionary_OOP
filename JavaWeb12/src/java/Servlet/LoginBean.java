/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author vutrunganh
 */
public class LoginBean {
    private String userName, passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public boolean validate(){
        if (this.passWord.equals("admin") && this.userName.equals("admin")){
            return true;
        }
        return false;
    }
}
