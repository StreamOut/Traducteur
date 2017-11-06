import java.util.ArrayList;

public class Trellis {
	private ArrayList<Etat> etats;
	
	public Trellis (){
		etats = new ArrayList<>();
	}
	
	public Trellis (String phrase, Table table){
		int i = 0, j = 0, etat = 0;
		String number;
		etats = new ArrayList<>();
		while (i < phrase.length()){
			etat = addEtat();
	    	j = i +1;
	    	while(phrase.charAt(j) != ' ')
	    		j++;
	    	number = phrase.substring(i,j);
	    	for(int k = 0; k < table.getEtat(Integer.parseInt(number)-1).getNbElement(); k++){
	    		addElementToEtat(etat, table.getEtat(Integer.parseInt(number)-1).getElement(k).getMot(), table.getEtat(Integer.parseInt(number)-1).getElement(k).getValeur());
	    	}
	    	i = j +1;
	    }
	}

	public ArrayList<Etat> getEtats() {
		return etats;
	}

	public int addEtat(){
		etats.add(new Etat());
		return etats.size() -1;
	}
	
	public void addElementToEtat(int etat, String m, float v){
		if(etat >= etats.size())
			etat = addEtat();
		etats.get(etat).addElement(m, v);
	}
	
	public Etat getEtat(int etat){
		if(etat < etats.size())
			return etats.get(etat);
		return null;
	}
	
	public int getNbEtat(){
		return etats.size();
	}

}
