package dao;

import stage.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {
	
	
	private static final String TABLE = "Adresse";
	private static final String CLE_PRIMAIRE = "Id_utilisateur";
	private static final String CLE_ETRANGERE = "Id_entreprise";

	private static final String PROMO = "Promo";
	private static final String NOM = "Nom";
	private static final String PRENOM = "Prenom";
	private static final String AGE = "Age";
	private static final String EMAIL = "Email";
	private static final String NUM_TEL = "Num_Tel";
	private static final String ADMIS_STAGE = "Admis_Stage";
	
	
	
	
	/*Patron de conception singleton*/
	private static UtilisateurDAO instance=null;

	public static UtilisateurDAO getInstance(){
		if (instance==null){
			instance = new UtilisateurDAO();
		}
		return instance;
	}
	
	private UtilisateurDAO() {
		super();
	}

	
	
	
	
	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Utilisateur read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
