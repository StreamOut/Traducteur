import java.io.IOException;
import java.util.HashMap;


public class Algo {
	private static HashMap<String, Integer> unGram;
	private static DeuxGram deuxGram = new DeuxGram();
	private static float alpha = (float) 0.1;
	private static float[][] alpha2;
	private static int[] beta;
	private static float N1;
	private static float N2;
	
	public static void initialisation(Trellis trellis) {
		for(int j=0; j < trellis.getEtat(0).getNbElement(); j++){
			alpha2[0][j]=trellis.getEtat(0).getElement(j).getValeur();
		}
	}
	
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
	
	private static int trouve_min_alpha(int i){
		float min = 9999999;
		int m = 0;
		int j;
		for (j = 0; j < alpha2[i].length; j++){
			if(alpha2[i][j] < min){
				min = alpha2[i][j];
				m = j;
			}
		}
		return m;
	}
	
	public static void Viterbi(Trellis trellis){
		int nbEtat = trellis.getNbEtat();
		int min;
		Element elem;
		for(int i = 1; i < nbEtat; i++){
			min=trouve_min_alpha(i-1);
			beta[i-1]=min;
			for(int j = 0; j < trellis.getEtat(i).getNbElement(); j++){
				elem = trellis.getEtat(i).getElement(j);
				alpha2[i][j]=alpha2[i-1][min]+elem.getValeur()+perp_deuxgram(trellis.getEtat(i-1).getElement(min).getMot() , elem.getMot());
			}
		}
		min=trouve_min_alpha(nbEtat-1);
		beta[nbEtat-1]=min;
	}
	
	public static void meilleurChemin(Trellis trellis){
		int nbEtat = trellis.getNbEtat();
		Element[] resultat = new Element[nbEtat];
		for(int i = 0; i < nbEtat; i++){
			resultat[i] = trellis.getEtat(i).getMin();
			System.out.print(resultat[i].getMot()+" ");
		}
	}
	
	public static void afficheRes(Trellis trellis){
		int etat = 0;
		for(int i = 0 ; i < beta.length; i++){
			//System.out.println("Etat "+etat+ " size "+trellis.getEtat(etat).getNbElement()+ " > " +beta[i]);
				System.out.print(trellis.getEtat(etat).getElement((int) beta[i]).getMot()+ " ");
			etat++;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Trellis trellis = new Trellis();
		
			
		try {
			FileTools.lectureTrellis(args[0], trellis);
			unGram =FileTools.lecture_compteUnGram(args[1]);
			FileTools.lecture_compteDeuxGram(args[1],Algo.deuxGram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		N1 = unGram.size();
		N2 = deuxGram.size();
		
	
		alpha2 = new float[trellis.getNbEtat()][];
		for(int i = 0; i < trellis.getNbEtat(); i++)
			alpha2[i] = new float[trellis.getEtat(i).getNbElement()];
		beta = new int[trellis.getNbEtat()];
		
		initialisation(trellis);
		Viterbi(trellis);	
		afficheRes(trellis);
		//meilleurChemin(trellis);
	}

}
