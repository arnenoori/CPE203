public class Dog extends Animal
{
	boolean mediumDog;

	public Dog(boolean mediumDog)
	{
		this.mediumDog = mediumDog;
	}

	public void speak()
	{
		System.out.println("bark");
	}

	public int calculateHumanYears(int years)
	{
		// age faster when younger, so set 1 years to 15.
		if (years == 1)
		{
			return 15;
		}
		
		// after year 2 (which is 28), age in multiples of 4
		int humanYears = 16 + 4 * years; 

		if (mediumDog)
		{
			if (years == 6)
			{
				humanYears += 2;
			}
			else if (years >= 7)
			{
				humanYears += 3;
			}
		}

		return humanYears;
	}

	public void attack(int i)
	{
		System.out.println("Grrrrr");
		if (i > 5)
			System.out.println("growl");
		System.out.println("Grrrrr");
	}
}