
package ch.hearc.dice.moo.specification;

import java.util.Map;

import ch.hearc.b_poo.thread.vecteur.Intervalle;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.AlgoIteratif_I;

public interface DiceVariable_I extends AlgoIteratif_I
	{

	// Outputs
	public Map<Integer, Integer> getMapFaceLancer();
	public Map<Integer, Chrono> getMapFaceChrono();

	// Inputs
	public Intervalle getNbFaces();
	public int getNbExperience();
	}
