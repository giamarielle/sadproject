
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reyes.jenneth
 */
public class DoctorView extends javax.swing.JFrame {
    public String service;
    public List<String> patient_id = new ArrayList<>();
    /**
     * Creates new form DoctorView
     */
    public DoctorView(String service) {
        initComponents();
        this.service = service;
        jLabelService.setText(service);
        getDBData();
        if(patient_id.size()>0){
            if(patient_id.get(0)!=null)
                CurrentTextField.setText(patient_id.get(0));
            if(patient_id.get(1)!=null)
                NextTextField.setText(patient_id.get(1));
        }
    }
    
    public void getDBData(){
        String query = "SELECT * FROM queue";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.100.117:3306/sad_db", "ARWEN","MYPASS");
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/QMS","konsulta","resulta");
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                if(rs.getString("service").equals(service))
                    if(!patient_id.contains(rs.getString("patient_id")))
                        patient_id.add(rs.getString("patient_id"));
            }
            
        }catch (Exception ex){
            System.out.println("Scan_DB Error: " + ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReceptionPanel = new javax.swing.JPanel();
        ChangeUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CurrentTextField = new javax.swing.JTextField();
        PatientInfo = new javax.swing.JTextArea();
        NextTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        HoldButton = new javax.swing.JButton();
        CallNextButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OnHoldText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ReceptionPanel.setBackground(new java.awt.Color(228, 241, 254));

        ChangeUser.setBackground(java.awt.Color.lightGray);
        ChangeUser.setFont(new java.awt.Font("Proxima Nova Rg", 1, 20)); // NOI18N
        ChangeUser.setText("CHANGE USER");
        ChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CURRENT PATIENT");

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NEXT PATIENT");

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ON HOLD");

        CurrentTextField.setEditable(false);
        CurrentTextField.setFont(new java.awt.Font("Proxima Nova Rg", 0, 24)); // NOI18N
        CurrentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentTextFieldActionPerformed(evt);
            }
        });

        PatientInfo.setEditable(false);
        PatientInfo.setColumns(20);
        PatientInfo.setFont(new java.awt.Font("Proxima Nova Rg", 0, 22)); // NOI18N
        PatientInfo.setRows(5);
        PatientInfo.setText("Patient ID:\t000005\nFirst Name: \tGia Marielle\nMiddle Name: \tCayetano\nLast Name: \tReyes\nAddress: \tPasig City\nGender: \tFemale\nAge: \t20\n");
        PatientInfo.setMargin(new java.awt.Insets(10, 10, 10, 10));

        NextTextField.setEditable(false);
        NextTextField.setFont(new java.awt.Font("Proxima Nova Rg", 0, 24)); // NOI18N
        NextTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PATIENT INFO");

        jLabelService.setFont(new java.awt.Font("Poppins Medium", 0, 40)); // NOI18N
        jLabelService.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelService.setText("PEDIATRICIAN");

        HoldButton.setBackground(java.awt.Color.lightGray);
        HoldButton.setFont(new java.awt.Font("Proxima Nova Rg", 1, 22)); // NOI18N
        HoldButton.setText("HOLD PATIENT");
        HoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoldButtonActionPerformed(evt);
            }
        });

        CallNextButton.setBackground(java.awt.Color.lightGray);
        CallNextButton.setFont(new java.awt.Font("Proxima Nova Rg", 1, 22)); // NOI18N
        CallNextButton.setText("CALL NEXT PATIENT");
        CallNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallNextButtonActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faves/KRlogo.png"))); // NOI18N

        OnHoldText.setEditable(false);
        OnHoldText.setColumns(20);
        OnHoldText.setLineWrap(true);
        OnHoldText.setRows(5);
        jScrollPane1.setViewportView(OnHoldText);

        javax.swing.GroupLayout ReceptionPanelLayout = new javax.swing.GroupLayout(ReceptionPanel);
        ReceptionPanel.setLayout(ReceptionPanelLayout);
        ReceptionPanelLayout.setHorizontalGroup(
            ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(94, 94, 94)
                        .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelService, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChangeUser)))
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CurrentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceptionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NextTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(212, 212, 212)
                        .addComponent(jLabel4))
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(PatientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(CallNextButton))
                            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(HoldButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ReceptionPanelLayout.setVerticalGroup(
            ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addComponent(jLabelService)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangeUser)))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(ReceptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(HoldButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CallNextButton))
                    .addGroup(ReceptionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 61, Short.MAX_VALUE))
        );

        getContentPane().add(ReceptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NextTextFieldActionPerformed

    private void ChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeUserActionPerformed
        flashscreen fs = new flashscreen();
        fs.setVisible(true);
        fs.pack();
        fs.setLocationRelativeTo(null);
        //rv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ChangeUserActionPerformed

    private void HoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoldButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoldButtonActionPerformed

    private void CallNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallNextButtonActionPerformed
        getDBData();
        
    }//GEN-LAST:event_CallNextButtonActionPerformed

    private void CurrentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorView("Test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CallNextButton;
    private javax.swing.JButton ChangeUser;
    private javax.swing.JTextField CurrentTextField;
    private javax.swing.JButton HoldButton;
    private javax.swing.JTextField NextTextField;
    private javax.swing.JTextArea OnHoldText;
    private javax.swing.JTextArea PatientInfo;
    private javax.swing.JPanel ReceptionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
