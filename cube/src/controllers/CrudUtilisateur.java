package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Class.utilisateur;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CrudUtilisateur implements Initializable {
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	int id;
	ObservableList<utilisateur> list = FXCollections.observableArrayList();
     public void setData(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String motDePasseUtilisateur,
    		 String adresseUtilisateur, String villeUtilisateur, int idUtilisateur,
    		 int codePostaleUtilisateur, int telephoneUtilisateur, int administrateur) {
    	 this.id=idUtilisateur;
        list.add(new utilisateur(nomUtilisateur, prenomUtilisateur, emailUtilisateur, motDePasseUtilisateur, adresseUtilisateur, villeUtilisateur,  idUtilisateur, codePostaleUtilisateur, telephoneUtilisateur, administrateur));
        System.out.println("Id : " + id + "  Nom : " + nomUtilisateur + "  Référence : " + emailUtilisateur);

    }

    @FXML
    private BorderPane crudUtilisateurPane;

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
    	System.out.println("delete from article where IdArticle = "+id);
//		PreparedStatement ps;
//		try {
//			ps = cnx.prepareStatement("delete from article where IdArticle = "+id);
//			ps.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
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
	}

}
