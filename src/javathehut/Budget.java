package javathehut;

import javafx.beans.property.DoubleProperty;

public class Budget {

    private double budget;
    private String stringBudget;

    public Budget()
    {
        this(0);
    }

    public Budget(double d)
    {
        this.budget = d;
        this.stringBudget = "$" + Double.toString(d);
    }

    // Get & Set

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
        setStringBudget();
    }

    public String getStringBudget()
    {
        this.setStringBudget();
        return stringBudget;
    }

    public void setStringBudget(String s) {
        this.stringBudget = s;
        this.budget = Double.parseDouble(s);
    }

    public void setStringBudget()
    {
        this.stringBudget = "$" + Double.toString(budget);
    }
}
