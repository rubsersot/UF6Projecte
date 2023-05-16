package uf6projecte;

/**
 *
 * @author santi
 */
public class AlumneEntity extends ORMEntity {
    
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    /* Propietats de l'objecte */
    /* Camps de la taula */
    private int codiAl;
    private String nom, DNI;
    private int codiGrup;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public AlumneEntity(int codiAl, String nom, String DNI, int codiGrup) {
        this.codiAl = codiAl;
        this.nom = nom;
        this.DNI = DNI;
        this.codiGrup = codiGrup;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    /**
     * Getters i Setters
     */
    
    public int getCodiAl() {
        return codiAl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getCodiGrup() {
        return codiGrup;
    }

    public void setCodiGrup(int codiGrup) {
        this.codiGrup = codiGrup;
    }
    //</editor-fold>


}
