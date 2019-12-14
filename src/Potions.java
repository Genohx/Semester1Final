import java.util.Random;

public class Potions
{
    //variables
    private int potAmount;
    private int healAmount;
    private static int dropChance;
    //constructors
    public Potions()
    {
        potAmount = 0;
        healAmount = 0;
    }//end default constructor
    public Potions(int potAmount, int healAmount) {
        this.potAmount = potAmount;
        this.healAmount = healAmount;
    }//end three argument constructor
    //getters
    public int getPotAmount()
    {
        return potAmount;
    }
    public int getHealAmount()
    {
        return healAmount;
    }
    //setters
    public void setPotAmount(int newPotAmount) {
        potAmount = newPotAmount;
    }
    public void setHealAmount(int newHealAmount) {
        healAmount = newHealAmount;
    }

    //method for randomly getting a potion when defeating an enemy
    public String dropChance()
    {
        Random rand = new Random();
        if(rand.nextInt(100) < 50)//50 being the drop chance
        {
            setPotAmount(getPotAmount()+1);
            return "You got a potion from the enemy!";
        }
        else
        {
            return "";
        }
    }
    //method for using a potion
    public int usePotion()
    {
        Random rand = new Random();
        if(rand.nextInt(100) < 30)//30 being the critical heal chance
        {
            System.out.println("You got a critical heal! Heal for double the amount!");
            return healAmount * 2;
        }
        else
        {
            return healAmount;
        }
    }
    //toString
}
