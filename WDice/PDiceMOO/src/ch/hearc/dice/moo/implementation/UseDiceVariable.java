
package ch.hearc.dice.moo.implementation;

import ch.hearc.b_poo.thread.vecteur.Intervalle;
import ch.hearc.dice.moo.implementation.app.DiceVariable;
import ch.hearc.dice.moo.implementation.app.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;

public class UseDiceVariable
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		Intervalle intervalle = new Intervalle(6, 30);
		DiceVariableInputs dvi = new DiceVariableInputs(intervalle, 1000, TypeProcessing.PARALLELE);

		DiceVariable diceVariable = new DiceVariable(dvi);

		for(int i = 0; i < dvi.getSize(); i++)
			{
			diceVariable.iterationStep(i);
			}

		System.out.println(diceVariable.toString());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
