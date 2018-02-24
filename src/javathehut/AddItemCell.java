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

public class AddItemCell extends TableCell<InventoryItem, Boolean>
{
    final Button addButton = new Button("Add");
    final TextField addTextField = new TextField("1");
    final StackPane paddedButton = new StackPane();


    AddItemCell(TableView tbl_cat, final TableView tbl_cart)
    {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InventoryItem item = getTableView().getItems().get(getIndex());
                InventoryItem new_item = new InventoryItem();
                new_item.copy(item);
                new_item.setQuantity(Integer.parseInt(item.getTextField().getText()));
                tbl_cart.getItems().add(new_item);
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
