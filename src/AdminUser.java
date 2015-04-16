import java.util.ArrayList;
import java.util.GregorianCalendar;



@SuppressWarnings("serial")
public class AdminUser extends User{
	private static ArrayList<Event> eventos=new ArrayList<Event>();
	public static void addEvent(Event event){
		AdminUser.eventos.add(event);
	}
	public static ArrayList<Event> getEventList(){
		ArrayList<Event> aux= new ArrayList<Event>();
		for(Event e:AdminUser.eventos)
			aux.add(e.clone());
		return aux;
	}
	public static boolean containsEvent(String name){
		boolean cont=false;
		for(Event e:AdminUser.eventos){
			if (e.getNome().equals(name)) {
				cont=true;
				break;
			}
		}
		return cont;
	}
	public static boolean containsEvent(GregorianCalendar gc){
		boolean cont= false;
		for(Event e:AdminUser.eventos){
			if (e.getData_Evento().equals(gc)){
				cont = true;
				break;
			}
		}
		return cont;
	}
	public static ArrayList<Event> listEvents(String ev) throws UnexistingEventException{
		ArrayList<Event> aux= new ArrayList<Event>();
		if(AdminUser.containsEvent(ev)) throw new UnexistingEventException(ev);
		else{
			for(Event e : AdminUser.eventos)
				if(e.equalsNome(ev))
					aux.add(e.clone());
		}
		return aux;
	}
	public static ArrayList<Event> listEvents(GregorianCalendar gc) throws UnexistingEventException{
		if (!AdminUser.containsEvent(gc)) throw new UnexistingEventException();
		ArrayList<Event> aux= new ArrayList<Event>();
		for(Event e : AdminUser.eventos)
			if(e.equalsDate(gc))
				aux.add(e.clone());
		return aux;	
	}
	
	public static boolean containsEvent(Event e){
		return AdminUser.eventos.contains(e);
	}
	public static boolean alreadyInsc(Event ev,String e){
		return ev.alreadyInsc(e);
	}
	public static void inscrevEvent(Event ev, String e){
		if(!AdminUser.containsEvent(e)) {ev.inscreve(e);AdminUser.creatEvent(ev.getActividade(), ev.getLimiteInsc());}
		else {
			AdminUser.addCompetitor(ev,e);
		}
		
	}
	public AdminUser(String nome,String email,String password, String favSport,GregorianCalendar birthdate, int idade, int altura, int peso,char genero){
	super(nome,email, password, favSport, birthdate, idade, altura, peso, genero, true);	
	}
	public void turnAdmin(User other){
		other.setAdmin(true);
	}
	public static void addCompetitor(Event ev,String mail){
		int ind=AdminUser.eventos.indexOf(ev);
		AdminUser.eventos.get(ind).inscreve(mail);
		
	}
	public static void creatEvent(Actividades other, int max){
		Event e= new Event(other, max);
		AdminUser.addEvent(e.clone());
	}
	
}
