package gestioneRegistroEta;

public class NomeEta {
	String nome;
	int eta;
	
	public NomeEta(String nome,int eta) {
		this.nome=nome;
		this.eta=eta;
	}
	
	public void incrementaEta() {
		this.eta+=1;
	}
	
	public int getEta() {
		return eta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String individuo() {
		return nome+" studente di "+eta+" anni";
	}

}
