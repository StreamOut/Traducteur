

import java.util.ArrayList;

public class DeuxGram {
	private ArrayList<GramElement> elements;
	
	public DeuxGram (){
		elements = new ArrayList<>();
	}
	
	public void put (String m1, String m2, int v){
		elements.add(new GramElement(m1, m2, v));
	}
	
	public boolean containsKey(String m1, String m2){
		for(int i =0; i< elements.size(); i++){
			if(elements.get(i).isKey(m1, m2))
				return true;
			//System.out.println("M1 : "+m1+" M2 : "+m2);
			//elements.get(i).display();
		}
		return false;
	}
	
	public int get(String m1, String m2){
		for(int i =0; i< elements.size(); i++)
			if(elements.get(i).isKey(m1, m2))
				return elements.get(i).getElement();
		return 0;
	}
	
	public int size(){
		return elements.size();
	}
	
	public void display(){
		for(int i = 0; i < elements.size(); i++)
			elements.get(i).display();
	}

}
