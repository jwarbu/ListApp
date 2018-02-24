package javathehut;

import javafx.beans.property.*;
import java.util.Objects;

public class Product {
    private StringProperty prodName = new SimpleStringProperty();
    private IntegerProperty prodNum = new SimpleIntegerProperty();
    private DoubleProperty prodPrice = new SimpleDoubleProperty();


    // Default constructor

    public Product()
    {
        this("UNKNOWN", 0, 0);
    }

    public Product(String inName, int inNum, double inPrice)
    {
        this.prodName = new SimpleStringProperty(inName);
        this.prodNum = new SimpleIntegerProperty(inNum);
        this.prodPrice = new SimpleDoubleProperty(inPrice);
    }


    // Property Methods

    public StringProperty prodNameProperty()
    {
        if (prodName == null)
        {
            prodName = new SimpleStringProperty(this, "prodName");
        }
        return prodName;
    }

    public IntegerProperty prodNumProperty()
    {
        if (prodNum == null)
        {
            prodNum = new SimpleIntegerProperty(this, "prodNum");
        }
        return prodNum;
    }

    public DoubleProperty prodPriceProperty()
    {
        if (prodPrice == null)
        {
            prodPrice = new SimpleDoubleProperty(this, "prodPrice");
        }
        return prodPrice;
    }


    // Copy

    public Product copy()
    {
        Product new_prod = new Product(this.getProdName(), this.getProdNum(), this.getProdPrice());
        return new_prod;
    }

    public void copy(Product toCopy)
    {
        this.setProdName(toCopy.getProdName());
        this.setProdNum(toCopy.getProdNum());
        this.setProdPrice(toCopy.getProdPrice());
    }


    // Equals methods

    public boolean equals(Product prod)
    {
        boolean flag = true;
        if(!prod.prodName.equals(this.prodName))
        {
            flag = false;
        }

        if(prod.prodNum != this.prodNum)
        {
            flag = false;
        }

        if(prod.prodPrice != this.prodPrice)
        {
            flag = false;
        }

        return flag;

    }

    public boolean isName(String s)
    {
        return(this.prodName.equals(s));
    }

    public boolean isNum(int i)
    {
        return(this.prodNum.getValue()==i);
    }

    public boolean isPrice(double d)
    {
        return(this.prodPrice.getValue() == d);
    }


    // Getters & Setters

    public String getProdName() {
        return prodName.get();
    }

    public void setProdName(String prodName) {
        this.prodName.set(prodName);
    }

    public int getProdNum() {
        return prodNum.get();
    }

    public void setProdNum(int prodNum) {
        this.prodNum.set(prodNum);
    }

    public double getProdPrice() {
        return prodPrice.get();
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice.set(prodPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodName=" + prodName +
                ", prodNum=" + prodNum +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
