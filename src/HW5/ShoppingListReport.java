/**package HW5;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.File;

public class ShoppingListReport implements PrintInterface
{
    private static final int LIST_SIZE = 7;
    private String shopperName;
    private InputChecker processString = new InputChecker();
    private double bankAccount;
    private ShoppingListItem itemCheck = new ShoppingListItem();
    private ArrayList<ShoppingListItem> shoppingList = new ArrayList<ShoppingListItem>(LIST_SIZE);
    private ArrayList<ShoppingListItem> overbudgetItems = new ArrayList<ShoppingListItem>(LIST_SIZE);
    private ArrayList<ShoppingListItem> purchasedItems = new ArrayList<ShoppingListItem>(LIST_SIZE);
    private int loopcount;

    // history variables
    String fileName = "ShoppingHistory.txt";


    public void readShopperName()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter your name:");
        System.out.print("> ");
        shopperName = keyboard.nextLine();
        if (shopperName.equals("end"))
        {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        System.out.println();
        shopperName = processString.stripNum(shopperName);

    }

    public String getShopperName()
    {
        return shopperName;
    }

    public void setShopperName(String inputName)
    {
        shopperName = inputName;
    }

    public void getData()
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<ShoppingListItem> test = new ArrayList<ShoppingListItem>();

        System.out.println("Please enter the 'PRODUCT #' from the inventory list above.");
        System.out.println("(please enter 'DONE' after you have submitted your final item)\n");

        // Loop: ListItem entry

        int loopcount = 0;
        String ordinal = "";

        while (loopcount < 7)
            {
                shoppingList.add(loopcount, new ShoppingListItem());

                switch (loopcount)
                {
                    case 0:
                        ordinal = "First";
                        break;
                    case 1:
                        ordinal = "Second";
                        break;
                    case 2:
                        ordinal = "Third";
                        break;
                    case 3:
                        ordinal = "Fourth";
                        break;
                    case 4:
                        ordinal = "Fifth";
                        break;
                    case 5:
                        ordinal = "Sixth";
                        break;
                    case 6:
                        ordinal = "Seventh";
                        break;

                }

                System.out.println("[" + ordinal + " Item]");
                shoppingList.get(loopcount).readInfo();

                if (shoppingList.get(loopcount).getEndFlag() != null)
                {
                    break;
                }

                for (int i=0; i <7; i++)
                {
                    try
                    {
                        if (shoppingList.get(i) != null && i < loopcount)
                        {
                            if (shoppingList.get(i).getName().equals(shoppingList.get(loopcount).getName()))
                            {
                                System.out.println();

                                //System.out.println("Sorry! '" + shoppingList.get(loopcount).getName() + "' is already on your list");
                                shoppingList.remove(loopcount);
                                loopcount = loopcount - 1;

                                throw new DuplicateProductException();
                            }

                        }
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        //System.out.println("index error");
                    }
                    catch (DuplicateProductException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

                loopcount++;
                System.out.println();

            }

    }

    public void displayData()
    {
        System.out.println(shopperName + "'s Shopping List:");
        System.out.println("........................");
        System.out.println("(highest -> lowest priority)");
        System.out.println();

        Collections.sort(shoppingList);

        for (int i = 0; i < 7; i++)
        {
            try
            {
                if (shoppingList.get(i) != null && !shoppingList.get(i).getName().equals("n/a"))
                {
                    System.out.println(" $" + String.format("%.2f", shoppingList.get(i).getPrice()) + "\t" + shoppingList.get(i).getName() + " (x" + shoppingList.get(i).getQuantity() + ")");
                }
            }

            catch (IndexOutOfBoundsException e)
            {
                shoppingList.add(i, new ShoppingListItem());
            }

        }
    }


// BUDGET CALCULATIONS


    public void readBudget()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your budget for this order?");
        System.out.print("$");
        String budgetString = keyboard.nextLine().toLowerCase();
        System.out.println();

        if (budgetString.equals("end"))
        {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        budgetString = processString.stripForMoney(budgetString);
        bankAccount = Double.parseDouble(budgetString);

    }

    public void setBudget(double inputBudget)
    {
        bankAccount = inputBudget;
    }

    public double getBudget()
    {
        return bankAccount;
    }

    public void writeBudget()
    {
        System.out.println("------------------------------------------");
        System.out.println("Starting Balance: $" + String.format("%.2f", bankAccount));
        System.out.println("------------------------------------------");

    }

    public void calcBudget()
    {
        // Treats items with multiple quantities are under the same priority and is
        // therefore all or nothing in terms of budget

        Collections.sort(shoppingList);

        double remainingBudget = 0;
        int i;

        for (i = 0; i < 7; i++)
        {
            if (i == 0)
            {
                remainingBudget = bankAccount - (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());

                if (remainingBudget < 0)
                {
                    overbudgetItems.add(i, shoppingList.get(i));
                    remainingBudget = bankAccount;
                }

                else
                {
                    purchasedItems.add(i, shoppingList.get(i));
                }
            }

            else
            {
                remainingBudget = remainingBudget - (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());

                    if (remainingBudget < 0)
                    {
                        overbudgetItems.add(shoppingList.get(i));
                        remainingBudget = remainingBudget + (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());
                    }
                    else
                    {
                        purchasedItems.add(shoppingList.get(i));
                    }
            }

        }
        System.out.println("------------------------------------------");
        System.out.println("Successfully purchased:");
        System.out.println("------------------------------------------");

        for (i = 0; i < 7; i++)
        {
            try
            {
                if (purchasedItems.get(i) != null && !purchasedItems.get(i).getName().equals("n/a"))
                {
                    System.out.println(" $" + String.format("%.2f", purchasedItems.get(i).getPrice()) + "\t" + purchasedItems.get(i).getName() + " (x" + purchasedItems.get(i).getQuantity() + ")");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                purchasedItems.add(i, new ShoppingListItem());
            }
        }
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("The following items were not purchased:");
        System.out.println("------------------------------------------");

        for (i = 0; i < 7; i++)
        {
            try
            {
                if (overbudgetItems.get(i) != null && !overbudgetItems.get(i).getName().equals("n/a"))
                {
                    System.out.println(" $" + String.format("%.2f", overbudgetItems.get(i).getPrice()) + "\t" + overbudgetItems.get(i).getName() + " (x" + overbudgetItems.get(i).getQuantity() + ")");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                overbudgetItems.add(i, new ShoppingListItem());
            }
        }
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("End Balance: $" + String.format("%.2f", remainingBudget));
        System.out.println("------------------------------------------");

    }

    public void writeTxt()
    {
        Scanner keyboard = new Scanner(System.in);

        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter (fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not save shopping history.");
        }
// calc budget to text file
        outputStream.println(shopperName + "'s Shopping History");
        Collections.sort(shoppingList);

        double remainingBudget = 0;
        int i;

        for (i = 0; i < 7; i++)
        {
            if (i == 0)
            {
                remainingBudget = bankAccount - (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());

                if (remainingBudget < 0)
                {
                    overbudgetItems.add(i, shoppingList.get(i));
                    remainingBudget = bankAccount;
                }

                else
                {
                    purchasedItems.add(i, shoppingList.get(i));
                }
            }

            else
            {
                remainingBudget = remainingBudget - (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());

                if (remainingBudget < 0)
                {
                    overbudgetItems.add(shoppingList.get(i));
                    remainingBudget = remainingBudget + (shoppingList.get(i).getPrice() * shoppingList.get(i).getQuantity());
                }
                else
                {
                    purchasedItems.add(shoppingList.get(i));
                }
            }

        }
        outputStream.println("------------------------------------------");
        outputStream.println("Successfully purchased:");
        outputStream.println("------------------------------------------");

        for (i = 0; i < 7; i++)
        {
            try
            {
                if (purchasedItems.get(i) != null && !purchasedItems.get(i).getName().equals("n/a"))
                {
                    outputStream.println(" $" + String.format("%.2f", purchasedItems.get(i).getPrice()) + "\t" + purchasedItems.get(i).getName() + " (x" + purchasedItems.get(i).getQuantity() + ")");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                purchasedItems.add(i, new ShoppingListItem());
            }
        }
        outputStream.println();
        outputStream.println("------------------------------------------");
        outputStream.println("The following items were not purchased:");
        outputStream.println("------------------------------------------");

        for (i = 0; i < 7; i++)
        {
            try
            {
                if (overbudgetItems.get(i) != null && !overbudgetItems.get(i).getName().equals("n/a"))
                {
                    outputStream.println(" $" + String.format("%.2f", overbudgetItems.get(i).getPrice()) + "\t" + overbudgetItems.get(i).getName() + " (x" + overbudgetItems.get(i).getQuantity() + ")");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                overbudgetItems.add(i, new ShoppingListItem());
            }
        }
        outputStream.println();
        outputStream.println("------------------------------------------");
        outputStream.println("End Balance: $" + String.format("%.2f", remainingBudget));
        outputStream.println("------------------------------------------");

        outputStream.close();

    }

    public void readTxt()
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner inputStream = null;

        while (true)
        {
            System.out.println("Would you like to see the history of your most recent shopping list?");
            System.out.print(">");
            String userResponse = keyboard.nextLine();
            userResponse = processString.stripNonalpha(userResponse).toLowerCase();


            if (userResponse.equals("end"))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if (userResponse.equals("no")||userResponse.equals("n"))
            {
                break;
            }

            if (userResponse.equals("yes")||userResponse.equals("y"))
            {
                try
                {
                    inputStream = new Scanner(new File(fileName));
                }
                catch(FileNotFoundException e)
                {
                    System.out.println();
                    System.out.println("Sorry! Your shopping history could not be retrieved.");
                    System.out.println();
                    break;
                }

                System.out.println("[START HISTORY]");
                System.out.println();

                while(inputStream.hasNextLine())
                {
                    String line = inputStream.nextLine();
                    System.out.println(line);
                }
                inputStream.close();
                System.out.println("[END HISTORY]");
                System.out.println();
                break;
            }

            else
            {
                System.out.println("Sorry, we couldn't understand that.");
                System.out.println("");
            }

        }
    }

}

**/