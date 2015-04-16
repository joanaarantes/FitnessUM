import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class TableTennis extends Indoor 
{
	private static String nome="Tenis de Mesa";
	public static String getNome(){
		return TableTennis.nome;
		}
	private int scoredpoints;
	private int concededpoints;
		
	public TableTennis(){
		super();
		this.scoredpoints = 0;
		this.concededpoints = 0;

	}

	public TableTennis(TableTennis other){
		super(other);
		this.scoredpoints=other.getScoredpoints();
		this.concededpoints=other.getConcededpoints();

	}
	public TableTennis(int duracao,
			GregorianCalendar data_atividade,
			String nome_estabelecimento, int scoredpoints, int concededpoints
			) {
		super(duracao, data_atividade, nome_estabelecimento);
		this.scoredpoints = scoredpoints;
		this.concededpoints = concededpoints;

	}



	public int getScoredpoints() {
		return scoredpoints;
	}
	public void setScoredpoints(int scoredpoints) {
		this.scoredpoints = scoredpoints;
	}
	
	public int getConcededpoints() {
		return concededpoints;
	}
	public void setConcededpoints(int concededpoints) {
		this.concededpoints = concededpoints;
	}

	public Actividades clone(){
		return new TableTennis(this);
	}

	public double calcBurnCals(){
		return 0.0481*this.getDuracao();
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		TableTennis other = (TableTennis) obj;
		if (this.getConcededpoints() != other.getConcededpoints())
			return false;
		if (this.getScoredpoints() != other.getScoredpoints())
			return false;
		return true;
	}
public String toString(){
	StringBuffer sb= new StringBuffer();
	sb.append(TableTennis.getNome());
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
	sb.append("Pontos Marcados: ");
	sb.append(this.getScoredpoints());
	sb.append("\n"); 
	sb.append("Pontos Sofridos: ");
	sb.append(this.getConcededpoints());
	sb.append("\n"); 

	return sb.toString();
}

}
