
package ch.hearc.dice.moo.implementation.app;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Assertions;

public class Experience
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Experience(int nbFace)
		{
		// input
			{
			this.nbFace = nbFace;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Fonction qui
	 */
	public int throwDice()
		{
		int nbLancer = 0;
		Set<Integer> setFaceObtenu = new HashSet<Integer>(nbFace);
		ThreadLocalRandom random = ThreadLocalRandom.current();
		do
			{
			double random0to1 = random.nextDouble();
			int random1toN = 1 + (int)(random0to1 * nbFace);
			Assertions.assertTrue(random1toN >= 1 && random1toN <= nbFace);

			setFaceObtenu.add(random1toN);

			nbLancer++;

			} while(setFaceObtenu.size() < nbFace);

		return nbLancer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private int nbFace;
	}
