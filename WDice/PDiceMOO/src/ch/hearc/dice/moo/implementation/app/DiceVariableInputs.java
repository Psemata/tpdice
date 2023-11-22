
package ch.hearc.dice.moo.implementation.app;

import ch.hearc.b_poo.thread.vecteur.Intervalle;

public class DiceVariableInputs
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Constructeur - "standard plein"
	 */
	public DiceVariableInputs(Intervalle nbFace, int nbExperience, TypeProcessing typeProcessing)
		{
		this.nbFace = nbFace;
		this.nbExperience = nbExperience;
		this.typeProcessing = typeProcessing;
		}

	/**
	 * Constructeur - "vide"
	 */
	public DiceVariableInputs()
		{
		this(new Intervalle(NB_FACE_MIN, NB_FACE_MAX), NB_EXPERIENCE, TypeProcessing.PARALLELE);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	public int getSize()
		{
		return nbFace.getB() - nbFace.getA();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Public						*|
	\*------------------------------------------------------------------*/

	public Intervalle nbFace;
	public int nbExperience;
	public TypeProcessing typeProcessing;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int NB_FACE_MIN = 6;
	public static final int NB_FACE_MAX = 200;
	public static final int NB_EXPERIENCE = Integer.MAX_VALUE / 100;
	}
