
package ch.hearc.dice.moo.implementation.app;

import org.junit.jupiter.api.Assertions;

public class Dice implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Dice(int nbExperience, int nbFace, TypeProcessing version)
		{
		// input
			{
			this.nbExperience = nbExperience;
			this.nbFace = nbFace;
			this.version = version;
			}
		}

	public Dice(int nbExperience, int nbFace)
		{
		this(nbExperience, nbFace, TypeProcessing.SEQUENTIEL);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		switch(version)
			{
			case PARALLELE:
				{
				this.nbLancerMoyen = versionThread();
				break;
				}
			case RUNNABLE:
				{
				this.nbLancerMoyen = versionRunnable();
				break;
				}
			case SEQUENTIEL:
				{
				this.nbLancerMoyen = versionSequentielle();
				break;
				}
			default:
				{
				Assertions.fail("Pas encore impl�ment�e");
				break;
				}
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancerMoyen()
		{
		return this.nbLancerMoyen;
		}

	public int getNbFace()
		{
		return this.nbFace;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private int versionSequentielle()
		{
		// R�alise l'exp�rience
		ExperienceSerie experienceSerie = new ExperienceSerie(this.nbExperience, this.nbFace);
		experienceSerie.run();
		// Moyennage des r�sultats
		return average(experienceSerie.getNbLancerTotal(), this.nbExperience);
		}

	private int versionRunnable()
		{
		// Cr�ation d'un tableau d'objet experienceSerie
		ExperienceSerie experienceSerie[] = new ExperienceSerie[Runtime.getRuntime().availableProcessors()];
		int nbEach = nbExperience(experienceSerie.length, this.nbExperience); // Nombre de d'exp�rience � faire par thread
		// Initialisation des �l�ments du tableau
		for(int i = 0; i < experienceSerie.length; i++)
			{
			experienceSerie[i] = new ExperienceSerie(nbEach, this.nbFace);
			}
		// Nombre de lancer
		int nbLancer = 0;
		// R�alise les exp�riences
		for(int i = 0; i < experienceSerie.length; i++)
			{
			experienceSerie[i].run();
			nbLancer += experienceSerie[i].getNbLancerTotal();
			}
		// Moyennage des r�sultats
		return average(nbLancer, experienceSerie.length * nbEach);
		}

	private int versionThread()
		{
		// Cr�ation d'un tableau d'objet experienceSerie et d'un tableau de threads
		int nbCore = Runtime.getRuntime().availableProcessors();
		ExperienceSerie experienceSerie[] = new ExperienceSerie[nbCore];
		Thread threads[] = new Thread[nbCore];
		int nbEach = nbExperience(experienceSerie.length, this.nbExperience); // Nombre de d'exp�rience � faire par thread
		// Initialisation des �l�ments du tableau
		for(int i = 0; i < nbCore; i++)
			{
			experienceSerie[i] = new ExperienceSerie(nbEach, this.nbFace);
			threads[i] = new Thread(experienceSerie[i]);
			}
		// Nombre de lancer
		int nbLancer = 0;
		// R�alise les exp�riences
		for(int i = 0; i < nbCore; i++)
			{
			threads[i].start();
			}
		// Attends que les threads finissent
		try
			{
			for(int i = 0; i < nbCore; i++)
				{
				threads[i].join();
				nbLancer += experienceSerie[i].getNbLancerTotal();
				}
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}

		// Moyennage des r�sultats
		return average(nbLancer, experienceSerie.length * nbEach);
		}

	private int nbExperience(int nbThread, int nbExperience)
		{
		return nbExperience / nbThread;
		}

	private int average(long nbLancerTotal, int nbExperience)
		{
		return (int)Math.ceil(nbLancerTotal / (double)nbExperience);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private int nbExperience;
	private int nbFace;
	private TypeProcessing version;

	// output
	private int nbLancerMoyen;
	}
