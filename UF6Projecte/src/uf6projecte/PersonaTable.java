package uf6projecte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class PersonaTable extends ORMTable {

    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public PersonaTable() {
        super("Persona");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Operacions amb la Base de Dades">
    /**
     * Inserta l'objecte a la taula de Persones
     *
     * @return int: nombre de files afectades
     * @throws NullConnectionException: La connexió és nul·la o es troba tancada
     * @throws SQLException: Qualsevol altra excepció SQL
     */
    @Override
    public int Insert(ORMEntity o) throws NullConnectionException, SQLException {
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        PersonaEntity p = (PersonaEntity) o;
        String sqlCommand = "INSERT INTO Persona VALUES (ID, Nom, Cognom, Edat) "
                + "VALUES (" + p.getID() + ",'" + p.getNom() + "','" + p.getCognoms() + "'," + p.getEdat() + ")";

        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    /**
     * Obté tots els registres de la taula
     * @return Retorna una llista amb tots els registres de la taula
     * @throws NullConnectionException
     * @throws SQLException 
     */
    @Override
    public ArrayList<PersonaEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<PersonaEntity> resultList = new ArrayList<PersonaEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM Persones");

        while (resultat.next()) {
            PersonaEntity p = new PersonaEntity(
                    resultat.getInt("ID"), 
                    resultat.getString("Nom"), 
                    resultat.getString("Cognoms"), 
                    resultat.getInt("Edat"));
            resultList.add(p);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    // </editor-fold>

}
