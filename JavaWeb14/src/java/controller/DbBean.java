/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import src.Product;
import src.ShoppingItem;

/**
 *
 * @author vutrunganh
 */
public class DbBean {
    public String dbUrl = ""; 
    public String dbUserName = ""; 
    public String dbPassword = ""; 

    public void setDbUrl(String url) {
      dbUrl = url; 
    } 
    public void setDbUserName(String userName) {
      dbUserName = userName; 
    } 
    public void setDbPassword(String password) {
      dbPassword = password; 
    } 

    public ArrayList getAllProduct(){
        ArrayList products = new ArrayList();
        try {
            Connection connection = getConnection();
            String sql = "SELECT ProductId, Name, Description, Price FROM Products" + " ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql); 
            while (rs.next()) {
                Product p = new Product();
//                products.put(rs.getString(1), rs.getString(2) );
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                products.add(p);
            } 
            rs.close(); 
            connection.close(); 
        }
        catch (SQLException e) {} 
        return products;
    }
    public Hashtable getCategories() {
      Hashtable categories = new Hashtable(); 
      try {
        Connection connection = getConnection();
  //      Statement s = connection.createStatement(); 
        String sql = "SELECT CategoryId, Category FROM Categories" + " ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql); 
        while (rs.next()) {
          categories.put(rs.getString(1), rs.getString(2) ); 
        } 
        rs.close(); 
        connection.close(); 
      } 
      catch (SQLException e) {} 
      return categories; 
    } 

    public static Connection getConnection() {
          Connection con = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book2JSPchap18", "root", "");
          } catch (Exception e) {
              System.out.println(e);
          }
          return con;
      }
      public ArrayList getSearchResults(String keyword) {
        ArrayList products = new ArrayList(); 
        try {
            Connection connection = getConnection(); 
    //        Statement s = connection.createStatement(); 
            String sql = "SELECT ProductId, Name, Description, Price FROM Products" 
                + " WHERE Name LIKE '%" + keyword.trim() + "%'" 
                + " OR Description LIKE '%" + keyword.trim() + "%'"; 
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery(sql); 
            while (rs.next()) {
                Product product = new Product(); 
//                product.id = rs.getInt(1); 
//                product.name = rs.getString(2); 
//                product.description = rs.getString(3); 
//                product.price = rs.getDouble(4);
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                products.add(product); 
            } 
            rs.close(); 
      //      s.close(); 
            connection.close(); 
        } 
        catch (SQLException e) {} 
        return products; 
    } 

    public ArrayList getProductsInCategory(String categoryId) {
      ArrayList products = new ArrayList(); 
      try {
        Connection connection = getConnection(); 
  //      Statement s = connection.createStatement(); 
        String sql = "SELECT ProductId, Name, Description, Price FROM Products" +   
          " WHERE CategoryId=" + categoryId; 
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery(sql); 
        while (rs.next()) {
          Product product = new Product(); 
          product.id = rs.getInt(1); 
          product.name = rs.getString(2); 
          product.description = rs.getString(3); 
          product.price = rs.getDouble(4); 
          products.add(product); 
        } 
        rs.close(); 
  //      s.close(); 
        connection.close(); 
      } 
      catch (SQLException e) {} 
      return products; 
    } 

    public Product getProductDetails(int productId) {
      Product product = null; 
      try {
        Connection connection = getConnection(); 
  //      Statement s = connection.createStatement(); 
        String sql = "SELECT ProductId, Name, Description, Price FROM Products" + 
          " WHERE ProductId=" + Integer.toString(productId); 
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery(sql); 
        if (rs.next()) {
          product = new Product(); 
          product.id = rs.getInt(1); 
          product.name = rs.getString(2); 
          product.description = rs.getString(3); 
          product.price = rs.getDouble(4); 
        } 
        rs.close(); 
  //      s.close(); 
        connection.close(); 
      } 
      catch (SQLException e) {} 
      return product; 
    } 

    public boolean insertOrder(String contactName, String deliveryAddress, 
        String ccName, String ccNumber, String ccExpiryDate, Hashtable shoppingCart) {
        boolean returnValue = false; 
        int orderId = (int) System.currentTimeMillis(); 
        Connection connection = null; 
        try {
            connection = getConnection();
            connection.setAutoCommit(false); 
      //      Statement s = connection.createStatement(); 
            String sql = "INSERT INTO Orders" + 
              " (OrderId, ContactName, DeliveryAddress, CCName, CCNumber, CCExpiryDate)" + 
              " VALUES" + 
              " (" + orderId + ",'" + contactName + "','" + deliveryAddress + "'," + 
              "'" + ccName + "','" + ccNumber + "','" + ccExpiryDate + "')"; 
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate(sql);
//            ps.executeQuery(sql);
            // now insert items into OrderDetails table 
            Enumeration enum1 = shoppingCart.elements(); 
            while (enum1.hasMoreElements()) {
                ShoppingItem item = (ShoppingItem) enum1.nextElement(); 
                sql = "INSERT INTO OrderDetails (OrderId, ProductId, Quantity, Price)" + 
                " VALUES (" + orderId + "," + item.productId + "," + 
                item.quantity + "," + item.price + ")"; 
                ps.executeUpdate(sql); 
            }
            connection.commit(); 
            connection.close(); 
            returnValue = true; 
        } 
        catch (SQLException e) {
            try {
                connection.rollback(); 
                connection.close(); 
            } 
            catch (SQLException se) {} 
        } 
        return returnValue; 
    } 
}
