import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, email, password, favSport;
	private GregorianCalendar datNasc;
	private int idade, altura, peso;
	private char genero;
	private ArrayList<Actividades> activ= new ArrayList<Actividades>();;
	private boolean isAdmin;
	private ArrayList<String> amigos = new ArrayList<String>();
	private ArrayList<String> requests = new ArrayList<String>();
	
	public User(String nome, String email, String password, String favSport,
			GregorianCalendar datNasc, int idade, int altura, int peso,
			char genero,boolean isAdmin) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.favSport = favSport;
		this.datNasc = datNasc;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.genero = genero;
		this.activ = new ArrayList<Actividades>();
		this.amigos = new ArrayList<String>();
		this.requests = new ArrayList<String>();
		this.isAdmin=isAdmin;
	}
	public User(String nome, String email, String password, String favSport,
			GregorianCalendar datNasc, int idade, int altura, int peso,
			char genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.favSport = favSport;
		this.datNasc = datNasc;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.genero = genero;
		this.isAdmin=false;
		this.activ = new ArrayList<Actividades>();
		this.amigos = new ArrayList<String>();
		this.setRequests(new ArrayList<String>());
	
	}
	
	public User() {
		super();
		this.nome = new String();
		this.email = new String();
		this.password = new String();
		this.favSport = new String();
		this.datNasc = new GregorianCalendar();
		this.idade = 0;
		this.altura = 0;
		this.peso = 0;
		this.genero = 74;
		this.isAdmin=false;
		this.activ = new ArrayList<Actividades>();
		this.amigos = new ArrayList<String>();
		this.setRequests(new ArrayList<String>());
	}


	public User(User utili) {
		super();
		this.nome = utili.getNome();
		this.email = utili.getEmail();
		this.password = utili.getPassword();
		this.favSport = utili.getFavSport();
		this.datNasc = utili.getDatNasc();
		this.idade = utili.getIdade();
		this.altura = utili.getAltura();
		this.peso = utili.getPeso();
		this.genero = utili.getGenero();
		this.activ = utili.getActiv();
		this.amigos = utili.getAmigos();
		this.isAdmin=false;
	}

	
	public ArrayList<String> getRequests() {
		ArrayList<String> aux= new ArrayList<String>();
		for (String str: this.requests)
			aux.add(str);
		return aux;
	}

	public void setRequests(ArrayList<String> requests) {
		this.requests = new ArrayList<String>();
		for (String str:requests)
			this.requests.add(str);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFavSport() {
		return favSport;
	}
	public void setFavSport(String favSport) {
		this.favSport = favSport;
	}
	
	public GregorianCalendar getDatNasc() {
		return (GregorianCalendar)datNasc.clone();
	}
	public String getSimpleBirthdate(){
      	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	String d = df.format(this.datNasc.getTime());
    	return d;
	}
	public void setDatNasc(GregorianCalendar datNasc) {
		this.datNasc = datNasc;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	//incompleto
	public ArrayList<Actividades> getActiv() {
		ArrayList<Actividades> aux = new ArrayList<Actividades>();
		for(Actividades a:this.activ)
			aux.add(a);
		return aux;
	}
	
	public void setActiv(ArrayList<Actividades> activ) {
		for(Actividades act: activ)
			this.activ.add(act.clone());
	}
	
	//incompleto
	public ArrayList<String> getAmigos() {
		ArrayList<String> aux= new ArrayList<String>();
		for(String str:this.amigos)
			aux.add(str);
		return aux;
	}
	public void setAmigos(ArrayList<User> amigos) {
		this.amigos= new ArrayList<String>();
		for(User u: amigos)
			this.amigos.add(u.getEmail());
	}

	public void addActiv(Actividades act){
 		this.activ.add(act.clone());
 	}
	public void inscreveEvento(Event e) throws UnexistingEventException,ExistingEventException{
		if(!AdminUser.containsEvent(e))throw new UnexistingEventException();
		if(AdminUser.alreadyInsc(e, this.getEmail())) throw new ExistingEventException(this.getEmail());
		AdminUser.inscrevEvent(e, this.getEmail());
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activ == null) ? 0 : activ.hashCode());
		result = prime * result + altura;
		result = prime * result + ((amigos == null) ? 0 : amigos.hashCode());
		result = prime * result + ((datNasc == null) ? 0 : datNasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((favSport == null) ? 0 : favSport.hashCode());
		result = prime * result + genero;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + peso;
		return result;
	}

	public User clone(){
		return new User(this);
	}
	
	public void sendRequest(User other){
	other.addRequest(this.getEmail());	
	}
	public void addRequest(String strenk){
		this.requests.add(strenk);
	}
	public void addFriend(String mail){
		this.amigos.add(mail);
	}
	public void removeRequest(String mail){
		this.amigos.remove(mail);
	}
	public boolean containsFriend(String mail){
		return this.amigos.contains(mail);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.getActiv() == null) {
			if (other.getActiv() != null)
				return false;
		} else if (!this.getActiv().equals(other.getActiv()))
			return false;
		if (this.getAltura() != other.getAltura())
			return false;
		if (this.getAmigos() == null) {
			if (other.getAmigos() != null)
				return false;
		} else if (!this.getAmigos().equals(other.getAmigos()))
			return false;
		if (this.getDatNasc() == null) {
			if (other.getDatNasc() != null)
				return false;
		} else if (!this.getDatNasc().equals(other.getDatNasc()))
			return false;
		if (this.getEmail() == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!this.getEmail().equals(other.getEmail()))
			return false;
		if (this.getFavSport() == null) {
			if (other.getFavSport() != null)
				return false;
		} else if (!this.getFavSport().equals(other.getFavSport()))
			return false;
		if (this.getGenero() != other.getGenero())
			return false;
		if (this.getIdade() != other.getIdade())
			return false;
		if (this.getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!this.getNome().equals(other.getNome()))
			return false;
		if (this.getPassword() == null) {
			if (other.getPassword() != null)
				return false;
		} else if (!this.getPassword().equals(other.getPassword()))
			return false;
		if (this.getPeso() != other.getPeso())
			return false;
		return true;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}
	protected void setAdmin(boolean admn){
		this.isAdmin=admn;
	}
	public void remAmigo(User u){
		this.amigos.remove(u.getEmail());
		u.remAmigo(this);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [nome=" + this.getNome() + ", email=" + this.getEmail() + ", favSport="
				+ this.getFavSport() + ", datNasc=" + this.getSimpleBirthdate() + ", idade=" + this.getIdade()
				+ ", altura=" + this.getAltura() + ", peso=" + this.getPeso() + ", genero="
				+ this.getGenero() + ", activ=" + this.getActiv() + ", amigos=" + this.getAmigos()
				+ ", requests=" + this.getRequests() + "]";
	}

	
	
	
}
