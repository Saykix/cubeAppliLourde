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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrudUtilisateur implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	int id;
	ObservableList<utilisateur> list = FXCollections.observableArrayList();
     public void setData(String villeUtilisateur,String nomUtilisateur ,String prenomUtilisateur, String emailUtilisateur,
    		  String motDePasseUtilisateur, String adresseUtilisateur, int idUtilisateur,
    		 int codePostaleUtilisateur, int telephoneUtilisateur, int administrateur) {
    	 System.out.println("Id : " + id + "  Nom : " + nomUtilisateur + "  email : " + emailUtilisateur+ "  mdp : " + motDePasseUtilisateur);
    	 this.id=idUtilisateur;
        list.add(new utilisateur(nomUtilisateur, prenomUtilisateur, emailUtilisateur, motDePasseUtilisateur, adresseUtilisateur, villeUtilisateur,  idUtilisateur, codePostaleUtilisateur, telephoneUtilisateur, administrateur));

    }

    @FXML
    private BorderPane crudUtilisateurPane;

    @FXML
    private Button supprimerUtilisateur;
    
    @FXML
    private Button modifierUtilisateur;


    @FXML
    void modifierUtilisateur(MouseEvent event) {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/interfaces/NewUtilisateur.fxml"));

		try {
			Loader.load();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		NewUtilisateur NewUtilisateur = Loader.getController();
		NewUtilisateur.setData(tableUtilisateur.getSelectionModel().getSelectedItem().getNomUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getPrenomUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getEmailUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getMotDePasseUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getAdresseUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getVilleUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getIdUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getCodePostaleUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getTelephoneUtilisateur(),
				tableUtilisateur.getSelectionModel().getSelectedItem().getAdministrateur()
				);
		Parent p = Loader.getRoot();


		Stage stage = new Stage();
		crudUtilisateurPane.getChildren().removeAll();
		stage.setScene(new Scene(p));
		stage.show();
    }
    


    @FXML
    void delUtilisateur(MouseEvent event) {
		try {
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM `utilisateur` WHERE `utilisateur`.`IdUtilisateur` = " + id + ";");
			 ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableUtilisateur.getItems().removeAll(tableUtilisateur.getSelectionModel().getSelectedItem());
    }
    
    
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
		
		tableUtilisateur.setItems(list);
		
		// open crud popup
				tableUtilisateur.setOnMouseClicked(new EventHandler<MouseEvent>(){
				
		        @Override
		        public void handle(MouseEvent event) {
		        	//open only on double click
		        	if(event.getClickCount() == 2) {            		
		        		FXMLLoader Loader = new FXMLLoader();
		        		Loader.setLocation(getClass().getResource("/interfaces/NewUtilisateur.fxml"));
		        		try {
		        			Loader.load();
		        		} catch (IOException ex) {
		        			ex.printStackTrace();
		        		}
		        		
		        		NewUtilisateur NewUtilisateur = Loader.getController();
		        		
		        		NewUtilisateur.setData(tableUtilisateur.getSelectionModel().getSelectedItem().getNomUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getPrenomUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getEmailUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getMotDePasseUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getAdresseUtilisateur(),
		        				tableUtilisateur.getSelectionModel().getSelectedItem().getVilleUtilisateur(),
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
	}


