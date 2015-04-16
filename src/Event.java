import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Event {
	private String nome;
	private GregorianCalendar data_evento;
	private ArrayList<String> inscritos;
	private Actividades act;
	private int limite_Insc;
	public Event(Actividades act, int limite_Insc){
		this.nome=getNome();
		this.data_evento=act.getData_atividade();
		this.inscritos=new ArrayList<String>();
		this.act=act.clone();
	}
	public Event(String nome, Actividades act, int limite_Insc){
		this.nome=nome;
		this.data_evento=act.getData_atividade();
		this.inscritos=new ArrayList<String>();
		this.act=act.clone();
		this.limite_Insc=limite_Insc;
	}
	public Event(Event other){
		this.nome=other.getNome();
		this.data_evento=other.getData_Evento();
		this.inscritos=other.getInscritos();
		this.act=other.getActividade();
		this.limite_Insc=other.getLimiteInsc();
	}
	public String getNome(){
		return this.nome;
	}
	public GregorianCalendar getData_Evento()
	{
		return (GregorianCalendar)this.data_evento.clone();			
	}
	public ArrayList<String> getInscritos(){
		ArrayList<String> aux= new ArrayList<String>();
		for(String insc:this.inscritos)
			aux.add(insc);
		return aux;
	}
	public Actividades getActividade(){
		return this.act.clone();
	}
	public void inscreve(String email){
		this.inscritos.add(email);
	}
	public int nInscritos(){
		return this.inscritos.size();
	}
	public int detalheActTempo(){
		return this.act.getDuracao();
	}
	public double detalheActBurnCals(){
		return this.act.getBurnCals();
	}
	public int getLimiteInsc(){
		return this.limite_Insc;
	}
	public boolean equals(Object other){
		if(this.equals(other)) return true;
		if(this==null||other==null||this.getClass()!=other.getClass()) return false;
		else{
			Event e=(Event) other;
			return(this.getNome().equals(e.getNome())&&this.nInscritos()==e.nInscritos()&&this.getLimiteInsc()==e.getLimiteInsc()&&this.getInscritos().equals(getInscritos()));
		}
		
	}
	
	public String getSimpleEventDate(){
      	DateFormat df = new SimpleDateFormat("dd--MM-yyyy");
    	String d = df.format(this.data_evento.getTime());
    	return d;}
	public String toString(){
		int i=1;
		StringBuilder sb= new StringBuilder();
		sb.append("Nome"+this.getNome());
		sb.append(System.lineSeparator());
		sb.append("Data do evento"+this.getSimpleEventDate());
		sb.append(System.lineSeparator());
		for(String inscr:this.inscritos){
			sb.append("Competidor numero "+i+"\n");
			sb.append(inscr);
			sb.append(System.lineSeparator());
			i++;
		}
		sb.append(this.nInscritos()+"inscritos/Limite de "+this.getLimiteInsc());
		return sb.toString();
	}
	public Event clone(){
		return new Event(this);
	}
	public boolean equalsDate(Object other){
		Event a=(Event) other;
		return (this.getData_Evento().equals(a.getData_Evento()));
	}
	public boolean equalsNome(Object other){
		Event a = (Event) other;
		return(this.getNome().equals(a.getNome()));
	}
	public boolean alreadyInsc(String name){
		return this.inscritos.contains(name);
				}
	
}
