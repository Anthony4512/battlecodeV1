
package battlecode;

public class Hero {
    
    //private fields
    private int health;
    private int agility;
    private int strength;
    private String name;

    //constructor that sets up the name of the hero
    public Hero(String name) {
        this.name = name;
    }

    //constructor that sets the agility, name and stregth of the hero
    public Hero(int agility, int strength, String name) {
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }    

    //getters and setters bellow//    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //end of getters and setters//
    
    
    //method to add health to the hero
    public void addHealth(int healthToAdd) {
        if(healthToAdd >= 0) {
            this.health += healthToAdd;
        }        
    }
    //method to remove the health of the hero
    public void removeHealth(int healthToRemove) {
        if(healthToRemove >= 0) {
            this.health -= healthToRemove;
        }
    }
    //method to print hero's stats
    public void printStats() {
        System.out.println("");
        System.out.println(this.name.toUpperCase() + "'S STATS");
        System.out.println("-------------------------");
        System.out.println("Hero's Strength: " + this.strength);
        System.out.println("Hero's Agility: " + this.agility);
        System.out.println("Hero's Health: " + this.health);
    }
    
    // method that makes the hero attack--it returns an int(value of attack)
    public int  attack() {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        int attackValue = this.strength + die1.roll() + die2.roll();
        
        return attackValue;
    }
    
    //method that makes the hero block--returns an int(value of block)
    public int block() {
        int doubleValue; //value to be returned
        Die die1 = new Die(10);
        int die1Value = die1.roll();
        if(die1Value < 4) {
            doubleValue = (die1Value*2) + this.agility;
        }
        else {
            doubleValue = die1Value + this.agility;
        }
        return doubleValue;
        
    }
    
    //method that makes the hero rest and heal -- returns the value of the healing 
    public int rest() {
        Die die1 = new Die(8);
        Die die2 = new Die(8);
        
        int sum = die1.roll() + die2.roll();
        this.health += sum;
        return sum;
    }
    
    
}
