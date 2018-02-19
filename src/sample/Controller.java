package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML public ComboBox itembox;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        itembox.getItems().clear();

        ManageInventory loadInventory = new ManageInventory();
        //loadInventory.loadNovember();
        //InventoryItem[] inventory = loadInventory.getInventory();

        /**for(int i = 0; i<inventory.length; i++)
        {
            if(i == 0)
            {
                itembox.getItems().add("-- Select Items --");
            }
            else {
                itembox.getItems().add(i, inventory[i].getLabel());
            }
        }**/
        itembox.setItems(loadInventory.getObsInv());
        itembox.getSelectionModel().select(0);
    }
}
