/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uf6projecte;

import java.sql.SQLException;
import java.util.Scanner;

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
            
            VentanaGrups ventana = new VentanaGrups();
            ventana.setVisible(true);
            //Crear l'objecte de la taula persona i assignar la connexió
            GrupTable pt = new GrupTable();
            pt.setConnection(bdCon);  
        } catch (ClassNotFoundException ce) {
            System.out.println("Error al carregar el driver");
        } catch (SQLException se) {
            System.out.println("Excepcio: ");
            System.out.println();
            System.out.println("El getSQLState es: " + se.getSQLState());
            System.out.println();
            System.out.println("El getMessage es: " + se.getMessage());
        }
    }
    
}
