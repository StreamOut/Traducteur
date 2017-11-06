import java.util.ArrayList;

public class Table {
private ArrayList<Etat> mots;
	
	public Table (){
		mots = new ArrayList<>();
	}

	public ArrayList<Etat> getMots() {
		return mots;
	}

	public int addMot(){
		mots.add(new Etat());
		return mots.size() -1;
	}
	
	public void addElementToMot(int mot, String m, float v){
		if(mot >= mots.size())
			mot = addMot();
		mots.get(mot).addElement(m, v);
	}
	
	public Etat getEtat(int mot){
		if(mot < mots.size())
			return mots.get(mot);
		return null;
	}
	
	public int getNbEtat(){
		return mots.size();
	}
}
