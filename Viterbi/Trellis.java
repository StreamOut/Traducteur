import java.util.ArrayList;

public class Trellis {
	private ArrayList<Etat> etats;
	
	public Trellis (){
		etats = new ArrayList<>();
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
