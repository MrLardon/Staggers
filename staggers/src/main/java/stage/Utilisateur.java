package stage;

public class Utilisateur {
	
	private int id_utilisateur;
	private int id_entreprise;
	private int promo;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private String numtel;
	private boolean admis_stage;
	
	
	public Utilisateur(int id_utilisateur, int id_entreprise, int promo, String nom, String prenom, int age,
			String email, String numtel, boolean admis_stage) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.id_entreprise = id_entreprise;
		this.promo = promo;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.numtel = numtel;
		this.admis_stage = admis_stage;
	}


	/**
	 * @return the id_utilisateur
	 */
	public int getId_utilisateur() {
		return id_utilisateur;
	}


	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}


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
	 * @return the promo
	 */
	public int getPromo() {
		return promo;
	}


	/**
	 * @param promo the promo to set
	 */
	public void setPromo(int promo) {
		this.promo = promo;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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
	 * @return the admis_stage
	 */
	public boolean isAdmis_stage() {
		return admis_stage;
	}


	/**
	 * @param admis_stage the admis_stage to set
	 */
	public void setAdmis_stage(boolean admis_stage) {
		this.admis_stage = admis_stage;
	}
	

	
	
	
	
	
	
}
