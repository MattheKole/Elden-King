import java.util.Random;
import java.util.Scanner;


public class Grade11Game {
    public static void main(String[] args) {
        
        //System objects
Scanner in = new Scanner (System.in);
Random r = new Random();

// Game variables
String[] enemies = { "Dragon", "Giant", "Demon", "Griffin", "Kraken", "Golem", "Werewolves", "Minotaurs", "Wraiths", "Orcs", "Goblins", "Sirens", "Banshees", "Revenant", "Dementors", "Phantoms"};
int maxEnemyHP = 150;
int maxEnemyDmg = 50;

//Counter for breaking the loop if player dies
int ctr = 0;

//Counter for if determing if player won
int finalctr = 0;

//Player variables
int maxHP = 150;
int maxAttackDmg = 50;
int HP_Potion = 3;
int maxHP_Potion = 50;
int HPDropChance = 100;

//Instructions
String Play = "explanation";
while (Play.equals("explanation"))
        {
    System.out.println("Welcome to Elden King\n Here are the instructions\n After you have read the story you will be prompted to add you name, here you can add anyting you like\n After you enter your name you will immediatly encounter an enemy there you will be given 3 choice: Attack, Heal, Run\n In order to choose which option you would like all you need is the enter the numbers 1, 2 or 3 respectivly\n You will continue until you die or have slain 3 enemies\n If you have slayed 3 enemies you would have completed the game\n Thank you for playing Elden King I sincerely hope you enjoy\n - Matthew K.\n \n Please enter \" Play \" if you understand and want to play");
    Play = in.nextLine();
        }

//Story
System.out.println();//for proper spacing
System.out.println("Elden King");
System.out.println("_____________________________________");
System.out.println("Hello adventurer my name is Melina and I am the guide to this dungeon. Before we begin I would like to know your name");
String name = in.nextLine();
System.out.println("Welcome to the land inbetween " + name);
System.out.println("You have been tasked by the guild known as Xerneas to clear this Dungeon and collect the rumoured wing of Yveltal inside");
System.out.println("Before you continue " + name + " I have to warn you about the dangers inside. This dungeon has been nicknamed ”Nightmare on Earth” by all the Adventurers who have stepped foot in, but I sense something great inside you " + name + ". May the Gods guide your journey " + name + " and Good luck.");
System.out.println("_____________________________________");

//Players HP determined before
int HP = r.nextInt(maxHP)+51;

//Loop whole game will be inside after they beat three enemies they win
int run = 0;

while(run != 3)//run == 3 means they killed 3 enemies
    {
    //Code for encountering enemy and creating its HP and name
    System.out.println();
System.out.println("YOU HAVE ENCOUNTERED AN ENEMY");
int enemyHP = r.nextInt(maxEnemyHP)+51; // generates HP
String enemy = enemies[r.nextInt(enemies.length)];// determines name of enemy from aray listed above
System.out.println();
System.out.println("# " + enemy + " appeared! #");

if (run > 0)//gives them bonus HP after they defeat an enemy
    {
    HP = HP +  20; //Heals player a bit after every succesful kill
    }

	while(enemyHP > 0 && HP > 0)//The loop stops if any characters HP goes under zero
    {
    //Player Options
System.out.println(name + " HP: " + HP);
System.out.println(enemy + " HP: " + enemyHP);
System.out.println();
System.out.println("What would you like to do?");
System.out.println("1. Attack");
System.out.println("2. Drink Health Potion");
System.out.println("3. Run!");

//Choices for player
int choice;

try { //Try and catch do they cant enter a strong into the integer and it wont break the code
    choice = in.nextInt();
    }
catch (Exception e)
    {
    System.out.println();
    System.out.println("> INVALID INPUT PLEASE GIVE A NUMBER FROM 1-3 < ");
    System.out.println();
    in.nextLine(); // Redo the input
    continue; // Restart the loop
    }

//If they choose Attack
if (choice == 1)
    {
    int attack = r.nextInt(maxAttackDmg)+ 71; // determines gamage
    enemyHP = enemyHP - attack; // subtracrs enemy HP from damage generated
    System.out.println();
    System.out.println("> You have done " + attack + " damage");//prints hw much damage they do
    }

//If they choose heal
if (choice == 2 && HP_Potion > 0)
    {
    int gain = r.nextInt(maxHP_Potion)+51;//determines their healing amount
    HP = HP + gain;//gives them Hp
    HP_Potion = HP_Potion - 1;
    System.out.println("> You have healed " + gain + " health");
    System.out.println("      You have " + HP_Potion + " HP Potions left");//prints how much they healed and how much HP potions they have
    }
//If they choose to heal but have no potions left
if (choice == 2 && HP_Potion <= 0)
    {
        System.out.println();
        System.out.println("You have ran out of potions");
        System.out.println();
    }

//If they want to run
if (choice == 3)
{
    int num1 = r.nextInt(100)+1;//50-50 chance they run if they run they just go into another enemy
        if (num1 >= 50)
        {
        System.out.println();
        System.out.println("** You have successfully escaped ** ");
        break;//if they ran away succesfully it breaks loop
        }
if (num1 < 50)
    {
    System.out.println();
    System.out.println("** You Have failed to Escape **");//if they didnt run away succesfully
    System.out.println();
    }
}

//If the enemy dies they cant attack anymore
if (enemyHP > 0)
    {
    int enemyAttack = r.nextInt(maxEnemyDmg)+ 31;
    HP = HP - enemyAttack;
    System.out.println("> The " + enemy + " have done " + enemyAttack + " damage");
    System.out.println();
    }

//if player dies it breaks this loop and then goes to break the other loop
if (HP <= 0)//if player dies break loop but also gives ctr +1 so after it breaks this loop it breaks the other loop
    {
    ctr++;
    break;
    
    }
 else if (HP >= 0 && enemyHP <= 0)//if your HP is over 0 and the enemyHP is under 0 you win
{
    //If statement here because I dont want this text displayed when they win their third fight
    if (finalctr == 2|| finalctr == 1|| finalctr == 0)
    {
    System.out.println();
    System.out.println("|| You have Won the battle ||");
    }
}

                                                                                                                  } //End of loop for choice and fighting
        
         int HPchance = r.nextInt(HPDropChance)+ 1; //Health Potion Drop Chance
    if (HPchance >= 50 && HP > 0)//makes sure player is alive when giving the HP Potion
    {
    HP_Potion = HP_Potion + 2;
    System.out.println();
    System.out.println("[You have gained an HP Potion]");
    }
    
    //If player dies
if (ctr == 1)
    {   
    System.out.println();
    System.out.println("You have died may the Gods help you in your next life " + name);
    break;
    }

run++; //If they win against an enemy run goes up it theu beat three enemies they win


finalctr++; //to detrmine if they died or if they won


       
                                                                                                                    } //End of entire Loop for fighting the 3 enemies 

if(finalctr == 3)//final ctr making sure if they died and the loops break they dont get the winning screen
    {
    System.out.println();
    System.out.println("#######################################");
    System.out.println("# THANK YOU FOR PLAYING, YOU HAVE WON #");
    System.out.println("#######################################");
    }

    
} //End of Class 
   
    
}//End of Main

