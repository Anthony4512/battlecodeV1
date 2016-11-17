
package battlecode;

import java.util.Random;

//die class
public class Die {
    
    //fields
    private int sides;
    private int value;
    Random r = new Random();
    
    //default constructor
    public Die() {
        sides = 6;
        value = 1;
    }
    
    // constructor that takes an int as input and assigns it to the number of sizes
    public Die(int numOfSizes) {
        if (numOfSizes <= 0) {
            sides = 1;
            value = 1;
        }
        else {
            sides = numOfSizes;
            value = 1;
        }
    }
    //rolls the dice and return the value of the roll
    public int roll()
    {
        value = r.nextInt(sides) + 1;
        return value;
    }
    
    //setters and getters bellow//
    public int getValue()
    {
        return value;
    }
    
    public int getSides()
    {
        return sides;
    }
    public void setSides(int s)
    {
        sides = s;
    }
    //end of setters and getters
}
