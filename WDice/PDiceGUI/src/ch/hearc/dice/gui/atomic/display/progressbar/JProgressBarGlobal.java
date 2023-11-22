
package ch.hearc.dice.gui.atomic.display.progressbar;

import javax.swing.JProgressBar;

public class JProgressBarGlobal extends JProgressBar
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBarGlobal()
		{
		super(0, 100);

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
		setString("L'algorithme tourne");
		setIndeterminate(true);
		}

	private void control()
		{

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
	}
