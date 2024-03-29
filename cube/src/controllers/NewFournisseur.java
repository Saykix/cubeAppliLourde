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
	
	 public void setData(String idFournisseur, String nomFournisseur, String siretFournisseur, String emailFournisseur, String coordonneesBancaireFournisseur, 
			String adresseFournisseur, String villeFournisseur , String descriptionFournisseur,String codePostalFournisseur, String telephoneFournisseur) {
			this.nom = nomFournisseur;
			this.email = emailFournisseur;
			this.siret = siretFournisseur;
			this.adresse = adresseFournisseur;
			this.coordonneesBancaire = coordonneesBancaireFournisseur;
			this.ville = villeFournisseur;
			this.description = descriptionFournisseur;
			this.id = idFournisseur;
			this.telephone = telephoneFournisseur;
			this.codePostal = codePostalFournisseur;
			
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
	 
		String nom, email, siret, adresse, coordonneesBancaire, ville, description, telephone, codePostal,id;
	

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
    void AjouterFournisseur(MouseEvent event) {
    	if (nom == null) {
	    	String requete = "INSERT INTO `tablefournisseur` (`nomFournisseur`, `emailFournisseur`, `telephoneUtilisateur`, `siretFournisseur`,"
	    			+ " `coordonneesBancarieFournisseur`, `adresseFournisseur`, `codePostaleUtilisateur`, `villeFournisseur`, `descriptionFournisseur`) VALUES"
	    			+ " ('"+nomFournisseur.getText()+"', '"+emailFournisseur.getText()+"', '"+telephoneFournisseur.getText()+"', '"+siretFournisseur.getText()+"', '"
	    			+coordonneesBancaireFournisseur.getText()+"', '"+adresseFournisseur.getText()+"', '"+codePostaleFournisseur.getText()+"', '"+villeFournisseur.getText()+"', '"
	    			+descriptionFournisseur.getText()+"');";
	    	try {
				PreparedStatement ps = cnx.prepareStatement(requete);
				 ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		String requete = "UPDATE `tablefournisseur` SET `nomFournisseur` = '"+nomFournisseur.getText()+"', `emailFournisseur` = '"+emailFournisseur.getText()+"',"
    				+ " `telephoneUtilisateur` = '"+telephoneFournisseur.getText()+"', `siretFournisseur` = '"+siretFournisseur.getText()+"',"
    				+ " `coordonneesBancarieFournisseur` = '"+coordonneesBancaireFournisseur.getText()+"', `adresseFournisseur` = '"+adresseFournisseur.getText()+"', `codePostaleUtilisateur` = '"+codePostaleFournisseur.getText()+"',"
    				+ " `villeFournisseur` = '"+villeFournisseur.getText()+"', `descriptionFournisseur` = '"+descriptionFournisseur.getText()+"' WHERE `tablefournisseur`.`IdFournisseur` = "+id+";";
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


