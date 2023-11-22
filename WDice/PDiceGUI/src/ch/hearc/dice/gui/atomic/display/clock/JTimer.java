
package ch.hearc.dice.gui.atomic.display.clock;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JTimer extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimer()
		{
		super(BoxLayout.Y_AXIS);
		this.isRunning = new AtomicBoolean();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		this.animationThread.start();
		}

	public void stop()
		{
		this.animationThread.stop();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void resetClock()
		{
		this.jTimerHorloge.reset();
		}

	private void createAnimationThread()
		{
		resetClock();
		this.animationThread = new Thread(new Runnable()
			{

			int h = 0;
			int m = 0;
			int s = 0;

			@Override
			public void run()
				{
				while(isRunning.get())
					{

					try
						{
						// Attend une seconde
						Thread.sleep(1000);

						// Calcul pour les secondes, minutes et heures
						s++;
						if (s == 60)
							{
							s = 0;
							m++;
							}
						if (m == 60)
							{
							m = 0;
							h++;
							}
						}
					catch (InterruptedException e)
						{
						System.out.println(e.getMessage());
						}

					// Raffraichit l'affichage
					jTimerDigit.setTime(h, m, s);
					jTimerHorloge.setTime(); // Sans paramètres car pas d'utilités
					}
				}

			});
		}

	private void geometry()
		{
		this.jTimerDigit = new JTimerDigit();
		this.jTimerHorloge = new JTimerHorloge();

		add(jTimerDigit);
		add(jTimerHorloge);
		}

	private void control()
		{

		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServiceCreated(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED)
					{
					createAnimationThread();
					isRunning.set(true);
					animationThread.start();
					}

				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.STOPPED)
					{
					isRunning.set(false);
					}

				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					animationThread.stop();
					isRunning.set(false);
					}

				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{
						if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
							{
							isRunning.set(false);
							}
						}
					});

				}
			});
		}

	private void appearance()
		{
		Sizes.setHeight(jTimerDigit, 60);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JTimerDigit jTimerDigit;
	private JTimerHorloge jTimerHorloge;

	// Tools animation
	private Thread animationThread;
	private AtomicBoolean isRunning;
	}
