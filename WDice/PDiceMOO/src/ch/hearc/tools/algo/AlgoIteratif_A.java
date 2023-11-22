
package ch.hearc.tools.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AlgoIteratif_A implements AlgoIteratif_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public AlgoIteratif_A()
		{
		this.listIterationListener = new ArrayList<IterationListener>();
		this.isStop = new AtomicBoolean(false);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void stop()
		{
		isStop.set(true);
		}

	@Override
	public void run()
		{
		isStop.set(false);
		// onBegin
			{
			onBegin();
			IterationEvent iterationEvent = new IterationEvent(this, -1, EtatAlgo.BEGIN);
			avertirListener(iterationEvent);
			}
		// iteration
			{
			int i = 0;
			while(!isFini(i) && !isStop.get())
				{
				iterationStep(i);
				IterationEvent iterationEvent = new IterationEvent(this, i, EtatAlgo.RUNNING);
				avertirListener(iterationEvent);
				i++;
				}
			}
		// onEnd
			{
			onEnd();
			IterationEvent iterationEvent = new IterationEvent(this, -1, EtatAlgo.END);
			avertirListener(iterationEvent);
			}
		}// end run

	@Override
	public synchronized void addIterationListener(IterationListener iterationListener)
		{
		listIterationListener.add(iterationListener);
		}

	@Override
	public synchronized void removeIterationListener(IterationListener iterationListener)
		{
		listIterationListener.remove(iterationListener);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private synchronized void avertirListener(IterationEvent iterationEvent)
		{
		for(IterationListener iterationListener:listIterationListener)
			{
			iterationListener.iterationPerformed(iterationEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private List<IterationListener> listIterationListener;
	private AtomicBoolean isStop;
	}
