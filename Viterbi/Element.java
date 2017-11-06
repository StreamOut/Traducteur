
public class Element {
	private String mot = "";
	private float valeur = 0;
	
	public Element(String m, float v){
		mot = m;
		valeur = v;
	}
	
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public boolean isSmallerthan(Element elem){
		if(valeur < elem.getValeur())
			return true;
		return false;
	}
}
