/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.vistas.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.control.VueloJpaController;
import proyecto.entidades.VistaVuelos;
import proyecto.entidades.Vuelo;

/**
 *
 * @author David
 */
public class resultadosIda extends javax.swing.JFrame {
    private static String origen;
    private static String destino;
    private static Date fechaIda;
    private static int nAdultos;
    private static int nMenores;
    private static int idVueloSelected;
    private static DefaultTableModel modeloResultados;
    private static VueloJpaController vuelosControl= new VueloJpaController(); 
    private static double totalPago;
    private static String claseVuelo;
    /**
     * Creates new form resultadosIda
     */
    public resultadosIda(String origen, String destino, Date fechaIda, int nAdultos, int nMenores, String claseVuelo) {
        initComponents();
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.nAdultos = nAdultos;
        this.nMenores = nMenores;
        this.claseVuelo = claseVuelo;
        System.out.println(claseVuelo);
        System.out.println(""+this.origen+" "+this.destino+" "+this.fechaIda+" "+this.nAdultos+" "+this.nMenores);
           listarResultados(this.origen, this.destino, this.fechaIda,this.nAdultos+this.nMenores);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vueloId = new javax.swing.JLabel();
        fechaVuelo = new javax.swing.JLabel();
        origenVuelo = new javax.swing.JLabel();
        destinoVuelo = new javax.swing.JLabel();
        tiempoEstimado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        kButton1 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(123, 123, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(253, 166, 253));

        jPanel1.setOpaque(false);

        jLabel2.setText("Informacion de selección: ");

        jLabel3.setText("Vuelo:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Origen:");

        jLabel6.setText("Destino:");

        tiempoEstimado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setText("Total: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(destinoVuelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(origenVuelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaVuelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vueloId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tiempoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(794, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vueloId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(fechaVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(origenVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(destinoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tiempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        resultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resultados de busqueda");

        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-back-arrow-16.png"))); // NOI18N
        kButton1.setText("Regresar");
        kButton1.setkEndColor(new java.awt.Color(140, 126, 242));
        kButton1.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(204, 204, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(170, 61, 250));
        kButton1.setkStartColor(new java.awt.Color(204, 176, 252));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-ball-point-pen-16.png"))); // NOI18N
        kButton2.setText("Reservar");
        kButton2.setkEndColor(new java.awt.Color(140, 126, 242));
        kButton2.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(204, 204, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(170, 61, 250));
        kButton2.setkStartColor(new java.awt.Color(204, 176, 252));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadosMouseClicked
        int row = resultados.getSelectedRow();

        double totalMenores = Double.parseDouble(modeloResultados.getValueAt(row, 5).toString())*nMenores*0.5;
        double totalAdultos =Double.parseDouble(modeloResultados.getValueAt(row, 5).toString())*nAdultos;
        totalPago = totalMenores+totalAdultos;
        vueloId.setText(modeloResultados.getValueAt(row, 0).toString());
        fechaVuelo.setText(modeloResultados.getValueAt(row, 2).toString());
        origenVuelo.setText(modeloResultados.getValueAt(row, 3).toString());
        destinoVuelo.setText(modeloResultados.getValueAt(row, 4).toString());
        tiempoEstimado.setText(String.valueOf(totalPago));
        idVueloSelected = Integer.parseInt(vueloId.getText());
        
    }//GEN-LAST:event_resultadosMouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        new proyecto.vistas.usuario.FormBusqueda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println(idVueloSelected);
        int[] vuelos = {idVueloSelected}; 
        new proyecto.vistas.usuario.fReserva(vuelos, "Solo Ida", totalPago, nAdultos+nMenores).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(resultadosIda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultadosIda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultadosIda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultadosIda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resultadosIda("Quito", "s", new GregorianCalendar(3920, 10, 10).getTime(), 1, 1, "Económica").setVisible(true);
            }
        });
    }

    
    private void listarResultados(String origen, String destino, Date fecha, int pasajeros) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            String fechaQ = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
            
            Query query = em.createNativeQuery("SELECT * FROM VISTA_VUELOS AS V WHERE V.ORIGEN='"+origen+"' AND v.destino='"+destino+"' AND v.FECHA='"+fechaQ+"' AND v.VACANTES>"+pasajeros+"", VistaVuelos.class);
            List<VistaVuelos> vuelos = query.getResultList();
            if(vuelos.size()<1){
                JOptionPane.showMessageDialog(null, "No se han encontrado vuelos en el sistema para los datos especificados, vuelva a la ventana de busqueda y realice otra busqueda");
                return;
            }
            for (VistaVuelos vuelo : vuelos) {
                System.out.println(vuelo.getOrigen());
            }
            
            String[] tableTitles = {"ID VUELO", "FECHA", "VACANTES","ORIGEN", "DESTINO", "TIEMPO ESTIMADO", "VACANTES", "AEROLINEA","ID AVION","MODELO"};
            modeloResultados = new DefaultTableModel(null, tableTitles);
            String[] vuelo;
            vuelo = new String[10];
            for (VistaVuelos iteVuelo : vuelos) {
                vuelo[0] = iteVuelo.getIdVuelo()+"";
                vuelo[1] = iteVuelo.getFecha()+"";
                vuelo[2] = iteVuelo.getVacantes().toString();
                vuelo[3] = iteVuelo.getOrigen();
                vuelo[4] = iteVuelo.getDestino();
                vuelo[5] = iteVuelo.getTiempoEstimado().toString();
                vuelo[6] = iteVuelo.getVacantes().toString();
                vuelo[7] = iteVuelo.getNombre();
                vuelo[8] = iteVuelo.getIdAvion()+"";
                vuelo[9] = iteVuelo.getModelo();
                modeloResultados.addRow(vuelo);
            }
            resultados.setModel(modeloResultados);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel destinoVuelo;
    private javax.swing.JLabel fechaVuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel origenVuelo;
    private javax.swing.JTable resultados;
    private javax.swing.JLabel tiempoEstimado;
    private javax.swing.JLabel vueloId;
    // End of variables declaration//GEN-END:variables
}
