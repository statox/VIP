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
public class Tests {
    public static void main(String [ ] args)
    {
        Person p1 = new Person();
        Person p2 = new Person("Germaine", "Tapedur", "666-666-666", "777-777-777", "12 rue du soleil", "80800", "soleilVille", "germaine@tapedur.com");
        
        System.out.println(p1);
        System.out.println(p2);
        return;
    }
}
