
package ch.hearc.dice.gui.atomic.input;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.c_gui.tools.JCenter;

public class JNbExperience extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbExperience(JInputs jInputs)
		{
		super(BoxLayout.Y_AXIS);
		this.jInputs = jInputs;

		geometry();
		control();
		appearance();

		jInputs.setNbExperience(jExperienceSlider.getNbExperienceSlider().getValue());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void disable()
		{
		this.jExperienceSlider.getNbExperienceSlider().setEnabled(false);
		}

	@Override
	public void enable()
		{
		this.jExperienceSlider.getNbExperienceSlider().setEnabled(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jExperienceSlider = new JExperienceSlider();
		this.labelCurrentValue = new JLabel(String.valueOf(this.jExperienceSlider.getNbExperienceSlider().getValue()));

		add(new JCenter(this.jExperienceSlider));
		add(Box.createVerticalStrut(5));
		add(new JCenter(this.labelCurrentValue));
		}

	private void control()
		{

		// Permet de modifier le contenu du label indiquant la valeur actuelle sélectionnée
		this.jExperienceSlider.getNbExperienceSlider().addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				int value = jExperienceSlider.getNbExperienceSlider().getValue();
				labelCurrentValue.setText(String.valueOf(value));
				jInputs.setNbExperience(value);
				}
			});

		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Nb. d'expériences"));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Output

	// Inputs
	private JInputs jInputs;
	private JExperienceSlider jExperienceSlider;

	// Tools
	private JLabel labelCurrentValue;

	}
