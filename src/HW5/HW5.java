/**package sample;

import java.util.Scanner;

public class HW5
{
    public static void main2 (String[] args)
    {
        ShoppingListReport checkOut = new ShoppingListReport();

        System.out.println();
        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ");
        System.out.println("ASSIGNMENT no.5 RE-UPDATED SHOPPING LIST");
        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * \n");

        System.out.println("\033[1mEnter 'END' at any time to exit the program\033[0m");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        InputChecker stringChecker = new InputChecker();

// Display history?

        checkOut.readTxt();

// Loop: Start Shopping?

        while (true)
        {
            System.out.println("Are you interested in making a new purchase?");
            System.out.print(">");
            String startChoice = keyboard.nextLine();
            startChoice = stringChecker.stripNonalpha(startChoice).toLowerCase();


            if (startChoice.equals("end"))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if (startChoice.equals("no")||startChoice.equals("n"))
            {
                System.out.println("Don't forget to check out our new inventory next month.");
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if (startChoice.equals("yes")||startChoice.equals("y"))
            {
                break;
            }

            else
            {
                System.out.println("Sorry, we couldn't understand that.");
                System.out.println("");
            }

        }
        checkOut.readShopperName();

// Set Budget before shopping
        checkOut.readBudget();

// Welcome Message (class for inventory)

        ManageInventory currentInventory = new ManageInventory();
        currentInventory.loadNovember();
        currentInventory.displayNovember();


// Get & print Data
        checkOut.getData();
        System.out.println();
        checkOut.writeBudget();
        checkOut.displayData();
        System.out.println();
        checkOut.calcBudget();
        checkOut.writeTxt();

        System.out.println();
        System.out.println("Thanks for shopping with us!");
        System.out.println();

    }
}
**/