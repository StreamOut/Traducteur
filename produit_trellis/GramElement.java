
public class GramElement {
	private String mot1;
	private String mot2;
	private int valeur;
	
	public GramElement (String m1, String m2, int v){
		mot1 = m1;
		mot2 = m2;
		valeur = v;
	}
	
	public boolean isKey(String m1, String m2){
		if(m1.compareTo(mot1) == 0)
			if(m2.compareTo(mot2) == 0)
				return true;
		return false;
	}

	public int getElement (){
		return valeur;
	}
	
	public void display(){
		System.out.println("Mot1 : "+mot1+" Mot2 : "+mot2+" Valeur : "+valeur);
	}
}
