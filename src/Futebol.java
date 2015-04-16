import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Futebol extends Outdoor 
{
	private static String nome="Futebol";
	public static String getNome(){
		return Futebol.nome;
		}
	private int golosMarc, golosSofr;
	private int passes;
	

	
	public Futebol(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met, int golosMarc, int golosSofr, int passes) {
		super(duracao, data_atividade, temperatura,
				condicoes_met);
		this.golosMarc = golosMarc;
		this.golosSofr = golosSofr;
		this.passes = passes;
	}
	public Futebol(Futebol other){
		super(other);
		this.golosMarc=other.getGolosMarc();
		this.golosSofr=other.getGolosSofr();
		this.passes=other.getPasses();
	}

	public Futebol() {
		super();
		this.golosMarc = 0;
		this.golosSofr = 0;
		this.passes = 0;
	}


	public int getGolosMarc() {
		return golosMarc;
	}
	public void setGolosMarc(int golosMarc) {
		this.golosMarc = golosMarc;
	}
	public double calcBurnCals(){
	return this.getDuracao()*0.1442;
	}
	public int getGolosSofr() {
		return golosSofr;
	}
	public void setGolosSofr(int golosSofr) {
		this.golosSofr = golosSofr;
	}

	public int getPasses() {
		return passes;
	}
	public void setPasses(int passes) {
		this.passes = passes;
	}

public Actividades clone(){
	return new Futebol(this);
}

public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(Futebol.getNome());
	sb.append(";\n");
	sb.append("Data: ");
	sb.append(this.getData_atividade());
	sb.append("\n");
	sb.append("Duracao: ");
	sb.append(this.getDuracao());
	sb.append("\n");
	sb.append("Calorias Queimadas: ");
	sb.append(this.getBurnCals());
	sb.append("\n");
	sb.append("Temperatura: ");
	sb.append(this.getTemperatura());
	sb.append("\n");
	sb.append("Condicoes Meteorologicas: ");
	sb.append(this.getCondicoes_met());
	sb.append("\n");
	sb.append("Golos Marcados: ");
	sb.append(this.getGolosMarc());
	sb.append("\n");
	sb.append("Golos Sofridos: ");
	sb.append(this.getGolosSofr());
	sb.append("\n");
	sb.append("Passes Efectuados: ");
	sb.append(this.getPasses());
	sb.append("\n");
	return sb.toString();
}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Futebol other = (Futebol) obj;
		if (this.getGolosMarc() != other.getGolosMarc())
			return false;
		if (this.getGolosSofr() != other.getGolosSofr())
			return false;
		if (this.getPasses() != other.getPasses())
			return false;
		return true;
	}
	
	
	
}
