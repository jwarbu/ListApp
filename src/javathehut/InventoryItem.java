package javathehut;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InventoryItem extends Product
{
    private SimpleIntegerProperty quantity = new SimpleIntegerProperty();
    private SimpleDoubleProperty total = new SimpleDoubleProperty();
    private TextField textField;
    private TextField tfQty;
    private TextField tfPriority;


    // Default Constructor
    public InventoryItem()
    {
        super();
        this.quantity.set(0);
        this.total.set(super.getProdPrice());
        this.textField = new TextField("1");
        this.tfQty = new TextField("0");
        this.tfPriority = new TextField("1");

    }

    public InventoryItem(String inName, int inNumber, double inPrice)
    {
        super(inName, inNumber, inPrice);
        this.quantity.set(0);
        this.total.set(inPrice);
        this.textField = new TextField("1");
        this.tfQty = new TextField("0");
        this.tfPriority = new TextField("1");

    }

// Property Methods
    public SimpleIntegerProperty quantityProperty() {
    return quantity;
}

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
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

// Other Methods
    public void calcPrice()
    {
        setTotal(getQuantity() * getProdPrice());
    }

// Getters and Setters
    public String getLabel()
    {
        return super.getProdName() + " ($" + super.getProdPrice() + ")";
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int i) {
        this.quantity.set(i);
        this.tfQty.setText(Integer.toString(i));
        this.calcPrice();
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public TextField getTfQty() {
        return tfQty;
    }

    public void setTfQty(int i) {
        this.tfQty.setText(Integer.toString(i));
    }

    public TextField getTfPriority() {
        return tfPriority;
    }

    public void setTfPriority(TextField tfPriority) {
        this.tfPriority = tfPriority;
    }
}
