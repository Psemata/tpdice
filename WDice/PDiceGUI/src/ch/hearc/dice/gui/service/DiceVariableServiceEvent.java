
package ch.hearc.dice.gui.service;

import ch.hearc.dice.moo.implementation.app.DiceVariableInputs;
import ch.hearc.dice.moo.specification.DiceVariable_I;

public class DiceVariableServiceEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariableServiceEvent(DiceVariableService source, DiceVariable_I currentDiceVariable, DiceVariableInputs diceVariableInputs, LifeCycle lifeCycle)
		{
		this.source = source;
		this.currentDiceVariable = currentDiceVariable;
		this.diceVariableInputs = diceVariableInputs;
		this.lifeCycle = lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public DiceVariableService getSource()
		{
		return this.source;
		}

	public DiceVariable_I getCurrentDiceVariable()
		{
		return this.currentDiceVariable;
		}

	public DiceVariableInputs getDiceVariableInputs()
		{
		return this.diceVariableInputs;
		}

	public LifeCycle getLifeCycle()
		{
		return this.lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs / Outputs
	private DiceVariableService source;
	private DiceVariable_I currentDiceVariable;
	private DiceVariableInputs diceVariableInputs;
	private LifeCycle lifeCycle;
	}
