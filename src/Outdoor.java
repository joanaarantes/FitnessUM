import java.util.GregorianCalendar;


@SuppressWarnings("serial")
public abstract class Outdoor extends Actividades 
{
	 // instance variables - replace the example below with your own
    private int temperatura;
    private String condicoes_met;
    
    
	public Outdoor(Outdoor outra){
		super(outra);
		this.temperatura=outra.getTemperatura();
		this.condicoes_met=outra.getCondicoes_met();
	}
	
	public Outdoor(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met) {
		super(duracao, data_atividade);
		this.temperatura = temperatura;
		this.condicoes_met = condicoes_met;
	}


	public Outdoor(){
		super();
		this.condicoes_met=new String();
		this.temperatura=0;
	}
	
	
	public int getTemperatura() {
		return this.temperatura;
	}
	
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public String getCondicoes_met() {
		return this.condicoes_met;
	}
	
	public void setCondicoes_met(String condicoes_met) {
		this.condicoes_met = condicoes_met;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Outdoor other = (Outdoor) obj;
		if (this.getCondicoes_met() == null) {
			if (other.getCondicoes_met() != null)
				return false;
		} else if (!this.getCondicoes_met().equals(other.getCondicoes_met()))
			return false;
		if (this.getTemperatura() != other.getTemperatura())
			return false;
		return true;
	}
	
}
