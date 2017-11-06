package calcule_perplexite;

import java.util.ArrayList;

public class Separateur {
	private static ArrayList<Character> separateurs = new ArrayList<Character>();
	
	public static boolean isSeparateur(char c){
		return separateurs.contains(Character.valueOf(c));
	}
	
	public static void create(){
		separateurs.add(Character.valueOf('-'));
		separateurs.add(Character.valueOf(' '));
	}

}
