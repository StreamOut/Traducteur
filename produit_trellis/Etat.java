import java.util.ArrayList;

public class Etat {
	private ArrayList<Element> elements;
	
	public Etat(){
		elements = new ArrayList<>();
	}

	public ArrayList<Element> getElements() {
		return elements;
	}
	
	public Element getElement(int elem) {
		return elements.get(elem);
	}
	
	public void addElement(String m, float v){
		elements.add(new Element(m, v));
	}
	
	public int getNbElement(){
		return elements.size();
	}
	
	public Element getMin(){
		Element Min = elements.get(0);
		for(int i = 1; i < elements.size(); i++)
			if(elements.get(i).isSmallerthan(Min))
				Min = elements.get(i);
		return Min;
	}
	
}
