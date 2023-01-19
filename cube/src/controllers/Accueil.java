package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Class.articleStock;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Accueil implements Initializable{
	private Parent fxml;
	
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
    @FXML
    private Text CoutStockage;

    @FXML
    private Button Inventoriser;

    @FXML
    private BorderPane accueilPane;

    @FXML
    private Text commanderVin;

    @FXML
    private Text coutMarchandise;

    @FXML
    private Text gererClient;

    @FXML
    private Text gererStock;

    @FXML
    private TextField rechercheBare;

    @FXML
    private TableView<articleStock> tableArticles;

    @FXML
    private TableColumn<articleStock, String> tableArticlesAnnee;

    @FXML
    private TableColumn<articleStock, Integer> tableArticlesCoutStockage;

    @FXML
    private TableColumn<articleStock, String> tableArticlesDomaine;

    @FXML
    private TableColumn<articleStock, String> tableArticlesFamille;

    @FXML
    private TableColumn<articleStock, Integer> tableArticlesFournisseur;

    @FXML
    private TableColumn<articleStock, String> tableArticlesNom;

    @FXML
    private TableColumn<articleStock, Integer> tableArticlesPrixCarton;

    @FXML
    private TableColumn<articleStock, Integer> tableArticlesPrixUnitaire;

    @FXML
    private TableColumn<articleStock, String> tableArticlesReference;

    @FXML
    private TableColumn<articleStock, Integer> tableArticlesTVA;

    @FXML
    private TableColumn<articleStock, Integer> stockArticle;
    @FXML
    private Text totalProduit;

    @FXML
    void doInventaire(MouseEvent event) {
    	ObservableList<Integer> produit = FXCollections.observableArrayList();
    	ObservableList<Integer> coutProduit = FXCollections.observableArrayList();
    	ObservableList<Integer> coutStockage = FXCollections.observableArrayList();
    	try {
			PreparedStatement ps = cnx.prepareStatement("select IdArticle from article");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				produit.add(Integer.parseInt(rs.getString("IdArticle")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	totalProduit.setText(totalProduit.getText() + " \n" + produit.size());
    	try {
			PreparedStatement ps = cnx.prepareStatement("select prixUnitaireArticle from article");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				coutProduit.add(Integer.parseInt(rs.getString("prixUnitaireArticle")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	float coutTotal = 0;
    	for(int i = 0; i < coutProduit.size(); i++) {
    		coutTotal += coutProduit.get(i);
    	}
    	coutMarchandise.setText(coutMarchandise.getText() + " \n" + coutTotal+"€");
    	
    	try {
			PreparedStatement ps = cnx.prepareStatement("select coutStockageArticle from article");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				coutStockage.add(Integer.parseInt(rs.getString("coutStockageArticle")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	coutTotal = 0;
    	for(int i = 0; i < coutStockage.size(); i++) {
    		coutTotal += coutStockage.get(i);
    	}
    	CoutStockage.setText(CoutStockage.getText() + " " + coutTotal +"€/j");
    }

	public static ObservableList<articleStock> getDataArticle(){
		ObservableList<articleStock> list = FXCollections.observableArrayList();
		ObservableList<String> references = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from article");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(!references.contains(rs.getString("referenceArticle"))) {
					list.add(new articleStock(Integer.parseInt(rs.getString("IdArticle")), rs.getString("nomArticle"), rs.getString("referenceArticle"), rs.getString("anneeArticle"), rs.getString("familleArticle"),Integer.parseInt(rs.getString("prixUnitaireArticle")), Integer.parseInt(rs.getString("prixCartonArticle")), Integer.parseInt(rs.getString("prixFournisseurArticle")), 
							Integer.parseInt(rs.getString("coutStockageArticle")), Integer.parseInt(rs.getString("tvaArticle")), rs.getString("domaineArticle"),rs.getString("descriptionArticle"),0));
				}
				references.add(rs.getString("referenceArticle"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i <  list.size(); i++) {
			int occurence = 0;
			for(int j = 0; j < references.size(); j++) {
				if(list.get(i).getReference().equals(references.get(j)) ) {
					occurence++;
				}
			}
			if(list.get(i).getReference().equals(references.get(i))) {
				list.get(i).setStock(occurence);
			}
		}
		return list;
	}
    
    @FXML
    void goClient(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Utilisateur.fxml"));
            accueilPane.getChildren().removeAll();
            accueilPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void goStock(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Articles.fxml"));
            accueilPane.getChildren().removeAll();
            accueilPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    void goVin(MouseEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
		tableArticlesNom.setCellValueFactory(new PropertyValueFactory<articleStock,String>("nom"));
		tableArticlesReference.setCellValueFactory(new PropertyValueFactory<articleStock,String>("reference"));
		tableArticlesAnnee.setCellValueFactory(new PropertyValueFactory<articleStock,String>("annee"));
		tableArticlesFamille.setCellValueFactory(new PropertyValueFactory<articleStock,String>("famille"));
		tableArticlesDomaine.setCellValueFactory(new PropertyValueFactory<articleStock,String>("domaine"));
		stockArticle.setCellValueFactory(new PropertyValueFactory<articleStock, Integer>("stock"));
		tableArticlesPrixUnitaire.setCellValueFactory(new PropertyValueFactory<articleStock,Integer>("prixUnitaire"));
		tableArticlesPrixCarton.setCellValueFactory(new PropertyValueFactory<articleStock,Integer>("prixCarton"));
		tableArticlesFournisseur.setCellValueFactory(new PropertyValueFactory<articleStock,Integer>("prixFournisseur"));
		tableArticlesTVA.setCellValueFactory(new PropertyValueFactory<articleStock,Integer>("tva"));
		tableArticlesCoutStockage.setCellValueFactory(new PropertyValueFactory<articleStock,Integer>("coutStockage"));
		
		tableArticles.setItems(getDataArticle());
		
	}

}