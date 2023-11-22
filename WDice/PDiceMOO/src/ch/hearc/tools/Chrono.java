
package ch.hearc.tools;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chrono()
		{
		start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		this.startTime = System.currentTimeMillis();
		this.stopTime = System.currentTimeMillis();
		this.deltaTime = 0;
		this.stopped = false;
		}

	public long stop() // retourne en [ms] le temps écoulé
		{
		if (!stopped)
			{
			this.stopTime = System.currentTimeMillis();
			this.deltaTime = this.stopTime - this.startTime;
			this.stopped = true;
			}

		return this.deltaTime;
		}

	public long getTimeMS() // en [ms]
		{
		if (stopped)
			{ return this.deltaTime; }
		return System.currentTimeMillis() - this.startTime;
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append(getTimeMS());
		builder.append(" [ms]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// tools
	private long startTime;
	private long stopTime;
	private long deltaTime;

	private boolean stopped;
	}
