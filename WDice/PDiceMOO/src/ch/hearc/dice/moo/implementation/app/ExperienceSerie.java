
package ch.hearc.dice.moo.implementation.app;

public class ExperienceSerie implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ExperienceSerie(int nbExperiences, int nbFace)
		{
		this.experience = new Experience(nbFace);
		this.nbExperiences = nbExperiences;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		for(int i = 0; i < this.nbExperiences; i++)
			{
			this.nbLancerTotal += this.experience.throwDice();
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public long getNbLancerTotal()
		{
		return this.nbLancerTotal;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private int nbExperiences;

	// output
	private long nbLancerTotal;

	// tools
	private Experience experience;

	}
