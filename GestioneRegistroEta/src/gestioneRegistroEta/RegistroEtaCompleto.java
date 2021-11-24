package gestioneRegistroEta;
import java.util.Vector;

public class RegistroEtaCompleto {
	private Vector<NomeEta> nomeEta=new Vector<NomeEta>();
	
	public void addElemento(NomeEta nomeEta) {
		this.nomeEta.add(nomeEta);
	}
	
	
	
	public boolean cercaEIncrementa(String nome) {
		for(int i=0;i<nomeEta.size();i++) {
			if(nome.equals(nomeEta.get(i).getNome())) {
				nomeEta.get(i).incrementaEta();
				System.out.println("Hai incrementato l'età di "+nome);
				return true;
			}	
		}
		System.out.println("Non esiste alcuno studente con questo nome");
		return false;
	}
	
	public String individui() {
		String completa="";
		
		for(int i=0;i<nomeEta.size();i++)
			completa+=nomeEta.get(i).individuo()+"\n";
		
		return completa;
	}
	
	

}
