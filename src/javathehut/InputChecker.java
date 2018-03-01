
package javathehut;
// used in most received inputs

public class InputChecker
{

    public static Boolean isAlpha(String userInput)
    {
        return userInput.matches("[a-zA-Z]+");
    }

    public static Boolean isInt(String userInput)
    {
        return userInput.matches("[0-9]+");
    }

    public static String stripNum(String userInput)
    {
        return userInput.replaceAll("[0-9]", "");
    }

    public static String stripSpecial(String userInput)
    {
        return userInput.replaceAll("[^a-zA-Z0-9]+", "");
    }

    public static String stripNonalpha(String userInput)
    {
        return userInput.replaceAll("[^a-zA-Z]+", "");
    }

    public static String stripForMoney(String userInput)
    {
        return userInput.replaceAll("[^0-9.]+", "");
    }

    public static String stripAlpha(String userInput)
    {
        return userInput.replaceAll("[a-zA-Z]+", "");
    }

    public static String stripNonNum(String userInput)
    {
        return userInput.replaceAll("[^0-9]+", "");
    }

}
