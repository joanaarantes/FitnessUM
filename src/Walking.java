import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Walking extends Outdoor 
{
	private static String nome="Caminhada";
	public static String getNome(){
		return Walking.nome;
		}
	private int distancia;
	private int altMin, altMax;
	

	public Walking(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met, int distancia, int altMin, int altMax) {
		super(duracao, data_atividade, temperatura,
				condicoes_met);
		this.distancia = distancia;
		this.altMin = altMin;
		this.altMax = altMax;
	}
	public double calcBurnCals(){
		return this.getDuracao()*0.04*this.diffHeight();
	}
	public Walking(Walking other){
		super(other);
		this.distancia=other.getDistancia();
		this.altMin=other.getAltMin();
		this.altMax=other.getAltMax();
	}

	public Walking() {
		super();
		this.distancia = 0;
		this.altMin = 0;
		this.altMax = 0;
	}
	
	public String toString(){
		StringBuffer sb= new StringBuffer();
		sb.append(Walking.getNome());
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
		sb.append("Altura Minima: ");
		sb.append(this.getAltMin());
		sb.append("\n");
		sb.append("Altura Maxima: ");
		sb.append(this.getAltMax());
		sb.append("\n");
		return sb.toString();
	}
		
	
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getAltMin() {
		return altMin;
	}
	public void setAltMin(int altMin) {
		this.altMin = altMin;
	}

	public int getAltMax() {
		return altMax;
	}
	public void setAltMax(int altMax) {
		this.altMax = altMax;
	}
	
	public Actividades clone(){
		return new Walking(this);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Walking other = (Walking) obj;
		if (altMax != other.altMax)
			return false;
		if (altMin != other.altMin)
			return false;
		if (distancia != other.distancia)
			return false;
		return true;
	}
		
	public int diffHeight(){
		return this.getAltMax()-this.getAltMin();
	}
	
	
}
