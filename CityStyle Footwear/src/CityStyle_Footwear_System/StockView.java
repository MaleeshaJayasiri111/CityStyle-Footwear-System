package CityStyle_Footwear_System;

import java.sql.Connection;        // to connect with database
import java.sql.PreparedStatement; // to create SQL query 
import java.sql.ResultSet;         // to get data from database
import java.sql.SQLException;
import javax.swing.JOptionPane;     //to show error messages
import javax.swing.table.DefaultTableModel; // to add data into table
import java.sql.Statement; // for statements
import java.awt.Desktop;    // for Desktop.getDesktop()
import java.io.File;       // for File Handling

public class StockView extends javax.swing.JFrame {

   String userRole;
   
    public StockView(String role) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.userRole = role;
        loadAllStock();; // to show all available items 
        checkAccess();
    }
    
    private void checkAccess() {
    // if user is not Manager,hide this options 
    if (userRole == null || !userRole.equalsIgnoreCase("Manager")) {
        btnUpdateStock.setVisible(false);
        txtAdjustQty.setVisible(false);
        lblQuantity.setVisible(false);
        lblLowStock.setVisible(false);
        lblLowStock.setVisible(false);
        btnGenInventoryReport.setVisible(false);
    }
}

    private StockView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void loadAllStock() {
    try {
        Connection con = DatabaseConnection.getConnection();
        //show avalable stock (minimum stock to maximum stock)
        String sql = "SELECT * FROM public.shoe ORDER BY qty ASC";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblStock.getModel(); 
        model.setRowCount(0); 

        while (rs.next()) {
            Object[] row = {
                rs.getInt("shoeid"),
                rs.getString("model"),
                rs.getString("brand"),
                rs.getString("category"),
                rs.getString("size"),
                rs.getString("color"),
                rs.getInt("qty") // Real-time stock 
            };
            model.addRow(row);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading stock: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnUpdateStock = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        lblLowStock = new javax.swing.JLabel();
        txtAdjustQty = new javax.swing.JTextField();
        btnRefresh1 = new javax.swing.JButton();
        btnGenInventoryReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Stock Availability & Adjustments");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Shoe id", "Model", "Brand", "Category", "Size", "Colour", "Available stock"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        btnBack.setBackground(new java.awt.Color(0, 0, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdateStock.setBackground(new java.awt.Color(0, 0, 51));
        btnUpdateStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateStock.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStock.setText("Update");
        btnUpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStockActionPerformed(evt);
            }
        });

        lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuantity.setText("Update Stock Quantity (+/-):");

        lblLowStock.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLowStock.setForeground(new java.awt.Color(204, 0, 0));
        lblLowStock.setText("Default Low Stock Alert: 10 units");

        btnRefresh1.setBackground(new java.awt.Color(0, 0, 51));
        btnRefresh1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefresh1.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh1.setText("Refresh");
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        btnGenInventoryReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenInventoryReport.setText("Generate Inventory Report");
        btnGenInventoryReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenInventoryReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addGap(18, 18, 18)
                                .addComponent(txtAdjustQty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateStock)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(lblLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenInventoryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnGenInventoryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdjustQty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLowStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStockActionPerformed
       int selectedRow = tblStock.getSelectedRow(); //check is table row is selected (Must select a row before updating)
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a shoe from the table first!");
        return;
    }

    String qtyStr = txtAdjustQty.getText().trim();

    if (qtyStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the quantity to add!");
        return;
    }

    try {
      
        String shoeId = tblStock.getValueAt(selectedRow, 0).toString(); 
        int addQty = Integer.parseInt(qtyStr);

        Connection con = DatabaseConnection.getConnection();
        
        // SQL to manage Qty and also update Threshold
        //
        String sql = "UPDATE public.shoe SET qty = qty + ? WHERE shoeid = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(txtAdjustQty.getText())); // add new Qty
        pst.setInt(2, Integer.parseInt(shoeId)); // add shoe id
       

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Inventory updated successfully!");
            txtAdjustQty.setText("");
            loadStockData(); //Refresh the table to show new Qty
        }
    }
    catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
    }
    catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
    }
        loadAllStock();
    }//GEN-LAST:event_btnUpdateStockActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose(); // close this window
    
    // Open dashboard by user role
    if (this.userRole != null && this.userRole.equalsIgnoreCase("Manager")) {
        new ManagerDashboard().setVisible(true); // if user is manager, open ManagerDashboard
    } else {
        // if user is cashier, open cashier dashboard
        new CashierDashboard().setVisible(true); 
    }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void btnGenInventoryReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenInventoryReportActionPerformed
      try {
        java.io.FileWriter fw = new java.io.FileWriter("Inventory_Report.txt"); // create report as txt file
        fw.write("--- SHOE SHOP INVENTORY REPORT ---\n\n");
        
        fw.write(String.format("%-5s | %-15s | %-10s | %-10s | %-5s | %-10s | %-5s\n",  // Used String Formatting to align Column Headers 
                 "ID", "Model", "Brand", "Category", "Size", "Color", "Stock"));
        fw.write("--------------------------------------------------------------------------------\n");

        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.shoe ORDER BY qty ASC");

        while (rs.next()) {
            // get data in every column using loop
            String line = String.format("%-5s | %-15s | %-10s | %-10s | %-5s | %-10s | %-5s\n",
                    rs.getString("shoeid"),
                    rs.getString("model"),
                    rs.getString("brand"),
                    rs.getString("category"),
                    rs.getString("size"),
                    rs.getString("color"),
                    rs.getString("qty"));
            fw.write(line);
        }
        
        fw.close();
        JOptionPane.showMessageDialog(null, "Report Saved as Inventory_Report.txt");
        
        // open created file
        Desktop.getDesktop().open(new java.io.File("Inventory_Report.txt"));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenInventoryReportActionPerformed

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
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenInventoryReport;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnUpdateStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLowStock;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtAdjustQty;
    // End of variables declaration//GEN-END:variables

    private void loadLowStock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    private void loadStockData() {
        // get data from ResultSet 
       try {
        Connection con = DatabaseConnection.getConnection();
        // get data from shoe table 
        String sql ="SELECT shoeid, model, brand, category, size, color, price, qty FROM public.shoe";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(); 

        //Add new data to the table after clear it
        DefaultTableModel model = (DefaultTableModel) tblStock.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            String shoeName = rs.getString("model");
            int currentQty = rs.getInt("qty");
            int threshold = 10; //if low than 10, low alert will display

            // add data into table
            model.addRow(new Object[]{
                rs.getInt("shoeid"),
                shoeName,
                rs.getString("brand"),
                rs.getString("category"),
                rs.getString("size"),
                rs.getString("color"),
                currentQty
            });

            // if current stock is low, Show a Low Stock Warning
            if (currentQty <= threshold) {

        JOptionPane.showMessageDialog(this, 
            " LOW STOCK ALERT!\nModel: " + shoeName+ "\nOnly " + currentQty + " items left.", 
            "Inventory Warning", 
            JOptionPane.WARNING_MESSAGE);
    }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading stock: " + e.getMessage());
    }
    }
}
