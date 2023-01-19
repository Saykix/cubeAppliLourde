package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Class.article;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrudArticle implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	int id;
	ObservableList<article> list = FXCollections.observableArrayList();
     public void setData(int id, String nom, String reference, String annee, String famille, int prixUnitaire, int prixCarton, int prixFournisseur, int coutStockage, int tva,
 			String domaine, String description) {
    	 this.id=id;
        list.add(new article(id, nom, reference, annee, famille, prixUnitaire, prixCarton, prixFournisseur, coutStockage, tva, domaine, description));
        System.out.println("Id : " + id + "  Nom : " + nom + "  Référence : " + reference);

    }
    @FXML
    private Button CommandVin;

    @FXML
    private Button ModifierVin;

    @FXML
    private BorderPane crudArticlesPane;

    @FXML
    private Button delvin;
    

    @FXML
    void CommandVin(MouseEvent event) {
    	
    }

    @FXML
    void ModifierVin(MouseEvent event) {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/interfaces/ModifierVin.fxml"));
		try {
			Loader.load();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		ModifierVin modifierVin = Loader.getController();
		
		modifierVin.setData(tableArticles.getSelectionModel().getSelectedItem().getId(),
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

    @FXML
    void delvin(MouseEvent event) {
		try {
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM `article` WHERE `article`.`IdArticle` = " + id + ";");
			 ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	tableArticles.getItems().removeAll(tableArticles.getSelectionModel().getSelectedItem());
    }
    
    
    @FXML
    private TableView<article> tableArticles;

    @FXML
    private TableColumn<article, String> tableArticlesAnnee;

    @FXML
    private TableColumn<article, Integer> tableArticlesCoutStockage;

    @FXML
    private TableColumn<article, String> tableArticlesDescription;

    @FXML
    private TableColumn<article, String> tableArticlesDomaine;

    @FXML
    private TableColumn<article, String> tableArticlesFamille;

    @FXML
    private TableColumn<article, Integer> tableArticlesFournisseur;

    @FXML
    private TableColumn<article, String> tableArticlesNom;

    @FXML
    private TableColumn<article, Integer> tableArticlesPrixCarton;

    @FXML
    private TableColumn<article, Integer> tableArticlesPrixUnitaire;

    @FXML
    private TableColumn<article, String> tableArticlesReference;

    @FXML
    private TableColumn<article, Integer> tableArticlesTVA;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
		tableArticlesNom.setCellValueFactory(new PropertyValueFactory<article,String>("nom"));
		tableArticlesReference.setCellValueFactory(new PropertyValueFactory<article,String>("reference"));
		tableArticlesAnnee.setCellValueFactory(new PropertyValueFactory<article,String>("annee"));
		tableArticlesFamille.setCellValueFactory(new PropertyValueFactory<article,String>("famille"));
		tableArticlesDomaine.setCellValueFactory(new PropertyValueFactory<article,String>("domaine"));
		tableArticlesDescription.setCellValueFactory(new PropertyValueFactory<article,String>("description"));
		tableArticlesPrixUnitaire.setCellValueFactory(new PropertyValueFactory<article,Integer>("prixUnitaire"));
		tableArticlesPrixCarton.setCellValueFactory(new PropertyValueFactory<article,Integer>("prixCarton"));
		tableArticlesFournisseur.setCellValueFactory(new PropertyValueFactory<article,Integer>("prixFournisseur"));
		tableArticlesTVA.setCellValueFactory(new PropertyValueFactory<article,Integer>("tva"));
		tableArticlesCoutStockage.setCellValueFactory(new PropertyValueFactory<article,Integer>("coutStockage"));
		
		tableArticles.setItems(list);
	}

}
