public class gameDriver
{
    public static void main(String[] args)
    {
        Player player1 = new Player("Josh", 100, 0);
        System.out.println(player1.toString());
        player1.level(1);
        player1.setHealth(player1.getHealth()-2);
        System.out.println(player1.toString());

        int iceBolt = player1.iceBolt();
        System.out.println(iceBolt);
        System.out.println(iceBolt);
        System.out.println(iceBolt);
        System.out.println(iceBolt);

    }
}
