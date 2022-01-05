package jeu.cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jeu.cartes.carte.Carte;
import jeu.cartes.carte.Symbole;

/**
 * Implémente le patron de conception façade :
 * on évite le extends, on ajoute un attribut privé
 * et on redéfinit uniquement les méthodes dont on a besoin 
 * @author Alain
 *
 */
public class PaquetCarte {
	private static final int NBR_CARTES=72;


	// à gauche le type vu dans le programme, à droite l'organisation effective de la mémoire
	// possible car ArrayList est une spécialisation de List
	private List<Carte> cartes = new ArrayList<Carte>();


	public PaquetCarte() {
		super();
		for (int couleur = 1; couleur <= Carte.NBR_COULEURS; couleur++) {
			for (int valeur = 1; valeur <= Carte.NBR_VALEURS; valeur++) {
				for (int motif = 1; motif <=Carte.NBR_MOTIFS; motif++) {	
					cartes.add(new Carte(couleur,valeur,Symbole.get(motif)));
				}
			}
		}
		
		Collections.shuffle(cartes);
		
		// ôter les cartes en trop pour descendre à NBR_CARTES
		for (int i = cartes.size(); i > NBR_CARTES; i--) {
			cartes.remove(0);
			//cartes.remove(i-1);
		}
		
	}




	/**
	 * façade : on redéfinit les méthodes utiles de List directement sur PaquetCarte
	 * pour conserver le même vocabulaire, connu de tous.
	 * on écrira ainsi :
	 * PaquetCarte pc = new PaquetCarte()
	 * pc.size() au lieu de pc.getCartes().size()
	 * pc.add(c1) au lieu de pc.getCartes().add(c1)
	 */
	public int size() {
		return cartes.size();
	}

	public boolean add(Carte carte) {
		return cartes.add(carte);
	}

	public Carte get(int indice) {
		return cartes.get(indice);
	}

	public Carte remove(int indice) {
		return cartes.remove(indice);
	}


	@Override
	public String toString() {
		return "PaquetCarte taille : "+this.size()+" -> "+ cartes;
	}







}
