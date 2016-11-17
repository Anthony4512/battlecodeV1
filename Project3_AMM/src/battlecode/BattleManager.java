
package battlecode;

//imports
import java.util.Arrays;

// manager class
public class BattleManager {
    
    
    // sets the strength and the agility depending on the dice value
    private void setStrengthAgility(Hero myHero) {
        // created 3 dice 
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        Die die3 = new Die(6);
        //roll the dice and assigned their values to variables 
        int value1 = die1.roll();
        int value2 = die2.roll();
        int value3 = die3.roll();
        //created an array with the integers to determine which one i want to use
        int[] values = new int[]{value1, value2, value3};
        //sorted the array from smallest to biggest
        Arrays.sort(values);
        //assigned the biggest value to my strength
        int strengh = values[values.length - 1];
        //assigned the medium value to my agility
        int agility = values[values.length -2];
        myHero.setStrength(strengh);
        myHero.setAgility(agility); 
             
    }
    
    // takes a hero, rolls a 3 sided die and return the value from 1 to 3
    private int selectMove(Hero hero1) {
        Die die1 = new Die(3); 
        int moveCode = die1.roll();
        
        // return value from 1 to 3 --> 1=attack, 2=block, 3=rest
        return moveCode; 
    }
    // this method has the logic for the fight, takes 2 heroes
    private void fight(Hero hero1, Hero hero2) {
        int move1; // this will hold the selected move from the selectMove method
        int move2; // this will hold the selected move from the selectMove method
        int fight1;
        int fight2;
        int block1;
        int block2;
        int valueAfterBlocking;
        move1 = this.selectMove(hero1);  // assigned the selected move from hero1
        move2 = this.selectMove(hero2);  // assigned the selected move from hero2
        
        // if hero 1 attacks and hero 2 attacks 
        if(move1 == 1 && move2 == 1) {
            // prints the move
            System.out.println(hero1.getName() + " is attacking...");
            // attacks
            fight1 = hero1.attack();
            // prints the move
            System.out.println(hero2.getName() + " is attacking...");
            //attack
            fight2 = hero2.attack();
            //health is remove from the heroes
            hero1.removeHealth(fight2);
            hero2.removeHealth(fight1);
        }
        //else if hero1 is attacking and hero2 is blocking
        else if(move1 == 1 && move2 == 2) {
            // prints the move
            System.out.println(hero1.getName() + " is attacking...");
            //hero1 attacks
            fight1 = hero1.attack();
            // prints the move
            System.out.println(hero2.getName() + " is blocking...");
            //hero2 blocks
            block2 = hero2.block();
            valueAfterBlocking = fight1 - block2;  
            if(valueAfterBlocking > 0) {
                hero2.removeHealth(valueAfterBlocking);
            }

        }
        //else if hero1 attacks and hero2 rest
        else if(move1 == 1 && move2 == 3) {
            // prints the move
            System.out.println(hero1.getName() + " is attacking...");
            //hero1 attacks
            fight1 = hero1.attack();
            // prints the move
            System.out.println(hero2.getName() + " is resting...");
            //hero2 rests
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }
            
            hero2.removeHealth(fight1);
        }
        //else if hero1 blocks and hero2 attacks
        else if(move1 == 2 && move2 == 1) {
            // prints the move
            System.out.println(hero1.getName() + " is blocking...");
            //hero1 blocks
            block1 = hero1.block();
            // prints the move
            System.out.println(hero2.getName() + " is attacking...");
            //hero2 attacks
            fight2 = hero2.attack();
            valueAfterBlocking = fight2 - block1;
            if(valueAfterBlocking > 0) {
                hero1.removeHealth(valueAfterBlocking);
            }
        }
        //else if hero1 blocks and hero2 blocks
        else if(move1 == 2 && move2 == 2) {
            // prints the move
            System.out.println(hero1.getName() + " is blocking...");
            //hero1 blocks
            hero1.block();
            // prints the move
            System.out.println(hero2.getName() + " is blocking...");
            //hero2 blocks
            hero2.block();
        }
        //else if hero1 blocks and hero2 rests
        else if(move1 == 2 && move2 == 3) {
            // prints the move
            System.out.println(hero1.getName() + " is blocking...");
            //hero1 blocks
            hero1.block();
            // prints the move
            System.out.println(hero2.getName() + " is resting...");
            //hero2 rests
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }
        } 
        //else if hero1 is resting and hero2 is attacking
        else if(move1 == 3 && move2 == 1) {
            // prints the move
            System.out.println(hero1.getName() + " is resting...");
            //hero1 rests
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            // prints the move
            System.out.println(hero2.getName() + " is attacking...");
            //hero2 attacks
            fight2 = hero2.attack();
            hero1.removeHealth(fight2);
        }
        //else if hero1 is resting and hero2 is blocking
        else if(move1 == 3 && move2 == 2) {
            // prints the move
            System.out.println(hero1.getName() + " is resting...");
            //hero1 rests
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            //hero2 blocks
            System.out.println(hero2.getName() + " is blocking...");
            hero2.block();
        }
        //else if both heroes rest
        else if(move1 == 3 && move2 == 3) {            
            // prints the move
            System.out.println(hero1.getName() + " is resting...");
            //hero1 rests
            int restValue1 = hero1.rest();
            if ((hero1.getHealth() + restValue1) >= 100) {
                hero1.setHealth(100);
            }
            // prints the move
            System.out.println(hero2.getName() + " is resting...");
            //hero2 rests
            int restValue2 = hero2.rest();
            if ((hero2.getHealth() + restValue2) >= 100) {
                hero2.setHealth(100);
            }
        }
    }
  
    // battle method, takes 2 heroes and a number as input and return a winner hero
    public Hero battle(Hero hero1, Hero hero2, int numOfRounds) {
        //set the strenth and agility to both heroes
        this.setStrengthAgility(hero1);
        this.setStrengthAgility(hero2);
        
        // if the num of rounds is greater than 0
        if(numOfRounds > 0) {
            // loop from 1 to num of rounds
            for(int i = 1; i <= numOfRounds; i++) {
                // print out some stuff
                System.out.println("\n<<<<<<<<>>>>>>>>>");
                System.out.println("ROUND NUMBER " + i);
                System.out.println("-------------------");
                //call the fight method passing the two heroes
                fight(hero1, hero2); 
                //print stats of both heroes
                hero1.printStats();
                System.out.println("");
                hero2.printStats();               
            } 
        }
        // else if the num of rounds is greater than 0
        else if(numOfRounds == 0) {
            //implement while loop to fight to the death
            int counter = 1;
            // while none of the heroes has 0 health them keep fighting
            while(hero1.getHealth() > 0 && hero2.getHealth() > 0) {
                System.out.println("\n<<<<<<<<>>>>>>>>>");
                System.out.println("ROUND NUMBER " + counter);
                System.out.println("-------------------");
                fight(hero1, hero2);                
                hero1.printStats();
                System.out.println("");
                hero2.printStats();
                counter++;
            }
        }
        
        // return the hero with more health
        if(hero1.getHealth() > hero2.getHealth()) {
            return hero1;
        }
        else {
            return hero2;
        }
    }
}
