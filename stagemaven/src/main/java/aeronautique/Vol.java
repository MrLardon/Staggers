package aeronautique;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Vol {

	private int numVol;
	private Avion avion;// Ensuite il faudra passer aux objets
	private Pilote pilote;	// Ensuite il faudra passer aux objets
	
	// Pour les bases de données, on passera par java.sql.Timestamp
	/* Pour le find :
	 * GregorianCalendar hArr = new GregorianCalendar();
	 * hArr.setTimesInMillis (rs.getTimeStamp("harr").getTime());
	 * Pour le create :
	 * Timestamp ts = new Timestamp (vol.gethDep().getTimeInMillis());
	 * pst.setTimestamp(3,ts); 
	 */
	private GregorianCalendar hDep;	
	private GregorianCalendar hArr;
	private String villeDep;
	private String villeArr;
	
	@Override
	public String toString() {
		// TimeStamp de java.sql se rapproche du dateTime de sql Server
		Timestamp hDepTs = new Timestamp(hDep.getTimeInMillis()); 
		Timestamp hArrTs = new Timestamp(hArr.getTimeInMillis()); 
		return "Vol [numVol=" + numVol + ", numAv=" + avion + ","
				+ "numPil=" + pilote + ", hDep=" + hDepTs + ", hArr="
				+ hArrTs + ", villeDep=" + villeDep + ", villeArr=" +
				villeArr + "]";
	}
	
	public int getNumVol() {
		return numVol;
	}
	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Pilote getPilote() {
		return pilote;
	}
	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}
	public GregorianCalendar gethDep() {
		return hDep;
	}
	public void sethDep(GregorianCalendar hDep) {
		this.hDep = hDep;
	}
	public GregorianCalendar gethArr() {
		return hArr;
	}
	public void sethArr(GregorianCalendar hArr) {
		this.hArr = hArr;
	}
	public String getVilleDep() {
		return villeDep;
	}
	public void setVilleDep(String villeDep) {
		this.villeDep = villeDep;
	}
	public String getVilleArr() {
		return villeArr;
	}
	public void setVilleArr(String villeArr) {
		this.villeArr = villeArr;
	}
	public Vol(Avion avion, Pilote pilote, GregorianCalendar hDep, GregorianCalendar hArr, String villeDep,
			String villeArr) {
		super();
		this.avion = avion;
		this.pilote = pilote;
		this.hDep = hDep;
		this.hArr = hArr;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
	}
	
	public Vol(int numero,Avion avion, Pilote pilote, GregorianCalendar hDep, GregorianCalendar hArr, String villeDep,
			String villeArr) {
		super();
		this.numVol=numero;
		this.avion = avion;
		this.pilote = pilote;
		this.hDep = hDep;
		this.hArr = hArr;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
	}

	
	
	
}
