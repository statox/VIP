/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import VIP.Utilisateur;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author matthieudelaro
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {
    @PersistenceContext(unitName = "VIPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
//    @Override 
//    public List<Utilisateur> findAll() {
////        Query q = em.createNamedQuery("Utilisateur.findAll", Utilisateur.class);
////        List<Utilisateur> u = q.getResultList();
//        return u;
//    }
}
