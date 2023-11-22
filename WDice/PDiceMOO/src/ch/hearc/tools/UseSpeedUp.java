
package ch.hearc.tools;

import ch.hearc.dice.moo.implementation.app.Dice;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;

/**
 * SpeedUp de la version 1
 */
public class UseSpeedUp
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
		// r�cup�re les propri�t�s syst�mes
		String nbFace = System.getProperty("nbFace");
		String nbExperience = System.getProperty("nbExperience");

		// Calcul s�quentiel
		Chrono chronoS = new Chrono();
		Dice diceS = new Dice(Integer.parseInt(nbExperience), Integer.parseInt(nbFace), TypeProcessing.SEQUENTIEL);
		diceS.run();
		long timeS = chronoS.stop();

		// Calcul parall�le
		Chrono chronoP = new Chrono();
		Dice diceP = new Dice(Integer.parseInt(nbExperience), Integer.parseInt(nbFace), TypeProcessing.PARALLELE);
		diceP.run();
		long timeP = chronoP.stop();

		show(timeS, timeP);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void show(long timeS, long timeP)
		{
		double rapport = timeS / (double)timeP; // Donne le rapport entre les deux temps
		System.out.println("Nombre de core            : " + Runtime.getRuntime().availableProcessors());
		System.out.println("Temps - calcul s�quentiel : " + timeS);
		System.out.println("Temps - calcul parall�le  : " + timeP);
		System.out.println(" /                        ________");
		System.out.println("                            " + (Math.round(rapport * 100.0) / 100.0) + " x plus rapide");
		}

	}
