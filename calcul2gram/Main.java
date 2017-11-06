package calcul2gram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	private static HashMap<Integer, Integer> occurence = new HashMap<>();
	private static ArrayList<String> codeMots = new ArrayList<>();
	
	private static void init(String arg){
	    String number ="";
	    for(int i = 1; i< arg.length(); i++){
	    	if(arg.charAt(i) != ' ')
	    		number += arg.charAt(i);
	    	else{
	    		if(occurence.containsKey(Integer.valueOf(number)))
	    			occurence.replace(Integer.valueOf(number), occurence.get(Integer.valueOf(number).intValue())+1);
	    		else
	    			occurence.put(Integer.valueOf(number),1);
	    		codeMots.add(number);
	    		number = "";
	    	}
	    }
	}
	
	public static void main(String[] args) throws IOException {
		String ligne="";
		BufferedReader lecteurAvecBuffer = null;
		if(args.length < 1){
			lecteurAvecBuffer = new BufferedReader(new InputStreamReader(System.in)) ;
			while ((ligne = lecteurAvecBuffer.readLine()) != null){
				init(ligne);
			}
		}
		n_gram.generateUnGram(occurence);
		n_gram.generateDeuxGram(codeMots);
		//FileTools.ecrire_Gram(n_gram.getUnGram(),"output/comptesUnGram");
		//FileTools.ecrire_Gram(n_gram.getDeuxGram(),"output/comptesDeuxGram");
		n_gram.printUnGram();
		n_gram.printDeuxGram();
	}
}
