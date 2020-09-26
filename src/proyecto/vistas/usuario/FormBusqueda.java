/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.vistas.usuario;

import proyecto.control.AerolineaJpaController;
import proyecto.entidades.Aerolinea;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.vistas.MainWindow;

/**
 *
 * @author David
 */
public class FormBusqueda extends javax.swing.JFrame {
    AerolineaJpaController AeroControl = new AerolineaJpaController();
    private static Date fechaida;
    private static Date fechaRetorno;
    private static String origen;
    private static String destino;
    private static int nAdultos;
    private static int nMenores;
    
    /**
     * Creates new form FormBusqueda
     */
    public FormBusqueda() {
        initComponents();
        Cargar_Info();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReservaOptions = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jPanel7 = new javax.swing.JPanel();
        destinoSoloIda = new javax.swing.JTextField();
        destinoIVlbl1 = new javax.swing.JLabel();
        origenSoloIda = new javax.swing.JTextField();
        origenIVLbl1 = new javax.swing.JLabel();
        fechaSoloIDa = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        numAdultosI = new com.toedter.components.JSpinField();
        numMenoresI = new com.toedter.components.JSpinField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        claseVueloI = new javax.swing.JComboBox<>();
        kButton3 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();
        jPanel3 = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jPanel9 = new javax.swing.JPanel();
        destinoIdaIIV = new javax.swing.JTextField();
        destinoIVlbl3 = new javax.swing.JLabel();
        origenIdaIV = new javax.swing.JTextField();
        origenIVLbl3 = new javax.swing.JLabel();
        fechaIdaIV = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fechaVueltaIV = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        numAdultosIV = new com.toedter.components.JSpinField();
        numMenoresIV = new com.toedter.components.JSpinField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        claseVueloIV = new javax.swing.JComboBox<>();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(226, 251, 252));

        kGradientPanel4.setkEndColor(new java.awt.Color(123, 123, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(253, 166, 253));

        jPanel7.setBackground(new java.awt.Color(243, 252, 253));
        jPanel7.setOpaque(false);

        destinoSoloIda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        destinoSoloIda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        destinoSoloIda.setOpaque(false);
        destinoSoloIda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoSoloIdaActionPerformed(evt);
            }
        });

        destinoIVlbl1.setText("Destino");

        origenSoloIda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        origenSoloIda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        origenSoloIda.setOpaque(false);

        origenIVLbl1.setText("Origen");

        jLabel11.setText("Fecha ida");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fechaSoloIDa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(origenSoloIda, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origenIVLbl1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destinoIVlbl1)
                            .addComponent(destinoSoloIda, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(origenIVLbl1)
                    .addComponent(destinoIVlbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(origenSoloIda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoSoloIda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaSoloIDa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(226, 251, 252));
        jPanel6.setOpaque(false);

        jLabel10.setText("Pasajeros y clase");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Adulto");

        jLabel14.setText("Desde 10 años");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Menores");

        jLabel16.setText("Hasta 17 años");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Clase");

        claseVueloI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        claseVueloI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Económica", "Premium economy", "Ejecutiva/Busines", "Primera clase" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(185, 185, 185)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claseVueloI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numMenoresI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAdultosI, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(numAdultosI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16))
                    .addComponent(numMenoresI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(claseVueloI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-search-16.png"))); // NOI18N
        kButton3.setText("Buscar");
        kButton3.setkEndColor(new java.awt.Color(140, 126, 242));
        kButton3.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton3.setkHoverForeGround(new java.awt.Color(204, 204, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(170, 61, 250));
        kButton3.setkStartColor(new java.awt.Color(204, 176, 252));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-back-arrow-16.png"))); // NOI18N
        kButton2.setText("Regresar");
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

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(512, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        ReservaOptions.addTab("Solo ida", jPanel2);

        jPanel3.setBackground(new java.awt.Color(226, 251, 252));
        jPanel3.setForeground(new java.awt.Color(226, 251, 252));

        kGradientPanel3.setkEndColor(new java.awt.Color(123, 123, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(253, 166, 253));

        jPanel9.setBackground(new java.awt.Color(243, 252, 253));
        jPanel9.setOpaque(false);

        destinoIdaIIV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        destinoIdaIIV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        destinoIdaIIV.setOpaque(false);
        destinoIdaIIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoIdaIIVActionPerformed(evt);
            }
        });

        destinoIVlbl3.setText("Destino");

        origenIdaIV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        origenIdaIV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        origenIdaIV.setOpaque(false);

        origenIVLbl3.setText("Origen");

        jLabel12.setText("Fecha ida");

        jLabel19.setText("Fecha vuelta");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(175, 175, 175)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaVueltaIV, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fechaIdaIV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(origenIdaIV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origenIVLbl3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destinoIVlbl3)
                            .addComponent(destinoIdaIIV, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(origenIVLbl3)
                    .addComponent(destinoIVlbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(origenIdaIV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoIdaIIV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaIdaIV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaVueltaIV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(226, 251, 252));
        jPanel10.setForeground(new java.awt.Color(226, 251, 252));
        jPanel10.setOpaque(false);

        jLabel32.setText("Pasajeros y clase");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Adulto");

        jLabel34.setText("Desde 10 años");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Menores");

        jLabel36.setText("Hasta 17 años");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Clase");

        claseVueloIV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        claseVueloIV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Económica", "Premium economy", "Ejecutiva/Busines", "Primera clase" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(185, 185, 185)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claseVueloIV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numMenoresIV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAdultosIV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34))
                    .addComponent(numAdultosIV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36))
                    .addComponent(numMenoresIV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(claseVueloIV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-search-16.png"))); // NOI18N
        kButton4.setText("Buscar");
        kButton4.setkEndColor(new java.awt.Color(140, 126, 242));
        kButton4.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton4.setkHoverForeGround(new java.awt.Color(204, 204, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(170, 61, 250));
        kButton4.setkStartColor(new java.awt.Color(204, 176, 252));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/imgs/icons8-back-arrow-16.png"))); // NOI18N
        kButton5.setText("Regresar");
        kButton5.setkEndColor(new java.awt.Color(140, 126, 242));
        kButton5.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton5.setkHoverForeGround(new java.awt.Color(204, 204, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(170, 61, 250));
        kButton5.setkStartColor(new java.awt.Color(204, 176, 252));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(520, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        ReservaOptions.addTab("Ida y vuelta", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ReservaOptions)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ReservaOptions)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void destinoSoloIdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoSoloIdaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoSoloIdaActionPerformed

    private void destinoIdaIIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoIdaIIVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoIdaIIVActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        try{
            String claseVuelo  = claseVueloIV.getSelectedItem().toString();
            nAdultos = numAdultosIV.getValue();
            nMenores = numMenoresIV.getValue();
            fechaida = fechaIdaIV.getCalendar().getTime();
            fechaRetorno = fechaVueltaIV.getCalendar().getTime();
            origen = origenIdaIV.getText();
            destino = destinoIdaIIV.getText();
            System.out.println(origen + " " + destino);
            new IdaVueltaResultados(origen, destino, fechaida, nAdultos, nMenores, fechaRetorno, claseVuelo).setVisible(true);
            this.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Revise su formulario, todos los datos son requeridos para realizar la búsqueda "+e);
        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        try{
            String claseVuelo = claseVueloI.getSelectedItem().toString();
            nAdultos = numAdultosI.getValue();
            nMenores = numMenoresI.getValue();
            fechaida = fechaSoloIDa.getCalendar().getTime();
            origen = origenSoloIda.getText();
            destino = destinoSoloIda.getText();

            new resultadosIda(origen, destino, fechaida, nAdultos, nMenores, claseVuelo).setVisible(true);
            this.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Revise su formulario, todos los datos son requeridos para realizar la búsqueda "+e);
        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        new MainWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        new MainWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
/*    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBusqueda().setVisible(true);
            }
        });
    }*/
    
    private void Cargar_Info(){
        try{
            Object O = null;
            System.out.println(AeroControl.findAerolinea(1).getNombre());
            List<Aerolinea> lista = AeroControl.findAerolineaEntities();

        }catch(Exception e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ReservaOptions;
    private javax.swing.JComboBox<String> claseVueloI;
    private javax.swing.JComboBox<String> claseVueloIV;
    private javax.swing.JLabel destinoIVlbl1;
    private javax.swing.JLabel destinoIVlbl3;
    private javax.swing.JTextField destinoIdaIIV;
    private javax.swing.JTextField destinoSoloIda;
    private com.toedter.calendar.JDateChooser fechaIdaIV;
    private com.toedter.calendar.JDateChooser fechaSoloIDa;
    private com.toedter.calendar.JDateChooser fechaVueltaIV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private com.toedter.components.JSpinField numAdultosI;
    private com.toedter.components.JSpinField numAdultosIV;
    private com.toedter.components.JSpinField numMenoresI;
    private com.toedter.components.JSpinField numMenoresIV;
    private javax.swing.JLabel origenIVLbl1;
    private javax.swing.JLabel origenIVLbl3;
    private javax.swing.JTextField origenIdaIV;
    private javax.swing.JTextField origenSoloIda;
    // End of variables declaration//GEN-END:variables
}
