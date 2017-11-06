

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class FileTools {
	
	public static void lectureTrellis(String file, Trellis trellis) throws IOException{
		String number1="";
		String number2="";
		int etat = -1;
	 	BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    int i = 0;
	    try {
		lecteurAvecBuffer = new BufferedReader(new FileReader(file));
	    }
	    catch(FileNotFoundException exc){
		System.out.println("Erreur d'ouverture");
	    }
	    while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	if(ligne.charAt(0) == '%'){
	    		etat = trellis.addEtat();
	    		continue;
	    	}
	    	while(ligne.charAt(i) != ' ')
	    		i++;
	    	number1 = ligne.substring(0, i);
	    	number2 = ligne.substring(i+1);
	    	trellis.addElementToEtat(etat, number1, Float.parseFloat(number2));
	    	i = 0;
	    }
	      
	    lecteurAvecBuffer.close();
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
