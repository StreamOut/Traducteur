package calcul2gram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n_gram {
	private static Map<Integer,Integer> unGram;
	private static Map<String,Integer> deuxGram = new HashMap<String, Integer>();
	
	public static void generateUnGram(Map<Integer, Integer> occurence){
		unGram = occurence;
	}
	
	public static void generateDeuxGram(ArrayList<String> codeMots){
		int val;
		String key;
		for(int i = 0; i < codeMots.size()-1; i++){
			key = codeMots.get(i)+" "+codeMots.get(i+1);
			if(deuxGram.containsKey(key)){
				val = deuxGram.get(key)+1;
				deuxGram.replace(key, val);
			}
			else
				deuxGram.put(key, 1);
		}
	}
	
	public static Map<Integer, Integer> getUnGram() {
		return unGram;
	}

	public static Map<String, Integer> getDeuxGram() {
		return deuxGram;
	}

	public static void printUnGram(){
		System.out.println("1 gram:");
		Set<Integer> listKeys=unGram.keySet();
		Iterator<Integer> iterateur=listKeys.iterator();
		while(iterateur.hasNext())
		{
			Object key= iterateur.next();
			System.out.println (key+" "+unGram.get(key));
		}
	}
	
	public static void printDeuxGram(){
		System.out.println("2 gram:");
		Set<String> listKeys=deuxGram.keySet();
		Iterator<String> iterateur=listKeys.iterator();
		while(iterateur.hasNext())
		{
			Object key= iterateur.next();
			System.out.println (key+" "+deuxGram.get(key));
		}
	}
	
	public static int getCompte(int mot){
		if(unGram.containsKey(mot))
			return unGram.get(mot);
		return 0;
	}
	
	public static int getCompte(String mot, String mot2){
		if(deuxGram.containsKey(mot+" "+mot2))
			return deuxGram.get(mot+" "+mot2);
		return 0;
	}

}
