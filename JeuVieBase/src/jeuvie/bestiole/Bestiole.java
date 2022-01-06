package jeuvie.bestiole;
import jeuvie.Couleur;

public abstract class Bestiole implements IBestiole {

	private static int compteur = 0;
	
	protected Couleur couleur;
	protected boolean vivante=true;
	protected final int numero;
	
	protected abstract Couleur getCouleurVivant();
	protected abstract Couleur getCouleurMort();
	
	public static int getCompteur() {
		return compteur++;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public boolean isVivante() {
		return this.vivante;
	}
	
	public int getNumero() {
		return this.numero;
	}
	public Bestiole() {
		super();
		this.couleur = getCouleurVivant();
		this.numero = ++compteur;
	}



	public void tuer(){
		this.vivante = false;
		this.couleur = getCouleurMort();
	}
	@Override
	public String toString() {
		return "Bestiole [couleur=" + couleur + ", numero=" + numero + ", isVivante()=" + isVivante() + "]";
	}
	


}
