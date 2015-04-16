import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Treadmill extends Indoor
{
	private static String nome="Treadmill";
	public static String getNome(){
		return Treadmill.nome;
		}
	private int velocidade;
	private int elevation;
	

	public Treadmill() {
		super();
		this.velocidade = 0;
		this.elevation = 0;
	}

	public Treadmill(Treadmill other){
		super(other);
		this.velocidade=other.getVelocidade();
	}

	public double calcBurnCals(){
		return this.getDuracao()*0.1119*(this.getVelocidade()%20)*this.getElevation();
	}
	public Treadmill(int duracao,
			GregorianCalendar data_atividade, 
			String nome_estabelecimento, int velocidade, int elevation) {
		super(duracao, data_atividade, nome_estabelecimento);
		this.velocidade = velocidade;
		this.elevation = elevation;
	}


public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(Treadmill.getNome());
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
	sb.append("Nome do Estabelecimento: ");
	sb.append(this.getNome_estabelecimento());
	sb.append("\n");   	
	sb.append("Velocidade: ");
	sb.append(this.getVelocidade());
	sb.append("\n");
	sb.append("Elevacao: ");
	sb.append(this.getElevation());
	sb.append("\n");
	return sb.toString();
}

	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public Actividades clone(){
		return new Treadmill(this);
	}

	public int getElevation() {
		return elevation;
	}
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Treadmill other = (Treadmill) obj;
		if (this.getElevation() != other.getElevation())
			return false;
		if (this.getVelocidade() != other.getVelocidade())
			return false;
		return true;
	}

}
