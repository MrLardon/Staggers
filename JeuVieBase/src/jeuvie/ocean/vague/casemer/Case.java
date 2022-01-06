package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;

public abstract class Case implements ICase {

	public abstract Couleur getCouleurCaseVide();
	protected abstract void setBestioleVivante();

	protected boolean vide=true;
	protected IBestiole occupant = null;

	public void setVivante(){
		setBestioleVivante();
		vide=false;
	}	

	public Couleur getCouleur(){
		Couleur c = getCouleurCaseVide();
		if (!this.vide) {
			c = this.occupant.getCouleur();
		}
		return c;
	}

	public boolean isVide() {
		return this.vide;
	}
	
	public boolean contientBestioleVivante(){
		
		return !this.vide && this.occupant.isVivante(); 
	}

	public void tuerEventuelOccupant(){
		if (this.contientBestioleVivante()) {
			this.occupant.tuer();
		}
	}
	public Case() {
		super();
	}
	public Case(boolean vide, IBestiole occupant) {
		super();
		this.vide = vide;
		this.occupant = occupant;
	}
	@Override
	public String toString() {
		return "Case [vide=" + vide + ", occupant=" + occupant + "]";
	}

	
}
