package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Class.article;
import Class.fournisseur;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrudFournisseur implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	String idFournisseur;
	ObservableList<fournisseur> list = FXCollections.observableArrayList();
     public void setData(String idFournisseur, String nomFournisseur, String emailFournisseur, String siretFournisseur, String adresseFournisseur, String coordonneesBancaireFournisseur, String villeFournisseur , String descriptionFournisseur, String telephoneUtilisateur, String codePostaleUtilisateur) {
    	 this.idFournisseur=idFournisseur;
        list.add(new fournisseur( nomFournisseur, emailFournisseur, siretFournisseur, adresseFournisseur, coordonneesBancaireFournisseur, villeFournisseur, descriptionFournisseur,idFournisseur , telephoneUtilisateur, codePostaleUtilisateur ));
        System.out.println("Id : " + idFournisseur + "  Nom : " + nomFournisseur + "  Référence : " + siretFournisseur);

    }

    @FXML
    private Button ModifierVin;

    @FXML
    private BorderPane crudArticlesPane;

    @FXML
    private Button delvin;
    

    @FXML
    void ModifierFournisseur(MouseEvent event) {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/interfaces/NewFournisseur.fxml"));
		try {
			Loader.load();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		NewFournisseur newFournisseur = Loader.getController();
		
		newFournisseur.setData(tableFournisseur.getSelectionModel().getSelectedItem().getIdFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getNomFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getSiretFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getEmailFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getCoordonneesBancaireFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getAdresseFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getVilleFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getDescriptionFournisseur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getCodePostaleUtilisateur(),
				tableFournisseur.getSelectionModel().getSelectedItem().getTelephoneUtilisateur()
				);
		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();
    }


    @FXML
    void delFournisseur(MouseEvent event) {
		try {
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM `tablefournisseur` WHERE `tablefournisseur`.`IdFournisseur` = " + idFournisseur + ";");
			 ps.executeUpdate();
			 tableFournisseur.getItems().removeAll(tableFournisseur.getSelectionModel().getSelectedItem());
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR,"Impossible de supprimer le fournisseur, il reste un article de ce fournisseur en stock", ButtonType.OK);
			alert.showAndWait();
			e.printStackTrace();
		}
    }
    
    
    @FXML
    private TableView<fournisseur> tableFournisseur;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurAdresse;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurCodePostal;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurDescription;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurEmail;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurNom;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurSiret;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurTelephone;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurVille;

    @FXML
    private TableView<article> tableArticles;

    @FXML
    private TableColumn<article, String> tableArticlesAnnee;

    @FXML
    private TableColumn<article, String> tableArticlesCoutStockage;

    @FXML
    private TableColumn<article, String> tableArticlesDescription;

    @FXML
    private TableColumn<article, String> tableArticlesDomaine;

    @FXML
    private TableColumn<article, String> tableArticlesFamille;

    @FXML
    private TableColumn<article, String> tableArticlesFournisseur;

    @FXML
    private TableColumn<article, String> tableArticlesNom;

    @FXML
    private TableColumn<article, String> tableArticlesPrixCarton;

    @FXML
    private TableColumn<article, String> tableArticlesPrixUnitaire;

    @FXML
    private TableColumn<article, String> tableArticlesReference;

    @FXML
    private TableColumn<article, String> tableArticlesTVA;

	public static ObservableList<article> getDataArticle(){
		ObservableList<article> listArticle = FXCollections.observableArrayList();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from tablearticle");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				listArticle.add(new article(rs.getString("IdArticle"), rs.getString("nomArticle"), rs.getString("referenceArticle"), rs.getString("anneeArticle"), rs.getString("familleArticle"),rs.getString("prixUnitaireArticle"), rs.getString("prixCartonArticle"), rs.getString("prixFournisseurArticle"), rs.getString("coutStockageArticle"), rs.getString("tvaArticle"), rs.getString("domaineArticle"),rs.getString("descriptionArticle")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticle;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
		tableFournisseurNom.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("nomFournisseur"));
		tableFournisseurEmail.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("emailFournisseur"));
		tableFournisseurSiret.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("siretFournisseur"));
		tableFournisseurAdresse.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("adresseFournisseur"));
		tableFournisseurVille.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("villeFournisseur"));
		tableFournisseurDescription.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("descriptionFournisseur"));
		tableFournisseurTelephone.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("telephoneUtilisateur"));
		tableFournisseurCodePostal.setCellValueFactory(new PropertyValueFactory<fournisseur,String>("codePostaleUtilisateur"));
		
		tableArticlesNom.setCellValueFactory(new PropertyValueFactory<article,String>("nom"));
		tableArticlesReference.setCellValueFactory(new PropertyValueFactory<article,String>("reference"));
		tableArticlesAnnee.setCellValueFactory(new PropertyValueFactory<article,String>("annee"));
		tableArticlesFamille.setCellValueFactory(new PropertyValueFactory<article,String>("famille"));
		tableArticlesDomaine.setCellValueFactory(new PropertyValueFactory<article,String>("domaine"));
		tableArticlesDescription.setCellValueFactory(new PropertyValueFactory<article,String>("description"));
		tableArticlesPrixUnitaire.setCellValueFactory(new PropertyValueFactory<article,String>("prixUnitaire"));
		tableArticlesPrixCarton.setCellValueFactory(new PropertyValueFactory<article,String>("prixCarton"));
		tableArticlesFournisseur.setCellValueFactory(new PropertyValueFactory<article,String>("prixFournisseur"));
		tableArticlesTVA.setCellValueFactory(new PropertyValueFactory<article,String>("tva"));
		tableArticlesCoutStockage.setCellValueFactory(new PropertyValueFactory<article,String>("coutStockage"));
		
		tableFournisseur.setItems(list);
		
		tableArticles.setItems(getDataArticle());
		
		tableFournisseur.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() == 2) {
					
				}
				
			}
			
		});
		
		tableArticles.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
            @Override
            public void handle(MouseEvent event) {
            	//open only on double click
            	if(event.getClickCount() == 2) {            		
            		FXMLLoader Loader = new FXMLLoader();
            		Loader.setLocation(getClass().getResource("/interfaces/CrudVin.fxml"));
            		try {
            			Loader.load();
            		} catch (IOException ex) {
            			ex.printStackTrace();
            		}
            		
            		CrudArticle CrudArticle = Loader.getController();
            		
            		CrudArticle.setData(tableArticles.getSelectionModel().getSelectedItem().getId(),
            					tableArticles.getSelectionModel().getSelectedItem().getNom(),
            					tableArticles.getSelectionModel().getSelectedItem().getReference(),
            					tableArticles.getSelectionModel().getSelectedItem().getAnnee(),
            					tableArticles.getSelectionModel().getSelectedItem().getFamille(),
            					tableArticles.getSelectionModel().getSelectedItem().getPrixUnitaire(),
            					tableArticles.getSelectionModel().getSelectedItem().getPrixCarton(),
            					tableArticles.getSelectionModel().getSelectedItem().getPrixFournisseur(),
            					tableArticles.getSelectionModel().getSelectedItem().getCoutStockage(),
            					tableArticles.getSelectionModel().getSelectedItem().getTva(),
            					tableArticles.getSelectionModel().getSelectedItem().getDomaine(),
            					tableArticles.getSelectionModel().getSelectedItem().getDescription()
            				);
            		Parent p = Loader.getRoot();
            		Stage stage = new Stage();
            		stage.setScene(new Scene(p));
            		stage.show();
            	}
            	}
                    
        });
	}
}
