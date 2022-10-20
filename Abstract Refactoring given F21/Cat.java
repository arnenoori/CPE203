public class Cat extends Animal
{
	private boolean clawsSharp;

	public Cat(boolean c) { clawsSharp = c; }
	public void speak()
	{
		if (clawsSharp)
		{
			System.out.println("hiss");
		}
		System.out.println("moew");
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


		return humanYears;
	}

	public void attack(int i)
	{
		System.out.println("Grrrrr");
		if (i > 5)
		{	
			if (clawsSharp)
				System.out.println("scratch");
			else
				clawsSharp = true;
		}
		System.out.println("Grrrrr");
	}
}