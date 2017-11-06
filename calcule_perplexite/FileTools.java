package calcule_perplexite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FileTools {
	
	public static ArrayList<Integer> lecture_phrase(String phrase) throws IOException{
		ArrayList<Integer> codeMots = new ArrayList<>();
	    
	    int i=0,j=0;
	    while (i< phrase.length() ){
	    	while(i < phrase.length() && phrase.charAt(i) == ' ')
				i++;
			i=Arbre.tokenize(i,phrase);
			if (Arbre.getCode_mot() != -1){ 
				codeMots.add(Arbre.getCode_mot());
			}
			else{
				j = i;
			  while ((i<phrase.length()) &&(phrase.charAt(j)!=' '))
			        j++;
			  i = j;
			}
		}
	    return codeMots;
	}
	
	public static HashMap<String, Integer> lecture_compteUnGram(String file) throws IOException{
		HashMap<String, Integer> unGram = new HashMap<String,Integer>();
		String number1="";
		String number2="";
	 	BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    char c='a';
	    int i = 0;
	    try {
		lecteurAvecBuffer = new BufferedReader(new FileReader(file));
	    }
	    catch(FileNotFoundException exc){
		System.out.println("Erreur d'ouverture");
	    }
	    ligne = lecteurAvecBuffer.readLine();
	    while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	if(ligne.contains(":"))
	    		return unGram;
	    	c=ligne.charAt(0);
	    	while(i < ligne.length() && c != ' '){
			    number1 = number1 +c;
			    i++;
			    c = ligne.charAt(i);
			  }
	    	i++;
	    	while(i < ligne.length()){
				c = ligne.charAt(i);
			    number2 = number2 +c;
			    i++;
			  }
	    	unGram.put(number1, Integer.valueOf(number2));
	    	number1="";
	    	number2="";
	    	i=0;
	    	c='a';
	    }
	      
	    lecteurAvecBuffer.close();
	    return unGram;
	}
	public static void lecture_compteDeuxGram(String file,DeuxGram deuxgram) throws IOException{
		String number="";
		String m1 = "", m2= "";
	 	BufferedReader lecteurAvecBuffer = null;
	    String ligne = "";
	    int i = 0,j;
	    try {
		lecteurAvecBuffer = new BufferedReader(new FileReader(file));
	    }
	    catch(FileNotFoundException exc){
		System.out.println("Erreur d'ouverture");
	    }
	    while(!ligne.contains("2 gram:"))
	    	ligne = lecteurAvecBuffer.readLine();
	    while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	j = i +1;
	    	while(ligne.charAt(i) != ' ')
	    		i++;
	    	m1 = ligne.substring(0,i);
	    	j = i + 1;
	    	while(ligne.charAt(j) != ' ')
	    		j++;
	    	m2 = ligne.substring(i+1, j);
	    	number = ligne.substring(j+1);
	    	deuxgram.put(m1,m2, Integer.valueOf(number));
	    	i=0;
	    }
	      
	    lecteurAvecBuffer.close();
	}

}
