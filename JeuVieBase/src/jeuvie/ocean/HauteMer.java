package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;


public class HauteMer extends Ocean {


	//Test commit pc 2222222

	protected HauteMer(List<ILigneEau> grille) {
		super(grille);
		// TODO Auto-generated constructor stub
	}

	private static final int NB_LIGNES = 55;
	private static final int NB_COLONNES = 60;

	
	protected void remplirDeLignesEau() {
		//TODO
	}

	public int getNbLignes() {		
		return NB_LIGNES;
	}

	public int getNbColonnes() {
		return NB_COLONNES;
	}

}
