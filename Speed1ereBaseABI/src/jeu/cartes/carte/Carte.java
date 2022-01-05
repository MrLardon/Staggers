package jeu.cartes.carte;

import java.awt.Color;

public class Carte {

	// static final
	public static final int NBR_COULEURS=5;
	public static final int NBR_MOTIFS=5;
	public static final int NBR_VALEURS=5;
	// static

	// final (attributs constants)
	// attributs simples
	private Color couleur;
	private Symbole motif;
	private int valeur;
	
	public Carte() {
		super();
		forcerCarteVide();
	}
	
	private void forcerCarteVide() {
		this.couleur = Color.DARK_GRAY;
		this.motif = Symbole.VIDE;
		this.valeur = -1;
	}

	public Carte(int couleur, int valeur, Symbole motif) {
		super();
		if (couleur<1 || couleur>NBR_COULEURS || valeur<1 || valeur>NBR_VALEURS)
		{
			System.out.println("ERREUR DE CRÉATION DE CARTE");
			forcerCarteVide();
		}
		else {
			this.couleur = Carte.getColor(couleur);
			this.motif = motif;
			this.valeur = valeur;
		}
	}

	public Color getCouleur() {
		return this.couleur;
	}
	public Symbole getMotif() {
		return motif;
	}
	public int getValeur() {
		return valeur;
	}

	

	/*Color.BLUE; Color.ORANGE; Color.CYAN; Color.BLACK; Color.LIGHT_GRAY;*/
	private static Color getColor(int couleur2) {
		Color coul;

		switch (couleur2) {
		case 1:  coul = Color.BLUE;  break;
		case 2:  coul = Color.ORANGE;  break;
		case 3:  coul = Color.CYAN;  break;
		case 4:  coul = Color.BLACK;  break;
		case 5:  coul = Color.LIGHT_GRAY;  break;
		default:
			coul = Color.DARK_GRAY;
			break;
		}		
		return coul;
	}
	
	
	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", motif=" + motif + ", valeur=" + valeur + "]";
	}
	



}
