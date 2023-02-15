package Class;

public class articleStock extends article {
	
	int stock;
	
	public articleStock(String id, String nom, String reference, String annee, String famille, String prixUnitaire,
			String prixCarton, String prixFournisseur, String coutStockage, String tva, String domaine, String description, String stock) {
			
		super(id, nom, reference, annee, famille, prixUnitaire, prixCarton, prixFournisseur, coutStockage, tva, domaine,
				description);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
