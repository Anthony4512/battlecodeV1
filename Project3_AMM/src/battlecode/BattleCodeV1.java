/* 
*   __author__== "Anthony Mirely" &&  __NECC#__ == 00261404
*   This is a game that simulates a battle between 2 heroes
*   
*   The code was done entirely on my own, with some of the classes taken from the 
*   zybook labs that I have already completed.
*   Idea from Michael Penta
*/

package battlecode;

// imports
import java.util.Scanner;

public class BattleCodeV1 {
    
    
    //Main
    public static void main(String[] args) {
        
        //scanner and dies for game created
        Scanner scan = new Scanner(System.in);
        Die die1 = new Die(8);
        Die die2 = new Die(8);
        
        //ask for the name of hero number 1
        System.out.println("Enter name for hero number 1: ");
        //stores input value the string hero1Name
        String hero1Name = scan.next();
        //ask for the name of hero number 2
        System.out.println("Enter name for hero number 2: ");
        //stores intut value into the string hero2Name
        String hero2Name = scan.next();
        //ask to input number of rounds to play
        System.out.println("Enter the number of rounds: ");
        //stores input value into variable int rounds
        int rounds = scan.nextInt();
        
        //instantiated the two hero2s passing the input names on the constructor
        Hero hero1 = new Hero(hero1Name); 
        Hero hero2 = new Hero(hero2Name);
        hero1.setHealth(100);
        hero2.setHealth(100);
        //declared an hero object that is going to be the winner hero
        Hero winner;
        
        //instantiated an battle manager object and assigned a new manager
        BattleManager myMan = new BattleManager(); 
        
        //winner is going to hold the winner hero returned by the battle method
        winner = myMan.battle(hero1, hero2, rounds);
        
        //some printing declaring who the winner is
        System.out.println("\nAND THE WINNER IS.... " + winner.getName().toUpperCase());
        
    }
    
}
