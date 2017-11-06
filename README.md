# Traducteur
Traducteur automatique utilisant des corpus de texte pour apprendre la langue a traduire


 ___________________________________________________________________________
|    Auteurs:								    |
|	Malo	DUMONT			 		 Date : 07/12/2016  |
|								    	    |
|___________________________________________________________________________|

----------------------------------Avertissement------------------------------

Faire bien attention à ne pas confondre argument et récupération de la sortie
standard. En java les deux ne peuvent ce confondre comme en c. Il est donc 
conseillé de bien respecter les indications faites pour les arguments de 
chaque programme.

--------------------------------------Tokenize-------------------------------

Tokenize prend en argument un fichier lexique et un fichier à tokenizer. Il 
écrit sur la sortie standard les mot du fichier à tokenizersous forme de code.

Exemple : java -jar tokenize.jar data/lexique_ratp_en.txt data/corpus.txt

------------------------------------Calcule 2 gram---------------------------

Calcule 2 gram récupère la sortie standard par exemple le résultat de
l'execution de tokenize. Puis il écrit l'éstimation du modèle de langage sur 
la sortie standard.

Exemple : java -jar tokenize.jar data/lexique_ratp_fr.txt data/corpus_ratp_fr.txt
 | java -jar calcule_2gram_model.jar 

---------------------------------Calcule Perplexite--------------------------

Calcule Perplexite récupère la sortie standard par exemple le résultat de
l'execution de tokenize et prend en argument le fichier de compte calculé par 
calcule 2 gram. Puis il écrit le résultat de la perplexite de chaque phrase
ainsi que son code sur la sortie standard.

Exemple : java -jar tokenize.jar data/lexique_ratp_fr.txt data/phase_test1.txt 
| java -jar calcule_perplexite.jar data/modele_2g_ratp_fr.txt | sort -n

---------------------------------------Viterbi-------------------------------

Viterbi prend deux argument le premier est le fichier de trellis le dauxième 
est le fichier de compte. Il écrite sur la sortie standard la phrase résultat 
sous forme de code.

Exemple : java -jar Viterbi.jar data/exemple_treillis.txt data/modele_2g_ratp_fr.txt 

----------------------------------Produit Treillis---------------------------

Produit treillis récupère la sortie standard par exemple le résultat de
l'execution de tokenize et prend en argument le lexique utilisé et une table de
traduction. Puis il affiche le résultat sous forme de code.

Exemple : java -jar tokenize.jar data/lexique_ratp_en.txt data/phase_test2.txt 
| java -jar produit_treillis.jar data/table_ratp_en_fr_20iter.code 
data/modele_2g_ratp_fr.txt 2g

------------------------------------Table Generation---------------------------

Malheuresement cette partie du projet ne fonctionne pas

------------------------------------Trace--------------------------------------

java -jar tokenize.jar data/lexique_ratp_fr.txt data/phase_test1.txt | java -jar calcule_perplexite.jar data/modele_2g_ratp_fr.txt | sort -n
3.1657658	6458 5926 4554 215 8908 290 
3.3592658	4554 215 8908 290 6458 5926 
3.9661164	290 5926 4554 215 8908 6458 
4.2431693	6458 8908 290 4554 215 5926 
4.497009	290 6458 5926 8908 4554 215 
4.9515224	290 6458 8908 5926 215 4554 
5.3732724	6458 4554 290 5926 215 8908 
5.917183	4554 290 215 5926 8908 6458 
6.4972396	5926 215 290 6458 4554 8908 
6.8029575	8908 215 5926 290 4554 6458 

java -jar tokenize.jar data/lexique_ratp_en.txt data/phase_test2.txt | java -jar produit_treillis.jar data/table_ratp_en_fr_20iter.code data/modele_2g_ratp_fr.txt 2g
8832 1055 4625 660 5357 6553 8908 1203 2317 1683 302 1450 2317 5751 3311 4761 6665 1346 6458 6394 2317 1695 3298 2298 9189 4145 9193 910 1210 3298 5994 8832 4883 4574 9283 7960 18 4688 369 4384 1890 4761 7740 1203 9297 5940 2878 4373 571 4574 5500 0 5889 6861 6732 6843 1210 3298 8978 9297 6631 6631 1055 4625 695 5892

