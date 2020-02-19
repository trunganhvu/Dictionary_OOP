/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vutrunganh
 */
public class ClientConnectDB {

    Connection con = null;
    Statement stm = null;

    public ClientConnectDB() {
        String urlMYSQL = "jdbc:mysql://localhost/appchat";
        //java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.print("ClassNotFoundException: ");
        }
        try {
            con = DriverManager.getConnection(urlMYSQL, "root", "");
            stm = con.createStatement();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public ArrayList<String> getMessage(String fromuser, String touser) throws SQLException {
        ArrayList<String> message = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from message_user where fromuser=? and touser=?");
        pre.setString(1, fromuser);
        pre.setString(2, touser);

        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            String value = rs.getString(4);
            message.add(value);
        }
        return message;
    }

    public void insertMessage(String fromuser, String touser, String content) throws SQLException {
        PreparedStatement pre = con.prepareStatement("insert into message_user values(null,?,?,?)");
        pre.setString(1, fromuser);
        pre.setString(2, touser);
        pre.setString(3, content);
        pre.executeUpdate();
    }

    public void insertArrayListMessage(ArrayList<String> listMessage, String fromuser, String touser) throws SQLException {
        for (int i = 0; i < listMessage.size(); i++) {
            insertMessage(fromuser, touser, listMessage.get(i));
        }
    }

    public void insertUsername(String username) throws SQLException {
        PreparedStatement pre = con.prepareStatement("insert into user values(null,?)");
        pre.setString(1, username);
        pre.executeUpdate();
    }

    public boolean checkUser(String username) throws SQLException {
        PreparedStatement pre = con.prepareStatement("select * from user where username=?");
        pre.setString(1, username);
        ResultSet rs = pre.executeQuery();

        return rs.next();
    }

    public void insertGroupDefault(String username, String content) throws SQLException {
        PreparedStatement pre = con.prepareStatement("insert into group_default values(null,?,?)");
        pre.setString(1, username);
        pre.setString(2, content);
        pre.executeUpdate();
    }

    public ArrayList<String> getMessageGroupDefault() throws SQLException {
        ArrayList<String> message = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from group_default");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            String content = rs.getString(3);
            message.add(content);
        }
        return message;
    }

    public static void main(String args[]) throws SQLException {
        ClientConnectDB mysql = new ClientConnectDB();
        ArrayList<String> message = mysql.getMessageGroupDefault();
        System.out.println(message.toString());
        // System.out.println(message.size());
        //mysql.insertMessage("test1", "test2", "add nhe");

    }
}
