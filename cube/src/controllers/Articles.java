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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Articles implements Initializable{
	private Parent fxml;
	
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
		
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
		
		tableArticles.setItems(getDataArticle());
			// open crud popup
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
	
	public static ObservableList<article> getDataArticle(){
		ObservableList<article> list = FXCollections.observableArrayList();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from article");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new article(Integer.parseInt(rs.getString("IdArticle")), rs.getString("nomArticle"), rs.getString("referenceArticle"), rs.getString("anneeArticle"), rs.getString("familleArticle"),Integer.parseInt(rs.getString("prixUnitaireArticle")), Integer.parseInt(rs.getString("prixCartonArticle")), Integer.parseInt(rs.getString("prixFournisseurArticle")), Integer.parseInt(rs.getString("coutStockageArticle")), Integer.parseInt(rs.getString("tvaArticle")), rs.getString("domaineArticle"),rs.getString("descriptionArticle")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
    @FXML
    void goFournisseur(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Fournisseur.fxml"));
            articlesPane.getChildren().removeAll();
            articlesPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    void goBack(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
            articlesPane.getChildren().removeAll();
            articlesPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    private ImageView backArrow;
    
    @FXML
    private MenuButton Famille;

    @FXML
    private MenuItem FamilleBlanc;

    @FXML
    private MenuItem FamilleRouge;

    @FXML
    private Text Fournisseur;

    @FXML
    private BorderPane articlesPane;

    @FXML
    private TextField rechercheBare;

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

 

}
