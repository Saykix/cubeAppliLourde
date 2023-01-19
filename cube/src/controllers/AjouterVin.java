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


public class AjouterVin implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	

    @FXML
    private BorderPane AjouterVinPane;

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
    private TextField idFournisseurArticle;

    @FXML
    private Button modifierArticle;

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
    void ajoutervin(MouseEvent event) {
    	String requete = "INSERT INTO `article` (`nomArticle`, `anneeArticle`, `prixUnitaireArticle`, `prixCartonArticle`, `prixFournisseurArticle`, `referenceArticle`,"
    			+ " `tvaArticle`, `domaineArticle`, `descriptionArticle`, `familleArticle`, `coutStockageArticle`, `IdFournisseurCE`)"
    			+ " VALUES ('"+nomArticle.getText()+"', '"+anneeArticle.getText()+"', '"+prixUnitaireArticle.getText()+"', '"+prixCartonArticle.getText()+"', '"+prixFournisseurArticle.getText()+"', '"+referenceArticle.getText()+"', "
    					+ "'"+tvaArticle.getText()+"', '"+domaineArticle.getText()+"', '"+descriptionArticle.getText()+"', '"+familleArticle.getText()+"', '"+coutStockageArticle.getText()+"', '"+idFournisseurArticle.getText()+"');";
    	System.out.println(requete);
    	try {
			PreparedStatement ps = cnx.prepareStatement(requete);
			 ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
	}

}
