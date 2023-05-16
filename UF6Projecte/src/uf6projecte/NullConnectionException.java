package uf6projecte;

/**
 *
 * @author santi
 */
public class NullConnectionException extends Exception{
    
    public NullConnectionException()
    {
        this("No es poden fer operacions amb una connexio nul·la o tancada");
    }
    
    public NullConnectionException(String msg)
    {
        super(msg);
    }
}
