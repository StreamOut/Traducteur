package calcule_perplexite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Perplexité {
	private static float alpha = (float) 0.1;
	private static HashMap<String, Integer> unGram;
	private static DeuxGram deuxGram = new DeuxGram();
	private static float N1;
	private static float N2;
	
	
	public static float perp_ungram(String mot) {
		float perp = alpha;
		if (unGram.containsKey(mot))
			perp += unGram.get(mot);
		else
			System.out.println("Mot : "+mot);
		return (float) -Math.log(perp / (N1 + N1 * alpha));
	}

	public static float perp_deuxgram(String mot, String mot2) {
		float per1 = alpha, per2 = N2 * alpha;
		if (deuxGram.containsKey(mot,mot2))
			per1 += deuxGram.get(mot,mot2);
		if (unGram.containsKey(mot))
			per2 += unGram.get(mot);
		return (float) -Math.log(per1 / per2);
	}

	public static float perp_phrase(String phrase[], int size) {
		float somme = 0;
		for (int i = 0; i < size -1; i++) {
			somme += perp_deuxgram(phrase[i], phrase[i + 1]);
		}
		return (float) Math.log(Math.pow(2,(perp_ungram(phrase[0]) + somme)/(float)size));
	}

	public static void main(String[] args) throws IOException {
		unGram =FileTools.lecture_compteUnGram(args[0]);
		FileTools.lecture_compteDeuxGram(args[0],deuxGram);
		N1 = unGram.size();
		N2 = deuxGram.size();
		String number="",ligne="";
		BufferedReader lecteurAvecBuffer = null;
		int j;
		lecteurAvecBuffer = new BufferedReader(new InputStreamReader(System.in));
		while ((ligne = lecteurAvecBuffer.readLine()) != null){
			String[] temp = new String[ligne.length()];
			j =0;
			for (int i = 0; i < ligne.length(); i++){
				if(ligne.charAt(i) == ' '){
					temp[j] = number;
					number ="";
					j++;
				}
				else{
					number += ligne.charAt(i);
				}
			}
			System.out.println(perp_phrase(temp,j)+"\t"+ligne);
	      }
	}
}
