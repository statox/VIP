/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

/**
 *
 * @author adrien
 */
public class Person {

    private String name; 
    private String prenom;
    private String telPerso;
    private String telPro;
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
    
    public Person(String name, String prenom, String telPerso, String telPro, String address, String zipCode, String city, String email) {
        this.name = name;
        this.prenom = prenom;
        this.telPerso = telPerso;
        this.telPro = telPro;
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
        this.address = "default";
        this.zipCode = "default";
        this.city = "default";
        this.email = "default";
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", prenom=" + prenom + ", telPerso=" + telPerso + ", telPro=" + telPro + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", email=" + email + '}';
    }

    
}
