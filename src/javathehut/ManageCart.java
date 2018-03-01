package javathehut;

import HW5.Inventory;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

public class ManageCart {

    public static boolean isDuplicate(ObservableList<InventoryItem> cart, Product item)
    {
        boolean flag = false;

        for(int i = 0; i < cart.size(); i++)
        {
            if(cart.get(i).isNum(item.getProdNum()))
            {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static ObservableList<InventoryItem> addToExisting(ObservableList<InventoryItem> cart, InventoryItem item)
    {
        int index = indexOfNum(cart, item.getProdNum());
        int qty = item.getQuantity() + cart.get(index).getQuantity();

        cart.get(index).setQuantity(qty);
        cart.get(index).calcPrice();

        return cart;
    }


    public static int indexOfNum(List<InventoryItem> cart, int num)
    {
        int index = -1;

        for(int i = 0; i<cart.size(); i++)
        {
            if(cart.get(i).isNum(num))
            {
                index = i;
                break;
            }
        }
        return index;
    }

}
