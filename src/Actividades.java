import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 *Uma Actividade física, será definida pelo seu nome(Futebol, Natação, etc...), duração, pela sua data e pelo número de calorias queimadas
 * 
 * @author Joana Arantes; José Pereira; Pedro Cunha
 * @version 2014.05.20
 */
public abstract class Actividades implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7611773747461069993L;
	/**
	 * 
	 */
	// instance variables - replace the example below with your own
    private int duracao;
    private GregorianCalendar data_atividade;
    private double burnCals;
    private static String nome;
	
    
    /**
     * Construtor Parametrizado
     * @param nome_Act Nome da Actividade
     * @param duracao Duração da Actividade
     * @param data_atividade Data da Actividade 
     * @param burnCals Quantidade de Calorias Queimadas
     */

	public Actividades(int duracao,
			GregorianCalendar data_atividade) {
		super();
		this.duracao = duracao;
		this.data_atividade = data_atividade;
		this.burnCals=this.getBurnCals();
	}
	public Actividades(Actividades other){
		this.duracao=other.getDuracao();
		this.data_atividade=other.getData_atividade();
		this.burnCals=other.getBurnCals();
	}
/**
 * Construtor Vazio
 */
	public Actividades() 
	{
		
		this.duracao = 0;
		this.burnCals=0.0;
		this.data_atividade = new GregorianCalendar();
	}

	
	

	public static String getNome() { return Actividades.nome; }
/**
 * 
 * @return Duração da actividade física
 */
	public int getDuracao() {
		return duracao;
	}
/**
 * 
 * @param duracao Duração que será atualizada na instância
 */

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

/**
 * 
 * @return Data da actividade física
 */
	public GregorianCalendar getData_atividade() {
		return (GregorianCalendar)data_atividade.clone();
	}

/**
 * 
 * @param data_atividade Data que será atualizada na instância
 */
	public void setData_atividade(GregorianCalendar data_atividade) {
		this.data_atividade = data_atividade;
	}

/**
 * 
 * @return As calorias queimadas no decorrer da actividade
 */
	public double getBurnCals() {
		return this.burnCals;
	}
	public abstract double calcBurnCals();


	/**
	 * @param obj Objecto a ser comparado com o this
	 * @return Valor booleano sobre a igualdade semântica entre os dois objectos
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Actividades other = (Actividades) obj;
		if (this.getBurnCals() != other.getBurnCals())
			return false;
		if (this.getData_atividade() == null) {
			if (other.getData_atividade() != null)
				return false;
		} else if (!this.getData_atividade().equals(other.getData_atividade()))
			return false;
		if (this.getDuracao() != other.getDuracao())
			return false;
		return true;
	}
/**
 * Representação texual da actividade
 */
    public abstract String toString();
    /**
     * Retorna uma nova Actividade igual semanticamente ao this
     */
	public abstract Actividades clone();
	
}

