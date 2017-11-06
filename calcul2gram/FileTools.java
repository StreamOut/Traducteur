package calcul2gram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FileTools {
	
	
	public static void ecrire_Gram(Map map, String path){
		File f = new File (path);
		Set listKeys=map.keySet();
		Iterator iterateur=listKeys.iterator();
		try
		{
		    FileWriter fw = new FileWriter (f);
		    while(iterateur.hasNext())
			{
				Object key= iterateur.next();
				fw.write (String.valueOf (key)+" "+map.get(key));
		        fw.write ("\r\n");
			}
		    fw.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		
	}

}
