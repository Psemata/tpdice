
package ch.hearc.dice.gui.atomic.display.clock;

import ch.hearc.c_gui.tools.JFrameBaseline;
import ch.hearc.dice.gui.service.DiceVariableService;

public class UseJTimerAlone
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
		new JFrameBaseline(new JTimer());
		DiceVariableService.getInstance().start(); // Utilisé pour start les timers
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
