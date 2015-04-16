import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * Write a description of class RedeUser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedeUser
{
    // instance variables - replace the example below with your own
    private HashMap<String,User> rede;

    /**
     * Constructor for objects of class RedeUser
     */
    public RedeUser()
    {
        // initialise instance variables
        this.rede=new HashMap<String,User>();
    }

    public RedeUser(RedeUser other){
        this.rede=other.getRede();
    }

    public HashMap<String,User> getRede(){
        HashMap<String,User> aux= new HashMap<String,User>();
        for(User u:this.rede.values())
            aux.put(u.getEmail(),u.clone());
        return aux;
    }

    public void setRede(HashMap<String,User> user){
        this.rede=new HashMap<String,User>();
        for(User u:user.values())
            this.rede.put(u.getEmail(),u.clone());
    }

    public void addUser(User u) throws ExistingUserException
    {
        if (this.rede.containsKey(u.getEmail())) throw new ExistingUserException(u.getEmail());
        else{
            this.rede.put(u.getEmail(),u.clone());
        }
    }
    
    public void addActivUser(String email, Actividades a) throws UnexistingUserException
    {
        if (!this.rede.containsKey(email)) throw new UnexistingUserException(email);
        else this.rede.get(email).addActiv(a);
    }
    
    public List<Actividades> getActivUser(String email)throws UnexistingUserException{
        if(!this.rede.containsKey(email))throw new UnexistingUserException(email);
        else return this.rede.get(email).getActiv();
    }
    
    public List<String> getAmigosUser(String email)throws UnexistingUserException{
        if(!this.rede.containsKey(email))throw new UnexistingUserException(email);
        else return this.rede.get(email).getAmigos();
    }

    public User getUser(String email)throws UnexistingUserException{
        if(!this.rede.containsKey(email))throw new UnexistingUserException(email);
        else return this.rede.get(email).clone();
    }

    public void banUser(User u) throws UnexistingUserException
    {
        if(!(this.rede.containsKey(u.getEmail()))) throw new UnexistingUserException(u.getEmail());
        this.rede.remove(u.getEmail());
        //Remover os amigos
        /*for(User usr: u.getAmigos())
            usr.remAmigo(u.getEmail());
    */}
    
    public TreeSet<User> ordenaPorNome(){
        TreeSet<User> aux= new TreeSet<User>(new ComparatorNome());
        for(User u:this.rede.values())
            aux.add(u.clone());
        return aux;
    }

    public TreeSet<User> ordenaPorDataNasc(){
        TreeSet<User> aux= new TreeSet<User>(new ComparatorDataNasc());
        for(User u:this.rede.values())
            aux.add(u.clone());
        return aux;
    }

    public RedeUser clone(){
        return new RedeUser(this);
    }

    public void toObjFile(){

        Iterator<String> it = rede.keySet().iterator();
        try
        {   // Catch errors in I/O if necessary.
            // Open a file to write to, named SavedObj.sav.
            FileOutputStream saveFile=new FileOutputStream("SaveUsers.sav");

            // Create an ObjectOutputStream to put objects into save file.
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            while(it.hasNext()) 
            {
                save.writeObject( (User)this.rede.get(it.next()) );
            }

            // Close the file.
            save.close(); // This also closes saveFile.
        }
        catch(Exception exc){ exc.printStackTrace(); /* If there was an error, print the info.*/	}
    }

    public void loadObj(){
        User uti;
        ObjectInputStream objIn = null;
        try 
        {
            objIn = new ObjectInputStream(new FileInputStream("SaveUsers.sav"));

            while ( (uti = (User)objIn.readObject()) != null) 
            {
                this.rede.put(uti.getEmail(), uti);
            }

            objIn.close();				       
        } 
        catch (EOFException e)
        { 
            try {
                objIn.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } 
        }
        catch(Exception e) { e.printStackTrace(); }

    }
    public void sendRequest(String mail1,String mail2) throws UnexistingUserException, ExistingUserException{
    	if (!this.rede.containsKey(mail1)) throw new UnexistingUserException(mail1);
    	if (!this.rede.containsKey(mail2)) throw new UnexistingUserException(mail2);
    	if (this.rede.get(mail1).containsFriend(mail2)) throw new ExistingUserException(mail2);
    	this.rede.get(mail2).addRequest(mail1);
    }
    public void acceptRequest(String mail1,String mail2) throws UnexistingUserException{
    	if(!this.rede.containsKey(mail1)) throw new UnexistingUserException(mail1);
    	if(!this.rede.containsKey(mail2)) throw new UnexistingUserException(mail2);
    	this.rede.get(mail2).removeRequest(mail1);
    	this.rede.get(mail1).addFriend(mail2);
    	this.rede.get(mail2).addFriend(mail1);
    }
    public void rejectRequest(String mail1,String mail2) throws UnexistingUserException{
    	if(!this.rede.containsKey(mail1)) throw new UnexistingUserException(mail1);
    	if(!this.rede.containsKey(mail2)) throw new UnexistingUserException(mail2);
    	this.rede.get(mail1).removeRequest(mail2);
    	}
}
