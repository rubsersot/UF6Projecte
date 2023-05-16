package uf6projecte;

/**
 *
 * @author santi
 */
public class GrupEntity extends ORMEntity {
    
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    /* Propietats de l'objecte */
    /* Camps de la taula */
    private int ID;
    private String nom;
    private int numAlumnes;
    private float quota;
    

    /* Connexió a la Base de dades */
    private BDConnection c;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public GrupEntity(int ID, String nom, int numAlumnes, float quota) {
        this.ID = ID;
        this.nom = nom;
        this.quota = quota;
        this.numAlumnes = numAlumnes;
        
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    /**
     * Getters i Setters
     */
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public int getnumAlumnes() {
        return numAlumnes;
    }

    public void setnumAlumnes(int numAlumnes) {
        this.numAlumnes = numAlumnes;
    }  

    public void setConnection(BDConnection c) {
        this.c = c;
    }
    //</editor-fold>


}
