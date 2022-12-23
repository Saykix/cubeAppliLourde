package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionBdd;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class NewFournisseur implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 public void setData(String nomFournisseur, String emailFournisseur, String siretFournisseur,
				String adresseFournisseur, String coordonneesBancaireFournisseur, String villeFournisseur,
				String descriptionFournisseur, int idFournisseur, int telephoneFournisseur, int codePostalFournisseur) {
			this.nom = nomFournisseur;
			this.email = emailFournisseur;
			this.siret = siretFournisseur;
			this.adresse = adresseFournisseur;
			this.coordonneesBancaire = coordonneesBancaireFournisseur;
			this.ville = villeFournisseur;
			this.description = descriptionFournisseur;
			this.id = idFournisseur;
			this.telephone = Integer.toString(telephoneFournisseur);
			this.codePostal = Integer.toString(codePostalFournisseur);
			
			this.nomFournisseur.setText(nom);
			this.emailFournisseur.setText(email);
			this.siretFournisseur.setText(siret);
			this.adresseFournisseur.setText(adresse);
			this.coordonneesBancaireFournisseur.setText(coordonneesBancaire);
			this.villeFournisseur.setText(ville);
			this.descriptionFournisseur.setText(description);
			this.telephoneFournisseur.setText(telephone);
			this.codePostaleFournisseur.setText(codePostal);
			Ajouter.setText("Modifier");
	 }
	 
		String nom, email, siret, adresse, coordonneesBancaire, ville, description, telephone, codePostal;
		int id;
	
	

	    @FXML
	    private Button Ajouter;

	    @FXML
	    private TextField adresseFournisseur;

	    @FXML
	    private TextField codePostaleFournisseur;

	    @FXML
	    private TextField coordonneesBancaireFournisseur;

	    @FXML
	    private TextField descriptionFournisseur;

	    @FXML
	    private TextField emailFournisseur;

	    @FXML
	    private BorderPane newUtilisateurPane;

	    @FXML
	    private TextField nomFournisseur;

	    @FXML
	    private TextField siretFournisseur;

	    @FXML
	    private TextField telephoneFournisseur;

	    @FXML
	    private TextField villeFournisseur;

    @FXML
    void ModifierUtilisateur(MouseEvent event) {
    	if (nom == null) {
	    	String requete = "INSERT INTO `fournisseur` (`nomFournisseur`, `emailFournisseur`, `telephoneFournisseur`, `siretFournisseur`,"
	    			+ " `coordonneesBancaireFournisseur`, `adresseFournisseur`, `codePostalFournisseur`, `villeFournisseur`, `descriptionFournisseur`) VALUES"
	    			+ " ('"+nomFournisseur.getText()+"', '"+emailFournisseur.getText()+"', '"+telephoneFournisseur.getText()+"', "+siretFournisseur.getText()+"', '"
	    			+coordonneesBancaireFournisseur.getText()+"', '"+adresseFournisseur.getText()+"', '"+codePostaleFournisseur.getText()+"', '"+villeFournisseur.getText()+"', '"
	    			+descriptionFournisseur.getText()+" ');";
	    	System.out.println(requete);
	    	try {
				PreparedStatement ps = cnx.prepareStatement(requete);
				 ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		String requete = "";
	    	System.out.println(requete);
	    	try {
				PreparedStatement ps = cnx.prepareStatement(requete);
				 ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx = ConnexionBdd.connexionDB();
	}
}


