import java.util.Scanner;

public class gameDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Guard: You there! Wizard! Thank the heavens you answered out plea! Our kingdom is currently being attacked by a horde of slime!" +
                "\n\nGuard: I see you're ready to start fighting, so I'll let you get right to it! But before I do, may I ask your name so I may report it to King Rowan?" +
                "\n\n(Enter your name)");//intro
        String playerName = keyboard.nextLine();//player enters their name

        Player player1 = new Player(playerName, 100, 0);//sets up the player character stats
        Potions potion = new Potions(3, 30);

        player1.setHealth(2);//debug for testing when player faints

        int slimeLevelHealth = 30;
        int slimesDefeated = 0;

        boolean gameRunning = true;//controls if the game is running

        while (gameRunning)//starts game
        {
            while (player1.getHealth() > 0 && slimesDefeated < 5)//while the player is alive AND while the number of slimes defeated is less than 5
            {
                for (int level = 0; level < 5 && player1.getHealth() > 0; level++, slimesDefeated++)//checks to see if player is level 10, which breaks the loop and initiates the next phase(the boss fight)
                {
                    int slimeHealth = slimeLevelHealth;
                    Enemies slime = new Enemies("slime", slimeHealth);//sets up the enemy stats
                    System.out.println("-------------------------------------");
                    System.out.println("--- A level " + level + " " + slime.getName() + " has appeared! ---");

                    while (slime.getHealth() > 0 && player1.getHealth() > 0) {
                        System.out.println("-------------------------------------");
                        System.out.println("Your health: " + player1.getHealth() + " / " + player1.getMaxHealth());//"EX: "Your health: 100 / 100"
                        System.out.println("Your mana: " + player1.getMana() + " / " + player1.getMaxMana());//EX: "Your mana: 60 / 100"
                        System.out.println("Potions: " + potion.getPotAmount());
                        System.out.println("Slime's health: " + slime.getHealth());//BATTLE OPTIONS FOR THE PLAYER
                        System.out.println("\nWhat action will you take?");
                        System.out.println("1. Cast Icebolt\t  2. Cast Fireball\t3. Cast Explosion(requires 100 mana)\t4. Drink a health potion");

                        String input = keyboard.nextLine();

                        if (input.equals("1")) {
                            int damageDealt = player1.iceBolt();
                            if (damageDealt == 4) {
                                System.out.println("You got a critical hit with Icebolt, dealing double damage! The slime takes " + damageDealt + " damage.");
                                slime.setHealth(slime.getHealth() - damageDealt);
                            } else {
                                System.out.println("You cast Icebolt at the slime! The slime takes " + damageDealt + " damage.");
                                slime.setHealth(slime.getHealth() - damageDealt);
                            }
                            int damageTaken = slime.Attack();
                            System.out.println("The slime retaliates! You take " + damageTaken + " damage.");
                            player1.setHealth(player1.getHealth() - damageTaken);

                            int generateMana = player1.getMana() + 20;
                            if (player1.getMana() >= player1.getMaxMana()) {
                                System.out.println("You have maximum mana, and cannot generate any more.");
                                player1.setMana(player1.getMaxMana());
                            } else {
                                player1.setMana(generateMana);
                                System.out.println("You generate 20 mana!");
                            }


                        }//end if - casts icebolt
                        else if (input.equals("2")) {
                            if (player1.getMana() >= 20) {
                                int damageDealt = player1.fireBall();
                                if (damageDealt == 8) {
                                    System.out.println("You got a critical hit with Fireball, dealing double damage! The slime takes " + damageDealt + " damage.");
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                } else {
                                    System.out.println("You cast Fireball at the slime! The slime takes " + damageDealt + " damage.");
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                }
                                int damageTaken = slime.Attack();
                                System.out.println("The slime retaliates! You take " + damageTaken + " damage.");
                                player1.setHealth(player1.getHealth() - damageTaken);

                                player1.setMana(player1.getMana() - 20);//uses 20 mana to cast Fireball
                            } else {
                                System.out.println("You don't have enough mana to cast Fireball!");
                            }

                        }//end if - casts fireball
                        else if (input.equals("3")) {
                            if (player1.getMana() < 100) {
                                System.out.println("You don't have enough mana to cast Explosion!");
                            }//checks to see if the player has enough mana to cast explosion
                            else if (player1.getMana() > 100) {
                                int damageDealt = player1.explosion();
                                if (damageDealt == 48) {
                                    System.out.println("You got a critical hit with Explosion, dealing double damage! The slime takes " + damageDealt + " damage.");
                                    player1.setMana(0);
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                } else {
                                    System.out.println("You cast Explosion at the slime! The slime takes " + damageDealt + " damage.");
                                    player1.setMana(0);
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                }
                                int damageTaken = slime.Attack();
                                System.out.println("The slime retaliates! You take " + damageTaken + " damage.");
                                player1.setHealth(player1.getHealth() - damageTaken);
                            } else {
                                int damageDealt = player1.explosion();
                                if (damageDealt == 16) {
                                    System.out.println("You got a critical hit with Explosion, dealing double damage! The slime takes " + damageDealt + " damage.");
                                    player1.setMana(0);
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                } else {
                                    System.out.println("You cast Explosion at the slime! The slime takes " + damageDealt + " damage.");
                                    player1.setMana(0);
                                    slime.setHealth(slime.getHealth() - damageDealt);
                                }
                                int damageTaken = slime.Attack();
                                System.out.println("The slime retaliates! You take " + damageTaken + " damage.");
                                player1.setHealth(player1.getHealth() - damageTaken);
                            }//casts explosion
                        }//end if - casts explosion
                        else if (input.equals("4")) {
                            if (potion.getPotAmount() > 0) {
                                int drinkPot = potion.usePotion();
                                potion.setPotAmount(potion.getPotAmount() - 1);
                                if (player1.getHealth() == player1.getMaxHealth()) {
                                    System.out.println("You are at max health!");
                                    potion.setPotAmount(potion.getPotAmount() + 1);//gives them their potion back since it didn't heal
                                }//checks if the player is at max health already
                                else if (drinkPot == 60 && player1.getHealth() > (player1.getMaxHealth() - 60)) {
                                    System.out.println("You got a critical heal! Heal for double the amount!");
                                    player1.setHealth(player1.getMaxHealth());
                                    System.out.println("You are healed to full health");
                                } else if (player1.getHealth() > (player1.getMaxHealth() - 30))//if player health is less than/equal to 30 less than maximum health
                                {
                                    player1.setHealth(player1.getMaxHealth());
                                    System.out.println("You are healed to full health");
                                }//checks if the player has taken only 30 or less damage, in which case it heals them to full instead of over-healing
                                else {
                                    if (drinkPot == 60) {
                                        System.out.println("You got a critical heal! Heal for double the amount!");
                                        System.out.println("You healed for " + drinkPot);
                                        player1.setHealth(player1.getHealth() + drinkPot);
                                    } else {
                                        System.out.println("You healed for " + drinkPot);
                                        player1.setHealth(player1.getHealth() + drinkPot);
                                    }
                                }//heals the player for 30(60 if it is a critical heal)
                            } else {
                                System.out.println("You have no health potions!(Reminder: defeated enemies have a chance to drop potions ;) )");
                            }
                        } else {
                            System.out.println("Invalid command entered! Please enter a valid command");
                        }
                        //slime.setHealth(0); //testing the commands
                    }
                    if (player1.getHealth() > 0) {
                        System.out.println("-------------------------------------");
                        System.out.println("\nYou leveled up! +10 to health and +10 to maximum mana!(Explosion is empowered when used over 100 mana!)");
                        player1.level(level);
                        slimeLevelHealth = slimeLevelHealth + 5;
                        System.out.println(potion.dropChance());
                    } else {
                        break;
                    }
                }
                if(player1.getHealth() > 0)
                {
                    System.out.println("\n\nGuard: Good heavens, do you see that beast approaching?! It's massive!");
                    System.out.println("Guard: Here, I'll use the rest of my mana to heal you to full health.\n*The guard heals you to maximum health!*");
                    player1.setHealth(player1.getMaxHealth());
                    System.out.println("Guard: Also, take these! *The guard tosses you 3 health potions!*");
                    potion.setPotAmount(potion.getPotAmount() + 3);
                    System.out.println("*The ogre approaches you, towering over you. Time for battle!");
                }
                Enemies boss = new Enemies("Ogre", 2);//sets up the enemy stats                                                                                                                                                               // BOSS FIGHT TIME!
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                while (boss.getHealth() > 0 && player1.getHealth() > 0) {
                    System.out.println("-------------------------------------");
                    System.out.println("Your health: " + player1.getHealth() + " / " + player1.getMaxHealth());//"EX: "Your health: 100 / 100"
                    System.out.println("Your mana: " + player1.getMana() + " / " + player1.getMaxMana());//EX: "Your mana: 60 / 100"
                    System.out.println("Potions: " + potion.getPotAmount());
                    System.out.println("Boss's health: " + boss.getHealth());//BATTLE OPTIONS FOR THE PLAYER
                    System.out.println("\nWhat action will you take?");
                    System.out.println("1. Cast Icebolt\t  2. Cast Fireball\t3. Cast Explosion(requires 100 mana)\t4. Drink a health potion");

                    String input = keyboard.nextLine();

                    if (input.equals("1")) {
                        int damageDealt = player1.iceBolt();
                        if (damageDealt == 4) {
                            System.out.println("You got a critical hit with Icebolt, dealing double damage! The ogre takes " + damageDealt + " damage.");
                            boss.setHealth(boss.getHealth() - damageDealt);
                        } else {
                            System.out.println("You cast Icebolt at the ogre! The ogre takes " + damageDealt + " damage.");
                            boss.setHealth(boss.getHealth() - damageDealt);
                        }
                        int damageTaken = boss.Attack();
                        System.out.println("The ogre retaliates! You take " + damageTaken + " damage.");
                        player1.setHealth(player1.getHealth() - damageTaken);

                        int generateMana = player1.getMana() + 20;
                        if (player1.getMana() >= player1.getMaxMana()) {
                            System.out.println("You have maximum mana, and cannot generate any more.");
                            player1.setMana(player1.getMaxMana());
                        } else {
                            player1.setMana(generateMana);
                            System.out.println("You generate 20 mana!");
                        }


                    }//end if - casts icebolt
                    else if (input.equals("2")) {
                        if (player1.getMana() >= 20) {
                            int damageDealt = player1.fireBall();
                            if (damageDealt == 8) {
                                System.out.println("You got a critical hit with Fireball, dealing double damage! The ogre takes " + damageDealt + " damage.");
                                boss.setHealth(boss.getHealth() - damageDealt);
                            } else {
                                System.out.println("You cast Fireball at the ogre! The ogre takes " + damageDealt + " damage.");
                                boss.setHealth(boss.getHealth() - damageDealt);
                            }
                            int damageTaken = boss.Attack();
                            System.out.println("The ogre retaliates! You take " + damageTaken + " damage.");
                            player1.setHealth(player1.getHealth() - damageTaken);

                            player1.setMana(player1.getMana() - 20);//uses 20 mana to cast Fireball
                        } else {
                            System.out.println("You don't have enough mana to cast Fireball!");
                        }

                    }//end if - casts fireball
                    else if (input.equals("3")) {
                        if (player1.getMana() < 100) {
                            System.out.println("You don't have enough mana to cast Explosion!");
                        }//checks to see if the player has enough mana to cast explosion
                        else if (player1.getMana() > 100) {
                            int damageDealt = player1.explosion();
                            if (damageDealt == 48) {
                                System.out.println("You got a critical hit with Explosion, dealing double damage! The ogre takes " + damageDealt + " damage.");
                                player1.setMana(0);
                                boss.setHealth(boss.getHealth() - damageDealt);
                            } else {
                                System.out.println("You cast Explosion at the ogre! The ogre takes " + damageDealt + " damage.");
                                player1.setMana(0);
                                boss.setHealth(boss.getHealth() - damageDealt);
                            }
                            int damageTaken = boss.Attack();
                            System.out.println("The ogre retaliates! You take " + damageTaken + " damage.");
                            player1.setHealth(player1.getHealth() - damageTaken);
                        } else {
                            int damageDealt = player1.explosion();
                            if (damageDealt == 16) {
                                System.out.println("You got a critical hit with Explosion, dealing double damage! The ogre takes " + damageDealt + " damage.");
                                player1.setMana(0);
                                boss.setHealth(boss.getHealth() - damageDealt);
                            } else {
                                System.out.println("You cast Explosion at the ogre! The ogre takes " + damageDealt + " damage.");
                                player1.setMana(0);
                                boss.setHealth(boss.getHealth() - damageDealt);
                            }
                            int damageTaken = boss.Attack();
                            System.out.println("The ogre retaliates! You take " + damageTaken + " damage.");
                            player1.setHealth(player1.getHealth() - damageTaken);
                        }//casts explosion
                    }//end if - casts explosion
                    else if (input.equals("4")) {
                        if (potion.getPotAmount() > 0) {
                            int drinkPot = potion.usePotion();
                            potion.setPotAmount(potion.getPotAmount() - 1);
                            if (player1.getHealth() == player1.getMaxHealth()) {
                                System.out.println("You are at max health!");
                                potion.setPotAmount(potion.getPotAmount() + 1);//gives them their potion back since it didn't heal
                            }//checks if the player is at max health already
                            else if (drinkPot == 60 && player1.getHealth() > (player1.getMaxHealth() - 60)) {
                                System.out.println("You got a critical heal! Heal for double the amount!");
                                player1.setHealth(player1.getMaxHealth());
                                System.out.println("You are healed to full health");
                            } else if (player1.getHealth() > (player1.getMaxHealth() - 30))//if player health is less than/equal to 30 less than maximum health
                            {
                                player1.setHealth(player1.getMaxHealth());
                                System.out.println("You are healed to full health");
                            }//checks if the player has taken only 30 or less damage, in which case it heals them to full instead of over-healing
                            else {
                                if (drinkPot == 60) {
                                    System.out.println("You got a critical heal! Heal for double the amount!");
                                    System.out.println("You healed for " + drinkPot);
                                    player1.setHealth(player1.getHealth() + drinkPot);
                                } else {
                                    System.out.println("You healed for " + drinkPot);
                                    player1.setHealth(player1.getHealth() + drinkPot);
                                }
                            }//heals the player for 30(60 if it is a critical heal)
                        } else {
                            System.out.println("You have no health potions! Hopefully you can defeat the ogre before he defeats you...");
                        }
                    } else {
                        System.out.println("Invalid command entered! Please enter a valid command");
                    }

                }
                if (player1.getHealth() <= 0) {
                    System.out.println("-------------------------------------");
                    System.out.println("\nYour health has dropped below 0.");
                    System.out.println("You have fainted and are returned to the priests to be healed...\nThe kingdom falls in your absence...\n\n--- GAME OVER ---");
                } else {
                    System.out.println("-------------------------------------");
                    System.out.println("Guard: Wow! You did it! You successfully defended Rowan Kingdom from the invasion of slimes! I'm sure the king would like to thank you himself\n*The guard brings the king forth*\n" +
                            "King Rowan: Thank you, " + player1.getName() + ", for defending my kingdom. We owe you a great debt.\n\n CONGRATULATIONS, YOU BEAT THE GAME!");
                }
                gameRunning = false;
            }

//        int damageTaken = player1.getHealth() - slime.Attack();
//        player1.setHealth(damageTaken);
//        System.out.println(player1.getHealth());

//        System.out.println(player1.toString());
//        player1.level(1);
//        System.out.println(player1.toString());
//                                                                                  TESTING IF METHODS WORK THE WAY I THINK THEY DO BEFORE STARTING THE PROJECT (they worked exactly how I thought they would :D)
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
}
