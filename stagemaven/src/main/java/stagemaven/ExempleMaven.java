package stagemaven;

import dao.AvionDAO;
import dao.Connexion;
import dao.PiloteDAO;
import dao.VolDAO;

public class ExempleMaven {

	public static void main(String[] args) {
		Connexion.getInstance();
		System.out.println(Connexion.getMaxId("numAv", "avion"));
		
		/*Avion av = new Avion(0, "Airbus 44", "Paris", 428);
		AvionDAO.getInstance().create(av);
		
		System.out.println(Connexion.getMaxId("num_av", "avion"));*/
		System.out.println(AvionDAO.getInstance().read(2));
		System.out.println(PiloteDAO.getInstance().read(2));
		System.out.println(VolDAO.getInstance().read(2));
		Connexion.fermer();
		/*
        ImagePlus imp = IJ.openImage(); // Choisit un fichier et stocke le résultat dans imp
        imp.show(); // Affiche l'image à l'écran
        */
	}

}
