package javathehut;

import HW5.Inventory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import javax.swing.*;
import javax.xml.soap.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class con_ss implements Initializable{

    @FXML private TableView tbl_catalog;
    @FXML private TableView tbl_cart;
    @FXML private Label lb_current_budget;
    @FXML private TextField tf_budget;

    public List<InventoryItem> cartHistory = new ArrayList<>();
    public List<InventoryItem> cart = new ArrayList<>();
    public Budget totalBudget = new Budget(0);

    public void handleBudgetButtonAction(ActionEvent e)
    {
        String user_budget = InputChecker.stripForMoney(tf_budget.getText());
        if(user_budget.equals("")) //input was alpha characters only
        {
            totalBudget.setBudget(0);
        }
        else
        {
            totalBudget.setBudget(Double.parseDouble(user_budget));
            lb_current_budget.setText(totalBudget.getStringBudget());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ManageInventory currentInventory = new ManageInventory();
        Budget shoppingBudget = new Budget(0);
        lb_current_budget.setText(shoppingBudget.getStringBudget());

        TableColumn<InventoryItem, String> prodNameCol = new TableColumn<>("Product Name");
        prodNameCol.setCellValueFactory(new PropertyValueFactory("prodName"));

        TableColumn<InventoryItem, Double> prodPriceCol = new TableColumn<>("Price");
        prodPriceCol.setCellValueFactory(new PropertyValueFactory("prodPrice"));

        TableColumn<InventoryItem, TextField> catQtyCol = new TableColumn<>("Qty");
        catQtyCol.setCellValueFactory(new PropertyValueFactory("textField"));
        catQtyCol.setSortable(false);
        catQtyCol.setPrefWidth(50);

        TableColumn<InventoryItem, Boolean> addBtnCol = new TableColumn<>("Add");
        addBtnCol.setSortable(false);
        addBtnCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<InventoryItem, Boolean>, ObservableValue<Boolean>>(){
                    @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<InventoryItem, Boolean> features)
                        {
                            return new SimpleBooleanProperty(features.getValue() != null);
                        }
                });
        addBtnCol.setCellFactory(
                new Callback<TableColumn<InventoryItem, Boolean>, TableCell<InventoryItem, Boolean>>(){
                    @Override
                    public TableCell<InventoryItem, Boolean> call(TableColumn<InventoryItem, Boolean> inventoryItemBooleanTableColumn)
                        {
                            return new AddItemCell(tbl_catalog, tbl_cart);
                        }
                });


        tbl_catalog.setItems(currentInventory.getInventory());
        tbl_catalog.getColumns().setAll(prodNameCol, prodPriceCol, catQtyCol, addBtnCol);


        TableColumn<InventoryItem, String> cartNameCol = new TableColumn<>("Product Name");
        cartNameCol.setCellValueFactory(new PropertyValueFactory("prodName"));
        cartNameCol.setMinWidth(75);

/**
        TableColumn<InventoryItem, Integer> cartQtyCol = new TableColumn<>("Qty");
        cartQtyCol.setCellValueFactory(new PropertyValueFactory("quantity"));
 */

        TableColumn<InventoryItem, TextField> cartQtyCol = new TableColumn<>("Qty");
        cartQtyCol.setCellValueFactory(new PropertyValueFactory("tfQty"));
        cartQtyCol.setSortable(false);
        cartQtyCol.setPrefWidth(50);

        TableColumn<InventoryItem, Boolean> editCartCol = new TableColumn<>("Update");
        editCartCol.setSortable(false);
        editCartCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<InventoryItem, Boolean>, ObservableValue<Boolean>>(){
                    @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<InventoryItem, Boolean> features)
                    {
                        return new SimpleBooleanProperty(features.getValue() != null);
                    }
                });
        editCartCol.setCellFactory(
                new Callback<TableColumn<InventoryItem, Boolean>, TableCell<InventoryItem, Boolean>>(){
                    @Override
                    public TableCell<InventoryItem, Boolean> call(TableColumn<InventoryItem, Boolean> inventoryItemBooleanTableColumn)
                    {
                        return new EditCartCell(tbl_catalog, tbl_cart);
                    }
                });


        TableColumn<InventoryItem, Double> cartPriceCol = new TableColumn<>("Total Price");
        cartPriceCol.setCellValueFactory(new PropertyValueFactory("total"));

        TableColumn<InventoryItem, TextField> cartPriorityCol = new TableColumn<>("Priority");
        cartPriorityCol.setCellValueFactory(new PropertyValueFactory("tfPriority"));
        cartPriorityCol.setSortable(true);
        cartPriorityCol.setPrefWidth(50);


        tbl_cart.setItems(FXCollections.observableList(cartHistory));
        tbl_cart.getColumns().setAll(cartPriorityCol, cartNameCol, cartQtyCol, cartPriceCol, editCartCol);
    }

}
