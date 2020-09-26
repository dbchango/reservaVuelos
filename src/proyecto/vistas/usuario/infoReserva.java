/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.vistas.usuario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.control.ReservaJpaController;
import proyecto.entidades.Pasajero;
import proyecto.entidades.Reserva;
import proyecto.entidades.VistaReserva;

/**
 *
 * @author David
 */
public class infoReserva extends javax.swing.JFrame {
    private static int idReserva;
    private static ReservaJpaController controladorReservas = new ReservaJpaController();
    private static DefaultTableModel modelVuelos;
    private static DefaultTableModel modelPasajeros;
    private static Reserva reserva;
    
    /**
     * Creates new form infoReserva
     */
    public infoReserva(int idReserva) {
        initComponents();
        this.idReserva = idReserva;
        cargarReserva();
        cargarPasajeros();
        cargarVuelos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        tipoReserva = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVuelos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        totalReserva = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPasajeros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoReserva = new javax.swing.JLabel();
        estadoReserva = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaRegistroReserva = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel2.setkEndColor(new java.awt.Color(183, 202, 253));
        kGradientPanel2.setkStartColor(new java.awt.Color(217, 213, 254));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Estado");
        kGradientPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 140, -1));
        kGradientPanel2.add(tipoReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 140, 20));

        listaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(listaVuelos);

        kGradientPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 785, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Fecha de registro");
        kGradientPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 140, -1));

        totalReserva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kGradientPanel2.add(totalReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 140, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tipo de reserva");
        kGradientPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, -1));

        listaPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(listaPasajeros);

        kGradientPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 785, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pasajeros");
        kGradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 785, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Total");
        kGradientPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vuelos");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 785, -1));
        kGradientPanel2.add(codigoReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 140, 20));
        kGradientPanel2.add(estadoReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 140, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Código de la reserva");
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 140, -1));
        kGradientPanel2.add(fechaRegistroReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 140, 20));

        jLabel28.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Información de la reserva");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel28.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel28.setMaximumSize(new java.awt.Dimension(39, 14));
        kGradientPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 780, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-document-48.png"))); // NOI18N
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(infoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new infoReserva(26).setVisible(true);
            }
        });
    }
    
    private void cargarVuelos(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            em = emf.createEntityManager();
            em.getTransaction();
            Query query = em.createNativeQuery("SELECT * FROM vistaReserva where ID_RESERVA="+idReserva, VistaReserva.class);
            List<VistaReserva> vuelos = query.getResultList();
            String[] titulos = {"ID RESERVA", "FECHA REGISTRO", "FECHA DE VUELO", "ORIGEN", "DESTINO"};
            modelVuelos = new DefaultTableModel(null, titulos);
            String[] rowvuelo = new String[5];
            for (VistaReserva vuelo : vuelos) {
                rowvuelo[0] = vuelo.getIdReserva()+"";
                rowvuelo[1] = vuelo.getFechaRegistro().toString();
                rowvuelo[2] = vuelo.getFecha().toString();
                rowvuelo[3] = vuelo.getOrigen();
                rowvuelo[4] = vuelo.getDestino();
                modelVuelos.addRow(rowvuelo);
            }
            
            listaVuelos.setModel(modelVuelos);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }
    
    private void cargarReserva(){
        reserva = controladorReservas.findReserva(idReserva);
        codigoReserva.setText(reserva.getIdReserva().toString());
        estadoReserva.setText(reserva.getEstado());
        fechaRegistroReserva.setText(reserva.getFechaRegistro().toString());
        tipoReserva.setText(reserva.getTipo());
        totalReserva.setText(reserva.getTotal().toString());
    }
    
    private void cargarPasajeros(){
        try {
            
            
            List<Pasajero> pasajeros = reserva.getPasajeroList();
            String[] titulos = { "CEDULA", "NOMBRE", "EDAD", "FECHA DE NACIMIENTO", "GENERO"};
            String[] pasajero;
            pasajero = new String[5];
            modelPasajeros = new DefaultTableModel(null, titulos);
            for (Pasajero item : pasajeros) {
                pasajero[0] = item.getCedula();
                pasajero[1] = item.getNombre();
                pasajero[2] = item.getEdad().toString();
                pasajero[3] = item.getFechaNacimiento().toString();
                pasajero[4] = item.getGenero();
                modelPasajeros.addRow(pasajero);
            }
            listaPasajeros.setModel(modelPasajeros);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoReserva;
    private javax.swing.JLabel estadoReserva;
    private javax.swing.JLabel fechaRegistroReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTable listaPasajeros;
    private javax.swing.JTable listaVuelos;
    private javax.swing.JLabel tipoReserva;
    private javax.swing.JLabel totalReserva;
    // End of variables declaration//GEN-END:variables
}
