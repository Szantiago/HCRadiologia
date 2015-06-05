/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Profesor Jorge Páramo Fonseca
 * HCRadiologia
 * @author Glo System
 * 
 * 
 * Este formulario tiene por fin permitir la interaccion con la tabla ct_eps
 */
package Formulario;

import HCRadiologia.*;
import java.awt.Color;
import javax.swing.JOptionPane;


public class FormEps extends javax.swing.JFrame {
Eps miEps =new Eps();
 Eps[] miLista =miEps.crudListaEps();//array de marcas
 boolean b;

//---------------------------------------------------------------------------------
//Constructor
//---------------------------------------------------------------------------------
    public FormEps() {
        initComponents();
        this.setLocation(320,140);
        setSize(320,300);
        setResizable(false);
        this.getContentPane().setBackground(new Color (47,79,79));
        b=true;
        Eps[] miLista =miEps.crudListaEps();           
        for(int cont=0; cont < miLista.length; cont++ ){
        jComboEps.addItem(miLista[cont].getIntIdEps()+" - "+miLista[cont].getStrNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtEps = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jComboEps = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnDatosEps = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jButton1.setText("Actualizar datos Eps");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(224, 255, 255));
        jLabel1.setText("Código");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 50, 14);

        jLabel2.setForeground(new java.awt.Color(224, 255, 255));
        jLabel2.setText("Eps");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 40, 14);

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar);
        btnInsertar.setBounds(40, 150, 80, 23);

        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(170, 150, 90, 23);

        txtEps.setMargin(new java.awt.Insets(-3, -3, -3, -3));
        getContentPane().add(txtEps);
        txtEps.setBounds(90, 100, 170, 30);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(170, 190, 90, 23);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(40, 190, 80, 23);

        jComboEps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEpsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboEps);
        jComboEps.setBounds(90, 60, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Historia Clinica de Radiologia");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 310, 30);

        btnDatosEps.setText("Ingresar datosde contacto de  Eps");
        btnDatosEps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosEpsActionPerformed(evt);
            }
        });
        getContentPane().add(btnDatosEps);
        btnDatosEps.setBounds(30, 230, 220, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logomedicina.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 0, 260, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//---------------------------------------------------------------------------------
//Boton insertar
//---------------------------------------------------------------------------------    
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
       miEps.crudCrearEps(txtEps.getText());
       txtEps.setText("");
       
       JOptionPane.showMessageDialog(null, "Se creo el registro", "Crecion de color",2);//Mensaje de exito (dato 2)
       MenuPrincipal menu = new MenuPrincipal();
       menu.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_btnInsertarActionPerformed

//---------------------------------------------------------------------------------
//Boton limpiar
//---------------------------------------------------------------------------------    
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       b=false;
       txtEps.setText("");
       btnInsertar.setEnabled(true);
       jComboEps.removeAllItems();
       jComboEps.repaint();
       
        for(int cont=0; cont < miLista.length; cont++ ){
        jComboEps.addItem(miLista[cont].getIntIdEps()+miLista[cont].getStrNombre());
        }
        jComboEps.setSelectedIndex(0);
        b=true;
    }//GEN-LAST:event_btnClearActionPerformed

//---------------------------------------------------------------------------------
//Boton actualizar
//---------------------------------------------------------------------------------    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        int t= jComboEps.getSelectedIndex();
        t= miEps.getIntIdEps();
        
        miEps.crudActualizarEps(t,txtEps.getText());
        txtEps.setText(miEps.getStrNombre());
        btnActualizar.setEnabled(false);
        btnInsertar.setEnabled(false);
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jComboEpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEpsActionPerformed
         if(b){
        miEps = miLista[jComboEps.getSelectedIndex()];
        
        
        txtEps.setText(miEps.getStrNombre()); 

        Eps mD = new Eps();
        Eps[] lD = mD.crudListaEps();
        mD=lD[jComboEps.getSelectedIndex()];
        int varId=mD.getIntIdEps();
        String varInD=mD.getStrNombre();
        
        txtEps.setText(varInD);
        btnActualizar.setEnabled(true);
        btnInsertar.setEnabled(false);
        }
    }//GEN-LAST:event_jComboEpsActionPerformed

    private void btnDatosEpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosEpsActionPerformed
        FormDatosContactoEps dat = new FormDatosContactoEps();
        dat.txtIdEps.setText(jComboEps.getSelectedItem().toString());
        dat.txtEpsD.setText(""+Integer.parseInt(""+(jComboEps.getSelectedIndex()+1)));
        dat.txtIdEps.setEditable(false);
        dat.txtEpsD.setVisible(false);
        dat.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnDatosEpsActionPerformed

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
            java.util.logging.Logger.getLogger(FormEps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEps().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDatosEps;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboEps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtEps;
    // End of variables declaration//GEN-END:variables
}
