package Class;

public class articleStock extends article {
	
	int stock;
	
	public articleStock(int id, String nom, String reference, String annee, String famille, int prixUnitaire,
			int prixCarton, int prixFournisseur, int coutStockage, int tva, String domaine, String description, int stock) {
			
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
