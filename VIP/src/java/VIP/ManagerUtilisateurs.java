/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  

/**
 *
 * @author Adrien
 */
@Stateless
public class ManagerUtilisateurs {

    @PersistenceContext  
    private EntityManager em;

    public Utilisateur creerUtilisateur (String name, String prenom, String telPerso, String telPro, String telDom, String address, int zipCode, String city, String email) 
    {
        Utilisateur u = new Utilisateur(name, prenom, telPerso, telPro, telDom, address, zipCode, city, email);
        em.persist(u);
        return u;
    }
    
    public Collection<Utilisateur> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");  
        return q.getResultList();  
    }  
}
