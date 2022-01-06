package stage;

import java.awt.Image;

public class Entreprise {
	private int id_entreprise;
	private Image logo;
	private String nom;
	private String personne_contact;
	private String email;
	private String numtel;
	private String fax;
	private int nbsalarie;
	private int nbstagmax;
	
	
	
	/**
	 * @return the id_entreprise
	 */
	public int getId_entreprise() {
		return id_entreprise;
	}



	/**
	 * @param id_entreprise the id_entreprise to set
	 */
	public void setId_entreprise(int id_entreprise) {
		this.id_entreprise = id_entreprise;
	}



	/**
	 * @return the logo
	 */
	public Image getLogo() {
		return logo;
	}



	/**
	 * @param logo the logo to set
	 */
	public void setLogo(Image logo) {
		this.logo = logo;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the personne_contact
	 */
	public String getPersonne_contact() {
		return personne_contact;
	}



	/**
	 * @param personne_contact the personne_contact to set
	 */
	public void setPersonne_contact(String personne_contact) {
		this.personne_contact = personne_contact;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the numtel
	 */
	public String getNumtel() {
		return numtel;
	}



	/**
	 * @param numtel the numtel to set
	 */
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}



	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}



	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}



	/**
	 * @return the nbsalarie
	 */
	public int getNbsalarie() {
		return nbsalarie;
	}



	/**
	 * @param nbsalarie the nbsalarie to set
	 */
	public void setNbsalarie(int nbsalarie) {
		this.nbsalarie = nbsalarie;
	}



	/**
	 * @return the nbstagmax
	 */
	public int getNbstagmax() {
		return nbstagmax;
	}



	/**
	 * @param nbstagmax the nbstagmax to set
	 */
	public void setNbstagmax(int nbstagmax) {
		this.nbstagmax = nbstagmax;
	}



	public Entreprise(int id_entreprise, Image logo, String nom, String personne_contact, String email, String numtel,
			String fax, int nbsalarie, int nbstagmax) {
		super();
		this.id_entreprise = id_entreprise;
		this.logo = logo;
		this.nom = nom;
		this.personne_contact = personne_contact;
		this.email = email;
		this.numtel = numtel;
		this.fax = fax;
		this.nbsalarie = nbsalarie;
		this.nbstagmax = nbstagmax;
	}
	
	
	
	
	

}
