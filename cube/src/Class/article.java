package Class;

public class article {
	String nom, reference,annee, famille, domaine, description, id, prixUnitaire,prixCarton,prixFournisseur,tva,coutStockage;
	
	
	
	public article(String id, String nom, String reference, String annee, String famille, String prixUnitaire, String prixCarton, String prixFournisseur, String coutStockage, String tva,
			String domaine, String description
			) {
		super();
		this.nom = nom;
		this.reference = reference;
		this.annee = annee;
		this.famille = famille;
		this.domaine = domaine;
		this.description = description;
		this.id = id;
		this.prixUnitaire = prixUnitaire;
		this.prixCarton = prixCarton;
		this.prixFournisseur = prixFournisseur;
		this.tva = tva;
		this.coutStockage = coutStockage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getPrixCarton() {
		return prixCarton;
	}
	public void setPrixCarton(String prixCarton) {
		this.prixCarton = prixCarton;
	}
	public String getPrixFournisseur() {
		return prixFournisseur;
	}
	public void setPrixFournisseur(String prixFournisseur) {
		this.prixFournisseur = prixFournisseur;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public String getCoutStockage() {
		return coutStockage;
	}
	public void setCoutStockage(String coutStockage) {
		this.coutStockage = coutStockage;
	}
	
}
