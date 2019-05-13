package Snake;

import javax.swing.JOptionPane;
/**
 *
 * @author Danny Rojas Arguedas
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setSize(620, 670);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cantManzanas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("¿Cuántas manzanas desea colocar?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 217, -1));
        getContentPane().add(cantManzanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 217, -1));

        jLabel2.setText("Elija el mapa que desee:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map1.JPG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 220, 200));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map2.JPG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 220, 200));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map3.JPG"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 220, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cantManzanas.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de manzanas a mostrar!");
        } else {
            try {
                int manzanas = Integer.parseInt(cantManzanas.getText());
                if (manzanas > 52) {
                    JOptionPane.showMessageDialog(this, "No puedes colocar más manzanas que los espacios que hay disponibles!");
                } else {
                    GameFrame newFrame = new GameFrame(manzanas, 3);
                    newFrame.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "La cantidad de manzanas debe ser numérica!");

            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cantManzanas.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de manzanas a mostrar!");
        } else {
            try {
                int manzanas = Integer.parseInt(cantManzanas.getText());
                if (manzanas > 64) {
                    JOptionPane.showMessageDialog(this, "No puedes colocar más manzanas que los espacios que hay disponibles!");
                } else {
                    GameFrame newFrame = new GameFrame(manzanas, 2);
                    newFrame.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "La cantidad de manzanas debe ser numérica!");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cantManzanas.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cantidad de manzanas a mostrar!");
        } else {
            try {
                int manzanas = Integer.parseInt(cantManzanas.getText());
                if (manzanas > 75) {
                    JOptionPane.showMessageDialog(this, "No puedes colocar más manzanas que los espacios que hay disponibles!");
                } else {
                    GameFrame newFrame = new GameFrame(manzanas, 1);
                    newFrame.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "La cantidad de manzanas debe ser numérica!");

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantManzanas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
