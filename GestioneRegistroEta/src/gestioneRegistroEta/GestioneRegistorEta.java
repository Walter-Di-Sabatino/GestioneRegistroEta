package gestioneRegistroEta;
import java.util.*;
import java.io.*;

public class GestioneRegistorEta {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Scanner file_input = null;
		boolean x=true;
		RegistroEtaCompleto registro;

		do {
			x=false;
			try {

				System.out.println("Da quale file vuoi prendere dati?");
				String nome=input.next();


				file_input = new Scanner(new BufferedReader(new FileReader(nome)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Non esiste alcun file con questo nome.");
				input=new Scanner(System.in);
				x=true;
			}
		}while(x);

		registro=new RegistroEtaCompleto();

		try {
			while(file_input.hasNext()) {

				String nome=file_input.next();
				int eta=file_input.nextInt();
				NomeEta nomeEta=new NomeEta(nome,eta);
				registro.addElemento(nomeEta);
			}			
			file_input.close();




			int n=0,contatore=0;
			do {
				System.out.println("MENU");
				System.out.println("Premi 0 per uscire");
				System.out.println("Premi 1 per salvare i dati");
				System.out.println("Premi 2 per incrementare l'età di un individuo");
				System.out.println("Premi 3 per aggiungere un'elemento");
				System.out.println("Premi 4 per visualizzare il registro");
				n=input.nextInt();

				switch(n) {
				case 0:
					if(contatore>0)
						System.out.println("Ci sono state modifiche al file originale");
					break;
				case 1:
					PrintWriter file_output = new PrintWriter( new BufferedWriter(new FileWriter("FileDiDati.txt")));
					file_output.print(registro.individui());
					file_output.close();
					break;
				case 2:
					System.out.println("Inserisci il nome dello studente a cui aumentare l'età");

					String nome=input.next();
					if(registro.cercaEIncrementa(nome))
						contatore++;
					break;
				case 3:
					System.out.println("Inserisci il nome dello studente da aggiungere");
					String nome1=input.next();
					System.out.println("Inserisci l'età dello studente da aggiungere");
					int eta1=input.nextInt();
					NomeEta nomeEta1=new NomeEta(nome1,eta1);
					registro.addElemento(nomeEta1);
					contatore++;
					break;
				case 4:
					System.out.print(registro.individui());
					break;
				}
			}while(n!=0);
			System.out.println("Arrivederci!");
			
		}catch(IOException e){
			System.out.println("Eroore di I/O");
			System.out.println(e);
		}
	 }
	 

}
