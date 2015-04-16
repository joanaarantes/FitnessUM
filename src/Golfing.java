import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Golfing extends Outdoor 
{
	private static String nome="Golf";
	public static String getNome(){
		return Golfing.nome;
		}
	private int pontos, nBuracos;
	
	
	
	
	public Golfing(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met, int pontos, int nBuracos) {
		super(duracao, data_atividade, temperatura,
				condicoes_met);
		this.pontos = pontos;
		this.nBuracos = nBuracos;
	}
	public Golfing(Golfing other){
		super(other);
		this.pontos=other.getPontos();
		this.nBuracos=other.getnBuracos();
	}

	public Golfing() {
		super();
		this.pontos = 0;
		this.nBuracos = 0;
	}

	public double calcBurnCals(){
		return this.getDuracao()*0.0561;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getnBuracos() {
		return nBuracos;
	}
	public void setnBuracos(int nBuracos) {
		this.nBuracos = nBuracos;
	}

public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(Golfing.getNome());
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
	sb.append("Pontos: ");
	sb.append(this.getPontos());
	sb.append("\n");
	sb.append("Numero de Buracos: ");
	sb.append(this.getnBuracos());
	sb.append("\n");
	return sb.toString();
}
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Golfing other = (Golfing) obj;
		if (this.getnBuracos() != other.getnBuracos())
			return false;
		if (this.getPontos() != other.getPontos())
			return false;
		return true;
	}
	
	public Actividades clone(){
		return new Golfing(this);
	}

}
