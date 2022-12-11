package Class;

public class fournisseur {
	String nomFournisseur, emailFournisseur, siretFournisseur, adresseFournisseur, coordonneesBancaireFournisseur, villeFournisseur, descriptionFournisseur;
	int idFournisseur, telephoneFournisseur, codePostalFournisseur;
	
	
	public fournisseur(String nomFournisseur, String emailFournisseur, String siretFournisseur,
			String adresseFournisseur, String coordonneesBancaireFournisseur, String villeFournisseur,
			String descriptionFournisseur, int idFournisseur, int telephoneFournisseur, int codePostalFournisseur) {
		super();
		this.nomFournisseur = nomFournisseur;
		this.emailFournisseur = emailFournisseur;
		this.siretFournisseur = siretFournisseur;
		this.adresseFournisseur = adresseFournisseur;
		this.coordonneesBancaireFournisseur = coordonneesBancaireFournisseur;
		this.villeFournisseur = villeFournisseur;
		this.descriptionFournisseur = descriptionFournisseur;
		this.idFournisseur = idFournisseur;
		this.telephoneFournisseur = telephoneFournisseur;
		this.codePostalFournisseur = codePostalFournisseur;
	}
	
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getEmailFournisseur() {
		return emailFournisseur;
	}
	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}
	public String getSiretFournisseur() {
		return siretFournisseur;
	}
	public void setSiretFournisseur(String siretFournisseur) {
		this.siretFournisseur = siretFournisseur;
	}
	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}
	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}
	public String getCoordonneesBancaireFournisseur() {
		return coordonneesBancaireFournisseur;
	}
	public void setCoordonneesBancaireFournisseur(String coordonneesBancaireFournisseur) {
		this.coordonneesBancaireFournisseur = coordonneesBancaireFournisseur;
	}
	public String getVilleFournisseur() {
		return villeFournisseur;
	}
	public void setVilleFournisseur(String villeFournisseur) {
		this.villeFournisseur = villeFournisseur;
	}
	public String getDescriptionFournisseur() {
		return descriptionFournisseur;
	}
	public void setDescriptionFournisseur(String descriptionFournisseur) {
		this.descriptionFournisseur = descriptionFournisseur;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public int getTelephoneFournisseur() {
		return telephoneFournisseur;
	}
	public void setTelephoneFournisseur(int telephoneFournisseur) {
		this.telephoneFournisseur = telephoneFournisseur;
	}
	public int getCodePostalFournisseur() {
		return codePostalFournisseur;
	}
	public void setCodePostalFournisseur(int codePostalFournisseur) {
		this.codePostalFournisseur = codePostalFournisseur;
	}
	
}
