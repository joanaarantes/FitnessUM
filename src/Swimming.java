import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Swimming extends Outdoor 
{
	private static String nome="Natacao";
	public static String getNome(){
		return Swimming.nome;
		}
	private int distancia;

	
	public Swimming(Swimming other){
		super(other);
		this.distancia=other.getDistancia();
		
	}	
	public Swimming(int duracao,
			GregorianCalendar data_atividade,int temperatura,
			String condicoes_met, int distancia) {
		super(duracao, data_atividade,temperatura,
				condicoes_met);
		this.distancia = distancia;
	}

	public Swimming() {
		super();
		this.distancia = 0;
	}

	
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	
	public Actividades clone(){
		return new Swimming(this);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Swimming other = (Swimming) obj;
		if (this.getDistancia() != other.getDistancia())
			return false;
		return true;
	}
	public double calcBurnCals(){
		return (this.getDistancia()/this.getDuracao())*0.1442;
	}
	public String toString(){
		StringBuffer sb= new StringBuffer();
		sb.append(Swimming.getNome());
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
		return sb.toString();
	}
}
