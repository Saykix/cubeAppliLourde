package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Accueil {
	
	private Parent fxml;
	
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
    private TableView<?> tableInventaire;

    @FXML
    private Text totalProduit;

    @FXML
    void doInventaire(MouseEvent event) {

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

}