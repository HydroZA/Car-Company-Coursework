/*
CS4001 Programming
Coursework 2
All code by JAMES LEGGE - 17008250
London Metropolitan University
BSc Computer Networking and Cyber Security
*/
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author James
 */
public class frmBuyCar extends javax.swing.JFrame {

    String customerName;
    int carNum;
    private frmMainMenu cen;
    /**
     * Creates new form frmBuyCar
     */
    public frmBuyCar(frmMainMenu mainFrm) {
        cen = mainFrm;
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txfCarNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfCustomerName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuyCar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buy a Car");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Enter the ID of a car to buy:");

        jLabel1.setText("Customer Name:");

        btnBuyCar.setText("Buy Car");
        btnBuyCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyCarActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfCarNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBuyCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCustomerName)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCarNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuyCar)
                    .addComponent(btnClear))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
        
    private void btnBuyCarActionPerformed(java.awt.event.ActionEvent evt) {
    customerName = txfCustomerName.getText();

        // Try, Catch statements to catch if the user enters anything other than a valid integer into the carNum field
        // If coursework guidelines were different I would have used a Spinner component from the Swing library for this 
        try
        {
            carNum = Integer.parseInt(txfCarNumber.getText());
            
            // Validate if the user has selected a valid car number
            if (carNum >= 0 && carNum <= cen.cars.size())
            {
                // Validate that the selected object is available to buy by checking what kind of object it is
                if (cen.cars.get(carNum).getClass() == CarToBuy.class)
                {
                    // Continue to buy car
                    ((CarToBuy) cen.cars.get(carNum)).buyCar(customerName);
                    JOptionPane.showMessageDialog(this, "Successfully bought the car!", "Great Success!", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                else
                {
                    // Selected Car is not available to buy
                    JOptionPane.showMessageDialog(this, "The car you selected is a Car to Rent, not a Car to Buy", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid Car Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Car Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        txfCarNumber.setText("");
        txfCustomerName.setText("");
    }

    /**
     * @param args the command line arguments
     */

    private javax.swing.JButton btnBuyCar;
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfCarNumber;
    private javax.swing.JTextField txfCustomerName;
}
