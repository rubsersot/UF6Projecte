package uf6projecte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class GrupTable extends ORMTable {

    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public GrupTable() {
        super("Grup");
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
        GrupEntity g = (GrupEntity) o;
        String sqlCommand = "INSERT INTO GRUP (codiGrup, nom, numAlumnes, quota) "
                + "VALUES (" + g.getID() + ",'" + g.getNom() + "'," + g.getnumAlumnes() + "," + g.getQuota() + ")";

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
    public ArrayList<GrupEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<GrupEntity> resultList = new ArrayList<GrupEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM GRUP");

        while (resultat.next()) {
            GrupEntity g = new GrupEntity(
                    resultat.getInt("codiGrup"), 
                    resultat.getString("nom"), 
                    resultat.getInt("numAlumnes"), 
                    resultat.getFloat("quota"));
            resultList.add(g);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    

    @Override
    public int Delete(ORMEntity o) throws NullConnectionException, SQLException {
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
        GrupEntity g = (GrupEntity) o;
        String sqlCommand = "DELETE FROM GRUP WHERE codiGrup= "+ g.getID();

        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    @Override
    public int Update(ORMEntity o) throws NullConnectionException, SQLException {
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
        GrupEntity g = (GrupEntity) o;
        String sqlCommand = "UPDATE GRUP SET nom = '" + g.getNom() + "', numAlumnes = " + g.getnumAlumnes() +
                ", quota = " + g.getQuota() + " WHERE codiGrup = " + g.getID();

        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    // </editor-fold>
}
