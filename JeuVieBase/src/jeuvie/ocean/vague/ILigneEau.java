package jeuvie.ocean.vague;

import jeuvie.ocean.vague.casemer.ICase;

public interface ILigneEau extends Cloneable {

	public ICase get(int i) ;

	public int getNbColonnes();
	
	//ILigneEau ligne = ocean.get(j);
	//ICase uneCase =ligne.get(i);
	
	
}
