import java.util.Comparator;
import java.io.Serializable;
/**
 * Write a description of class ComparatorDataInsc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class ComparatorDataNasc implements Comparator<User>, Serializable
{
    // instance variables - replace the example below with your own
    public int compare(User u1, User u2){
    return u1.getDatNasc().compareTo(u2.getDatNasc());
    }
}
