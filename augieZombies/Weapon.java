import java.util.Random;

public class Weapon
{
	private static int damage;
	private static float hitChance;

	public Weapon(int damage, float hitChance)
	{
		this.damage = damage;
		this.hitChance = hitChance;
	}

	public int getDamage()
	{
		return damage;
	}

	public float getHitChance()
	{
		return hitChance;
	}

	public static Weapon generateWeapon()
	{
		Random rand = new Random();
		damage = rand.nextInt(40) + 10;
		hitChance = Math.round(rand.nextFloat() * (50) + 50);

		Weapon weapon = new Weapon(damage, hitChance);
		return weapon;
	}
}