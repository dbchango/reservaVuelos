/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.tests;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.control.AvionJpaController;
import proyecto.control.VistaAvionesJpaController;

import proyecto.entidades.Avion;
import proyecto.entidades.Vuelo;
import proyecto.control.VueloJpaController;
import proyecto.entidades.Pasajero;
import proyecto.entidades.Reserva;
import proyecto.entidades.Usuario;
import proyecto.entidades.VistaAviones;
import proyecto.entidades.VistaReserva;
import proyecto.entidades.VistaVuelos;

/**
 *
 * @author David
 */
public class NewClass {
    
    public static void main(String[] args) {
        /*try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            VistaAvionesJpaController avionesJPA = new VistaAvionesJpaController();
            List<VistaAviones> aviones =  avionesJPA.findVistaAvionesEntities();
            for (VistaAviones avione : aviones) {
                System.out.println(avione.getMarca());
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }*/
        /*
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            String origen = "Quito";
            String destino = "Madrid";
            Date calendar = new GregorianCalendar(3920, 10, 10).getTime();
            String full = new SimpleDateFormat("yyyy-MM-dd").format(calendar);
            System.out.println(full);
            Query query = em.createNativeQuery("SELECT * FROM VISTA_VUELOS AS V WHERE V.ORIGEN='"+origen+"' AND v.destino='"+destino+"' AND v.FECHA='"+full+"'", VistaVuelos.class);
            List<VistaVuelos> vuelos = query.getResultList();
            for (VistaVuelos vuelo : vuelos) {
                System.out.println(vuelo.getOrigen());
            }
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }*/
        
        
        
        
        
        /*
        try{
            VueloJpaController vueloControl = new VueloJpaController();
        AvionJpaController avionControl = new AvionJpaController();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
        EntityManager em = emf.createEntityManager();
        
        Vuelo vuelo = new Vuelo();
        vuelo.setDestino("Madrid");
        vuelo.setOrigen("Bogota");
        vuelo.setVacantes(32);
        vuelo.setTiempoEstimado(BigDecimal.valueOf(24.56));
        vuelo.setFecha(new GregorianCalendar().getTime());
        Avion avion = new Avion();
        avion = avionControl.findAvion(1);
        vuelo.setIdAvion(avion);
        em.getTransaction().begin();
        em.persist(vuelo);
        em.flush();
            System.out.println(vuelo.getIdVuelo());
        em.getTransaction().commit();
        em.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }*/
        /*
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            List resultados  = em.createNativeQuery("exec reporteVuelos").getResultList();
            for (Object resultado : resultados) {
                System.out.println(resultado.getClass());
            }
            em.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }*/
        
        /*
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
            EntityManager em = emf.createEntityManager();
            Usuario usuario = new Usuario();
            Usuario usref = new Usuario();
            Reserva reserva = new Reserva();
            usuario.setCedula("1804726113");
            usuario.setCelular("0984593359");
            usuario.setEmail("david@prueba.com");
            usuario.setNombre("David");
            usuario.setTelefono("032831467");
            usuario.setTipoDocumento("Cedula");
            reserva.setEstado("Creador");
            reserva.setFechaRegistro(new GregorianCalendar().getTime());
            reserva.setTipo("Solo ida");
            reserva.setTotal(BigDecimal.valueOf(1855.25));
            int idUsuario;
            em.getTransaction().begin();
            em.persist(usuario);
            em.flush();
            idUsuario = usuario.getIdUsuario();
            usref.setIdUsuario(idUsuario);
            System.out.println(idUsuario);
            reserva.setIdUsuario(usuario);
            em.persist(reserva);
            
            System.out.println(reserva.getIdUsuario());
            em.getTransaction().commit();
            em.close();
        }catch(Exception ex){
            
        }*/
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM vistaReserva where ID_RESERVA="+10, VistaReserva.class);
            List<VistaReserva> vuelos = query.getResultList();
            String[] titulos = {"ID RESERVA", "FECHA REGISTRO", "FECHA DE VUELO", "ORIGEN", "DESTINO"};
            DefaultTableModel modelVuelos = new DefaultTableModel(null, titulos);
            String[] rowvuelo = new String[5];
            for (VistaReserva vuelo : vuelos) {
                System.out.println(vuelo.getIdReserva());
                System.out.println(vuelo.getFechaRegistro().toString());
                System.out.println(vuelo.getFecha().toString());
                System.out.println(vuelo.getOrigen());
                System.out.println(rowvuelo[4] = vuelo.getDestino());
               
            }
            
           

    }
}
