package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aeronautique.Pilote;

public class PiloteDAO extends DAO<Pilote> {

	private static final String TABLE = "PILOTE";
	private static final String CLE_PRIMAIRE = "numPil";

	private static final String NOM_PIL = "nomPil";
	private static final String ADRESSE = "adr";
	private static final String SALAIRE = "sal";


	private static PiloteDAO instance=null;

	public static PiloteDAO getInstance(){
		if (instance==null){
			instance = new PiloteDAO();
		}
		return instance;
	}

	private PiloteDAO() {
		super();
	}
	
	@Override
	public boolean create(Pilote pilote) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM_PIL+", "+ADRESSE+", "+SALAIRE+") VALUES (?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, pilote.getNomPil());
			pst.setString(2, pilote.getAdr());
			pst.setInt(3, pilote.getSalaire());
			pst.executeUpdate();

			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				pilote.setNumPil(rs.getInt(1));
			}
			donnees.put(pilote.getNumPil(),pilote);

		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}

		return succes;
	}

	@Override
	public boolean delete(Pilote pilote) {
		boolean succes = true;
		try {
			int id = pilote.getNumPil();
			String requete = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			pst.executeUpdate();
			donnees.remove(id);
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean update(Pilote pilote) {
		boolean succes=true;

		String nom =pilote.getNomPil();
		String adr =pilote.getAdr();
		int salaire = pilote.getSalaire();
		int id = pilote.getNumPil();

		try {
			String requete = "UPDATE "+TABLE+" SET "+NOM_PIL+" = ?, "+ADRESSE+" = ?, "+SALAIRE+" = ? WHERE "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete) ;
			pst.setString(1,nom) ; 
			pst.setString(2,adr) ; 
			pst.setInt(3, salaire) ;
			pst.setInt(4, id) ;
			pst.executeUpdate() ;
			donnees.put(id, pilote);
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	@Override
	public Pilote read(int id) {
		Pilote pilote = null;
		if (donnees.containsKey(id)) {
			pilote = donnees.get(id);
		}
		else {
			try {
				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String nom = rs.getString(NOM_PIL);
				String adr = rs.getString(ADRESSE);
				int salaire = rs.getInt(SALAIRE);
				pilote = new Pilote (id, nom, adr, salaire);
				donnees.put(id, pilote);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pilote;
	}

	public void afficheSelectEtoilePilote() {
		System.out.println("--- Pilote non utilisé ---");
		String clauseWhere = CLE_PRIMAIRE+" NOT IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
		Connexion.afficheSelectEtoile("Pilote", clauseWhere);

		System.out.println("--- Pilote contraint par Vol --- ");
		clauseWhere = CLE_PRIMAIRE+" IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
		Connexion.afficheSelectEtoile("Pilote", clauseWhere);

	}



}
