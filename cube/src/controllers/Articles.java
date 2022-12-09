package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Articles {
    @FXML
    private Text Famille;

    @FXML
    private Button pd;
    
    @FXML
    private Text Fournisseur;

    @FXML
    private BorderPane articlesPane;

    @FXML
    private TextField rechercheBare;

    @FXML
    private AnchorPane vinPaneList;
    

    @FXML
    void pdtext(ActionEvent event) {

    	// create a label
    	Label l = new Label("no text");
    	vinPaneList.getChildren().add(l);
    	System.out.println(vinPaneList.getChildren());
    	
    }

}
