package javathehut;

import HW5.Inventory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.List;

public class EditCartCell extends TableCell<InventoryItem, Boolean>
{
    final Button addButton = new Button("Update");
    final StackPane paddedButton = new StackPane();


    EditCartCell(TableView tbl_cat, TableView tbl_cart)
    {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InventoryItem item = getTableView().getItems().get(getIndex()); //get items in selected row

                String user_qty = item.getTfQty().getText();
                String user_priority = item.getTfPriority().getText();
                if(InputChecker.isInt(user_qty) && !user_qty.equalsIgnoreCase("0"))
                {
                    int new_qty = Integer.parseInt(user_qty);
                    item.setQuantity(new_qty);
                }

                else if(user_qty.equalsIgnoreCase("0")) //remove from cart
                {
                    tbl_cart.getItems().remove(getIndex());
                }

            }
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty)
    {
        super.updateItem(item, empty);
        if (!empty)
        {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(paddedButton);
        }

        else
        {
            setGraphic(null);
        }
    }
}
