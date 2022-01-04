package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aeronautique.Avion;

public class AvionDAO extends DAO<Avion> {

	private static final String TABLE = "AVION";
	private static final String CLE_PRIMAIRE = "numAv";

	private static final String NOM_AV = "nomAv";
	private static final String LOCALISATION = "loc";
	private static final String CAPACITE = "capacite";

	private static AvionDAO instance=null;

	public static AvionDAO getInstance(){
		if (instance==null){
			instance = new AvionDAO();
		}
		return instance;
	}

	private AvionDAO() {
		super();
	}


	@Override
	public boolean create(Avion av) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM_AV+","+LOCALISATION+" , "+CAPACITE+") VALUES (?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			// on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
			pst.setString(1, av.getNom());
			pst.setString(2, av.getLoc());
			pst.setInt(3, av.getCapacite());
			// on exécute la mise à jour
			pst.executeUpdate();

			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				av.setNumero(rs.getInt(1));
			}
			donnees.put(av.getNumero(), av);

		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}

		return succes;
	}

	@Override
	public boolean delete(Avion av) {
		boolean succes = true;
		try {
			int id = av.getNumero();
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
	public boolean update(Avion obj) {
		boolean succes=true;

		String nom =obj.getNom();
		String loc =obj.getLoc();
		int capacite = obj.getCapacite();
		int id = obj.getNumero();

		try {
			String requete = "UPDATE "+TABLE+" SET "+NOM_AV+" = ?, "+LOCALISATION+" = ?, "+CAPACITE+" = ? WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete) ;
			pst.setString(1,nom) ; 
			pst.setString(2,loc) ; 
			pst.setInt(3, capacite) ;
			pst.setInt(4, id) ;
			pst.executeUpdate() ;
			donnees.put(id, obj);
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	@Override
	public Avion read(int id) {
		Avion avion = null;
		if (donnees.containsKey(id)) {
			//System.out.println("récupéré");
			avion=donnees.get(id);
		}
		else {
			//System.out.println("recherché dans la BD");
			try {

				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String nom = rs.getString(NOM_AV);
				String loc = rs.getString(LOCALISATION);
				int capacite = rs.getInt(CAPACITE);
				avion = new Avion (id, nom, loc, capacite);
				donnees.put(id, avion);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}
		return avion;
	}

	public void afficheSelectEtoileAvion() {
		System.out.println("--- Avion non utilisé ---");
		String clauseWhere = CLE_PRIMAIRE+" NOT IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
		Connexion.afficheSelectEtoile("Avion", clauseWhere);

		System.out.println("--- Avion contraint par Vol --- ");
		clauseWhere = CLE_PRIMAIRE+" IN (SELECT "+CLE_PRIMAIRE+" From Vol)";
		Connexion.afficheSelectEtoile("Avion", clauseWhere);

	}



}
