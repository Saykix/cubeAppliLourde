package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import Class.utilisateur;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Utilisateur implements Initializable{


	private Parent fxml;
	
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	
    @FXML
    void goBack(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
            UtilisateurPane.getChildren().removeAll();
            UtilisateurPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
		tableUtilisateurNom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nomUtilisateur"));
		tableUtilisateurPrenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenomUtilisateur"));
		tableUtilisateurEmail.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("emailUtilisateur"));
		tableUtilisateurAdresse.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("adresseUtilisateur"));
		tableUtilisateurVille.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("villeUtilisateur"));
		tableUtilisateurId.setCellValueFactory(new PropertyValueFactory<utilisateur,Integer>("idUtilisateur"));
		tableUtilisateurCodePostale.setCellValueFactory(new PropertyValueFactory<utilisateur,Integer>("codePostaleUtilisateur"));
		tableUtilisateurTelephone.setCellValueFactory(new PropertyValueFactory<utilisateur,Integer>("telephoneUtilisateur"));
		
		tableUtilisateur.setItems(getDataArticle());
		
		// open crud popup
		tableUtilisateur.setOnMouseClicked(new EventHandler<MouseEvent>(){
				
		        @Override
		        public void handle(MouseEvent event) {
		        	//open only on double click
		        	if(event.getClickCount() == 2) {            		
		        		FXMLLoader Loader = new FXMLLoader();
		        		Loader.setLocation(getClass().getResource("/interfaces/CrudUtilisateur.fxml"));
		        		try {
		        			Loader.load();
		        		} catch (IOException ex) {
		        			ex.printStackTrace();
		        		}
		        		
		        		CrudUtilisateur CrudUtilisateur = Loader.getController();
		        		CrudUtilisateur.setData(tableUtilisateur.getSelectionModel().getSelectedItem().getVilleUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getNomUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getPrenomUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getEmailUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getMotDePasseUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getAdresseUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getIdUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getCodePostaleUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getTelephoneUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getAdministrateur()
		        				);
		        		Parent p = Loader.getRoot();
		        		Stage stage = new Stage();
		        		stage.setScene(new Scene(p));
		        		stage.show();
		        	}
		        	}
		                
		    });
		
	}
	
	public static ObservableList<utilisateur> getDataArticle(){
		ObservableList<utilisateur> list = FXCollections.observableArrayList();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from utilisateur");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new utilisateur(rs.getString("nomUtilisateur"),rs.getString("prenomUtilisateur"),rs.getString("emailUtilisateur"),rs.getString("motDePasseUtilisateur"),rs.getString("adresseUtilisateur"),rs.getString("villeUtilisateur"),Integer.parseInt(rs.getString("idUtilisateur")),Integer.parseInt(rs.getString("codePostaleUtilisateur")),Integer.parseInt(rs.getString("telephoneUtilisateur")),Integer.parseInt(rs.getString("administrateur"))));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
    @FXML
    void addUser(MouseEvent event) {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/interfaces/NewUtilisateur.fxml"));
		try {
			Loader.load();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		

		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();
		
    }
	
   
    
    @FXML
    private ImageView backArrow;
    
    @FXML
    private Text Fournisseur;

    @FXML
    private BorderPane UtilisateurPane;

    @FXML
    private TextField rechercheBare;

    @FXML
    private TableView<utilisateur> tableUtilisateur;

    @FXML
    private TableColumn<utilisateur, String> tableUtilisateurAdresse;

    @FXML
    private TableColumn<utilisateur, Integer> tableUtilisateurCodePostale;

    @FXML
    private TableColumn<utilisateur, String> tableUtilisateurEmail;

    @FXML
    private TableColumn<utilisateur, Integer> tableUtilisateurId;

    @FXML
    private TableColumn<utilisateur, String> tableUtilisateurNom;

    @FXML
    private TableColumn<utilisateur, String> tableUtilisateurPrenom;

    @FXML
    private TableColumn<utilisateur, Integer> tableUtilisateurTelephone;

    @FXML
    private TableColumn<utilisateur, String> tableUtilisateurVille;

    @FXML
    private Text ajouterUtilisateur;

}
