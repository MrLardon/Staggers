package jeuvie.ocean.vague;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.casemer.ICase;

public abstract class LigneEau implements ILigneEau {

    protected List<ICase> lesCases;
    protected final int nbColonnes;
    

    protected abstract void remplirDeCasesVides();
    
    
    public boolean contientBestioleVivante() {
		return false;
	}
    protected LigneEau(int taille) {
        super();
        this.nbColonnes = taille;
        //this.lesCases = new ArrayList<ICase>();
        this.remplirDeCasesVides();
    }


    public ICase get(int i) {
       return this.lesCases.get(i);
    }

    public int getNbColonnes() {
        //TODO
        return this.nbColonnes;
    }

    protected boolean add(ICase element) {
        
        return this.lesCases.add(element);
    }


}