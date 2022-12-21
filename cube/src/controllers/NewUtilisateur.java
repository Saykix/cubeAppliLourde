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

public class NewUtilisateur implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 public void setData(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
				String motDePasseUtilisateur, String adresseUtilisateur, String villeUtilisateur, int idUtilisateur,
				int codePostaleUtilisateur, int telephoneUtilisateur, int administrateur) {	 
		 			this.nom = nomUtilisateur;
		 			this.prenom = prenomUtilisateur;
		 			this.email = emailUtilisateur;
		 			this.motDePasse = motDePasseUtilisateur;
		 			this.adresse = adresseUtilisateur;
		 			this.ville = villeUtilisateur;
		 			this.id = idUtilisateur;
		 			this.codePostale = Integer.toString(codePostaleUtilisateur);
		 			this.telephone = Integer.toString(telephoneUtilisateur);
		 			this.administrateur = administrateur;
		 			
		 			
		 			this.nomUtilisateur.setText(nom);
		 			this.prenomUtilisateur.setText(prenom);
		 			this.emailUtilisateur.setText(email);
		 			this.mdpUtilisateur.setText(motDePasse);
		 			this.adresseUtilisateur.setText(adresse);
		 			this.villeUtilisateur.setText(ville);
		 			this.codePostaleUtilisateur.setText(codePostale);
		 			this.telephoneUtilisateur.setText(telephone);		 			
		 			
	 }
	 
	 String nom,prenom,email,motDePasse,adresse,ville,codePostale,telephone;
		int id,administrateur;
	
	
	 

    @FXML
    private Button Ajouter;

    @FXML
    private TextField adresseUtilisateur;

    @FXML
    private TextField codePostaleUtilisateur;

    @FXML
    private TextField emailUtilisateur;

    @FXML
    private TextField mdpUtilisateur;

    @FXML
    private BorderPane newUtilisateurPane;

    @FXML
    private TextField nomUtilisateur;

    @FXML
    private TextField prenomUtilisateur;

    @FXML
    private TextField telephoneUtilisateur;

    @FXML
    private TextField villeUtilisateur;

    @FXML
    void ModifierUtilisateur(MouseEvent event) {
    	if (nom == null) {
	    	String requete = "INSERT INTO `utilisateur` ( `nomUtilisateur`, `prenomUtilisateur`, `emailUtilisateur`, `motDePasseUtilisateur`, `adresseUtilisateur`, `codePostaleUtilisateur`, "
	    			+ "`villeUtilisateur`, `telephoneUtilisateur`, `administrateur`) VALUES ('"+nomUtilisateur.getText()+
	    			"', '"+prenomUtilisateur.getText()+"', '"+emailUtilisateur.getText()+"', '"+mdpUtilisateur.getText()+"' , '"+adresseUtilisateur.getText()+"', '"+codePostaleUtilisateur.getText()+"',  '"+villeUtilisateur.getText()+"', '"+telephoneUtilisateur.getText()+"', '0');";
	    	System.out.println(requete);
	    	try {
				PreparedStatement ps = cnx.prepareStatement(requete);
				int rs = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		String requete = "UPDATE `utilisateur` SET `nomUtilisateur` = '"+nomUtilisateur.getText()+"', `prenomUtilisateur` = '"+prenomUtilisateur.getText()+"',"
    				+ " `emailUtilisateur` = '"+emailUtilisateur.getText()+"', `motDePasseUtilisateur` = '"+mdpUtilisateur.getText()+"', `adresseUtilisateur` = '"+adresseUtilisateur.getText()+"', `villeUtilisateur` = '"+villeUtilisateur.getText()+"' WHERE `utilisateur`.`IdUtilisateur` = 6;";
	    	System.out.println(requete);
	    	try {
				PreparedStatement ps = cnx.prepareStatement(requete);
				int rs = ps.executeUpdate();
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


