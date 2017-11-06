import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) throws IOException {
		String argv = "";
			Reader in =  new InputStreamReader(System.in) ;
		      for ( ; ; ) {// Boucle infinie, on sort par break
		        int c = in.read ();
		        if (c == -1) break;
		        if ((char) c != '\n')
		        	argv += (char)c;
		      }
		Table table = new Table();
		try {
			FileTools.lectureTable(args[0], table);
			Algo.unGram =FileTools.lecture_compteUnGram(args[1]);
			FileTools.lecture_compteDeuxGram(args[1],Algo.deuxGram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Trellis trellis = new Trellis(argv,table);
		Algo.N1 = Algo.unGram.size();
		Algo.N2 = Algo.deuxGram.size();
	
		Algo.alpha2 = new float[trellis.getNbEtat()][];
		for(int i = 0; i < trellis.getNbEtat(); i++)
			Algo.alpha2[i] = new float[trellis.getEtat(i).getNbElement()];
		Algo.beta = new int[trellis.getNbEtat()];
		if(args[2].contains("1g"))
			Algo.meilleurChemin(trellis);
		else{
			Algo.initialisation(trellis);
			Algo.Viterbi(trellis);	
			Algo.afficheRes(trellis);
		}
		
		
	}

}
