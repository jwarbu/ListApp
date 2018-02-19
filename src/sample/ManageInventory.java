package sample;

import HW5.Inventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ManageInventory
{
// This class is meant to manage the store's current inventory

    private List<InventoryItem> novemberInventory;
    private ObservableList<InventoryItem> obsInv;

    public ObservableList getInventory()
    {
        novemberInventory = new ArrayList<>();
        //Name, barcode, price
        //obsInv.add(0, new InventoryItem("Whole Coffee Beans", 1, 10.99));
        /**obsInv.add(1, new InventoryItem("Ground Coffee", 2, 15.45));
        obsInv.add(2, new InventoryItem("French Press", 3, 55.20));
        obsInv.add(3, new InventoryItem("Pour Over", 4, 19.95));
        obsInv.add(4, new InventoryItem("Cold Brew Toddy", 5, 31.05));
        obsInv.add(5, new InventoryItem("Large Mug", 6, 5.01));
        obsInv.add(6, new InventoryItem("Small Mug", 7, 2.50));**/

        // Name, barcode, price
        novemberInventory.add(0, new InventoryItem("Whole Coffee Beans", 1, 10.99));
        novemberInventory.add(1, new InventoryItem("Ground Coffee", 2, 15.45));
        novemberInventory.add(2, new InventoryItem("French Press", 3, 55.20));
        novemberInventory.add(3, new InventoryItem("Pour Over", 4, 19.95));
        novemberInventory.add(4, new InventoryItem("Cold Brew Toddy", 5, 31.05));
        novemberInventory.add(5, new InventoryItem("Large Mug", 6, 5.01));
        novemberInventory.add(6, new InventoryItem("Small Mug", 7, 2.50));

        obsInv = FXCollections.observableList(novemberInventory);
        return obsInv;

    }

    public void displayNovember()
    {
        for (int i=0; i<7; i++)
        {
            novemberInventory.get(i).writeInfo();
            System.out.println();
        }
    }

    public int getSize()
    {
        return novemberInventory.size();
    }

    public ObservableList<InventoryItem> getObsInv() {
        return obsInv;
    }

}
