package uf6projecte;

/**
 *
 * @author santi
 */
public class AlumneEntity extends ORMEntity {
    
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    /* Propietats de l'objecte */
    /* Camps de la taula */
    private int ID;
    private String nom;
    private String cognoms;
    private int edat;

    /* Connexió a la Base de dades */
    private BDConnection c;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public AlumneEntity(int ID, String nom, String cognoms, int edat) {
        this.ID = ID;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    /** 
     * Getters i Setters 
     */
    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setConnection(BDConnection c) {
        this.c = c;
    }
    //</editor-fold>


}
