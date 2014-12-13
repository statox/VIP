/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import javax.ejb.Stateless;
import java.util.Collection;  
import java.util.List;  
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  

/**
 *
 * @author Adrien
 */
@Stateless
public class MySessionBean {
    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em;
    
    
    public Utilisateur createVIP(String name, String prenom, 
                                    String telPerso, String telPro, String telDom, 
                                    String address, String zipCode, String city, 
                                    String email)
    {
        Utilisateur u = new Utilisateur("Dugenou", "Marcel", "666-666-666", "777-777-777", "888-888-888", "12 rue du soleil", 89320, "pouetCity", "m.dugenou@mail.fr");
        em.persist(u);
        return u;
    }
    
    public List<Utilisateur> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");  
        return q.getResultList();  
    }  
}
