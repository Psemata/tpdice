
package ch.hearc.dice.gui.atomic.input;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.c_gui.tools.JCenter;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.service.DiceVariableService;

public class JNbFace extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbFace(JInputs jInputs)
		{
		super(BoxLayout.X_AXIS);
		this.jInputs = jInputs;

		geometry();
		control();
		appearance();

		jInputs.setNbFace((int)minimalFaceSpinner.getValue(), (int)maximalFaceSpinner.getValue());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void disable()
		{
		this.minimalFaceSpinner.setEnabled(false);
		this.maximalFaceSpinner.setEnabled(false);
		}

	@Override
	public void enable()
		{
		this.minimalFaceSpinner.setEnabled(true);
		this.maximalFaceSpinner.setEnabled(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// Spinners
		this.minimalFaceSpinner = new JSpinner(new SpinnerNumberModel(MIN_FACES, MIN_FACES, MAX_FACES, 1)); // Changer par les valeurs par défauts
		this.maximalFaceSpinner = new JSpinner(new SpinnerNumberModel(MAX_FACES, MIN_FACES, MAX_FACES, 1)); // Changer par les valeurs par défauts

		// Labels
		this.labelMin = new JLabel("Min.");
		this.labelMax = new JLabel("Max.");

		add(Box.createHorizontalStrut(SMALL_MARGE));
		add(new JCenter(this.labelMin));
		add(Box.createHorizontalStrut(SMALL_MARGE));
		add(new JCenter(this.minimalFaceSpinner));
		add(Box.createHorizontalStrut(BIG_MARGE));
		add(new JCenter(this.labelMax));
		add(Box.createHorizontalStrut(SMALL_MARGE));
		add(new JCenter(this.maximalFaceSpinner));
		}

	private void control()
		{
		// Permet aux spinners d'être cohérents
		this.minimalFaceSpinner.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				if ((int)minimalFaceSpinner.getValue() >= (int)maximalFaceSpinner.getValue())
					{
					minimalFaceSpinner.setValue((int)maximalFaceSpinner.getValue() - 1);
					}
				jInputs.setNbFace((int)minimalFaceSpinner.getValue(), (int)maximalFaceSpinner.getValue());
				}
			});
		this.maximalFaceSpinner.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				if ((int)maximalFaceSpinner.getValue() <= (int)minimalFaceSpinner.getValue())
					{
					maximalFaceSpinner.setValue((int)minimalFaceSpinner.getValue() + 1);
					}
				jInputs.setNbFace((int)minimalFaceSpinner.getValue(), (int)maximalFaceSpinner.getValue());
				}
			});
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Nb. de faces"));

		Sizes.setWidth(minimalFaceSpinner, 50);
		Sizes.setHeight(minimalFaceSpinner, 30);
		Sizes.setWidth(maximalFaceSpinner, 50);
		Sizes.setHeight(maximalFaceSpinner, 30);

		// Police d'écriture
		this.font = new Font("Helvetica", Font.PLAIN, 16);
		minimalFaceSpinner.setFont(font);
		maximalFaceSpinner.setFont(font);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JSpinner minimalFaceSpinner;
	private JSpinner maximalFaceSpinner;

	// Outputs
	private JLabel labelMin;
	private JLabel labelMax;

	// Tools
	private JInputs jInputs;
	private Font font;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int MIN_FACES = DiceVariableService.getInstance().getDiceVariableInputs().NB_FACE_MIN;
	private static final int MAX_FACES = DiceVariableService.getInstance().getDiceVariableInputs().NB_FACE_MAX;

	private static final int SMALL_MARGE = 5;
	private static final int BIG_MARGE = 15;

	}
