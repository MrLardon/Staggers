package jeu.cartes.carte;

/**
 * Intérêts de l'énumération :
 * pour le développeur : manipuler des mots, c'est plus lisible
 * pour la mémoire, manipuler, comparer des entiers (adresses) c'est plus efficace
 * contrôle de données, les instances autorisées sont connues et limitées, c'est plus sûr
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
		case ETOILE: texte = "étoile"; break;
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
