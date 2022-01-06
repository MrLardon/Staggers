package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Dauphin;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.IOcean;

public class CaseEauProfonde extends Case {

	private static final Couleur VIDE = Couleur.BLEU_SOMBRE;

	protected void setBestioleVivante() {
		
		super.occupant= new Dauphin();
		
		
	}

	/**
	 * � chaque �tape, l��volution d�une cellule est enti�rement d�termin�e par l��tat de ses huit voisines de la fa�on suivante :

	 * Une cellule morte poss�dant exactement trois voisines vivantes devient vivante (elle na�t).
	 * Une cellule vivante poss�dant deux ou trois voisines vivantes le reste, sinon elle meurt.
	 * @param col la colonne dans la matrice
	 * @param j la ligne dans la matrice
	 * @return si cette case pr�cise doit survivre ou non.
	 */
	public void evoluer(IOcean copie, int j, int i){
		//TODO
	}
	
	 
	public CaseEauProfonde() {
		super();
	}
	
	public CaseEauProfonde(boolean vide, IBestiole occupant) {
		super(vide, occupant);
		
	}
	
	@Override
	public boolean isVide() {
		
		return vide;
	}

	@Override
	public Couleur getCouleurCaseVide() {
		
		return CaseEauProfonde.VIDE;
	}
	
}
