package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Class.fournisseur;
import application.ConnexionBdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Fournisseur implements Initializable {

	private Parent fxml;
	
	static Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	@FXML
	void goAccueil(MouseEvent event) {
    	try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
            fournisseurPane.getChildren().removeAll();
            fournisseurPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        } 
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
		tableFournisseurTelephone.setCellValueFactory(new PropertyValueFactory<fournisseur,Integer>("telephoneFournisseur"));
		tableFournisseurCodePostal.setCellValueFactory(new PropertyValueFactory<fournisseur,Integer>("codePostalFournisseur"));
		
		tableFournisseur.setItems(getDataArticle());
		
	}
	
	public static ObservableList<fournisseur> getDataArticle(){
		ObservableList<fournisseur> list = FXCollections.observableArrayList();
		
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from fournisseur");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new fournisseur(rs.getString("nomFournisseur"),rs.getString("emailFournisseur"),rs.getString("siretFournisseur"),rs.getString("adresseFournisseur"),rs.getString("coordonneesBancaireFournisseur"),rs.getString("villeFournisseur"),rs.getString("descriptionFournisseur"),Integer.parseInt(rs.getString("idFournisseur")),Integer.parseInt(rs.getString("telephoneFournisseur")),Integer.parseInt(rs.getString("codePostalFournisseur"))));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
    @FXML
    private Text accueil;

    @FXML
    private BorderPane fournisseurPane;

    @FXML
    private TextField rechercheBare;

    @FXML
    private TableView<fournisseur> tableFournisseur;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurAdresse;

    @FXML
    private TableColumn<fournisseur, Integer> tableFournisseurCodePostal;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurDescription;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurEmail;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurNom;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurSiret;

    @FXML
    private TableColumn<fournisseur, Integer> tableFournisseurTelephone;

    @FXML
    private TableColumn<fournisseur, String> tableFournisseurVille;


}
