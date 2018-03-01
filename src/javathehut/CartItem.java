package javathehut;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;


public class CartItem extends Product

{
    private SimpleIntegerProperty quantity = new SimpleIntegerProperty();
    private SimpleDoubleProperty total = new SimpleDoubleProperty();
    private String qtyText = "";
    private TextField tfQty;
    private TextField tfPriority;
    //private Spinner spinQty = new Spinner();


    // Default Constructor
    public CartItem()
    {
        super();
        this.quantity.set(0);
        this.total.set(super.getProdPrice());
        this.tfQty.setText(Integer.toString(quantity.getValue()));
        //this.spinQty = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
    }

    public CartItem(String inName, int inNumber, double inPrice)
    {
        super(inName, inNumber, inPrice);
        this.quantity.set(0);
        this.total.set(inPrice);
        this.tfQty.setText(Integer.toString(quantity.getValue()));

        //this.spinQty = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
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

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
        //this.spinQty.getValueFactory().setValue(quantity);
    }


    public String getQtyText() {
        return qtyText;
    }

    public void setQtyText(String qtyText) {
        this.qtyText = qtyText;
    }


    public TextField getTfQty() {
        return tfQty;
    }

    public void setTfQty(TextField tfQty) {
        this.tfQty = tfQty;
    }
}
