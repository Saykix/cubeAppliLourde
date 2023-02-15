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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrudArticle implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	String id;
	ObservableList<article> list = FXCollections.observableArrayList();
     public void setData(String id, String nom, String reference, String annee, String famille, String prixUnitaire, String prixCarton, String prixFournisseur, String coutStockage, String tva,
 			String domaine, String description) {
    	 this.id=id;
        list.add(new article(id, nom, reference, annee, famille, prixUnitaire, prixCarton, prixFournisseur, coutStockage, tva, domaine, description));

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
    private TextField nbArticle;

    @FXML
    void CommandVin(MouseEvent event) {
    	String idFournisseur;
    	try { 
    		PreparedStatement ps = cnx.prepareStatement("SELECT IdFournisseurCE FROM `tablearticle` WHERE referenceArticle = '"+list.get(0).getReference()+"';");
    		ResultSet rs = ps.executeQuery();
    		if(rs.next() != false ) {
    			idFournisseur = rs.getString("IdFournisseurCE");
    			String requete = "INSERT INTO `tablearticle` (`nomArticle`, `anneeArticle`, `prixUnitaireArticle`, `prixCartonArticle`, `prixFournisseurArticle`, `referenceArticle`,"
    					+ " `tvaArticle`, `domaineArticle`, `descriptionArticle`, `familleArticle`, `coutStockageArticle`, `IdFournisseurCE`)"
    					+ " VALUES ('"+list.get(0).getNom()+"', '"+list.get(0).getAnnee()+"', '"+list.get(0).getPrixUnitaire()+"', '"+list.get(0).getPrixCarton()+"', '"+list.get(0).getPrixFournisseur()+"', '"+list.get(0).getReference()+"', "
    					+ "'"+list.get(0).getTva()+"', '"+list.get(0).getDomaine()+"', '"+list.get(0).getDescription()+"', '"+list.get(0).getFamille()+"', '"+list.get(0).getCoutStockage()+"', '"+idFournisseur+"');";
    		 	for(int i = 0; i < Integer.parseInt(nbArticle.getText()) ; i++) {    	    		
    		 		try {
    		 			PreparedStatement psb = cnx.prepareStatement(requete);
    		 			psb.executeUpdate();
    		 			
    		 		} catch (SQLException e) {
    		 			e.printStackTrace();
    		 		}
    	    	}
    		}
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
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
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM `tablearticle` WHERE `tablearticle`.`IdArticle` = " + id + ";");
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
