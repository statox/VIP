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
    
    public Person(String name, String prenom, String telPerso, String telPro, String telDom, String address, String zipCode, String city, String email) {
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

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", prenom=" + prenom + ", telPerso=" + telPerso + ", telPro=" + telPro + ", telDom=" + telDom + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", email=" + email + '}';
    }

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
    
}
