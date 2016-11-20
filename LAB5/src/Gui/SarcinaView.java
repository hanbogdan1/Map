package Gui;

import Controller.Controller;
import Domain.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;




public class SarcinaView {
    sarcinaController sarcinaController;
    ObservableList<sarcina> model;

    BorderPane background ;
    Label idLabel ;
    Label descriereLabel;
    Label ratingLabel;
    TextField idText;
    TextField descriereText;
    TextField durataText;

    //Buttons
    Button saveB;
    Button updateB;
    Button deleteB;
    Button clearAllB;

    TableView<sarcina> sarcinaTable;
    
    TableColumn<sarcina,Integer> idColumn;
    TableColumn<sarcina,String> descriereColumn;
    TableColumn<sarcina,Integer> durataColumn;

    private Pane createLeftPane(){
        sarcinaTable = new TableView<>();
        idColumn= new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<sarcina, Integer>("id"));
        descriereColumn=new TableColumn<>("Descriere");
        descriereColumn.setCellValueFactory(new PropertyValueFactory<sarcina, String>("Descriere"));
        
        durataColumn=new TableColumn<>("Durata");
        durataColumn.setCellValueFactory(new PropertyValueFactory<sarcina, Integer>("Durata"));
        sarcinaTable.getColumns().add(idColumn);
        sarcinaTable.getColumns().add(descriereColumn);
        sarcinaTable.getColumns().add(durataColumn);
        sarcinaTable.setItems(model);
        return new HBox(sarcinaTable);
    }

    private Pane createCenterPane(){
        idLabel = new Label("ID: ");
        descriereLabel = new Label("Descriere: ");
        ratingLabel = new Label("Durata: ");
        idText = new TextField();
        descriereText = new TextField();
        durataText = new TextField();
        
        GridPane gridPane = new GridPane();
        gridPane.add(idLabel, 0, 0);
        gridPane.add(descriereLabel, 0, 1);
        gridPane.add(ratingLabel, 0, 2);
        gridPane.add(idText, 1, 0);
        gridPane.add(descriereText, 1, 1);
        gridPane.add(durataText, 1, 2);
        return gridPane;
    }

    private Pane createBottomPane(){
        saveB = new Button("Save");
        saveB.setOnAction(sarcinaController.addButtonHandler());
        updateB = new Button("Update");
        updateB.setOnAction(sarcinaController.updateButtonHandler());
        deleteB = new Button("Delete");
        deleteB.setOnAction(sarcinaController.deleteButtonHandler());
        return new HBox(saveB, updateB, deleteB, clearAllB);
    }

    private void initComponents(){
        background = new BorderPane();
        background.setLeft(createLeftPane());
        background.setCenter(createCenterPane());
        background.setBottom(createBottomPane());
    }

    public BorderPane getView(){
        return background;
    }
    public SarcinaView(ObservableList<sarcina> list, Controller controller){
        this.model = list;
        sarcinaController = new sarcinaController(this, controller);
        initComponents();
    }

}
