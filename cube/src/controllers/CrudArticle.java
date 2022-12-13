package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Class.article;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CrudArticle implements Initializable {
	
     public void setData(int id, String nom, String reference) {
        
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

    }

    @FXML
    void delvin(MouseEvent event) {
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
		// TODO Auto-generated method stub
		
	}

}
