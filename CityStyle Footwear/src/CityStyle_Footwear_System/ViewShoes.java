
package CityStyle_Footwear_System;

import java.sql.*; // to connect with database and run query (Connection, ResultSet, PreparedStatement)
import javax.swing.JOptionPane; //to show a messages if have an error
import javax.swing.table.DefaultTableModel;  // to add data into table

public class ViewShoes extends javax.swing.JFrame {
    String userRole;

    public ViewShoes(String role) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.userRole = role;
        showTableData(); //to load data into table when open window
        
        // Update/Delete button hide from cashier
    if (!"Manager".equalsIgnoreCase(userRole)) {
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
    }
    }

    private ViewShoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showTableData() {
    try {
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM public.shoe"; //to get all data
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) tblShoes.getModel();  //to get table model
        model.setRowCount(0); //show new data

        while (rs.next()) {
            // Add database data into an array
            Object[] row = {
                rs.getInt("shoeid"),
                rs.getString("model"),
                rs.getString("brand"),
                rs.getString("category"),
                rs.getString("size"),
                rs.getString("color"),
                rs.getDouble("price"),
                rs.getInt("qty")
            };
            model.addRow(row); // add array into created table
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblShoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tblShoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Shoe id", "Model", "Brand", "category", "Size", "Colour", "Price", "Stock on hand"
            }
        ));
        jScrollPane1.setViewportView(tblShoes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("All Shoe Details ");

        btnBack.setBackground(new java.awt.Color(0, 0, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 204, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(34, 34, 34)
                        .addComponent(btnDelete)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    this.dispose(); //to close this window
    
   if ("Manager".equals(userRole)) {
         new ManagerDashboard().setVisible(true); //if user is a Manager, show ManagerDashboard
       } else {
           new CashierDashboard().setVisible(true); //else, show cashier dashboard
    }
   
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      // Get the selected row index from the table
    int row = tblShoes.getSelectedRow();
    
    // Check if a row is selected to prevent errors
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Please select a shoe to update!");
        return;
    }

    // Safely retrieve current values 
    String id = (tblShoes.getValueAt(row, 0) != null) ? tblShoes.getValueAt(row, 0).toString() : "";
    String oldModel = (tblShoes.getValueAt(row, 1) != null) ? tblShoes.getValueAt(row, 1).toString() : "";
    String oldBrand = (tblShoes.getValueAt(row, 2) != null) ? tblShoes.getValueAt(row, 2).toString() : "";
    String oldCat = (tblShoes.getValueAt(row, 3) != null) ? tblShoes.getValueAt(row, 3).toString() : "";
    String oldSize = (tblShoes.getValueAt(row, 4) != null) ? tblShoes.getValueAt(row, 4).toString() : "";
    String oldColor = (tblShoes.getValueAt(row, 5) != null) ? tblShoes.getValueAt(row, 5).toString() : "";
    String oldPrice = (tblShoes.getValueAt(row, 6) != null) ? tblShoes.getValueAt(row, 6).toString() : "0.0";
    String oldQty = (tblShoes.getValueAt(row, 7) != null) ? tblShoes.getValueAt(row, 7).toString() : "0";

    // Create a list to store categories fetched from the database
    java.util.List<String> categoryList = new java.util.ArrayList<>();
    try {
        Connection con = DatabaseConnection.getConnection();
        
        // Fetch category names from the category table dynamically
        String catSql = "SELECT categoryname FROM public.category"; 
        PreparedStatement catPst = con.prepareStatement(catSql);
        ResultSet catRs = catPst.executeQuery();

        while (catRs.next()) {
            categoryList.add(catRs.getString("categoryname"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading categories: " + e.getMessage());
    }

    // Convert the category list into an array for the input dialog
    String[] categories = categoryList.toArray(new String[0]);

    // Show input dialogs for the user to enter new details
    String newModel = JOptionPane.showInputDialog(this, "Enter New Model Name:", oldModel);
    String newBrand = JOptionPane.showInputDialog(this, "Enter New Brand:", oldBrand);
    
    // Show a dropdown selection for Category using database values
    String newCat = (String) JOptionPane.showInputDialog(this, "Select Category:", "Update Category",
            JOptionPane.QUESTION_MESSAGE, null, categories, oldCat);

    String newSize = JOptionPane.showInputDialog(this, "Enter New Size:", oldSize);
    String newColor = JOptionPane.showInputDialog(this, "Enter New Color:", oldColor);
    String newPrice = JOptionPane.showInputDialog(this, "Enter New Price:", oldPrice);
    String newQty = JOptionPane.showInputDialog(this, "Enter New Quantity:", oldQty);

    // Verify that the user did not cancel the dialogs and values are valid
    if (newModel != null && newPrice != null && newQty != null && newCat != null) {
        try {
            Connection con = DatabaseConnection.getConnection();
            
            // Check if connection is valid before preparing the statement
            if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!");
                return;
            }

            // SQL query to update the shoe details in the database
            String sql = "UPDATE public.shoe SET model=?, brand=?, category=?, size=?, color=?, price=?, qty=? WHERE shoeid=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            // Set the new values into the SQL query parameters
            pst.setString(1, newModel);
            pst.setString(2, newBrand);
            pst.setString(3, newCat);
            pst.setString(4, newSize);
            pst.setString(5, newColor);
            pst.setDouble(6, Double.parseDouble(newPrice));
            pst.setInt(7, Integer.parseInt(newQty));
            pst.setInt(8, Integer.parseInt(id));

            // Execute the update query and check if it was successful
            int result = pst.executeUpdate();
            if (result > 0) {
                // Refresh the table to show updated data and show success message
                showTableData(); 
                JOptionPane.showMessageDialog(this, "Shoe details updated successfully!"); 
            }
        } catch (Exception e) {
            // Handle parsing or database errors
            JOptionPane.showMessageDialog(this, "Update Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int row = tblShoes.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Please select a shoe to delete!");
        return;
    }
    String shoeID = tblShoes.getValueAt(row, 0).toString();
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this shoe?", "Delete", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "DELETE FROM public.shoe WHERE shoeid = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(shoeID));
            pst.executeUpdate();
            showTableData(); // Refresh table
            JOptionPane.showMessageDialog(this, "Shoe deleted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ViewShoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewShoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblShoes;
    // End of variables declaration//GEN-END:variables
}
