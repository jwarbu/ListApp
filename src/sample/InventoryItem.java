package sample;

import java.util.Scanner;

public class InventoryItem extends ItemBase
{

// Default Constructor
    public InventoryItem()
    {
        super();
    }

    public InventoryItem(String inName, int inNumber, double inPrice)
    {
        super(inName, inNumber, inPrice);
    }

// Read & Write methods
    public void readInfo()
    {
    }

    public void writeInfo()
    {
        System.out.println("Item #" + getNumber());
        System.out.println(getName() + " | $" + getPrice());

    }

// Getters and Setters
    public String getLabel()
    {
        return super.getName() + " ($" + super.getPrice() + ")";
    }



}
