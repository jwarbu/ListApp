
package HW5;
// used in most received inputs

public class InputChecker
{

    public Boolean isAlpha(String userInput)
    {
        return userInput.matches("[a-zA-Z]+");
    }

    public String stripNum(String userInput)
    {
        return userInput.replaceAll("[0-9]", "");
    }

    public String stripSpecial(String userInput)
    {
        return userInput.replaceAll("[^a-zA-Z0-9]+", "");
    }

    public String stripNonalpha(String userInput)
    {
        return userInput.replaceAll("[^a-zA-Z]+", "");
    }

    public String stripForMoney(String userInput)
    {
        return userInput.replaceAll("[^0-9.]+", "");
    }

    public String stripAlpha(String userInput)
    {
        return userInput.replaceAll("[a-zA-Z]+", "");
    }

    public String stripNonNum(String userInput)
    {
        return userInput.replaceAll("[^0-9]+", "");
    }

}
