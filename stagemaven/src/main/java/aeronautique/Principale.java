package aeronautique;

import dao.AvionDAO;
import dao.Connexion;

public class Principale {

	public static void main(String[] args) {

		//Vous devez avoir un avion 5
		Avion avion=AvionDAO.getInstance().read(5);		
		System.out.println(avion);
		avion=AvionDAO.getInstance().read(5);		
		System.out.println(avion);
		AvionDAO.getInstance().create(avion);
		System.out.println(avion);
		avion=AvionDAO.getInstance().read(avion.getNumero());		
		System.out.println(avion);

		// Problème ici : le nouvel avion créé est associé à l'avion 5
		for (int i = 1; i < 30; i++) {
			avion=AvionDAO.getInstance().read(i);		
			System.out.println(avion);			
		}
		for (int i = 1000; i < 1020; i++) {
			avion=AvionDAO.getInstance().read(i);		
			System.out.println(avion);			
		}
		for (int i = 2000; i < 2030; i++) {
			avion=AvionDAO.getInstance().read(i);			
			System.out.println(avion);			
		}

		//new Controleur();		

		/*
		Connexion.afficheSelectEtoile("Avion",null);
		// Seul l'id compte
		//Avion avion = new Avion(-1, "airbus 320", "Caen", 350);
		//(new AvionDAO()).delete(avion);
		//(new AvionDAO()).create(avion);
		System.out.println(avion);
		Avion avion=(new AvionDAO()).find(5);
		System.out.println(avion);
		//Connexion.afficheSelectEtoile("Avion");		
		//Connexion.afficheSelectEtoile("Vol");
		System.out.println(Connexion.getLesIds("numav", "Avion", null));
		System.out.println(Connexion.getLesIds("numav", "Vol", null));
		(new AvionDAO()).afficheSelectEtoileAvion();
		 */
		Connexion.fermer();
	}

}
