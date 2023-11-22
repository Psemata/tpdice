
package ch.hearc.dice.gui.atomic.display.graph;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class JGraphes extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphes()
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
		// TODO

		JGrapheLancerMoyen lancerMoyen = new JGrapheLancerMoyen();
		JGrapheDuration lancerDuration = new JGrapheDuration();

		add(lancerMoyen.getChartPanel());
		add(lancerDuration.getChartPanel());
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	}
