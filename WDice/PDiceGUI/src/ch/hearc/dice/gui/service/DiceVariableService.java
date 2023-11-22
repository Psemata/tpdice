
package ch.hearc.dice.gui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Assertions;

import ch.hearc.dice.moo.implementation.app.DiceVariableInputs;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;

/**
 * singleton
 */
public class DiceVariableService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private DiceVariableService()
		{
		this.listDiceVariableServiceListener = new ArrayList<DiceVariableServiceListener>();
		this.diceVariableInputs = new DiceVariableInputs();
		this.isStarted = new AtomicBoolean(false);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized DiceVariableService getInstance()
		{
		if (instance == null)
			{
			instance = new DiceVariableService();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public DiceVariable_I getCurrentDiceVariable()
		{
		return currentDiceVariable;
		}

	public DiceVariableInputs getDiceVariableInputs()
		{
		return this.diceVariableInputs;
		}

	public void setInputs(DiceVariableInputs diceVariableInputs)
		{
		this.diceVariableInputs = diceVariableInputs;
		}

	// Listener
	public synchronized void addDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.add(diceVariableServiceListener);
		}

	public synchronized void removeDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.remove(diceVariableServiceListener);
		}

	/*--------------------------------------*\
	|*			  start/stop/kill			*|
	\*--------------------------------------*/

	public synchronized void onEnd()
		{
		if (isStarted.get())
			{
			isStarted.set(false);
			}
		}

	public synchronized DiceVariable_I start()
		{
		Assertions.assertTrue(this.diceVariableInputs != null);
		if (!isStarted.get())
			{
			this.currentDiceVariable = FactoryDiceVariable.create(this.diceVariableInputs);
			this.calculThread = new Thread(this.currentDiceVariable);
			this.calculThread.start();
			avertirDiceVariableListener(new DiceVariableServiceEvent(this, currentDiceVariable, diceVariableInputs, LifeCycle.CREATED));
			this.isStarted.set(true);
			return this.currentDiceVariable;
			}
		else
			{
			System.err.println("Le thread de calcul n'a pas pu se lancer correctement");
			return null;
			}
		}

	public synchronized void stop()
		{
		if (isStarted.get())
			{
			this.currentDiceVariable.stop();
			avertirDiceVariableListener(new DiceVariableServiceEvent(this, currentDiceVariable, diceVariableInputs, LifeCycle.STOPPED));
			this.isStarted.set(false);
			}
		else
			{
			System.err.println("Le thread ne s'est pas stoppé correctement");
			}
		}

	public synchronized void kill()
		{
		if (isStarted.get())
			{
			this.calculThread.stop();
			avertirDiceVariableListener(new DiceVariableServiceEvent(this, currentDiceVariable, diceVariableInputs, LifeCycle.KILLED));
			this.isStarted.set(false);
			}
		else
			{
			System.err.println("Le thread n'a pas été tué correctemenet");
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private synchronized void avertirDiceVariableListener(DiceVariableServiceEvent diceVariableEvent)
		{
		for(DiceVariableServiceListener diceVariableServiceListener:listDiceVariableServiceListener)
			{
			diceVariableServiceListener.diceVariableServiceCreated(diceVariableEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private DiceVariable_I currentDiceVariable;
	private List<DiceVariableServiceListener> listDiceVariableServiceListener;
	private AtomicBoolean isStarted;
	private Thread calculThread;

	// Inputs
	private DiceVariableInputs diceVariableInputs;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static DiceVariableService instance = null;

	}
