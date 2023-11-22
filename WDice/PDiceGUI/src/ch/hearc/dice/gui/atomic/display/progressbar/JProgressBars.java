
package ch.hearc.dice.gui.atomic.display.progressbar;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.JMarge;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JProgressBars extends Box
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBars()
		{
		super(BoxLayout.Y_AXIS);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.progressFace = new JProgressBarFace(0, 40);
		this.progressGlobal = new JMarge(new JProgressBarGlobal(), 0, 2);
		add(new JMarge(progressFace, 0, 4));
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
					add(progressGlobal);
					revalidate();
					}
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.STOPPED || diceVariableServiceEvent.getLifeCycle() == LifeCycle.KILLED)
					{
					remove(progressGlobal);
					revalidate();
					}

				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{
						if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
							{
							remove(progressGlobal);
							revalidate();
							}
						}
					});

				}
			});

		}

	private void appearance()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Outputs

	private JProgressBarFace progressFace;
	private JMarge progressGlobal;

	// Tools
	}
