package Class;

public class utilisateur {

		String nomUtilisateur,prenomUtilisateur,emailUtilisateur,motDePasseUtilisateur,adresseUtilisateur,villeUtilisateur,idUtilisateur,codePostaleUtilisateur,telephoneUtilisateur,administrateur;

		
		
		public utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
				String motDePasseUtilisateur, String adresseUtilisateur, String villeUtilisateur, String idUtilisateur,
				String codePostaleUtilisateur, String telephoneUtilisateur, String administrateur) {
			super();
			this.nomUtilisateur = nomUtilisateur;
			this.prenomUtilisateur = prenomUtilisateur;
			this.emailUtilisateur = emailUtilisateur;
			this.motDePasseUtilisateur = motDePasseUtilisateur;
			this.adresseUtilisateur = adresseUtilisateur;
			this.villeUtilisateur = villeUtilisateur;
			this.idUtilisateur = idUtilisateur;
			this.codePostaleUtilisateur = codePostaleUtilisateur;
			this.telephoneUtilisateur = telephoneUtilisateur;
			this.administrateur = administrateur;
		}

		public String getTelephoneUtilisateur() {
			return telephoneUtilisateur;
		}

		public void setTelephoneUtilisateur(String telephoneUtilisateur) {
			this.telephoneUtilisateur = telephoneUtilisateur;
		}

		public String getNomUtilisateur() {
			return nomUtilisateur;
		}
		public void setNomUtilisateur(String nomUtilisateur) {
			this.nomUtilisateur = nomUtilisateur;
		}
		public String getPrenomUtilisateur() {
			return prenomUtilisateur;
		}
		public void setPrenomUtilisateur(String prenomUtilisateur) {
			this.prenomUtilisateur = prenomUtilisateur;
		}
		public String getEmailUtilisateur() {
			return emailUtilisateur;
		}
		public void setEmailUtilisateur(String emailUtilisateur) {
			this.emailUtilisateur = emailUtilisateur;
		}
		public String getMotDePasseUtilisateur() {
			return motDePasseUtilisateur;
		}
		public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
			this.motDePasseUtilisateur = motDePasseUtilisateur;
		}
		public String getAdresseUtilisateur() {
			return adresseUtilisateur;
		}
		public void setAdresseUtilisateur(String adresseUtilisateur) {
			this.adresseUtilisateur = adresseUtilisateur;
		}
		public String getVilleUtilisateur() {
			return villeUtilisateur;
		}
		public void setVilleUtilisateur(String villeUtilisateur) {
			this.villeUtilisateur = villeUtilisateur;
		}
		public String getIdUtilisateur() {
			return idUtilisateur;
		}
		public void setIdUtilisateur(String idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}
		public String getCodePostaleUtilisateur() {
			return codePostaleUtilisateur;
		}
		public void setCodePostaleUtilisateur(String codePostaleUtilisateur) {
			this.codePostaleUtilisateur = codePostaleUtilisateur;
		}
		public String getAdministrateur() {
			return administrateur;
		}
		public void setAdministrateur(String administrateur) {
			this.administrateur = administrateur;
		}
		
		
}
