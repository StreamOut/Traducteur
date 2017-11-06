package tokenization;

public class Node {
	private char caractere;
	private int valeur;
	private Node fils_droit;
	private Node fils_gauche;
	
	public Node (char c, int v){
		caractere = c;
		valeur = v;
	}

	public Node getFils_droit() {
		return fils_droit;
	}

	public void setFils_droit(Node fils_droit) {
		this.fils_droit = fils_droit;
	}

	public Node getFils_gauche() {
		return fils_gauche;
	}

	public void setFils_gauche(Node fils_gauche) {
		this.fils_gauche = fils_gauche;
	}

	public char getCaractere() {
		return caractere;
	}
	public char getCaractere2() {
		if(caractere == '_')
			return ' ';
		return caractere;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
}
