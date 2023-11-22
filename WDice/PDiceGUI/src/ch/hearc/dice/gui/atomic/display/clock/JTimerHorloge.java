
package ch.hearc.dice.gui.atomic.display.clock;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class JTimerHorloge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerHorloge()
		{
		this.g2dhorloge = new G2DHorloge(this);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;

		AffineTransform backup = g2d.getTransform();

		g2dhorloge.draw(g2d, this.getWidth(), this.getHeight());

		g2d.setTransform(backup);
		}

	// Les paramètres ont été enlevés car pas d'utilité
	public void setTime()
		{
		this.g2dhorloge.rotate();
		}

	public void reset()
		{
		this.g2dhorloge.reset();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// rien
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private G2DHorloge g2dhorloge;
	}
