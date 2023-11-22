
package ch.hearc.dice.gui.atomic.display;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import ch.hearc.c_gui.tools.JCenterH;
import ch.hearc.dice.gui.atomic.display.graph.JGraphes;
import ch.hearc.dice.gui.tools.ShopImage;

public class JMain extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JMain()
		{
		super(BoxLayout.Y_AXIS);

		geometry();
		control();
		appearance();
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
		this.jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.jTabbedPane = new JTabbedPane();
		this.jOutputTexte = new JOutputTexte();
		this.jGraph = new JGraphes();

		this.jTabbedPane.addTab("Résultats", ShopImage.ICON, jOutputTexte);

		this.jSplitPane.setLeftComponent(this.jTabbedPane);
		this.jSplitPane.setRightComponent(this.jGraph);

		this.jlabelLogo = new JLabel(ShopImage.LOGO_HE_ARC);

		add(new JCenterH(this.jSplitPane));
		add(Box.createVerticalStrut(10));
		add(new JCenterH(this.jlabelLogo));
		}

	private void control()
		{
		this.jSplitPane.setOneTouchExpandable(true);
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
	private JSplitPane jSplitPane;
	private JLabel jLabelTabIcon;
	private JTabbedPane jTabbedPane;
	private JOutputTexte jOutputTexte;
	private JGraphes jGraph;
	private JLabel jlabelLogo;
	}
