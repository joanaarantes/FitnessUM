import java.util.GregorianCalendar;
/**
 * Um jogo de Badminton será definido, para além das variáveis das superclasses pelos pontos marcados e pelos pontos sofridos num jogo
 * @author Joana Arantes; José Pereira; Pedro Cunha
 *
 */

@SuppressWarnings("serial")
public class Badminton extends Indoor 
{
	private static String nome = "Badminton";
	public static String getNome(){
		return Badminton.nome;
		}
	private int scored;
	private int conceded;

/**
 * Construtor Vazio
 */
	public Badminton(){
		super();
		this.scored=0;
		this.conceded=0;
	}
/**
 * Construtor de Cópia
 * @param other Outro jogo de Badminton que será usado como base da nova instância
 */

	public Badminton(Badminton other){
		super(other.getDuracao(),other.getData_atividade(),other.getNome_estabelecimento());
		this.scored=other.getScored();
		this.conceded=other.getConceded();
	}

/**
 * Construtor Parametrizado
 * @param duracao Duração da Actividade
 * @param data_atividade Data da Actividade
 * @param burnCals Calorias Queimadas
 * @param nome_estabelecimento Nome do Estabelecimento
 * @param scored Pontos Marcados
 * @param conceded Pontos Sofridos
 */
	public Badminton(int duracao,
			GregorianCalendar data_atividade,
			String nome_estabelecimento, int scored, int conceded) {
		super(duracao, data_atividade, nome_estabelecimento);
		this.scored = scored;
		this.conceded = conceded;
	}
/**
 * 
 * @return Pontos Marcados
 */
	public int getScored() {
		return scored;
	}
	/**
	 * 
	 * @param scored Pontos marcados que serão atualizados na Instância
	 */
	public void setScored(int scored) {
		this.scored = scored;
	}
/**
 * 
 * @return Pontos Sofridos
 */
	public int getConceded() {
		return conceded;
	}
	/**
	 * 
	 * @param conceded Pontos sofridos que serão atualizados na Instância
	 */
	public void setConceded(int conceded) {
		this.conceded = conceded;
	}
/**
 * @return Representação textual do jogo de Badminton
 */
    public String toString(){
    	StringBuffer sb= new StringBuffer();
    	sb.append(Badminton.getNome());
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
    	sb.append("Marcados: ");
    	sb.append(this.getScored());
    	sb.append("\n");
    	sb.append("Sofridos: ");
    	sb.append(this.getConceded());
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
		Badminton other = (Badminton) obj;
		if (this.getConceded() != other.getConceded())
			return false;
		if (this.getScored() != other.getScored())
			return false;
		return true;
	}
public Actividades clone(){
	return new Badminton(this);
}

public double calcBurnCals(){
	return this.getDuracao()*0.121;
}
}