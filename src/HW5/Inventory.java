package HW5;

import javathehut.InputChecker;

import java.util.Scanner;

public class Inventory
{
    public int checkInventory(int productNumber)
    {
        String productName;
        InputChecker processString = new InputChecker();
        Scanner keyboard = new Scanner(System.in);

        while (true)
        {
            if (0 < productNumber && productNumber < 8)
            {
                break;
            }

            System.out.println("Sorry, that Product # is not in our inventory. Please try again.");
            System.out.println();
            System.out.println("Product #:");
            System.out.print("> ");
            String productNumberString = keyboard.nextLine().toLowerCase();

            if (productNumberString.equals("end"))
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            productNumberString = processString.stripForMoney(productNumberString);
            productNumber = Integer.parseInt(productNumberString);


        }
        return productNumber;
    }

    public String setInventoryName(int productNumber)
    {
        String productName = "";

        switch (productNumber)
        {
            case 1:
                productName = "whole coffee beans";
                break;

            case 2:
                productName = "ground coffee";
                break;

            case 3:
                productName = "french press";
                break;

            case 4:
                productName = "pour over";
                break;

            case 5:
                productName = "cold brew toddy";
                break;

            case 6:
                productName = "large mug";
                break;

            case 7:
                productName = "small mug";
                break;

        }
        return productName;
    }

    public double setInventoryPrice(int productNumber)
    {
        double price = 0;

        switch (productNumber)
        {
            case 1:
                price = 10.99;
                break;

            case 2:
                price = 15.45;
                break;

            case 3:
                price = 55.20;
                break;

            case 4:
                price = 19.95;
                break;

            case 5:
                price = 31.05;
                break;

            case 6:
                price = 5.01;
                break;

            case 7:
                price = 2.50;
                break;

        }
        return price;

    }


    public void displayInventory()
    {
        System.out.println("");
        System.out.println("Welcome to Brewed Awakening!");
        System.out.println("This month's handpicked inventory is:");
        System.out.println("");
        System.out.println("\033[1mPRODUCT # : NAME [$PRICE]\033[0m");
        System.out.println("1: whole coffee beans [$10.99]");
        System.out.println("2: ground coffee [$15.45]");
        System.out.println("3: french press [$55.20]");
        System.out.println("4: pour over [$19.95]");
        System.out.println("5: cold brew toddy [$31.05]");
        System.out.println("6: large mug [$5.01]");
        System.out.println("7: small mug [$2.50]");
        System.out.println("");

    }


}
