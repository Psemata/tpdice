
package ch.hearc.dice.moo.implementation.app;

import java.util.Map;
import java.util.TreeMap;

import ch.hearc.b_poo.thread.vecteur.Intervalle;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.AlgoIteratif_A;

public class DiceVariable extends AlgoIteratif_A implements DiceVariable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariable(DiceVariableInputs diceVariableInputs)
		{
		this.diceVariableInputs = diceVariableInputs;
		this.tabDices = new Dice[diceVariableInputs.getSize()]; // Création de la liste de dés
		this.mapFaceLancer = new TreeMap<Integer, Integer>();
		this.mapFaceChrono = new TreeMap<Integer, Chrono>();

		// Création des dés utilisés pour résoudre le problème pour chaque nb de faces entre l'intervalle définit dans diceVariableInputs
		for(int i = 0; i < tabDices.length; i++)
			{
			tabDices[i] = (new Dice(this.diceVariableInputs.nbExperience, this.diceVariableInputs.nbFace.getA() + i));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();

		int face = this.diceVariableInputs.nbFace.getA();

		for(Dice dice:tabDices)
			{
			builder.append("Un dé à ");
			builder.append(face++);
			builder.append(" faces, demande en moyenne ");
			builder.append(dice.getNbLancerMoyen());
			builder.append(" lancers\n");
			}

		return builder.toString();
		}

	@Override
	public void iterationStep(int i)
		{
		Chrono chrono = new Chrono();
		chrono.start();
		tabDices[i].run();
		chrono.stop();
		mapFaceLancer.put(tabDices[i].getNbFace(), tabDices[i].getNbLancerMoyen());
		mapFaceChrono.put(tabDices[i].getNbFace(), chrono);
		}

	@Override
	public boolean isFini(int i)
		{
		if (i == tabDices.length)
			{ return true; }
		return false;
		}

	@Override
	public void onBegin()
		{
		// Rien
		}

	@Override
	public void onEnd()
		{
		// Rien
		}

	@Override
	public Map<Integer, Integer> getMapFaceLancer()
		{
		return this.mapFaceLancer;
		}

	@Override
	public Map<Integer, Chrono> getMapFaceChrono()
		{
		return this.mapFaceChrono;
		}

	@Override
	public Intervalle getNbFaces()
		{
		return diceVariableInputs.nbFace;
		}

	@Override
	public int getNbExperience()
		{
		return diceVariableInputs.nbExperience;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private DiceVariableInputs diceVariableInputs;

	// tools
	private Dice[] tabDices;
	private Map<Integer, Integer> mapFaceLancer;
	private Map<Integer, Chrono> mapFaceChrono;

	}
