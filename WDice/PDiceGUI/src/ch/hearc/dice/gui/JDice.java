
package ch.hearc.dice.gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ch.hearc.c_gui.tools.JMarge;
import ch.hearc.dice.gui.atomic.display.JDisplay;
import ch.hearc.dice.gui.tools.ShopImage;

/**
 * singleton
 */
public class JDice extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private JDice(JComponent jComponent)
		{
		this.jComponent = jComponent;

		geometry();
		control();
		appearance();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized JDice getInstance()
		{
		if (instance == null)
			{
			instance = new JDice(new JMarge(new JDisplay(), MARGE));
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		setLayout(new BorderLayout());
		add(this.jComponent, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(1280, 820);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("TPDice - Bruno Costa, Diogo Lopes Da Silva, Loïc Frossard");
		setIconImage(ShopImage.ICON.getImage());
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jComponent;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static JDice instance = null;
	public static final int MARGE = 8;

	// Tools

	// Output

	}
