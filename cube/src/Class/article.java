package Class;

public class article {
	String nom, reference,annee, famille, domaine, description;
	int id, prixUnitaire,prixCarton,prixFournisseur,tva,coutStockage;
	
	
	
	public article(int id, String nom, String reference, String annee, String famille, int prixUnitaire, int prixCarton, int prixFournisseur, int coutStockage, int tva,
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getPrixCarton() {
		return prixCarton;
	}
	public void setPrixCarton(int prixCarton) {
		this.prixCarton = prixCarton;
	}
	public int getPrixFournisseur() {
		return prixFournisseur;
	}
	public void setPrixFournisseur(int prixFournisseur) {
		this.prixFournisseur = prixFournisseur;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	public int getCoutStockage() {
		return coutStockage;
	}
	public void setCoutStockage(int coutStockage) {
		this.coutStockage = coutStockage;
	}
	
}
