package javathehut;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class InventoryItem extends Product
{
    private SimpleIntegerProperty quantity = new SimpleIntegerProperty();
    private String qtyText = "";
    private Button button;
    private TextField textField;
    //private ChoiceBox choiceBox;


    // Default Constructor
    public InventoryItem()
    {
        super();
        this.quantity.set(0);
        this.button = new Button("add");
        this.textField = new TextField("1");
        //this.choiceBox = new ChoiceBox();
    }

    public InventoryItem(String inName, int inNumber, double inPrice)
    {
        super(inName, inNumber, inPrice);
        this.quantity.set(0);
        this.button = new Button("add");
        this.textField = new TextField("1");
    }

// Property Methods
    public SimpleIntegerProperty quantityProperty() {
    return quantity;
}


    // Read & Write methods
    public void readInfo()
    {
    }

    public void writeInfo()
    {
        System.out.println("Item #" + getProdNum());
        System.out.println(getProdName() + " | $" + getProdPrice());

    }

// Getters and Setters
    public String getLabel()
    {
        return super.getProdName() + " ($" + super.getProdPrice() + ")";
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }


    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public String getQtyText() {
        return qtyText;
    }

    public void setQtyText(String qtyText) {
        this.qtyText = qtyText;
    }
}
