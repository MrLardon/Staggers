package jeu.cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jeu.cartes.carte.Carte;
import jeu.cartes.carte.Symbole;

/**
 * Impl�mente le patron de conception fa�ade :
 * on �vite le extends, on ajoute un attribut priv�
 * et on red�finit uniquement les m�thodes dont on a besoin 
 * @author Alain
 *
 */
public class PaquetCarte {
	private static final int NBR_CARTES=72;


	// � gauche le type vu dans le programme, � droite l'organisation effective de la m�moire
	// possible car ArrayList est une sp�cialisation de List
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
		
		// �ter les cartes en trop pour descendre � NBR_CARTES
		for (int i = cartes.size(); i > NBR_CARTES; i--) {
			cartes.remove(0);
			//cartes.remove(i-1);
		}
		
	}




	/**
	 * fa�ade : on red�finit les m�thodes utiles de List directement sur PaquetCarte
	 * pour conserver le m�me vocabulaire, connu de tous.
	 * on �crira ainsi :
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
