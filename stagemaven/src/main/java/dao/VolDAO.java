package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;

public class VolDAO extends DAO<Vol> {

	private static final String CLE_PRIMAIRE = "numVol";
	private static final String TABLE = "VOL";

	private static final String VILLE_DEPART = "villeDep";
	private static final String VILLE_ARRIVEE = "villeArr";
	private static final String HEURE_DEPART = "hDep";
	private static final String HEURE_ARRIVEE = "hArr";
	private static final String NUM_PIL = "numPil";
	private static final String NUM_AV = "numAv";

	private static VolDAO instance=null;

	public static VolDAO getInstance(){
		if (instance==null){
			instance = new VolDAO();
		}
		return instance;
	}

	private VolDAO() {
		super();
	}

	@Override
	public boolean create(Vol vol) {

		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_AV+", "+NUM_PIL+", "+HEURE_DEPART+", "+HEURE_ARRIVEE+", "+VILLE_DEPART+", "+VILLE_ARRIVEE+") VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, vol.getAvion().getNumero());
			pst.setInt(2, vol.getPilote().getNumPil());
			Timestamp ds = new Timestamp(vol.gethDep().getTimeInMillis());
			pst.setTimestamp(3, ds);
			ds = new Timestamp(vol.gethArr().getTimeInMillis());
			pst.setTimestamp(4, ds);
			pst.setString(5, vol.getVilleDep());
			pst.setString(6, vol.getVilleArr());
			pst.executeUpdate() ;
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				vol.setNumVol(rs.getInt(1));
			}
			donnees.put(vol.getNumVol(),vol);

		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Vol obj) {
		boolean succes=true;
		int id = obj.getNumVol();
		try {
			String requete = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete) ;
			pst.setInt(1, id) ;
			pst.executeUpdate() ;
			donnees.remove(id);
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;		
	}

	@Override
	public boolean update(Vol vol) {
		boolean succes=true;

		int numPil= vol.getPilote().getNumPil();
		int numAv= vol.getAvion().getNumero();
		String vDep = vol.getVilleDep();
		String vArr = vol.getVilleArr();
		GregorianCalendar hDep = vol.gethDep();
		GregorianCalendar hArr = vol.gethArr();

		try {
			String requete = "UPDATE "+TABLE+" SET "+NUM_PIL+" = ?, "+NUM_AV+" = ?, "+VILLE_DEPART+" = ?, "+VILLE_ARRIVEE+" = ?, "+HEURE_DEPART+" = ?, "+HEURE_ARRIVEE+" = ? WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete) ;
			pst.setInt(1,numPil) ; 
			pst.setInt(2,numAv) ; 
			pst.setString(3, vDep) ;
			pst.setString(4, vArr) ;
			pst.setTimestamp(5, new Timestamp(hDep.getTimeInMillis())) ;
			pst.setTimestamp(6, new Timestamp(hArr.getTimeInMillis())) ;
			pst.setInt(7, vol.getNumVol()) ;
			pst.executeUpdate() ;
			donnees.put(vol.getNumVol(), vol);
		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	@Override
	public Vol read(int id) {
		String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+"="+id+";";
		ResultSet rs = Connexion.executeQuery(requete);
		Vol vol = null;
		if (donnees.containsKey(id)) {
			vol=donnees.get(id);
		}
		else {
			try {
				rs.next();
				int numAv=rs.getInt(NUM_AV);
				int numPil=rs.getInt(NUM_PIL);
				GregorianCalendar hDep = new GregorianCalendar();
				hDep.setTimeInMillis(rs.getTimestamp(HEURE_DEPART).getTime());
				GregorianCalendar hArr = new GregorianCalendar();
				hArr.setTimeInMillis(rs.getTimestamp(HEURE_ARRIVEE).getTime());
				String villeDep=rs.getString(VILLE_DEPART);;
				String villeArr=rs.getString(VILLE_ARRIVEE);;
				Avion avion = AvionDAO.getInstance().read(numAv);
				Pilote pilote = PiloteDAO.getInstance().read(numPil);
				vol=new Vol(avion, pilote, hDep, hArr, villeDep, villeArr);
				donnees.put(id, vol);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vol;
	}



}
