import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Sprint extends Outdoor 
{
	private static String nome="Sprint";
	public static String getNome(){
		return Sprint.nome;
		}
	private int velMax, distancia;

		
	public Sprint(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met, int velMax, int distancia) {
		super(duracao, data_atividade, temperatura,
				condicoes_met);
		this.velMax = velMax;
		this.distancia = distancia;
	}


	public Sprint(Sprint other){
		super(other);
		this.distancia=other.getDistancia();
		this.velMax=other.getVelMax();
	}
	public Sprint() {
		super();
		this.velMax = 0;
		this.distancia = 0;
	}
public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(Sprint.getNome());
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
	sb.append("Distancia: ");
	sb.append(this.getDistancia());
	sb.append("\n");
	sb.append("Velocidade Maxima: ");
	sb.append(this.getVelMax());
	sb.append("\n");
	return sb.toString();
}
	public int getVelMax() {
		return velMax;
	}
	public void setVelMax(int velMax) {
		this.velMax = velMax;
	}

	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	
	public Actividades clone(){
		return new Sprint(this);
	}
	public double calcBurnCals(){
		return this.getDuracao()*0.278*this.getVelMax();
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Sprint other = (Sprint) obj;
		if (this.getDistancia() != other.getDistancia())
			return false;
		if (this.getVelMax() != other.getVelMax())
			return false;
		return true;
	}
	

}
