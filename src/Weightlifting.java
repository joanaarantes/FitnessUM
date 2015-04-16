import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Weightlifting extends Indoor 
{
	private static String nome="Levantamento de Peso";
	public static String getNome(){
		return Weightlifting.nome;
		}
	private int peso;
	private int numbof_repetitions;
	
	public Weightlifting(){
		super();
		this.peso = 0;
		this.numbof_repetitions = 0;
	}	
	
	public Weightlifting(Weightlifting other){
		super(other.getDuracao(),other.getData_atividade(),other.getNome_estabelecimento());
		this.peso=other.getPeso();
		this.numbof_repetitions=other.getNumbof_repetitions();
	}
	public Weightlifting(int duracao,
			GregorianCalendar data_atividade,
			String nome_estabelecimento, int peso, int numbof_repetitions) {
		super(duracao, data_atividade, nome_estabelecimento);
		this.peso = peso;
		this.numbof_repetitions = numbof_repetitions;
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getNumbof_repetitions() {
		return numbof_repetitions;
	}
	public void setNumbof_repetitions(int numbof_repetitions) {
		this.numbof_repetitions = numbof_repetitions;
	}
	public double calcBurnCals(){
		return this.getDuracao()*0.08*(this.getNumbof_repetitions()/this.getPeso());
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weightlifting other = (Weightlifting) obj;
		if (numbof_repetitions != other.numbof_repetitions)
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}
	public Actividades clone(){
		return new Weightlifting(this);
	}
	public String toString(){
		StringBuffer sb= new StringBuffer();
    	sb.append(Weightlifting.getNome());
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
		sb.append("Peso levantado: ");
		sb.append(this.getPeso());
		sb.append("\n");  
		sb.append("Numero de repeticoes: ");
		sb.append(this.getNumbof_repetitions());
		sb.append("\n");  
		return sb.toString();
	}
}
