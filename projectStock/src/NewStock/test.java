/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vutrunganh
 */
public class test {
    public static void main(String args[]){
        
    }
    public void UpdateprepareStatement(Connection con, String updateQuery) {
        if (con != null) {
            PreparedStatement pre;
            try {
                pre = con.prepareStatement(updateQuery);
                pre.executeUpdate();
                pre.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }            
        }
    }
    public String SelectprepareStatement(Connection con, String selectQuery){
        String result = "";
        if (con != null){
            try {
                PreparedStatement pre = con.prepareStatement(selectQuery);
                ResultSet rs = pre.executeQuery();
                while(rs.next()){
                    String user = rs.getString(1);
                    String pass = rs.getString(2);
//                    System.out.println("name: " + user + " phone: " + pass);
                    result = user+pass;
                }
                pre.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }
}
