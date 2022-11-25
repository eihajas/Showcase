import java.util.Random;

public class Player
{
	//Weapon weapon = new Weapon(10);
	private static int health;
	private static Weapon weapon;

	public Player(int health, Weapon weapon)
	{
		this.health = health;
		this.weapon = weapon;
	}

	public int getHealth()
	{
		return health;
	}

	public boolean Attack()
	{
		Random rand = new Random();
		int prob = rand.nextInt(101);

		if (prob <= 100 * weapon.getHitChance())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public int loseHealth(int damage)
	{
		health = health - damage;
		return health;
	}

	public boolean Dodge()
	{
		Random rand = new Random();
		int prob = rand.nextInt(101);
		if (prob <= 80)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}