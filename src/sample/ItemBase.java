package sample;

import HW5.InputChecker;
import javafx.beans.property.*;

public abstract class ItemBase
{
    //private InputChecker processString = new InputChecker();
    public StringProperty prodName = new SimpleStringProperty();
    public StringProperty prodNameProperty()
    {
        if (prodName == null)
        {
            prodName = new SimpleStringProperty(this, "prodName");
        }
        return prodName;
    }
    public IntegerProperty prodNum = new SimpleIntegerProperty();
    public IntegerProperty prodNumProperty()
    {
        if (prodNum == null)
        {
            prodNum = new SimpleIntegerProperty(this, "prodNum");
        }
        return prodNum;
    }
    public DoubleProperty prodPrice = new SimpleDoubleProperty();
    public DoubleProperty prodPriceProperty()
    {
        if (prodPrice == null)
        {
            prodPrice = new SimpleDoubleProperty(this, "prodPrice");
        }
        return prodPrice;
    }

    // default constructor:

    public ItemBase()
    {
        this("n/a", 0, 0);
        // ^ this is calling the constructor below
    }

    public ItemBase (String inName, int inNumber, double inPrice)
    {
        prodName.set(inName);
        prodNum.set(inNumber);
        prodPrice.set(inPrice);
    }

    public ItemBase copy(ItemBase copy)
    {
        copy.prodName = this.prodName;
        copy.prodPrice = this.prodPrice;
        copy.prodNum = this.prodNum;
        return copy;

    }

    public boolean equals(String S)
    {
        return this.prodName.equals(S);
    }

// these abstract methods are given bodies in ShoppingListItem
    public abstract void readInfo();

    public abstract void writeInfo();

    public void setName(String inputName)
    {
        prodName.set(inputName);
    }

    public String getName()
    {
        return prodName.get();
    }

    public void setPrice(double inputPrice)
    {
        prodPrice.set(inputPrice);
    }

    public double getPrice()
    {
        return prodPrice.get();
    }

    public void setNumber(int inputNumber)
    {
        prodNum.set(inputNumber);
    }

    public int getNumber()
    {
        return prodNum.get();
    }



}
