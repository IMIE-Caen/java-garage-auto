/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

/**
 *
 * @author clement
 */
public class VehiculeEnPanne {
    private String nom ;
    private String panne ;

    public VehiculeEnPanne(String nom, String panne) {
        this.nom = nom;
        this.panne = panne;
    }

    @Override
    public String toString() {
        return nom + " panne: "+ panne;
    }

    
 
}  
