/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrien
 */
@Entity
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByMdp", query = "SELECT u FROM Utilisateur u WHERE u.mdp = :mdp"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByTeldom", query = "SELECT u FROM Utilisateur u WHERE u.teldom = :teldom"),
    @NamedQuery(name = "Utilisateur.findByTelpor", query = "SELECT u FROM Utilisateur u WHERE u.telpor = :telpor"),
    @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "Utilisateur.findByCp", query = "SELECT u FROM Utilisateur u WHERE u.cp = :cp"),
    @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville"),
    @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByTelpro", query = "SELECT u FROM Utilisateur u WHERE u.telpro = :telpro")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 32)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 32)
    @Column(name = "MDP")
    private String mdp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 32)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 32)
    @Column(name = "TELDOM")
    private String teldom;
    @Size(max = 32)
    @Column(name = "TELPOR")
    private String telpor;
    @Size(max = 32)
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "CP")
    private Integer cp;
    @Size(max = 32)
    @Column(name = "VILLE")
    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 32)
    @Column(name = "TELPRO")
    private String telpro;

    public Utilisateur() {
    }

    public Utilisateur(String nom) {
        this.nom = nom;
    }
    
    public Utilisateur (String name, String prenom, 
                        String telPerso, String telPro, String telDom, 
                        String address, int zipCode, String city, 
                        String email)
    {
        this.nom = name;
        this.prenom = prenom;
        this.telpor = telPerso;
        this.telpro = telPro;
        this.teldom = telDom;
        this.adresse = address;
        this.cp = zipCode;
        this.ville = city;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTeldom() {
        return teldom;
    }

    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }

    public String getTelpor() {
        return telpor;
    }

    public void setTelpor(String telpor) {
        this.telpor = telpor;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VIP.Utilisateur[ nom=" + nom + " ]";
    }
    
}
