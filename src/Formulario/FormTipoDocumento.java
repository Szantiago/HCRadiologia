/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * 
 * 
 * Esta clase tiene por fin permitir la interaccion con la tabla ct_tiposdocumentos
 */
package Formulario;

import HCRadiologia.TipoDocumento;
import java.awt.Color;
import javax.swing.JOptionPane;


public class FormTipoDocumento extends javax.swing.JFrame {
TipoDocumento mitipDoc = new TipoDocumento();
 TipoDocumento[] miLista =mitipDoc.crudListaTipoDocumento();
 boolean b;
//---------------------------------------------------------------------------------
//Constructor
//---------------------------------------------------------------------------------
    public FormTipoDocumento() {
        initComponents();
        this.setLocation(300,120);
        setSize(380,310);
        setResizable(false);
        this.getContentPane().setBackground(new Color (47,79,79));
        b=true;           
        for(int intCont = 0; intCont < miLista.length; intCont++){
        jComboDoc.addItem(miLista[intCont].getIntIdTipo()+ "-"+miLista[intCont].getStrCInicialesTipoDoc()+"-"+miLista[intCont].getstrTipDoc());
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIniciales = new javax.swing.JTextField();
        txtTipDoc = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        jComboDoc = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tipo de Documento");
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 80, 49, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iniciales");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 120, 60, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo documento");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 150, 100, 20);

        txtIniciales.setMargin(new java.awt.Insets(-3, -3, -3, -3));
        getContentPane().add(txtIniciales);
        txtIniciales.setBounds(150, 120, 43, 20);

        txtTipDoc.setMargin(new java.awt.Insets(-3, -3, -3, -3));
        getContentPane().add(txtTipDoc);
        txtTipDoc.setBounds(150, 150, 194, 20);

        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(35, 210, 70, 23);

        btnInsert.setText("Insertar");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(110, 210, 80, 23);

        jComboDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDocActionPerformed(evt);
            }
        });
        getContentPane().add(jComboDoc);
        jComboDoc.setBounds(130, 80, 113, 20);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(200, 210, 90, 23);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(293, 210, 80, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Historia Clinica de Radiologia");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(37, 23, 310, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logomedicina.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 0, 270, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//---------------------------------------------------------------------------------
//Boton limpiar
//---------------------------------------------------------------------------------    
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       b=false;
       
       txtIniciales.setText("");
       txtTipDoc.setText("");
       jComboDoc.removeAllItems();
       btnInsert.setEnabled(true);
       jComboDoc.repaint();
                    
        for(int intCont = 0; intCont < miLista.length; intCont++){
        jComboDoc.addItem(miLista[intCont].getIntIdTipo()+ "-"+miLista[intCont].getStrCInicialesTipoDoc()+"-"+miLista[intCont].getstrTipDoc());
       }
        jComboDoc.setSelectedIndex(0);
        b=true;
    }//GEN-LAST:event_btnClearActionPerformed

//---------------------------------------------------------------------------------
//Boton Insertar
//---------------------------------------------------------------------------------    
    
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
       mitipDoc.crudCrearTipoDocumento(txtTipDoc.getText(),txtIniciales.getText());       
       txtIniciales.setText("");
       txtTipDoc.setText("");
       JOptionPane.showMessageDialog(null, "Se creo el registro", "Crecion de color",2);//Mensaje de exito (dato 2)
       MenuPrincipal menu = new MenuPrincipal();
       menu.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btnInsertActionPerformed

//---------------------------------------------------------------------------------
//Combobox
//---------------------------------------------------------------------------------    
    
    private void jComboDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDocActionPerformed
        if(b){
        mitipDoc = miLista[jComboDoc.getSelectedIndex()];
        
        txtIniciales.setText(mitipDoc.getStrCInicialesTipoDoc());
        txtTipDoc.setText(mitipDoc.getstrTipDoc()); 

        TipoDocumento mD = new TipoDocumento();
        TipoDocumento[] lD = mD.crudListaTipoDocumento();
        mD=lD[jComboDoc.getSelectedIndex()];
        int varId=mD.getIntIdTipo();
        String varInD=mD.getStrCInicialesTipoDoc();
        String varD = mD.getstrTipDoc();
      
        txtIniciales.setText(varInD);
        txtTipDoc.setText(varD);
        btnInsert.setEnabled(false);
        }
    }//GEN-LAST:event_jComboDocActionPerformed

//---------------------------------------------------------------------------------
//Boton actualizar
//---------------------------------------------------------------------------------    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int t= jComboDoc.getSelectedIndex();
        t= mitipDoc.getIntIdTipo();
        mitipDoc.crudActualizarTipoDocumento(t,txtIniciales.getText(),txtTipDoc.getText());
        txtIniciales.setText(mitipDoc.getStrCInicialesTipoDoc());
        txtTipDoc.setText(mitipDoc.getstrTipDoc());
        
    }//GEN-LAST:event_btnActualizarActionPerformed

//--------------------------------------------------------------------------------------------
//Boton Volver
//--------------------------------------------------------------------------------------------
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FormTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTipoDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTipoDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox jComboDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIniciales;
    private javax.swing.JTextField txtTipDoc;
    // End of variables declaration//GEN-END:variables
}
