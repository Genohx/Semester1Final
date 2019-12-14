import java.util.Scanner;

public class gameDriver
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Guard: You there! Wizard! Thank the heavens you answered out plea! Our kingdom is currently being attacked by a horde of slime!" +
                            "\n\nGuard: I see you're ready to start fighting, so I'll let you get right to it! But before I do, may I ask your name so I may report it to King Rowan?" +
                            "\n\n(Enter your name)");//intro
        String playerName = keyboard.nextLine();//player enters their name

        Player player1 = new Player(playerName, 100, 0);//sets up the player character stats
        Potions potion = new Potions(3, 30);


        boolean gameRunning = true;

        while(gameRunning)
        {
            for(int level = 0; level<10; level++)//checks to see if player is level 10, which breaks the loop and initiates the next phase(the boss fight)
            {
                int slimeHealth = 30;
                Enemies slime = new Enemies("slime", slimeHealth);//sets up the enemy stats
                System.out.println("--- A " + slime.getName() + " has appeared! ---");

                while(slime.getHealth() > 0)
                {
                    System.out.println("Your health: "+player1.getHealth());
                    System.out.println("Your mana: "+player1.getMana());
                    System.out.println("Slime's health: "+slime.getHealth());//BATTLE OPTIONS FOR THE PLAYER
                    System.out.println("\nWhat action will you take?");
                    System.out.println("1. Cast Icebolt\t  2. Cast Fireball\t3. Cast Explosion(requires 100 mana)\t4. Drink a health potion");

                    String input = keyboard.nextLine();
                    if(input.equals("1"))
                    {
                        System.out.println("You cast Icebolt at the slime!");
                        
                    }
                    else if(input.equals("2"))
                    {

                    }
                    else if(input.equals("3"))
                    {

                    }
                    else
                    {

                    }
                    slime.setHealth(0);
                }
                level = 10;
            }

            gameRunning=false;
        }


//        int damageTaken = player1.getHealth() - slime.Attack();
//        player1.setHealth(damageTaken);
//        System.out.println(player1.getHealth());

//        System.out.println(player1.toString());
//        player1.level(1);
//        System.out.println(player1.toString());
//
//        player1.setHealth(player1.getHealth()-2);
//
//        System.out.println("Health: "+player1.getHealth());
//
//        int damage = player1.getHealth() - player1.iceBolt();
//
//        player1.setHealth(damage);
//
//        System.out.println("Health: "+player1.getHealth());

    }
}
