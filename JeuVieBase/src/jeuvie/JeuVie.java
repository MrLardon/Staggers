package jeuvie;

import java.util.ArrayList;
import java.util.List;

import jeuvie.bestiole.Bestiole;
import jeuvie.bestiole.Dauphin;
import jeuvie.ocean.vague.casemer.CaseEauProfonde;
import jeuvie.ocean.vague.casemer.ICase;


public class JeuVie {

	public static void main(String[] args) {

		//new Controleur(new BordDeCote(Ocean.PI));
		//new Controleur(new BordDeCote(Ocean.ALEA));

		//new Controleur(new HauteMer(Ocean.ALEA));
		//new Controleur(new HauteMer(Ocean.BARRE));
		//new Controleur(new HauteMer(Ocean.CANON));
		//new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
		//new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
		//new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
		//new Controleur(new HauteMer(Ocean.PETIT_VAISSEAU));
		/*List<IBestiole> bestioles = new ArrayList<IBestiole>(10);
		for (int i = 0; i < 10; i++) {
			Bestiole b = new Dauphin();
			//if (i%2==0) {
			//	b.tuer();
			}
			bestioles.add();*/
		List<ICase> cases = new ArrayList<ICase>(20);
		for (int i = 0; i < 20; i++) {

			//Bestiole b = new Dauphin();
			CaseEauProfonde c = new CaseEauProfonde();
			if (i%2==0) {
				c.setVivante();
				//

			}
			cases.add(c);
		
			



		}

		
		System.out.println(cases);
	}



}
