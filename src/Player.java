import java.util.Random;

public class Player implements levelUp {
    //variables
    private String name;
    private int health;
    private int mana;
    private static int maxMana = 100;
    private static int critChance = 30;

    //constructors
    public Player() {
        name = null;
        health = 0;
        mana = 0;
    }//end default constructor

    public Player(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }//end three argument constructor

    //getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    //setters
    public void setName(String newName) {
        name = newName;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public void setMana(int newMana) {
        mana = newMana;
    }

    //method for icebolt damage
    public int iceBolt()
    {
        Random rand = new Random();
        int iceDamage = 2;
        if(rand.nextInt(100) < critChance)
        {
            System.out.println("You landed a critical hit! You dealt double damage!");
            return iceDamage * 2;
        }
        else
        {
            return iceDamage;
        }
    }
    //method for fireball damage

    //method for explosion damage

    //method for leveling up
    public void level(int level)
    {
        health = health + (level * 10); //increase player health by 10 when they level up
        maxMana = maxMana + (level * 10); //increase player mana by 10 when they level up
    }
    //toString
    public String toString()
    {
        String output = "";
        output += "Name: "+name;
        output += "\nHealth: "+health;
        output += "\nMana: "+mana;
        output += "\nMaximum Mana: "+maxMana;
        return output;
    }
}
