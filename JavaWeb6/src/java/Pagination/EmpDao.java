/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vutrunganh
 */
public class EmpDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pages", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static ArrayList<Emp> getRecords(int start, int total) {
        ArrayList<Emp> list = new ArrayList<Emp>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from emp limit " + (start - 1) + "," + total);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
