/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author clement
 */
public class Main {

   
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        Garage g = new Garage();
        int choix ;      
        
        PannesCatalogueDBAdapter catalogue = new PannesCatalogueDBAdapter();
  
        
        do{
            System.out.println("\n\n---MENU---");
            System.out.println("0. Quitter");
            System.out.println("1. Voir le garage");
            System.out.println("2. Ajouter un véhicule");

            choix = new Scanner(System.in).nextInt();
            
            switch(choix){
                case 1:
                    System.out.println(g);
                    break;
                case 2:
                    System.out.println("--Ajout d'un véhicule--");
                    System.out.print("Nom: ");
                    String nom = new Scanner(System.in).nextLine();
                    System.out.print("Panne: ");
                    catalogue.reload();
                    System.out.println("\n");
                    System.out.println("0: Nouvelle panne");
                    System.out.println(catalogue);
                    int choixPanne = new Scanner(System.in).nextInt();
                    String panne ;
                    if(choixPanne == 0){
                        panne = new Scanner(System.in).nextLine();
                        catalogue.insert(panne);
                    }else{
                        panne = catalogue.get(choixPanne);
                    }
                    g.add(new VehiculeEnPanne(nom, panne));
            }  
        } while(choix != 0);
        catalogue.fermerConnexion();
    }
    
}
