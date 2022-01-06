package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connexion {

	
	private static Connection connect = null;
	private static final String NOMBD= "dbstage";
	private static final String SQL_SERVER = "localhost\\SQLEXPRESS01";
	private static final String ID = "sacha";
	private static final String MDP = "sio";
	test
	dfgfgdfgdfgdg
	public static Connection getInstance() {
		if (connect==null) {
			try { 

				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(ID);
				ds.setPassword(MDP);
				ds.setServerName(SQL_SERVER);
				ds.setDatabaseName(NOMBD);
				connect = ds.getConnection();
				System.out.println("connecté");
			}
			catch (SQLException e){
				System.out.println("Echec de la tentative de connexion : " + e.getMessage() + e.getStackTrace()) ;
			}
		}
		return connect;
	}
	
	private Connexion() {
		super();
	}

	public static ResultSet executeQuery(String requete){
		Statement st = null ;
		ResultSet rs = null;
		
		try{
			st = getInstance().createStatement() ;
			rs = st.executeQuery(requete) ;
		}catch(SQLException e){
			System.out.println("Echec de la tentative d'exécution de requete : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return rs;
	}
	
	public static boolean executeUpdate(String requete){
		boolean succes = true;
		
		Statement st = null ;
		try{
			st = getInstance().createStatement() ;
			st.executeUpdate(requete) ;
		}catch(SQLException e){
			succes = false;
			System.out.println("Echec de la tentative d'exécution de Mise à Jour : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return succes;
	}
	
	public static void fermer()
	{
		try
		{
			getInstance().close();
			System.out.println("deconnexion ok");
		}
		catch (SQLException e)
		{
			connect=null;
			System.out.println("echec de la fermeture");
		}
	}
}
