import java.util.Random;

public class Zombie
{
	private static int health;
	private static int damage;

	public Zombie(int health, int damage)
	{
		this.health = health;
		this.damage = damage;
	}

	public int getHealth()
	{
		return health;
	}

	public int getDamage()
	{
		return damage;
	}

	public int loseHealth(int damage)
	{
		health = health - damage;
		return health;
	}

	public static Zombie generateZombie()
	{
		Random rand = new Random();
		health = rand.nextInt(40) + 30;
		damage = rand.nextInt(5) + 10;

		Zombie zombie = new Zombie(health, damage);
		return zombie;
	}
}