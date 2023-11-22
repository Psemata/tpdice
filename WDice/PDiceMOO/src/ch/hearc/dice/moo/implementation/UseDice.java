
package ch.hearc.dice.moo.implementation;

import ch.hearc.dice.moo.implementation.app.Dice;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;

public class UseDice
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		int nbFace = 6;
		int nbExperience = Integer.MAX_VALUE / 1000;

		Dice dice = new Dice(nbExperience, nbFace, TypeProcessing.PARALLELE);
		dice.run();
		int nbLancerMoyen = dice.getNbLancerMoyen();

		System.out.println("nbFace        = " + nbFace);
		System.out.println("nbExperience  = " + nbExperience);
		System.out.println("nbLancerMoyen = " + nbLancerMoyen);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
