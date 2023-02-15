package Class;

public class fournisseur {
	String nomFournisseur, emailFournisseur, siretFournisseur, adresseFournisseur, coordonneesBancaireFournisseur, villeFournisseur, descriptionFournisseur, idFournisseur, telephoneUtilisateur, codePostaleUtilisateur;
	
	
	public fournisseur(String nomFournisseur, String emailFournisseur, String siretFournisseur,
			String adresseFournisseur, String coordonneesBancaireFournisseur, String villeFournisseur,
			String descriptionFournisseur, String idFournisseur, String telephoneUtilisateur, String codePostaleUtilisateur) {
		super();
		this.nomFournisseur = nomFournisseur;
		this.emailFournisseur = emailFournisseur;
		this.siretFournisseur = siretFournisseur;
		this.adresseFournisseur = adresseFournisseur;
		this.coordonneesBancaireFournisseur = coordonneesBancaireFournisseur;
		this.villeFournisseur = villeFournisseur;
		this.descriptionFournisseur = descriptionFournisseur;
		this.idFournisseur = idFournisseur;
		this.telephoneUtilisateur = telephoneUtilisateur;
		this.codePostaleUtilisateur = codePostaleUtilisateur;
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
	public String getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(String idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getTelephoneUtilisateur() {
		return telephoneUtilisateur;
	}
	public void setTelephoneUtilisateur(String telephoneUtilisateur) {
		this.telephoneUtilisateur = telephoneUtilisateur;
	}
	public String getCodePostaleUtilisateur() {
		return codePostaleUtilisateur;
	}
	public void setCodePostaleUtilisateur(String codePostaleUtilisateur) {
		this.codePostaleUtilisateur = codePostaleUtilisateur;
	}
	
}
