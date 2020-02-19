/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vutrunganh
 */
public class BookDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/AnOnlineShop", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static int save(Book k) {
        int status = 0;
        try {
            Connection con = BookDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into book(Category,Name,Description,Content) values (?,?,?,?)");
            ps.setString(1, k.getCategory());
            ps.setString(2, k.getName());
            ps.setString(3, k.getDescription());
            ps.setString(4, k.getContent());
            status = ps.executeUpdate();
            System.out.println(status);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int save2(Book k) {
        int status = 0;
        try {
            Connection con = BookDao.getConnection();
            String sql = "insert into book(Category,Name,Description,Content) values "
                    + "('" + k.getCategory() + "',"
                    + "'" + k.getName() + "',"
                    + "'" + k.getDescription() + "',"
                    + "'" + k.getContent() + "')";
            PreparedStatement ps = con.prepareStatement(sql);
//            PreparedStatement ps = con.prepareStatement(
//                    "insert into book(Category,Name,Description,Content) values (?,?,?,?)");
//            ps.setString(1, k.getCategory());
//            ps.setString(2, k.getName());
//            ps.setString(3, k.getDescription());
//            ps.setString(4, k.getContent());
            status = ps.executeUpdate(sql);
//            ps.executeUpdate(sql);
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    
    public static int update(Book k) {
        int status = 0;
        try {
            Connection con = BookDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update book set Category=?,Name=?,Description=?,Content=? where Id=?");
            ps.setString(1, k.getCategory());
            ps.setString(2, k.getName());
            ps.setString(3, k.getDescription());
            ps.setString(4, k.getContent());
            ps.setInt(5, k.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = BookDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from book where Id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Book getBookById(int id) {
        Book b = new Book();

        try {
            Connection con = BookDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book where Id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setId(rs.getInt(1));
                b.setCategory(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescription(rs.getString(4));
                b.setContent(rs.getString(5));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return b;
    }

//    public static ArrayList<Emp> hee(){
//        
//    }
    public static ArrayList<Book> getAllBook(){  
        ArrayList<Book> list=new ArrayList<Book>();  

        try {
            Connection con = BookDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setCategory(rs.getString(2));
                b.setName(rs.getString(3));
                b.setDescription(rs.getString(4));
                b.setContent(rs.getString(5));
                list.add(b);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
