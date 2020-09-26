/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.control;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import proyecto.entidades.Avion;
import proyecto.entidades.RefAeropuert;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyecto.control.exceptions.NonexistentEntityException;
import proyecto.entidades.Itinerario;
import proyecto.entidades.Vuelo;

/**
 *
 * @author David
 */
public class VueloJpaController implements Serializable {

    public VueloJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Proyecto_DespegarPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vuelo vuelo) {
        if (vuelo.getRefAeropuertList() == null) {
            vuelo.setRefAeropuertList(new ArrayList<RefAeropuert>());
        }
        if (vuelo.getItinerarioList() == null) {
            vuelo.setItinerarioList(new ArrayList<Itinerario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Avion idAvion = vuelo.getIdAvion();
            if (idAvion != null) {
                idAvion = em.getReference(idAvion.getClass(), idAvion.getIdAvion());
                vuelo.setIdAvion(idAvion);
            }
            List<RefAeropuert> attachedRefAeropuertList = new ArrayList<RefAeropuert>();
            for (RefAeropuert refAeropuertListRefAeropuertToAttach : vuelo.getRefAeropuertList()) {
                refAeropuertListRefAeropuertToAttach = em.getReference(refAeropuertListRefAeropuertToAttach.getClass(), refAeropuertListRefAeropuertToAttach.getIdReferenciaAer());
                attachedRefAeropuertList.add(refAeropuertListRefAeropuertToAttach);
            }
            vuelo.setRefAeropuertList(attachedRefAeropuertList);
            List<Itinerario> attachedItinerarioList = new ArrayList<Itinerario>();
            for (Itinerario itinerarioListItinerarioToAttach : vuelo.getItinerarioList()) {
                itinerarioListItinerarioToAttach = em.getReference(itinerarioListItinerarioToAttach.getClass(), itinerarioListItinerarioToAttach.getIdItinerario());
                attachedItinerarioList.add(itinerarioListItinerarioToAttach);
            }
            vuelo.setItinerarioList(attachedItinerarioList);
            em.persist(vuelo);
            if (idAvion != null) {
                idAvion.getVueloList().add(vuelo);
                idAvion = em.merge(idAvion);
            }
            for (RefAeropuert refAeropuertListRefAeropuert : vuelo.getRefAeropuertList()) {
                Vuelo oldIdVueloOfRefAeropuertListRefAeropuert = refAeropuertListRefAeropuert.getIdVuelo();
                refAeropuertListRefAeropuert.setIdVuelo(vuelo);
                refAeropuertListRefAeropuert = em.merge(refAeropuertListRefAeropuert);
                if (oldIdVueloOfRefAeropuertListRefAeropuert != null) {
                    oldIdVueloOfRefAeropuertListRefAeropuert.getRefAeropuertList().remove(refAeropuertListRefAeropuert);
                    oldIdVueloOfRefAeropuertListRefAeropuert = em.merge(oldIdVueloOfRefAeropuertListRefAeropuert);
                }
            }
            for (Itinerario itinerarioListItinerario : vuelo.getItinerarioList()) {
                Vuelo oldIdVueloOfItinerarioListItinerario = itinerarioListItinerario.getIdVuelo();
                itinerarioListItinerario.setIdVuelo(vuelo);
                itinerarioListItinerario = em.merge(itinerarioListItinerario);
                if (oldIdVueloOfItinerarioListItinerario != null) {
                    oldIdVueloOfItinerarioListItinerario.getItinerarioList().remove(itinerarioListItinerario);
                    oldIdVueloOfItinerarioListItinerario = em.merge(oldIdVueloOfItinerarioListItinerario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vuelo vuelo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vuelo persistentVuelo = em.find(Vuelo.class, vuelo.getIdVuelo());
            Avion idAvionOld = persistentVuelo.getIdAvion();
            Avion idAvionNew = vuelo.getIdAvion();
            List<RefAeropuert> refAeropuertListOld = persistentVuelo.getRefAeropuertList();
            List<RefAeropuert> refAeropuertListNew = vuelo.getRefAeropuertList();
            List<Itinerario> itinerarioListOld = persistentVuelo.getItinerarioList();
            List<Itinerario> itinerarioListNew = vuelo.getItinerarioList();
            if (idAvionNew != null) {
                idAvionNew = em.getReference(idAvionNew.getClass(), idAvionNew.getIdAvion());
                vuelo.setIdAvion(idAvionNew);
            }
            List<RefAeropuert> attachedRefAeropuertListNew = new ArrayList<RefAeropuert>();
            for (RefAeropuert refAeropuertListNewRefAeropuertToAttach : refAeropuertListNew) {
                refAeropuertListNewRefAeropuertToAttach = em.getReference(refAeropuertListNewRefAeropuertToAttach.getClass(), refAeropuertListNewRefAeropuertToAttach.getIdReferenciaAer());
                attachedRefAeropuertListNew.add(refAeropuertListNewRefAeropuertToAttach);
            }
            refAeropuertListNew = attachedRefAeropuertListNew;
            vuelo.setRefAeropuertList(refAeropuertListNew);
            List<Itinerario> attachedItinerarioListNew = new ArrayList<Itinerario>();
            for (Itinerario itinerarioListNewItinerarioToAttach : itinerarioListNew) {
                itinerarioListNewItinerarioToAttach = em.getReference(itinerarioListNewItinerarioToAttach.getClass(), itinerarioListNewItinerarioToAttach.getIdItinerario());
                attachedItinerarioListNew.add(itinerarioListNewItinerarioToAttach);
            }
            itinerarioListNew = attachedItinerarioListNew;
            vuelo.setItinerarioList(itinerarioListNew);
            vuelo = em.merge(vuelo);
            if (idAvionOld != null && !idAvionOld.equals(idAvionNew)) {
                idAvionOld.getVueloList().remove(vuelo);
                idAvionOld = em.merge(idAvionOld);
            }
            if (idAvionNew != null && !idAvionNew.equals(idAvionOld)) {
                idAvionNew.getVueloList().add(vuelo);
                idAvionNew = em.merge(idAvionNew);
            }
            for (RefAeropuert refAeropuertListOldRefAeropuert : refAeropuertListOld) {
                if (!refAeropuertListNew.contains(refAeropuertListOldRefAeropuert)) {
                    refAeropuertListOldRefAeropuert.setIdVuelo(null);
                    refAeropuertListOldRefAeropuert = em.merge(refAeropuertListOldRefAeropuert);
                }
            }
            for (RefAeropuert refAeropuertListNewRefAeropuert : refAeropuertListNew) {
                if (!refAeropuertListOld.contains(refAeropuertListNewRefAeropuert)) {
                    Vuelo oldIdVueloOfRefAeropuertListNewRefAeropuert = refAeropuertListNewRefAeropuert.getIdVuelo();
                    refAeropuertListNewRefAeropuert.setIdVuelo(vuelo);
                    refAeropuertListNewRefAeropuert = em.merge(refAeropuertListNewRefAeropuert);
                    if (oldIdVueloOfRefAeropuertListNewRefAeropuert != null && !oldIdVueloOfRefAeropuertListNewRefAeropuert.equals(vuelo)) {
                        oldIdVueloOfRefAeropuertListNewRefAeropuert.getRefAeropuertList().remove(refAeropuertListNewRefAeropuert);
                        oldIdVueloOfRefAeropuertListNewRefAeropuert = em.merge(oldIdVueloOfRefAeropuertListNewRefAeropuert);
                    }
                }
            }
            for (Itinerario itinerarioListOldItinerario : itinerarioListOld) {
                if (!itinerarioListNew.contains(itinerarioListOldItinerario)) {
                    itinerarioListOldItinerario.setIdVuelo(null);
                    itinerarioListOldItinerario = em.merge(itinerarioListOldItinerario);
                }
            }
            for (Itinerario itinerarioListNewItinerario : itinerarioListNew) {
                if (!itinerarioListOld.contains(itinerarioListNewItinerario)) {
                    Vuelo oldIdVueloOfItinerarioListNewItinerario = itinerarioListNewItinerario.getIdVuelo();
                    itinerarioListNewItinerario.setIdVuelo(vuelo);
                    itinerarioListNewItinerario = em.merge(itinerarioListNewItinerario);
                    if (oldIdVueloOfItinerarioListNewItinerario != null && !oldIdVueloOfItinerarioListNewItinerario.equals(vuelo)) {
                        oldIdVueloOfItinerarioListNewItinerario.getItinerarioList().remove(itinerarioListNewItinerario);
                        oldIdVueloOfItinerarioListNewItinerario = em.merge(oldIdVueloOfItinerarioListNewItinerario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vuelo.getIdVuelo();
                if (findVuelo(id) == null) {
                    throw new NonexistentEntityException("The vuelo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vuelo vuelo;
            try {
                vuelo = em.getReference(Vuelo.class, id);
                vuelo.getIdVuelo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vuelo with id " + id + " no longer exists.", enfe);
            }
            Avion idAvion = vuelo.getIdAvion();
            if (idAvion != null) {
                idAvion.getVueloList().remove(vuelo);
                idAvion = em.merge(idAvion);
            }
            List<RefAeropuert> refAeropuertList = vuelo.getRefAeropuertList();
            for (RefAeropuert refAeropuertListRefAeropuert : refAeropuertList) {
                refAeropuertListRefAeropuert.setIdVuelo(null);
                refAeropuertListRefAeropuert = em.merge(refAeropuertListRefAeropuert);
            }
            List<Itinerario> itinerarioList = vuelo.getItinerarioList();
            for (Itinerario itinerarioListItinerario : itinerarioList) {
                itinerarioListItinerario.setIdVuelo(null);
                itinerarioListItinerario = em.merge(itinerarioListItinerario);
            }
            em.remove(vuelo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vuelo> findVueloEntities() {
        return findVueloEntities(true, -1, -1);
    }

    public List<Vuelo> findVueloEntities(int maxResults, int firstResult) {
        return findVueloEntities(false, maxResults, firstResult);
    }

    private List<Vuelo> findVueloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vuelo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vuelo findVuelo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vuelo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVueloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vuelo> rt = cq.from(Vuelo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
