
package ch.hearc.dice.gui.atomic.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import ch.hearc.dice.moo.implementation.app.TypeProcessing;

public class JTypeProcessing extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTypeProcessing(JInputs jInputs)
		{
		super(BoxLayout.Y_AXIS);
		this.jInputs = jInputs;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void disable()
		{
		this.radioSequentiel.setEnabled(false);
		this.radioRunnable.setEnabled(false);
		this.radioParallele.setEnabled(false);
		}

	@Override
	public void enable()
		{
		this.radioSequentiel.setEnabled(true);
		this.radioRunnable.setEnabled(true);
		this.radioParallele.setEnabled(true);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.radioSequentiel = new JRadioButton("Séquentiel");
		this.radioRunnable = new JRadioButton("Runnable");
		this.radioParallele = new JRadioButton("Paralèlle");

		add(Box.createVerticalStrut(MARGE));
		add(this.radioSequentiel);
		add(Box.createVerticalStrut(MARGE));
		add(this.radioRunnable);
		add(Box.createVerticalStrut(MARGE));
		add(this.radioParallele);
		add(Box.createVerticalStrut(MARGE));
		}

	private void control()
		{
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(this.radioSequentiel);
		radioGroup.add(this.radioRunnable);
		radioGroup.add(this.radioParallele);

		this.radioSequentiel.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jInputs.setTypeProcessing(TypeProcessing.SEQUENTIEL);

				}
			});

		this.radioRunnable.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jInputs.setTypeProcessing(TypeProcessing.RUNNABLE);

				}
			});

		this.radioParallele.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jInputs.setTypeProcessing(TypeProcessing.PARALLELE);

				}
			});

		this.radioSequentiel.doClick();
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Processus"));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JRadioButton radioSequentiel;
	private JRadioButton radioRunnable;
	private JRadioButton radioParallele;

	// Tools
	private JInputs jInputs;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int MARGE = 4;

	}
