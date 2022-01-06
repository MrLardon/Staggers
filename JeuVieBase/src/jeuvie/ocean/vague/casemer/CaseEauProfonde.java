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
	 * À chaque étape, l’évolution d’une cellule est entièrement déterminée par l’état de ses huit voisines de la façon suivante :

	 * Une cellule morte possédant exactement trois voisines vivantes devient vivante (elle naît).
	 * Une cellule vivante possédant deux ou trois voisines vivantes le reste, sinon elle meurt.
	 * @param col la colonne dans la matrice
	 * @param j la ligne dans la matrice
	 * @return si cette case précise doit survivre ou non.
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
