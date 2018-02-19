package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class con_ss implements Initializable{

    @FXML private TableView tbl_catalog;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ManageInventory currentInventory = new ManageInventory();


        TableColumn<InventoryItem, String> prodNameCol = new TableColumn<InventoryItem, String>("Product Name");
        prodNameCol.setCellValueFactory(new PropertyValueFactory("prodName"));
        TableColumn<InventoryItem, Double> prodPriceCol = new TableColumn<InventoryItem, Double>("Price");
        prodPriceCol.setCellValueFactory(new PropertyValueFactory("prodPrice"));
        TableColumn addBtnCol = new TableColumn("Add");
        addBtnCol.setSortable(false);


        tbl_catalog.setItems(currentInventory.getInventory());
        tbl_catalog.getColumns().setAll(prodNameCol, prodPriceCol, addBtnCol);

    }
}
