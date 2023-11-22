
package ch.hearc.dice.gui.atomic.input;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;

import ch.hearc.c_gui.tools.Sizes;

public class JExperienceSlider extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JExperienceSlider()
		{
		super(BoxLayout.X_AXIS);

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

	public JSlider getNbExperienceSlider()
		{
		return this.nbExperienceSlider;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// Slider
		this.nbExperienceSlider = new JSlider(10000, 2000000, 1000000);
		// Les labels du slider
		this.labelMinValue = new JLabel("10K");
		this.labelMaxValue = new JLabel("2M");

		add(this.labelMinValue);
		add(this.nbExperienceSlider);
		add(this.labelMaxValue);
		}

	private void control()
		{
		}

	private void appearance()
		{
		Sizes.setWidth(nbExperienceSlider, 140);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Output
	private JLabel labelMinValue;
	private JLabel labelMaxValue;

	// Inputs
	private JSlider nbExperienceSlider;

	// Tools

	}
