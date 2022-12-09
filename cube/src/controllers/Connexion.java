package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class Connexion implements Initializable{
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
    	String email = emailField.getText();
    	String mdp = mdpField.getText();

    	if(email.equals("wayan.savary@gmail.com") && mdp.equals("wayan") || 1==1) {
        	try {
                fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
                connexionPane.getChildren().removeAll();
                connexionPane.getChildren().setAll(fxml);
            } catch (IOException e) {
                e.printStackTrace();
            }     		
    	}else {
    		System.out.println("Email or password are false fdp");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
