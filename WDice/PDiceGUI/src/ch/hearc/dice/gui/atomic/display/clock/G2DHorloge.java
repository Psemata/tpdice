
package ch.hearc.dice.gui.atomic.display.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class G2DHorloge
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public G2DHorloge(JComponent jComponent)
		{
		// Input
			{
			this.jComponent = jComponent;
			}

		// Tools
			{
			this.n = 60;
			// Graduation
			this.graduationSmall = new Rectangle2D.Double(-0.5, 0, 1, 10);
			this.graduationBig = new Rectangle2D.Double(-1.5, 0, 3, 25);
			// Aiguille
			this.needle = new Rectangle2D.Double();
			this.tip = new Ellipse2D.Double();
			}

		// Tools animation
			{
			this.dalpha = DALPHA;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	// Fait tourner l'aiguille
	public void rotate()
		{
		// Calcul de l'angle
		this.alpha += dalpha;
		this.jComponent.repaint();
		}

	// Reset le dessin de l'horloge
	public void reset()
		{
		this.alpha = 0;
		this.jComponent.repaint();
		}

	public void draw(Graphics2D g2d, int w, int h)
		{
		this.rayon = (int)(Math.min(w, h) / 2 * 0.9);

		center(g2d);

		// Fait une rotation basique pour avoir une aiguille verticale
		g2d.rotate(Math.PI);

		g2d.setPaint(Color.BLACK);
		for(int i = 0; i < n; i++)
			{
			if (i % 5 == 0)
				{
				g2d.translate(rayon, 0);
				g2d.rotate(Math.PI / 2);
				g2d.draw(this.graduationBig);
				g2d.fill(this.graduationBig);
				g2d.rotate(-(Math.PI / 2));
				g2d.translate(-rayon, 0);
				}
			else
				{
				g2d.translate(rayon, 0);
				g2d.rotate(Math.PI / 2);
				g2d.draw(this.graduationSmall);
				g2d.fill(this.graduationSmall);
				g2d.rotate(-(Math.PI / 2));
				g2d.translate(-rayon, 0);
				}

			g2d.rotate(Math.PI * 2 / n);
			}

		// Dessin et animation de l'aiguille
		g2d.rotate(alpha);

		this.needle.setRect(-1.5, -(rayon * 0.1), 3, rayon * 0.6);
		this.tip.setFrame(-7.5, -7.5, 15, 15);
		g2d.setPaint(Color.RED);
		g2d.draw(this.needle);
		g2d.fill(this.needle);
		g2d.translate(0, (rayon * 0.5) - 3);
		g2d.draw(this.tip);
		g2d.fill(this.tip);
		g2d.translate(0, -(rayon * 0.5) + 3);

		backToOrigin(g2d);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void center(Graphics2D g2d)
		{
		g2d.translate(this.jComponent.getWidth() / 2, this.jComponent.getHeight() / 2);
		}

	private void backToOrigin(Graphics g2d)
		{
		g2d.translate(-this.jComponent.getWidth() / 2, -this.jComponent.getHeight() / 2);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JComponent jComponent;

	// Tools graduation
	private Rectangle2D.Double graduationSmall;
	private Rectangle2D.Double graduationBig;

	// Tools aiguille
	private Rectangle2D.Double needle;
	private Ellipse2D.Double tip;

	private int rayon;
	private int n;

	// Tools animation
	private double alpha;
	private double dalpha;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int SLEEP_TIME_MS = 1000;
	private static final double DALPHA = Math.PI * 2 / 60;

	}
