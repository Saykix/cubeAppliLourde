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


public class ModifierVin implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	String nom, reference,annee, famille, domaine, description, prixUnitaire,prixCarton,prixFournisseur,tva,coutStockage;
	int id;
	
	public void setData(int id, String nom, String reference, String annee, String famille, int prixUnitaire, int prixCarton, int prixFournisseur, int coutStockage, int tva,
			String domaine, String description
			) {
		
		this.nom = nom;
		this.reference = reference;
		this.annee = annee;
		this.famille = famille;
		this.domaine = domaine;
		this.description = description;
		this.id = id;
		this.prixUnitaire = Integer.toString(prixUnitaire);
		this.prixCarton = Integer.toString(prixCarton);
		this.prixFournisseur = Integer.toString(prixFournisseur);
		this.tva = Integer.toString(tva);
		this.coutStockage = Integer.toString(coutStockage);
		
		this.nomArticle.setText(nom);
		this.referenceArticle.setText(reference);
		this.anneeArticle.setText(annee);
		this.familleArticle.setText(famille);
		this.domaineArticle.setText(domaine);
		this.descriptionArticle.setText(description);
		this.prixUnitaireArticle.setText(this.prixUnitaire);
		this.prixCartonArticle.setText(this.prixCarton);
		this.prixFournisseurArticle.setText(this.prixFournisseur);
		this.tvaArticle.setText(this.tva);
		this.coutStockageArticle.setText(this.coutStockage);
	}

    @FXML
    private TextField anneeArticle;

    @FXML
    private TextField coutStockageArticle;

    @FXML
    private TextField descriptionArticle;

    @FXML
    private TextField domaineArticle;

    @FXML
    private TextField familleArticle;

    @FXML
    private Button modifierArticle;

    @FXML
    private BorderPane modifierVinPane;

    @FXML
    private TextField nomArticle;

    @FXML
    private TextField prixCartonArticle;

    @FXML
    private TextField prixFournisseurArticle;

    @FXML
    private TextField prixUnitaireArticle;

    @FXML
    private TextField referenceArticle;

    @FXML
    private TextField tvaArticle;

    @FXML
    void modifiervin(MouseEvent event) {
    	String requete = "UPDATE `article` SET `nomArticle` = '"+nomArticle.getText()+"', `anneeArticle` = '"+anneeArticle.getText()+"', `prixUnitaireArticle` = '"+prixUnitaireArticle.getText()+"', `prixCartonArticle` = '"+prixCartonArticle.getText()+"',"
    			+ " `prixFournisseurArticle` = '"+prixFournisseurArticle.getText()+"', `referenceArticle` = '"+referenceArticle.getText()+"', `tvaArticle` = '"+tvaArticle.getText()+"', `domaineArticle` = '"+domaineArticle.getText()+"', "
    			+ "`descriptionArticle` = '"+descriptionArticle.getText()+"', `familleArticle` = '"+familleArticle.getText()+"', `coutStockageArticle` = '"+coutStockageArticle.getText()+"' WHERE `article`.`IdArticle` = "+id+";";
    	System.out.println(requete);
    	try {
			PreparedStatement ps = cnx.prepareStatement(requete);
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx = ConnexionBdd.connexionDB();
	}

}
