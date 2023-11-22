
package ch.hearc.dice.moo.implementation;

import ch.hearc.b_poo.thread.vecteur.Intervalle;
import ch.hearc.dice.moo.implementation.app.DiceVariableInputs;
import ch.hearc.dice.moo.implementation.app.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class UseDiceVariableListener
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
		DiceVariable_I diceVariable = FactoryDiceVariable.create(new DiceVariableInputs(new Intervalle(6, 30), 1000, TypeProcessing.PARALLELE));

		IterationListener iterationListener = new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.BEGIN)
					{
					System.out.println("L'algorithme commence");
					}
				else if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
					{
					System.out.println("L'algorithme est terminé");
					System.out.println(diceVariable.toString());
					}
				else
					{
					double pourcentage = (iterationEvent.getI() + 1) / (double)(diceVariable.getNbFaces().getB() - diceVariable.getNbFaces().getA());
					pourcentage = 100 * Math.round(pourcentage * 10000.0) / 10000.0;
					System.out.println("L'algorithme est à " + pourcentage + "% fini");
					}
				}
			};

		diceVariable.addIterationListener(iterationListener);

		diceVariable.run();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
