
package ch.hearc.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.b_poo.tools.Maths;

public class TestChrono
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testChrono() // Fonction qui teste le chrono
		{
		Chrono chrono = new Chrono(); // Lance le chrono
		sleepMS(10000); // Permet de faire attendre 10s au thread actuel
		long time = chrono.stop(); // Stop le chrono

		Assertions.assertTrue(Maths.isEquals(time, 10000, 0.001));
		}

	private static void sleepMS(long durationMs)
		{
		try
			{
			Thread.sleep(durationMs);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
