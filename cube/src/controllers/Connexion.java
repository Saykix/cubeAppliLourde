package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnectAPI;
import application.ConnexionBdd;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class Connexion implements Initializable{
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	private Parent fxml;
	
	@FXML
	private BorderPane connexionPane;
	
    @FXML
    private Button connexion;

    @FXML
    private TextField emailField;

    @FXML
    private TextField mdpField;

    @FXML
    void connect(MouseEvent event) {
    	ConnectAPI.sendGetRequest();
    	ConnectAPI.sendPostRequest();
    	
    	String email = emailField.getText();
    	String mdp = mdpField.getText();
    	
    	String sql = "select emailUtilisateur, motDePasseUtilisateur, administrateur from utilisateur";
    	try {
			st = cnx.prepareStatement(sql);
			result = st.executeQuery();
			if(result.next()) {		
				System.out.println(result.getString("emailUtilisateur"));
				System.out.println(result.getString("motDePasseUtilisateur"));
				if(email.equals(result.getString("emailUtilisateur")) && mdp.equals(result.getString("motDePasseUtilisateur")) || 1==1) {
					try {
						fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
						connexionPane.getChildren().removeAll();
						connexionPane.getChildren().setAll(fxml);
					} catch (IOException e) {
						e.printStackTrace();
					}     		
				}else {
					Alert alert = new Alert(AlertType.ERROR,"L'email ou le mot de passe est incorrect", ButtonType.OK);
					alert.showAndWait();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBdd.connexionDB();
		
	}
}
