public class Player
{
    //variables
    private String name;
    private int health;
    private int mana;
    private static int maxMana
    //constructors
    public Player()
    {
        name = null;
        health = 0;
        mana = 0;
    }//end default constructor

    public Player(String name, int health, int mana)
    {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }//end three argument constructor

    //getters
    public String getName()
    {
        return name;
    }


    //setters

    //method for icebolt damage

    //method for fireball damage

    //method for explosion damage

    //method for leveling up

    //toString
}
