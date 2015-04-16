import java.util.GregorianCalendar;



@SuppressWarnings("serial")
public abstract class Indoor extends Actividades 
{
	  // instance variables - replace the example below with your own
	private String nome_estabelecimento;
	
	public Indoor(){
		super();
		this.nome_estabelecimento = new String();
	}
	
	public Indoor(Indoor outra){
		super(outra);
		this.nome_estabelecimento=outra.getNome_estabelecimento();
	}
	

	public Indoor(int duracao,
			GregorianCalendar data_atividade,
			String nome_estabelecimento) {
		super(duracao, data_atividade);
		this.nome_estabelecimento = nome_estabelecimento;
	}




	public String getNome_estabelecimento() {
		return nome_estabelecimento;
	}

	public void setNome_estabelecimento(String nome_estabelecimento) {
		this.nome_estabelecimento = nome_estabelecimento;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Indoor other = (Indoor) obj;
		if (this.getNome_estabelecimento() == null) {
			if (other.getNome_estabelecimento() != null)
				return false;
		} else if (!this.getNome_estabelecimento().equals(other.getNome_estabelecimento()))
			return false;
		return true;
	}


}
