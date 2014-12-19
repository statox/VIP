/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import java.sql.ResultSet;

/**
 *
 * @author adrien
 */
public class Person {

    private String name; 
    private String prenom;
    private String telPerso;
    private String telPro;
    private String telDom;
    private String address;
    private String zipCode;
    private String city;
    private String email;

    /* getters */
    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelPerso() {
        return telPerso;
    }

    public String getTelDom() {
        return telDom;
    }
    
    public String getTelPro() {
        return telPro;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    /* setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelPerso(String telPerso) {
        this.telPerso = telPerso;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public void setTelDom(String telDom) {
        this.telDom = telDom;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* ctors */
    
    public Person(String name, String prenom, String telPerso, String telPro,
            String telDom, String address, String zipCode, String city,
            String email) {
        this.name = name;
        this.prenom = prenom;
        this.telPerso = telPerso;
        this.telPro = telPro;
        this.telDom = telDom;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
    }
    
    public Person ()
    {
        this.name = "default";
        this.prenom = "default";
        this.telPerso = "default";
        this.telPro = "default";
        this.telDom = "default";
        this.address = "default";
        this.zipCode = "default";
        this.city = "default";
        this.email = "default";
    }
    
    /**
     * Creates a Person based on the current row of 
     * the given ResultSet coming from a request to the database.
     * @param rs 
     * @throws a java.security.InvalidParameterException in case an error 
     * occurs while reading the resultSet.
     */
    public Person (ResultSet rs) throws java.security.InvalidParameterException
    {
        if (!inflate(rs)) {
            throw new java.security.InvalidParameterException("Could not inflate.");
        }
    }
    
    /**
     * Creates a Person based on the given Utilisateur.
     * @throws a java.security.InvalidParameterException in case an error 
     * occurs while reading the resultSet.
     */
    public Person (Utilisateur u) throws java.security.InvalidParameterException
    {
        if (!inflate(u)) {
            throw new java.security.InvalidParameterException("Could not inflate.");
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", prenom=" + prenom + ", telPerso=" + telPerso + ", telPro=" + telPro + ", telDom=" + telDom + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", email=" + email + '}';
    }
    
    /**
     * This method inflates object's attributes with the current row of 
     * the given ResultSet coming from a request to the database.
     * 
     * @param rs
     * @return true in case of success, false otherwise.
     */
    public Boolean inflate (ResultSet rs)
    {
        try
        {
            this.setName(       rs.getString("NOM")); 
            this.setPrenom(     rs.getString("PRENOM")); 
            this.setTelPerso(   rs.getString("TELPOR")); 
            this.setTelPro(     rs.getString("TELPRO")); 
            this.setTelDom(     rs.getString("TELDOM")); 
            this.setAddress(    rs.getString("ADRESSE")); 
            this.setZipCode(    rs.getString("CP")); 
            this.setCity(       rs.getString("VILLE")); 
            this.setEmail(      rs.getString("EMAIL"));
        }
        catch ( Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    /**
     * This method inflates object's attributes based on the given Utilisateur.
     * 
     * @param u
     * @return true in case of success, false otherwise.
     */
    public Boolean inflate (Utilisateur u)
    {
        try
        {
            this.setName(       u.getNom()); 
            this.setPrenom(     u.getPrenom()); 
            this.setTelPerso(   u.getTelpor()); 
            this.setTelPro(     u.getTelpro()); 
            this.setTelDom(     u.getTeldom()); 
            this.setAddress(    u.getAdresse()); 
            this.setZipCode(    u.getCp().toString()); 
            this.setCity(       u.getVille()); 
            this.setEmail(      u.getEmail());
        }
        catch ( Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    public Utilisateur toUtilisateur() {
        Utilisateur u = new Utilisateur();
        
        u.setNom(name);
        u.setPrenom(prenom);
        u.setTelpor(telPerso);
        u.setTelpro(telPro);
        u.setTeldom(telDom);
        u.setAdresse(address);
        u.setCp(Integer.parseInt(zipCode));
        u.setVille(city);
        u.setEmail(email);
        
        return u;
    }
}
