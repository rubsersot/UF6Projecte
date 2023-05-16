/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf6projecte;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ausias
 */
public class UF6Projecte {
    
    // <editor-fold defaultstate="collapsed" desc="DadesConnexio">
    static final String USER = "a22rubsersot_user";
    static final String PWD = "AusiasMarch7";
    static final String URL = "labs.inspedralbes.cat";
    static final String PORT = "3306";
    static final String BD_NAME = "a22rubsersot_esportiva";
    // </editor-fold> 

    public static void main(String args[]) {
        try {
            Scanner scan = new Scanner(System.in);
            
            //Crear la connexió a la BD
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            
            
            //Crear l'objecte de la taula persona i assignar la connexió
            PersonaTable pt = new PersonaTable();
            pt.setConnection(bdCon);  
                     
            System.out.println("Vols inserir una nova persona?");
            if (scan.nextLine().equalsIgnoreCase("S"))
            {
                // inserir una Persona            
                PersonaEntity p = new PersonaEntity(6, "Nova","Persona",25);
                              
                pt.Insert(p);
                
                System.out.println("Segur que vols validar els canvis realitzats?");    
                if (scan.nextLine().equalsIgnoreCase("S")) 
                    //Confirma els canvis
                    bdCon.confirmarCanvis();
                else
                    //Desfà els canvis
                    bdCon.desferCanvis();
            }
            
            // Consultar totes les persones
            ArrayList<PersonaEntity> listaPersonas = pt.GetAll();
            
            for (PersonaEntity p : listaPersonas)
            {
                System.out.println("----");
                System.out.println("ID: " + p.getID());
                System.out.println("Nom: " + p.getNom());
                System.out.println("Cognoms: " + p.getCognoms());
                System.out.println("Edat: " + p.getEdat());
                System.out.println("----");
            }

            // Desconnexio de la base de dades
            bdCon.closeConnection();
            
            
            System.out.println("Rollback i desconnexio realitzats correctament.");
        } catch (ClassNotFoundException ce) {
            System.out.println("Error al carregar el driver");
        } catch (SQLException se) {
            System.out.println("Excepcio: ");
            System.out.println();
            System.out.println("El getSQLState es: " + se.getSQLState());
            System.out.println();
            System.out.println("El getMessage es: " + se.getMessage());
        } catch (NullConnectionException ex) {
            Logger.getLogger(M03_UF6_BD_ORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
