package src;


import src.Product;
import src.ShoppingItem;
import com.mysql.cj.xdevapi.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

  public Hashtable getCategories() {
    Hashtable categories = new Hashtable(); 
    try {
      Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword); 
      
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD_JSP", "root", "");
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
        String sql = "SELECT ProductId, Name, Description, Price FROM Products" + 
          " WHERE Name LIKE '%" + keyword.trim() + "%'" + 
          " OR Description LIKE '%" + keyword.trim() + "%'"; 
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
    long orderId = System.currentTimeMillis(); 
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
      // now insert items into OrderDetails table 
      Enumeration enum1 = shoppingCart.elements(); 
      while (enum1.hasMoreElements()) {
        ShoppingItem item = (ShoppingItem) enum1.nextElement(); 
        sql = "INSERT INTO OrderDetails (OrderId, ProductId, Quantity, Price)" + 
        " VALUES (" + orderId + "," + item.productId + "," + 
        item.quantity + "," + item.price + ")"; 
        ps.executeUpdate(sql); 
      } 

//      s.close(); 
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
