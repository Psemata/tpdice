
package ch.hearc.dice.gui.atomic.display;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.hearc.c_gui.tools.JMarge;
import ch.hearc.dice.gui.atomic.input.JInputs;

public class JDisplay extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDisplay()
		{
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
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		// Les deux parties principales : inputs -> partie de gauche ; main -> partie de droite
		this.jInputs = new JInputs();
		this.jMain = new JMain();

		add(new JMarge(this.jInputs, 6, 0), BorderLayout.WEST);
		add(this.jMain, BorderLayout.CENTER);
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
	private JInputs jInputs;

	// Tools
	private JMain jMain;

	}
