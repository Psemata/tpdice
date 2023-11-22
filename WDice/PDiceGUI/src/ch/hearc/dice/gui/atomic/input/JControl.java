
package ch.hearc.dice.gui.atomic.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.tools.ShopImage;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JControl extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JControl(JInputs jInputs)
		{
		super(BoxLayout.Y_AXIS);
		this.jInputs = jInputs;

		geometry();
		control();
		appearance();

		stopDisable();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void startDisable()
		{
		this.boutonStart.setEnabled(false);
		this.boutonKill.setEnabled(true);
		this.boutonStop.setEnabled(true);
		}

	public void stopDisable()
		{
		this.boutonStart.setEnabled(true);
		this.boutonKill.setEnabled(false);
		this.boutonStop.setEnabled(false);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// Initialisation des 3 boutons principaux
		this.boutonStart = new JButton("Start", ShopImage.PLAY);
		this.boutonStop = new JButton("Stop", ShopImage.STOP);
		this.boutonKill = new JButton("Kill", ShopImage.KILL);

		add(Box.createVerticalStrut(SMALL_SPACE));
		add(boutonStart);
		add(Box.createVerticalStrut(BIG_SPACE));
		add(boutonStop);
		add(Box.createVerticalStrut(BIG_SPACE));
		add(boutonKill);
		add(Box.createVerticalStrut(SMALL_SPACE));
		}

	private void control()
		{
		this.boutonStart.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// Lance le calcul des dés
				DiceVariableService.getInstance().start();
				startDisable();
				jInputs.disable();
				}
			});

		this.boutonStop.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// Stop doucement le calcul des dés
				DiceVariableService.getInstance().stop();
				stopDisable();
				jInputs.enable();
				}
			});

		this.boutonKill.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// Tue le calcul des dés
				DiceVariableService.getInstance().kill();
				stopDisable();
				jInputs.enable();
				}
			});

		// Quand le processus se termine de lui même, redonner l'accès aux inputs
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServiceCreated(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{
						if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
							{
							stopDisable();
							jInputs.enable();
							DiceVariableService.getInstance().onEnd();
							}
						}
					});
				}
			});
		}

	private void appearance()
		{
		Sizes.setWidth(boutonStart, 200);
		Sizes.setWidth(boutonStop, 200);
		Sizes.setWidth(boutonKill, 200);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JButton boutonStart;
	private JButton boutonStop;
	private JButton boutonKill;
	private JInputs jInputs;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int SMALL_SPACE = 5;
	private static final int BIG_SPACE = 10;

	private static final int BUTTON_ICON_SIZE = 20;

	}
