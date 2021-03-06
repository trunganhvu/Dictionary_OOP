/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewStock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projectstock.*;

/**
 *
 * @author vutrunganh
 */
public class StockUI extends javax.swing.JFrame {
    
    Set<String> SetTradeCode = new TreeSet<>();
    Integer indexBuy = 0;
    public List<TradeOrder> list = new ArrayList<>();

    /**
     * Creates new form Stock
     */
    public StockUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuy = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSell = new javax.swing.JTable();
        jTextName = new javax.swing.JTextField();
        jTextTradeCode = new javax.swing.JTextField();
        jTextQuantity = new javax.swing.JTextField();
        jTextPrice = new javax.swing.JTextField();
        jComboBoxType = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStock = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMatch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableBuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Trade Code", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBuy);

        jTableSell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Trade Code", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSell);

        jTextName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextNameMouseClicked(evt);
            }
        });

        jTextTradeCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextTradeCodeMouseClicked(evt);
            }
        });
        jTextTradeCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTradeCodeActionPerformed(evt);
            }
        });

        jTextQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextQuantityMouseClicked(evt);
            }
        });

        jTextPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextPriceMouseClicked(evt);
            }
        });

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buy", "Sell" }));

        jTableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Buyer", "Name Seller", "Trade Code", "Quantity", "Price", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableStock);

        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Buyer");

        jLabel2.setText("Seller");

        jButtonMatch.setText("Match");
        jButtonMatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMatchMouseClicked(evt);
            }
        });
        jButtonMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMatchActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Trade Code");

        jLabel5.setText("Quantity");

        jLabel6.setText("Price");

        jButtonLogin.setText("Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });

        jButton3.setText("Register");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonMatch)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextTradeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jTextQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(4, 4, 4))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButtonLogin)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTradeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonLogin)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<TradeOrder> getList() {
        return list;
    }

    public void setList(List<TradeOrder> list) {
        this.list = list;
    }

    public JTable getjTableBuy() {
        return jTableBuy;
    }

    public void setjTableBuy(JTable jTableBuy) {
        this.jTableBuy = jTableBuy;
    }

    public JTable getjTableSell() {
        return jTableSell;
    }

    public void setjTableSell(JTable jTableSell) {
        this.jTableSell = jTableSell;
    }

    public JTable getjTableStock() {
        return jTableStock;
    }

    public void setjTableStock(JTable jTableStock) {
        this.jTableStock = jTableStock;
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String name = jTextName.getText().trim();
        String type = jComboBoxType.getSelectedItem().toString();
        String tradeCode = jTextTradeCode.getText().trim();
        SetTradeCode.add(tradeCode);
        //int quantity = Integer.parseInt(jTextQuantity.getText().trim());
        String quantity = jTextQuantity.getText().trim();
//        Double price = Double.parseDouble(jTextPrice.getText().trim());
        String price = jTextPrice.getText().trim();
        if (type == "Buy") {
            Vector<String> row = new Vector<>();
            row.addElement(name);
            row.addElement(type);
            row.addElement(tradeCode);
            row.addElement(quantity);
            row.addElement(price);
            DefaultTableModel model = (DefaultTableModel) jTableBuy.getModel();
            model.addRow(row);
        } else if (type == "Sell") {
            Vector<String> row = new Vector<>();
            row.addElement(name);
            row.addElement(type);
            row.addElement(tradeCode);
            row.addElement(quantity);
            row.addElement(price);
            DefaultTableModel model = (DefaultTableModel) jTableSell.getModel();
            model.addRow(row);
        }
        System.out.println(getList().toString());
//        System.out.println(name + " " + type + " " + tradeCode + " " + quantity +" " + price);
    }//GEN-LAST:event_jButton1MouseClicked
    
    private void updateDB(String buyer, String seller, String code, String price, String quantity) {
        String urlMYSQL = "jdbc:mysql://localhost/test1";
        //double p = Double.parseDouble(price);
        int q = Integer.parseInt(quantity);
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.print("ClassNotFoundException: ");
        }
        try {
            con = DriverManager.getConnection(urlMYSQL, "root", "");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        UpdateprepareStatement(con, "INSERT INTO stock (Buyer,Seller,TradeCode,Price,Quantity)"
                + " VALUES" + "( " + "'" + buyer + "'" + "," + "'" + seller + "'" + "," + "'" + code + "'"
                + "," + "'" + price + "'" + "," + "'" + q + "'" + ")");
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
    private void jTextNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNameMouseClicked
        jTextName.setText("");
    }//GEN-LAST:event_jTextNameMouseClicked

    private void jTextTradeCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextTradeCodeMouseClicked
        jTextTradeCode.setText("");
    }//GEN-LAST:event_jTextTradeCodeMouseClicked

    private void jTextQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextQuantityMouseClicked
        jTextQuantity.setText("");
    }//GEN-LAST:event_jTextQuantityMouseClicked

    private void jTextPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPriceMouseClicked
        jTextPrice.setText("");
    }//GEN-LAST:event_jTextPriceMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextTradeCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTradeCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTradeCodeActionPerformed

    private void jButtonMatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMatchMouseClicked
        for (String i : SetTradeCode) {
            Stock stock = new Stock(i);
            int toRemove = 0;
            for (int count = 0; count < jTableBuy.getRowCount(); count++) {
                String text = String.valueOf(jTableBuy.getValueAt(count, 2));
                if (text.equals(i)) {
                    String name = jTableBuy.getValueAt(count, 0).toString();
                    String type = jTableBuy.getValueAt(count, 1).toString();
                    String price = jTableBuy.getValueAt(count, 3).toString();
                    String quantity = jTableBuy.getValueAt(count, 4).toString();
                    stock.setBuy(type, i, quantity, price, name);
                    DefaultTableModel model = (DefaultTableModel) jTableBuy.getModel();
                    model.removeRow(toRemove);
                } else {
                    toRemove++;
                }
            }
            int toRemove2 = 0;
            for (int count = 0; count < jTableSell.getRowCount(); count++) {
                String text = String.valueOf(jTableSell.getValueAt(count, 2));
                if (text.equals(i)) {
                    String name = jTableSell.getValueAt(count, 0).toString();
                    String type = jTableSell.getValueAt(count, 1).toString();
                    String price = jTableSell.getValueAt(count, 3).toString();
                    String quantity = jTableSell.getValueAt(count, 4).toString();
                    stock.setSell(type, i, quantity, price, name);
                    DefaultTableModel model = (DefaultTableModel) jTableSell.getModel();
                    model.removeRow(toRemove2);
                } else {
                    toRemove2++;
                }
            }
            stock.logic1();
            while (!stock.getListStock().isEmpty()) {
                Vector<String> row = new Vector<>();
                TradeOrder temp = stock.getListStock().poll();
                row.addElement(temp.getName());
                row.addElement(temp.getName2());
                row.addElement(i);
                row.addElement(String.valueOf(temp.getQuantity()));
                row.addElement(String.valueOf(temp.getPrice()));
                DefaultTableModel model = (DefaultTableModel) jTableStock.getModel();
                model.addRow(row);
                updateDB(temp.getName(), temp.getName2(), String.valueOf(temp.getTrade()),
                        String.valueOf(temp.getPrice()), String.valueOf(temp.getQuantity()));
            }
            Vector<Vector> tableBuy = new Vector<>();
            while (!stock.getBuy().isEmpty()) {
                TradeOrder temp = stock.getBuy().poll();
                Vector<String> row = new Vector<>();
                row.addElement(temp.getName());
                row.addElement(temp.getType());
                row.addElement(String.valueOf(temp.getTrade()));
                row.addElement(String.valueOf(temp.getPrice()));
                row.addElement(String.valueOf(temp.getQuantity()));
                tableBuy.addElement(row);
                DefaultTableModel model = (DefaultTableModel) jTableBuy.getModel();
                model.addRow(row);
            }
            Vector<Vector> tableSell = new Vector<>();
            while (!stock.getSell().isEmpty()) {
                TradeOrder temp = stock.getSell().poll();
                Vector<String> row = new Vector<>();
                row.addElement(temp.getName());
                row.addElement(temp.getType());
                row.addElement(String.valueOf(temp.getTrade()));
                row.addElement(String.valueOf(temp.getPrice()));
                row.addElement(String.valueOf(temp.getQuantity()));
                tableSell.addElement(row);
                DefaultTableModel model = (DefaultTableModel) jTableSell.getModel();
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_jButtonMatchMouseClicked

    private void jButtonMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMatchActionPerformed

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        Login l = new Login();
        l.setTitle("Login");
        l.setLocationRelativeTo(null);
        l.setVisible(true);
        l.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        Register register = new Register();
        register.setTitle("Register");
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        register.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StockUI stock = new StockUI();
                stock.setLocationRelativeTo(null);
                stock.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonMatch;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTableBuy;
    public javax.swing.JTable jTableSell;
    public javax.swing.JTable jTableStock;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextQuantity;
    private javax.swing.JTextField jTextTradeCode;
    // End of variables declaration//GEN-END:variables
}
