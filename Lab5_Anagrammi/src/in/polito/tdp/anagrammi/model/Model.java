package in.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	
	private List<String> listaAnagrammi=new ArrayList<String>();
	
	/**
	 * Metodo che cerca gli anagrammi richiamando la funzione recorsiva
	 * @param parola sotto forma di stringa
	 * @return lista di anagrammi in stringhe
	 */
	
	public List<String> cercaAnagrammi(String parola) {
		listaAnagrammi.clear();
		String parziale="";
		this.recorsiveAnagrammi(parola, parziale, 0);
		return this.listaAnagrammi;
	}

	
	
	/**
	 * Metodo ricorsivo che permette di creare tutti gli anagrammi della parola passata come parametro
	 * @param parolaOriginale parola di cui fare gli anagrammi
	 * @param parolaParziale stringa vuota che verrà via via riempita per formare gli anagrammi
	 * @param livello inizialmente 0
	 */
	private void recorsiveAnagrammi(String parolaOriginale, String parolaParziale, int livello) {
	
		int dim=parolaOriginale.length();
		
		if(livello==dim) {
			String p=parolaParziale;
			listaAnagrammi.add(p);
			return;
		}
		
		
		for(int i=0; i<dim;i++) {
			
			if(contaCaratteri(parolaParziale, parolaOriginale.charAt(i))<contaCaratteri(parolaOriginale, parolaOriginale.charAt(i))) {
				parolaParziale=parolaParziale+parolaOriginale.charAt(i);
				recorsiveAnagrammi(parolaOriginale, parolaParziale, livello+1);
				parolaParziale=parolaParziale.substring(0, parolaParziale.length()-1);		//si toglie l'ultima lettera dell'anagramma formato(parziale)
				/*In questo modo l'ultima riga è accessibile:
				 * o quando level==dim e si fa return 
				 * o quando terminano tutte le probabilità di fornire un anagramma diverso da quello già creato
				 * e quindi si toglie l'ultima lettera del parziale
				 */
			}
			
			
		}
		
		
		
		
	}
	
	/**
	 * Metodo che serve per capire quante volte il carattere viene ripetuto nella stringa
	 * @param s stringa
	 * @param c chat
	 * @return num di volte in cui il carattere passato come parametro viene ripetuto nella stringa 
	 */

	private int contaCaratteri(String s, char c) {
		
		int numCaratteri=0;
		char[] array=s.toCharArray();		//converte la stringa in array di char
		
		for(int i=0; i<array.length;i++) {
			if(c==array[i]) {		
			numCaratteri=numCaratteri+1;
			}
		}
		
		return numCaratteri;
	}
	
	
	public boolean isCorrect(String parola) {
		AnagrammaDAO dao=new AnagrammaDAO();
		return dao.isCorrect(parola);
	}
	
	

}
