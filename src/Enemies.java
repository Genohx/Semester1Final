import java.util.Random;

public class Enemies implements levelUp
{
    //variables
    private String name;
    private int health;
    private static int maxDamage = 5;
    //constructors
    public Enemies() {
        name = null;
        health = 0;
    }//end default constructor

    public Enemies(String name, int health) {
        this.name = name;
        this.health = health;
    }//end three argument constructor

    //getters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxDamage()
    {
        return maxDamage;
    }


    //setters
    public void setName(String newName) {
        name = newName;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public void level(int level)
    {
        health = health + (level + 5); //increase enemy health by 10 when they level up
        maxDamage = maxDamage * (level); //increase enemy damage by 5 when they level up
    }

    public int Attack()
    {
        Random rand = new Random();
        return rand.nextInt(maxDamage) + 1;
    }

    public String toString()
    {
        String output = "";
        output += "Name: "+name;
        output += "\nHealth: "+health;
        return output;
    }
}
