package tokenization;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
	private static int[] occurence;
	private static ArrayList<String> codeMots;
	private static int size;
	
	private static void init_occurence(){
		size = Arbre.getMax()+1 + ExpressionParticuliere.size();
	    occurence = new int[size];
	    for(int i = 0; i < size ; i++)
	    	occurence[i]=0;
	}
	
	private static void print_occurence(){
		for(int j = 0; j < size ; j++)
	    	if(occurence[j]!=0)
	    		if(j == 0)
	    			System.out.println("Mots inconnus"+" -> "+occurence[j]);
	    		else
	    			System.out.println(j+" -> "+occurence[j]);
	}
	
	private static void print_codeMot(){
		for(int j = 0; j < codeMots.size() ; j++){
			if(codeMots.get(j).contains("\n"))
				System.out.print(codeMots.get(j));
			else
				System.out.print(codeMots.get(j)+ " ");
		}
	    	
	}
	
	public static void main(String[] args) throws IOException {
		Separateur.create();
		ExpressionParticuliere.create();
		FileTools.lecture_lexique(args[0]);
	    init_occurence();
		codeMots = FileTools.lecture_corpus(args[1],occurence,size);
		print_codeMot();
	}
}
