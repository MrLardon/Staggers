package jeuvie.ocean.vague;

import jeuvie.ocean.vague.casemer.CaseEauProfonde;
import jeuvie.ocean.vague.casemer.ICase;

public class LigneEauProfonde extends LigneEau {


    protected LigneEauProfonde(int taille) {
        super(taille);
        // TODO Auto-generated constructor stub
    }

    protected void remplirDeCasesVides() {
        for (int i = 0; i < this.nbColonnes; i++) {
            lesCases.add(new CaseEauProfonde());
        }
    }
    
   /* public ICase get(int i) {
        //TODO
        return null;
    }

    public int getNbColonnes() {
        
        return this.nbColonnes;
    }

    protected boolean add(ICase element){
        //TODO
        return true;
    }
    */
    
}