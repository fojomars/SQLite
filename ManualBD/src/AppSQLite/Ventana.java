/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppSQLite;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fojomars
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Tabla
     */
    MetodosSQLite m = new MetodosSQLite();
    ArrayList<Integer> nclientes = new ArrayList<>();

    public Ventana() {
        initComponents();
        m.conectar();
        m.crearTablaTienda();
        m.insertarCliente(1, "Juan", 698125453);
        m.insertarCliente(2, "Pepe", 689531456);
        m.insertarCliente(3, "Ana", 678523698);
        m.insertarCliente(4, "Maria", 678952456);
        m.insertarCliente(5, "Juan", 627225411);
        m.insertarCliente(6, "Emilio", 627225411);

    }

    public void insertarClientes(int id, String nombre, int telefono) {
        m.insertarCliente(id, nombre, telefono);
        String[] client = m.devolverCliente(id).split(",");
        DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
        model.addRow(new Object[]{client[0], client[1], client[2]});
        nclientes.add(id);
    }

    public void borrarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
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

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        cbConsulta = new javax.swing.JComboBox<>();
        tConsulta = new javax.swing.JTextField();
        bConsulta = new javax.swing.JButton();
        bMostrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        tNombreM = new javax.swing.JTextField();
        tTelefonoM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tTelefono = new javax.swing.JTextField();
        bAñadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Telefono", " " }));
        cbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConsultaActionPerformed(evt);
            }
        });

        bConsulta.setText("Consultar");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });

        bMostrar.setText("Mostrar");
        bMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre");

        jLabel8.setText("Telefono");

        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        jLabel1.setText("NOMBRE");

        jLabel2.setText("TELEFONO");

        jLabel3.setText("ID");

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tTelefonoM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(bConsulta))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(bModificar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(bMostrar)
                                .addGap(18, 18, 18)
                                .addComponent(bBorrar))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(bAñadir)))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tTelefonoM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(12, 12, 12)
                                .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 69, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento del botón Borrar, que elimina una fila de la tabla alumnos al seleccionarla
    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        int fila = tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        } else {
            int id = Integer.parseInt(tablaClientes.getValueAt(fila, 0).toString());
            for (int i = 0; i < nclientes.size(); i++) {
                if (nclientes.get(i) == id) {
                    nclientes.remove(i);
                }
            }
            m.borrarCliente(id);
            bMostrarActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        }
    }//GEN-LAST:event_bBorrarActionPerformed


    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        int fila = tablaClientes.getSelectedRow();
                
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        } else {
            String nombre = tNombreM.getText();
            int telefono = Integer.parseInt(tTelefonoM.getText());
            int id = Integer.parseInt(tablaClientes.getValueAt(fila, 0).toString());
            m.modificarCliente(nombre, telefono, id);
            bMostrarActionPerformed(evt);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarActionPerformed
        borrarTabla(tablaClientes);
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            ResultSet rs = Mostrar.getTabla("select * from clientes");
            modelo.setColumnIdentifiers(new Object[]{"id", "nombre", "telefono"});
            try {
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getInt("id"), rs.getString("nombre"), rs.getInt("telefono")});
                }
                tablaClientes.setModel(modelo);
            } catch (Exception e) {
                System.out.println("Error al realizar la consulta");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bMostrarActionPerformed

    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        borrarTabla(tablaClientes);
        String opcion = cbConsulta.getSelectedItem().toString();
        String buscar = tConsulta.getText();
        switch (opcion) {
            case "ID":
                opcion = "id";
                break;
            case "Nombre":
                opcion = "nombre";
                break;
            case "Telefono":
                opcion = "telefono";
                break;
            default:
                opcion = "nombre";
                break;
        }
        ArrayList<String> clientes = m.consultaClientes(opcion, buscar);
        for (int i = 0; i < clientes.size(); i++) {
            int id = Integer.parseInt(clientes.get(i).split(",")[0]);
            String[] cliente = m.devolverCliente(id).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
            model.addRow(new Object[]{cliente[0], cliente[1], cliente[2]});
        }
    }//GEN-LAST:event_bConsultaActionPerformed

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        int fila = tablaClientes.getSelectedRow();
        int id, telefono;
        String nombre;
        id = Integer.parseInt(tID.getText());
        nombre = tNombre.getText();
        telefono = Integer.parseInt(tTelefono.getText());

        if(fila == -1){
            m.insertarCliente(id, nombre, telefono);
           JOptionPane.showMessageDialog(null,"Cliente añadido");
        }
        else{
            JOptionPane.showMessageDialog(null,"Error al añadir el cliente o puede que el id ya exista");
        }
        
        
    }//GEN-LAST:event_bAñadirActionPerformed

    private void cbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bMostrar;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tConsulta;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tNombreM;
    private javax.swing.JTextField tTelefono;
    private javax.swing.JTextField tTelefonoM;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
