
package ch.hearc.dice.gui.tools;

import javax.swing.ImageIcon;

import ch.hearc.c_gui.tools.ImageLoader;

public class ShopImage
	{

	private static final String PATH_IN_JAR = "ressource/TPDice/";

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon KILL = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "kill.png");
	public static final ImageIcon LOGO_HE_ARC = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "logo-he-arc.png");
	public static final ImageIcon PLAY = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "play.png");
	public static final ImageIcon STOP = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "stop.png");
	public static final ImageIcon ICON = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "dice.png");

	}
