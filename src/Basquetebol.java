import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Basquetebol extends Indoor 
{
	private static String nome="Basquetebol";
	public static String getNome(){
		return Basquetebol.nome;
		}
	private int marcados, passes;
	
	
	
	
	public Basquetebol(int duracao,
			GregorianCalendar data_atividade, 
			String nome_estabelecimento, int marcados,
			int passes) {
		super(duracao, data_atividade, nome_estabelecimento);
		this.marcados = marcados;
		this.passes = passes;
	}

	public Basquetebol() {
		super();
		this.marcados = 0;
		this.passes = 0;
	}
	
	
	public Basquetebol(Basquetebol activ) {
		super(activ.getDuracao(),activ.getData_atividade(),activ.getNome_estabelecimento());
		this.marcados = activ.getMarcados();
		this.passes = activ.getPasses();
	}


	public double calcBurnCals(){
		return this.getDuracao()*0.112;
	}
	public int getMarcados() {
		return marcados;
	}
	public void setMarcados(int marcados) {
		this.marcados = marcados;
	}
	
	public int getPasses() {
		return passes;
	}
	public void setPasses(int passes) {
		this.passes = passes;
	}

	
	public String toString(){
		StringBuffer sb= new StringBuffer();
    	sb.append(Basquetebol.getNome());
    	sb.append(";\n");
    	sb.append("Data: ");
    	sb.append(this.getData_atividade());
    	sb.append("\n");
    	sb.append("Duracao: ");
    	sb.append(this.getDuracao());
    	sb.append("\n");
    	sb.append("Nome do Estabelecimento: ");
    	sb.append(this.getNome_estabelecimento());
    	sb.append("\n");   	
		sb.append("Pontos Marcados: ");
		sb.append(this.getMarcados());
		sb.append("\n");
		sb.append("Passes Efectuados: ");
		sb.append(this.getPasses());
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
		Basquetebol other = (Basquetebol) obj;
		if (this.getMarcados() != other.getMarcados())
			return false;
		if (this.getPasses() != other.getPasses())
			return false;
		return true;
	}
	public Actividades clone(){
		return new Basquetebol(this);
	}
	
}

