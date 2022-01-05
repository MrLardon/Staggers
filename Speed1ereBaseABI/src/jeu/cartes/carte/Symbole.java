package jeu.cartes.carte;

/**
 * Int�r�ts de l'�num�ration :
 * pour le d�veloppeur : manipuler des mots, c'est plus lisible
 * pour la m�moire, manipuler, comparer des entiers (adresses) c'est plus efficace
 * contr�le de donn�es, les instances autoris�es sont connues et limit�es, c'est plus s�r
 *
 */
public enum Symbole {
	ARBRE, FANION, ETOILE, BALLON, MAISON, CHEVAL, LAPIN, VIDE;
	
	private static final Symbole[] LES_SYMBOLES = Symbole.values();
	public static final int NBR_SYMBOLES = LES_SYMBOLES.length;

	
	@Override
	public String toString() {
		String texte="";
		switch (this) {
		case ARBRE: texte = "arbres"; break;
		case FANION: texte = "fanion"; break;
		case ETOILE: texte = "�toile"; break;
		case BALLON: texte = "ballon"; break;
		case MAISON: texte = "maison"; break;
		case CHEVAL: texte = "cheval"; break;
		default:
			texte = " VIDE "; 
			break;
		}
		return texte;
	}

	public static Symbole get(int i) {
		return LES_SYMBOLES[i-1];
	}
	
}
