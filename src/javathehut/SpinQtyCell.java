package javathehut;

import javafx.application.Platform;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.input.KeyCode;

public class SpinQtyCell extends TableCell<InventoryItem, Integer> {
    private final Spinner<Integer> spinner;

    public SpinQtyCell(int min, int max, int initial, int step) {
        spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initial, step));
        setEditable(true);
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            InventoryItem item = getTableView().getItems().get(getIndex());

            spinner.getValueFactory().setValue(item.getQuantity());

            setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    Platform.runLater(() -> {
                        commitEdit(spinner.getValue());
                    });
                }
            });

            setText(null);
            setGraphic(spinner);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getItem().toString());
        setGraphic(null);
    }

    @Override
    public void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                setText(null);
                setGraphic(spinner);
            } else {
                setText(getItem().toString());
                setGraphic(null);
            }
        }
    }
}