package uf6projecte;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class AlumneTable extends ORMTable {

    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public AlumneTable() {
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
        AlumneEntity alum = (AlumneEntity) o;
        String sqlCommand = "INSERT INTO ALUMNE (codiAl, nom, DNI, codiGrup) "
                + "VALUES (" + alum.getCodiAl() + ",'" + alum.getNom() + "','" + alum.getDNI() + "'," + alum.getCodiGrup() + ")";

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
    public ArrayList<AlumneEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<AlumneEntity> resultList = new ArrayList<>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM Alumne");

        while (resultat.next()) {
            AlumneEntity alum = new AlumneEntity(
                    resultat.getInt("codiAl"), 
                    resultat.getString("nom"), 
                    resultat.getString("DNI"), 
                    resultat.getInt("codiGrup"));
            resultList.add(alum);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    // </editor-fold>

}
