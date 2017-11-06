package tokenization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileTools {
	
	public static void lecture_lexique (String file) throws IOException{
	 	BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    try {
		lecteurAvecBuffer = new BufferedReader(new FileReader(file));
	    }
	    catch(FileNotFoundException exc){
		System.out.println("Erreur d'ouverture");
	    }
	    while ((ligne = lecteurAvecBuffer.readLine()) != null)
	      Arbre.lexicalisation(ligne);
	    lecteurAvecBuffer.close();
	}
	
	public static ArrayList<String> lecture_corpus(String file,int occurence[],int size) throws IOException{
		String ligne;
		ArrayList<String> codeMots = new ArrayList<>();
		int temp;
	  	BufferedReader lecteurAvecBuffer = null;
	    try
	      {
		lecteurAvecBuffer = new BufferedReader(new FileReader(file));
	      }
	    catch(FileNotFoundException exc)
	      {
		System.out.println("Erreur d'ouverture");
	      }
	    int i=0,j=0;
	    while ((ligne = lecteurAvecBuffer.readLine()) != null){
	    	i = j =0;
		    while (i< ligne.length() ){
		    	while(i < ligne.length() && ligne.charAt(i) == ' ')
					i++;
				i=Arbre.tokenize(i,ligne);
				if (Arbre.getCode_mot() != -1){ 
					occurence[Arbre.getCode_mot()]++;
					codeMots.add(""+Arbre.getCode_mot());
				}
				else{
					j = i;
				  while ((j<ligne.length()) &&(ligne.charAt(j)!=' '))
				        j++;
				  temp = ExpressionParticuliere.isExpression(ligne.substring(i, j));
				  if(temp != -1)
					  occurence[temp + Arbre.getMax()+1]++;
				  else
					  occurence[0]++;
				  i = j;
				}
			}
		    codeMots.add("\n");
	    }
	    lecteurAvecBuffer.close();
	    return codeMots;
	}
}
