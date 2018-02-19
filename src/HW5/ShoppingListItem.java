/**import java.util.Scanner;


public class ShoppingListItem extends ItemBase implements Comparable<ShoppingListItem>
{
    private InputChecker processString = new InputChecker();
    private int productPriority;
    private int productQuantity;
    private String endFlag;

    // default constructor:

    public ShoppingListItem()
    {
        super();
        productPriority = 0;
        productQuantity = 0;

    }

    public ShoppingListItem (String inName, int inNumber, double inPrice)
    {
        // best way to load so many numbers???
        super(inName, inNumber, inPrice);
        productPriority = 0;
        productQuantity = 0;

    }

    public boolean equals(int I) // not sure this actually works??
    {
        return this.productPriority == I;
    }

    public void readInfo()
    {
        System.out.println("Product #:");
        System.out.print("> ");
        Scanner keyboard = new Scanner(System.in);
        Inventory inInventory = new Inventory();

        String productNumberString = keyboard.nextLine().toLowerCase();

        if (productNumberString.equals(""))
        {
            while (productNumberString.equals(""))
            {
                System.out.print("> ");
                productNumberString = keyboard.nextLine().toLowerCase();
            }
        }
        if (productNumberString.equals("end"))
        {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        if (productNumberString.equals("done"))
        {
            endFlag = "done";
        }
        else
        {

            productNumberString = processString.stripForMoney(productNumberString);
            setNumber(Integer.parseInt(productNumberString));
            setNumber(inInventory.checkInventory(getNumber()));


            setName(inInventory.setInventoryName(getNumber()));
            setPrice(inInventory.setInventoryPrice(getNumber()));

            System.out.println("Quantity of '" + getName() + "':");
            System.out.print(">");
            String quantityString = keyboard.nextLine().toLowerCase();
            if (quantityString.equals(""))
            {
                while (quantityString.equals(""))
                {
                    System.out.print("> ");
                    quantityString = keyboard.nextLine().toLowerCase();
                }
            }

            if (quantityString.equals("end"))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if (quantityString.equals("done"))
            {
                endFlag = "done";
            }

            else
            {
                quantityString = processString.stripNonNum(quantityString);
                productQuantity = Integer.parseInt(quantityString);
            }

            System.out.println("Priority of '" + getName() + "':");
            System.out.print("> ");
            String priorityString = keyboard.nextLine().toLowerCase();
            if (priorityString.equals(""))
            {
                while (priorityString.equals(""))
                {
                    System.out.print("> ");
                    priorityString = keyboard.nextLine().toLowerCase();
                }
            }
            if (priorityString.equals("end"))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if (priorityString.equals("done"))
            {
                endFlag = "done";
            }
            else
            {

                priorityString = processString.stripForMoney(priorityString);
                productPriority = Integer.parseInt(priorityString);
            }
        }

    }

// sorted and displayed in ShoppingListReport instead
    public void writeInfo()
    {
        System.out.println("Item: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Quantity: " + productQuantity);
        System.out.println("Cart Priority: " + productPriority);
        //System.out.println("Info: " + description);
    }


    public void setPriority(int inputPriority)
    {
        productPriority = inputPriority;
    }


    public int getPriority()
    {
        return productPriority;
    }

    public void setQuantity(int inputQuantity)
    {
        productQuantity = inputQuantity;
    }

    public int getQuantity()
    {
        return productQuantity;
    }

    public void setEndFlag(String inputFlag)
    {
        endFlag = inputFlag;
    }

    public String getEndFlag()
    {
        return endFlag;
    }

    public int compareTo(ShoppingListItem compareItem)
    {
        int comparePriority = ((ShoppingListItem) compareItem).getPriority();

        // ascending order
        return this.productPriority - comparePriority;

        // descending order
        //return comparePriority - this.priority;
    }


}**/
