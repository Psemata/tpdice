
package ch.hearc.dice.gui.atomic.display.progressbar;

import javax.swing.JProgressBar;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JProgressBarFace extends JProgressBar
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBarFace(int x0, int x1)
		{
		super(x0, x1);

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
		setStringPainted(true);
		setString("Progression des calculs : 0.0%");
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
					setMinimum(diceVariableServiceEvent.getDiceVariableInputs().nbFace.getA());
					setMaximum(diceVariableServiceEvent.getDiceVariableInputs().nbFace.getB());

					diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
						{

						@Override
						public void iterationPerformed(IterationEvent iterationEvent)
							{
							setValue(diceVariableServiceEvent.getDiceVariableInputs().nbFace.getA() + iterationEvent.getI());
							double pourcentage = (iterationEvent.getI() + 1) / (double)(diceVariableServiceEvent.getDiceVariableInputs().getSize());
							pourcentage = 100 * Math.round(pourcentage * 10000.0) / 10000.0;
							setString("Progression des calculs : " + pourcentage + "%");
							}
						});
					}

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

	// Tools

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	}
