/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.vistas.gestion;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import proyecto.control.AerolineaJpaController;
import proyecto.control.AvionJpaController;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Aerolinea;
import proyecto.entidades.Avion;

/**
 *
 * @author David
 */
public class GestionAviones extends JPanel {
    private static AerolineaJpaController aerolineasController = new AerolineaJpaController();    
    private static DefaultTableModel aerolineasModel;
    private static DefaultTableModel avionesModel;
    private static AvionJpaController avionesController = new AvionJpaController();
    
    public GestionAviones() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
            listarAerolineas();
            listarAviones();
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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Proyecto_DespegarPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Avion a");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        idAvionLabel = new javax.swing.JLabel();
        capacidadLabel = new javax.swing.JLabel();
        marcaLabel = new javax.swing.JLabel();
        modeloLabel = new javax.swing.JLabel();
        idAerolineaLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAerolineas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idAerolinea = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAviones = new javax.swing.JTable();
        idAvionField = new javax.swing.JTextField();
        capacidadField = new javax.swing.JTextField();
        marcaField = new javax.swing.JTextField();
        modeloField = new javax.swing.JTextField();
        deleteButton1 = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        idAvionLabel.setText("Id Avion:");

        capacidadLabel.setText("Capacidad:");

        marcaLabel.setText("Marca:");

        modeloLabel.setText("Modelo:");

        idAerolineaLabel.setText("Id Aerolinea:");

        saveButton.setText("Save");
        saveButton.addActionListener(formListener);

        newButton.setText("New");
        newButton.addActionListener(formListener);

        listaAerolineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listaAerolineas.addMouseListener(formListener);
        jScrollPane1.setViewportView(listaAerolineas);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione la aerolínea a la que pertenece el avión");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestion de aviones");

        idAerolinea.setEditable(false);

        listaAviones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listaAviones.addMouseListener(formListener);
        jScrollPane2.setViewportView(listaAviones);

        idAvionField.setEditable(false);

        deleteButton1.setText("Delete");
        deleteButton1.addActionListener(formListener);

        regresar.setText("Regresar");
        regresar.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idAvionLabel)
                                    .addComponent(capacidadLabel)
                                    .addComponent(marcaLabel)
                                    .addComponent(modeloLabel)
                                    .addComponent(idAerolineaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(idAerolinea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(idAvionField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(capacidadField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(marcaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(modeloField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addGap(10, 10, 10)
                                .addComponent(deleteButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton))
                            .addComponent(regresar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAvionLabel)
                            .addComponent(idAvionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadLabel)
                            .addComponent(capacidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(marcaLabel)
                            .addComponent(marcaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modeloLabel)
                            .addComponent(modeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAerolineaLabel)
                            .addComponent(idAerolinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(newButton)
                            .addComponent(deleteButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar)))
                .addContainerGap())
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                GestionAviones.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                GestionAviones.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton1) {
                GestionAviones.this.deleteButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == regresar) {
                GestionAviones.this.regresarActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == listaAerolineas) {
                GestionAviones.this.listaAerolineasMouseClicked(evt);
            }
            else if (evt.getSource() == listaAviones) {
                GestionAviones.this.listaAvionesMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
      
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void listarAerolineas(){    
        List<Aerolinea> aerolineas = aerolineasController.findAerolineaEntities();
        String[] titles = {"ID AEROLINEA", "NOMBRE", "PÁGINA WEB"};
        aerolineasModel = new DefaultTableModel(null, titles);
        String[] aerolinea;
        aerolinea = new String[3];
        for (Aerolinea item : aerolineas) {
            aerolinea[0] = item.getIdAerolinea().toString();
            aerolinea[1] = item.getNombre();
            aerolinea[2] = item.getPaginaweb();
            aerolineasModel.addRow(aerolinea);
        }
        listaAerolineas.setModel(aerolineasModel);
                
    }
    
    
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            Aerolinea a = aerolineasController.findAerolinea(Integer.parseInt(idAerolinea.getText()));
            Avion av = new Avion();
            av.setCapacidad(Integer.parseInt(capacidadField.getText()));
            av.setIdAerolinea(a);
            av.setMarca(marcaField.getText());
            av.setModelo(modeloField.getText());
            avionesController.create(av);
            listarAviones();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<proyecto.entidades.Avion> merged = new ArrayList<proyecto.entidades.Avion>(list.size());
            for (proyecto.entidades.Avion a : list) {
                merged.add(entityManager.merge(a));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void listaAerolineasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAerolineasMouseClicked
        // TODO add your handling code here:
        int row = listaAerolineas.getSelectedRow();
        idAerolinea.setText(aerolineasModel.getValueAt(row, 0).toString());
               
    }//GEN-LAST:event_listaAerolineasMouseClicked

    private void listaAvionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAvionesMouseClicked
        // TODO add your handling code here:
        int row = listaAviones.getSelectedRow();
        idAvionField.setText(avionesModel.getValueAt(row, 0).toString());
        capacidadField.setText(avionesModel.getValueAt(row, 1).toString());
        marcaField.setText(avionesModel.getValueAt(row, 2).toString());
        modeloField.setText(avionesModel.getValueAt(row, 3).toString());
        idAerolinea.setText(avionesModel.getValueAt(row, 4).toString());
        
    }//GEN-LAST:event_listaAvionesMouseClicked

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int row = listaAviones.getSelectedRow();
            String ida =  idAvionField.getText();
            avionesController.destroy(Integer.parseInt(ida));
            listarAviones();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestionAviones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        new GestionMain().setVisible(true);
        
    }//GEN-LAST:event_regresarActionPerformed

    private void listarAviones(){
        String[] titulos = {"ID AVION","CAPACIDAD","MARCA","MODELO","ID_AEROLINEA"};
        String[] avion;
        avion = new String[5];
        List<Avion> aviones =  avionesController.findAvionEntities();
        avionesModel = new DefaultTableModel(null, titulos);
        for (Avion item : aviones) {
            avion[0] = item.getIdAvion().toString();
            avion[1] = item.getCapacidad().toString();
            avion[2] = item.getMarca();
            avion[3] = item.getModelo();
            avion[4] = item.getIdAerolinea().toString();
            avionesModel.addRow(avion);
        }
        listaAviones.setModel(avionesModel);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capacidadField;
    private javax.swing.JLabel capacidadLabel;
    private javax.swing.JButton deleteButton1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField idAerolinea;
    private javax.swing.JLabel idAerolineaLabel;
    private javax.swing.JTextField idAvionField;
    private javax.swing.JLabel idAvionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.util.List<proyecto.entidades.Avion> list;
    private javax.swing.JTable listaAerolineas;
    private javax.swing.JTable listaAviones;
    private javax.swing.JTextField marcaField;
    private javax.swing.JLabel marcaLabel;
    private javax.swing.JTextField modeloField;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton regresar;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(GestionAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new GestionAviones());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
