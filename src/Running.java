import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Running extends Outdoor 
{
	private static String nome="Corrida";
	public static String getNome(){
		return Running.nome;
		}
	private int distancia;
	private int avgSpeed;
	private int altMin, altMax;
	
	
		
	public Running(int duracao,
			GregorianCalendar data_atividade, int temperatura,
			String condicoes_met, int distancia, int avgSpeed, int altMin,
			int altMax) {
		super(duracao, data_atividade,temperatura,
				condicoes_met);
		this.distancia = distancia;
		this.avgSpeed = avgSpeed;
		this.altMin = altMin;
		this.altMax = altMax;
	}

	public Running(Running other){
		super(other);
		this.distancia=other.getDistancia();
		this.altMin=other.getAltMin();
		this.avgSpeed=other.getAvgSpeed();
		this.altMax=other.getAltMax();
	}

	public Running() {
		super();
		this.distancia = 0;
		this.avgSpeed = 0;
		this.altMin = 0;
		this.altMax = 0;
	}
	public double calcBurnCals(){
		return this.getDuracao()*0.22417*this.diffHeight();
	}
	
public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(Running.getNome());
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
	sb.append("Velocidade Media: ");
	sb.append(this.getAvgSpeed());
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

	public int getAvgSpeed() {
		return avgSpeed;
	}
	public void setAvgSpeed(int avgSpeed) {
		this.avgSpeed = avgSpeed;
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
		return new Running(this);
	}
	public int diffHeight(){
		return this.altMax-this.altMin;
	}
    
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Running other = (Running) obj;
		if (this.getAltMax() != other.getAltMax())
			return false;
		if (this.getAltMin() != other.getAltMin())
			return false;
		if (this.getAvgSpeed() != other.getAvgSpeed())
			return false;
		if (this.getDistancia() != other.getDistancia())
			return false;
		return true;
	}

	
}
