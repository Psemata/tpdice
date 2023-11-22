
package ch.hearc.dice.moo.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.dice.moo.implementation.app.Dice;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;

public class TestDice
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testSequentiel()
		{
		Dice dice = new Dice(Integer.MAX_VALUE / 1000, 6, TypeProcessing.SEQUENTIEL);
		dice.run();

		int nbLancerMoyenEmpirique = dice.getNbLancerMoyen();
		int nbLancerMoyenTheorique = 15; // moyenne calculée en cours

		Assertions.assertEquals(nbLancerMoyenTheorique, nbLancerMoyenEmpirique);
		}

	@Test
	public void testRunnable()
		{
		Dice dice = new Dice(Integer.MAX_VALUE / 1000, 6, TypeProcessing.RUNNABLE);
		dice.run();

		int nbLancerMoyenEmpirique = dice.getNbLancerMoyen();
		int nbLancerMoyenTheorique = 15; // moyenne calculée en cours

		Assertions.assertEquals(nbLancerMoyenTheorique, nbLancerMoyenEmpirique);
		}

	@Test
	public void testThread()
		{
		Dice dice = new Dice(Integer.MAX_VALUE / 1000, 6, TypeProcessing.PARALLELE);
		dice.run();

		int nbLancerMoyenEmpirique = dice.getNbLancerMoyen();
		int nbLancerMoyenTheorique = 15; // moyenne calculée en cours

		Assertions.assertEquals(nbLancerMoyenTheorique, nbLancerMoyenEmpirique);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
