import java.util.Scanner;
import java.util.Random;

public class Game
{
	static boolean run;
	static Weapon weapon = Weapon.generateWeapon();
	static Player player = new Player(100,weapon);
	static Random rand = new Random();
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		//Random rand = new Random();
		//Weapon weapon = Weapon.generateWeapon();
		//Player player = new Player(100,weapon);
		int action1;
		
		run = true;
		boolean playerTurn = true;
		int playerChoice = 0;

		System.out.println("Welcome to Augie Zombies!");

		while (run == true)
		{
			System.out.println("1. Rest\n2. Explore");
			action1 = scn.nextInt();
			System.out.println();

			switch(action1)
			{
			case 1:
				rest();
				break;
			case 2:
				explore();
				break;
			}
		}
	}

	public static void rest()
	{
		System.out.println("You have rested\n");
	}

	public static void explore()
	{
		int explore_fail = rand.nextInt(2) + 1;
		switch(explore_fail)
		{
		case 1:
			encounter();
			break;
		case 2:
			System.out.println("You didn't encounter any zombies");
			break;
		}
	}

	public static void encounter()
	{
		int fight_flight;
		System.out.println("You come face to face with a reanimated corpse of a former classmate...\n1. Fight\n2. Flight");
		fight_flight = scn.nextInt();

		switch(fight_flight)
		{
		case 1:
			fight();
			break;
		case 2:
			flight();
			break;
		}
	}
	public static void flight()
	{
		System.out.println("You run away from your former classmate");
	}

	public static void fight()
	{
		Random rand = new Random();
		int playerTurn = rand.nextInt(2) + 1;
		boolean fight_over = false;
		Zombie zombie = Zombie.generateZombie();
		System.out.println("Your fingers tighten around your weapon as you prepare to take a swing...");

		while(fight_over == false)
		{
			switch(playerTurn)
			{
			case 1:
				if (player.Attack() == true)
				{
					System.out.println("You hear your former classmates skull crack as your weapon collides with its head");
					zombie.loseHealth(weapon.getDamage());
					playerTurn = 2;
					break;
				}
				else 
				{
					System.out.println("Your nerves get the best of you as you miss your swing entirely");
					playerTurn = 2;
					break;
				}
			case 2:
				if (player.Dodge() == true)
				{
					System.out.println("You narrowly dodge the mangled hands of your former classmate");
					playerTurn = 1;
					break;
				}
				else
				{
					System.out.println("Your former classmate manages to scratch you deeply and draws blood");
					player.loseHealth(zombie.getDamage());
					playerTurn = 1;
					break;
				}
			}
			if (zombie.getHealth() <= 0)
				{
					System.out.println("You deliver a blow that leaves your former classmate an inanimate heap on the floor. You hope they don't get up again.");
					fight_over = true;
					break;
				}
			if (player.getHealth() <= 0)
				{
					die();
					fight_over = true;
					break;
				}
		}
	}

	public static void die()
	{
		run = false;
		System.out.println("You have joined the undead");
	}
}

/*
		while (run == true)
			{
				if (zombie.getHealth() <= 0)
				{
					System.out.println("Zombie is dead");
					run = false;
					break;
				}
				if (player.getHealth() <= 0)
				{
					System.out.println("Player is dead");
					run = false;
					break;
				}
				while (playerTurn == true)
				{
					System.out.print("Strike(1) or dodge(2)?: ");
					playerChoice = scn.nextInt();

					switch (playerChoice)
					{
						case 1:
							if (player.Attack() == true)
							{
								System.out.printf("Success. Zombie takes %d points of damage\n", weapon.getDamage());
								zombie.loseHealth(weapon.getDamage());
								playerTurn = false;
								break;
							}
							else 
							{
								System.out.println("Fail. Zombie takes no damage");
								playerTurn = false;
								break;
							}

						case 2:
							if (player.Dodge() == true)
							{
								System.out.println("Success. Player takes no damage");
								break;
							}
							else
							{
								System.out.printf("Fail. Player takes %d points of damage\n", zombie.getDamage());
								player.loseHealth(zombie.getDamage());
								break;
							}
					}
				}

				if (zombie.getHealth() <= 0)
				{
					System.out.println("Zombie is dead");
					run = false;
					break;
				}
				if (player.getHealth() <= 0)
				{
					System.out.println("Player is dead");
					run = false;
					break;
				}

				while (playerTurn == false)
				{
					System.out.printf("Player takes %d points of damage\n", zombie.getDamage());
					player.loseHealth(zombie.getDamage());
					playerTurn = true;
					break;
				}
			}
}
*/