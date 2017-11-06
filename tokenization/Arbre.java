package tokenization;

public class Arbre {
	private static Node racine;
	private static int code_mot;
	private static int max = 0;
	
	public static void print_tree(Node n){
		System.out.print(n.getCaractere()+"/");
		if(n.getFils_droit() != null)
			print_tree(n.getFils_droit());
		if(n.getFils_gauche() != null){
			System.out.println();
			print_tree(n.getFils_gauche());
		}
	}
	
	public static void lexicalisation(String line){
		char c;
		boolean droit = true;
		String number="";
		int i = 0;
		Node n = racine;
		if(racine == null){
			racine = new Node(line.charAt(0), -1);
			i++;
			n = racine.getFils_droit();
		}
		Node pere =racine;
		while ((c = line.charAt(i)) != ' '){
			if(n == null){
				n = new Node (c,-1);
				i++;
				if(droit)
					pere.setFils_droit(n);
				else
					pere.setFils_gauche(n);
				droit = true;
				pere = n;
				n = n.getFils_droit();
			}
			else if(n.getCaractere() != c){
				pere = n;
				n = n.getFils_gauche();
				droit =  false;
			}
			else {
				pere = n;
				n = n.getFils_droit();
				i++;
				droit = true;
			}
		}
		i++;
		while(i < line.length()){
			c = line.charAt(i);
		    number = number +c;
		    i++;
		  }
		if(n == null)
			n = pere;
		  n.setValeur(Integer.parseInt(number));
		  if (n.getValeur()>getMax())
			  setMax(n.getValeur());
	}
	public static int tokenize(int indice,String buffer){
		int indiceMot = indice;
		char c;
		setCode_mot(-1);
		Node noeud = racine;
		while(indice < buffer.length() &&  noeud != null){
			c = buffer.charAt(indice);
			if(Separateur.isSeparateur(c))
				c = ' ';
			 if (c == noeud.getCaractere2()){
				 indice++;
				 if(noeud.getValeur()!=-1){
					 setCode_mot(noeud.getValeur());
					 indiceMot = indice;
				 }
				 noeud = noeud.getFils_droit();
			 }
			 else { 
				 noeud = noeud.getFils_gauche();
			 }
		}
		return indiceMot;
	}

	public static int getCode_mot() {
		return code_mot;
	}

	public static void setCode_mot(int code_mot) {
		Arbre.code_mot = code_mot;
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		Arbre.max = max;
	}
}
