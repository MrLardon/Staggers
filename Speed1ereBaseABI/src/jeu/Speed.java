package jeu;

import controleur.Controleur;
import jeu.cartes.PaquetCarte;
import jeu.cartes.carte.Carte;
import jeu.cartes.carte.Symbole;

public class Speed {

	public static void main(String[] args) {
		//new Controleur();
		System.out.println("le fanion : "+Symbole.FANION);
		System.out.println("l'étoile : "+Symbole.ETOILE);
		Carte carteVide = new Carte();
		System.out.println("carte vide : "+carteVide);
		Carte carte3 = new Carte(1, 2, Symbole.MAISON);
		Carte carte2 = new Carte(1, 2, Symbole.MAISON);
		System.out.println("carte autre : "+carte2);
		carte2 = new Carte(8, 2, Symbole.MAISON);
		System.out.println("carte autre : "+carte2);
		
		System.out.println("carte autre : "+carte3);
		
		PaquetCarte pc1 = new PaquetCarte();
		System.out.println("taille du paquet :"+pc1.size());
		System.out.println(pc1);
		//pc1.add(new Carte(2,2,Symbole.FANION));
		//System.out.println("taille du paquet :"+pc1.size());
		
	}
	
}
