import java.util.Random;
import java.util.Scanner;

class Main{
    public static void main(String [] args){
        Scanner scan = new Scanner (System.in);//scanner object
        Random random = new Random();//random constructor to generate numbers
        Enemies enemy = new Enemies();//instance of the enemies class

        //variables for the player
        int playerHealth = 100; //player's full health
        int playerAttackDamage = 50; //max damage the player can do
        int numHealthPotions = 2; //player stars out with 2 health potions 
        int healthPotionHeal = 25; //adds 25 each time a player uses a potion
        int dropHealthPotionChance = 60; //percentage

        
        boolean running = true;

        System.out.println("Welcome to");
        System.out.println("Danish's Game!");

        while(running){ //start of the actual game
            System.out.println("An enemy has appeared, it is a " + enemy.getEnemyName());
            while(enemy.getEnemyHealth() > 0){ //When enemy's health is greater than 0
                //Tells user their health and the enemies health
                System.out.println("Your health is " + playerHealth);
                System.out.println("The enemies health is " + enemy.getEnemyHealth());
                //Gives them options
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1. Attack the enemy");
                System.out.println("\t2. Drink your health potion");
                System.out.println("\t3. Run Away from the enemy");
                String x = scan.nextLine();//Where user will input 1, 2, or 3
                
                if(x.equals("1")) { // if user inputs 1
                    int damageDealt = random.nextInt(playerAttackDamage);//randomizes the player damage >= 50 
                int damageTaken = random.nextInt(enemy.getEnemyDamage());//randomizes the enemy damage 
                enemy.setEnemyHealth(enemy.getEnemyHealth() - damageDealt);//subtracts enemyhealth
                playerHealth -= damageTaken; //subtracts how much damage that the enemy did to the player
                System.out.println("\tYou strike the " + enemy.getEnemyName() + " for " + damageDealt + " damage.");
                System.out.println("\tYou have took " + damageTaken + " damage in return!");
                    
                    if(playerHealth < 1){ //checks if plyaer has less than 1 
                        System.out.println("You have taken a lot of damage, you can not go on");
                        break; //breaks while loop
                    }
                }
                else if(x.equals("2")){ //if user inputs 2
                    if(numHealthPotions > 0){ //checks if user has health potions
                        playerHealth += healthPotionHeal;//adds 25
                        numHealthPotions--; //subtracts 1 health potion from inventory
                        System.out.println("You have used a health potion for" + healthPotionHeal + " you have now " + playerHealth);
                        System.out.println("You have " + numHealthPotions + " potions");

                    }
                    else{ //if user has no health potions left
                        System.out.println("You have no health potions, to earn 1 defeat the enemy for a 60% chance");
                    }
                } 
                      else if(x.equals("3")){
                    System.out.println("You have ran away from the " + enemy.getEnemyName());
                    playerHealth -= 10; //concequence from running away
                    System.out.println("You have -10 from your health because you ran away. Your health is now " + playerHealth);
                    enemy = new Enemies(); // replaces old enemy with old enemies
                    System.out.println("A new enemy has arrived, it is the " + enemy.getEnemyName() + " please defeat it!");
                }  

                
                else{ //if user inputs something different other than 1,2,3
                    System.out.println("You have inputed an invalid command, please input 1, 2, or 3");
                }
            }
            if(playerHealth < 1){//if player health hits zero
                System.out.println("You have left the battleground");
                break;
            }
            System.out.println("You have defaeted the " + enemy.getEnemyName());
            System.out.println("You have " + playerHealth + " health left.");
            if(random.nextInt(100) > dropHealthPotionChance){ //health drop chacne randomizes with the 60% chance of getting one
                numHealthPotions++; //if they receive a health potion
                System.out.println("The " + enemy.getEnemyName() + " dropped a health potion!");//tells user the enemy dropped an health potion
                System.out.println("You have " + numHealthPotions + " in your inventory"); //tells user how many health potins are left

            }
            //This is where we give the user more options
            System.out.println("What would you like to do now?");
            System.out.println("\t1. Fight against another enemy"); 
            System.out.println("\t2.Exit out of the battleground");
            String y = scan.nextLine();

            while(!y.equals("1") && !y.equals("2")) {
                System.out.println("Invaliid command, please enter 1 or 2 please.");
                y = scan.nextLine(); //next command to input hopefully its valid
            }
            if(y.equals("1")){ // if the user inputs 2
                System.out.println("You have decided to fight another enemy");
                enemy = new Enemies(); //replaces the old enemy with a new enemy
            }
            else if(y.equals ("2")){
                System.out.println("You have left the battleground");
                break; //code breaks from the while loop
            }
            
         } 
        
         System.out.println("Thank you for playing Danish's Game! I hope you enjoyed it and later on I will add more things to make this a real game :) ");

    }
}
