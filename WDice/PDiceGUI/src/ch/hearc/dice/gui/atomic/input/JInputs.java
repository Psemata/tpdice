
package ch.hearc.dice.gui.atomic.input;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ch.hearc.b_poo.thread.vecteur.Intervalle;
import ch.hearc.c_gui.tools.JCenterH;
import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.atomic.display.clock.JTimer;
import ch.hearc.dice.gui.atomic.display.progressbar.JProgressBars;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.moo.implementation.app.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;

public class JInputs extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JInputs()
		{
		super(BoxLayout.Y_AXIS);
		this.diceVariableInputs = new DiceVariableInputs();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbExperience(int nbExperience)
		{
		this.diceVariableInputs.nbExperience = nbExperience;
		DiceVariableService.getInstance().setInputs(diceVariableInputs);
		}

	public void setNbFace(int min, int max)
		{
		this.diceVariableInputs.nbFace = new Intervalle(min, max);
		}

	public void setTypeProcessing(TypeProcessing type)
		{
		this.diceVariableInputs.typeProcessing = type;
		}

	@Override
	public void disable()
		{
		this.jNbFace.disable();
		this.jNbExperience.disable();
		this.jTypeProcessing.disable();
		}

	@Override
	public void enable()
		{
		this.jNbFace.enable();
		this.jNbExperience.enable();
		this.jTypeProcessing.enable();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jNbFace = new JNbFace(this);
		this.jNbExperience = new JNbExperience(this);
		this.jTypeProcessing = new JTypeProcessing(this);
		this.jTimer = new JTimer();
		this.jProgressBars = new JProgressBars();
		this.jControl = new JControl(this);

		add(new JCenterH(this.jNbFace));
		add(Box.createVerticalStrut(5));
		add(new JCenterH(this.jNbExperience));
		add(Box.createVerticalStrut(5));
		add(new JCenterH(this.jTypeProcessing));
		add(Box.createVerticalStrut(5));
		add(new JCenterH(this.jTimer));
		add(Box.createVerticalStrut(5));
		add(new JCenterH(this.jProgressBars));
		add(Box.createVerticalGlue());
		add(new JCenterH(this.jControl));
		}

	private void control()
		{
		}

	private void appearance()
		{

		Sizes.setHeight(jNbFace, 80);
		Sizes.setWidth(jNbFace, 200);

		Sizes.setHeight(jNbExperience, 80);
		Sizes.setWidth(jNbExperience, 200);

		Sizes.setHeight(jTypeProcessing, 110);
		Sizes.setWidth(jTypeProcessing, 200);

		Sizes.setHeight(jTimer, 300);
		Sizes.setWidth(jTimer, 200);

		Sizes.setHeight(jControl, 110);
		Sizes.setWidth(jControl, 200);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JLabel jlabelLogo;
	private JNbFace jNbFace;
	private JNbExperience jNbExperience;
	private JTypeProcessing jTypeProcessing;
	private JProgressBars jProgressBars;

	// Tools
	private JControl jControl;
	private DiceVariableInputs diceVariableInputs;
	private JTimer jTimer;
	}
