
package ch.hearc.dice.gui.atomic.display.clock;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JTimerDigit extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerDigit()
		{

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setTime(int h, int m, int s)
		{
		String hS = (h < 10) ? "0" + h : Integer.toString(h);
		String mS = (m < 10) ? "0" + m : Integer.toString(m);
		String sS = (s < 10) ? "0" + s : Integer.toString(s);

		this.timeLabel.setText(hS + "." + mS + "." + sS);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.timeLabel = new JLabel();
		setTime(0, 0, 0);

		setLayout(new FlowLayout());
		add(timeLabel);
		}

	private void control()
		{
		}

	private void appearance()
		{
		this.font = new Font("Helvetica", Font.BOLD, 45);
		this.timeLabel.setFont(font);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JLabel timeLabel;
	private Font font;

	}
