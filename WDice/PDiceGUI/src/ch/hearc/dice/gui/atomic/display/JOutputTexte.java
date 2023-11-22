
package ch.hearc.dice.gui.atomic.display;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JOutputTexte extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JOutputTexte()
		{
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
		String[] columns = { "Nb. de faces", "Nb. de lancers" };
		this.model = new DefaultTableModel(0, columns.length);
		this.model.setColumnIdentifiers(columns);

		this.jtable = new JTable(model);
		this.jtable.setEnabled(false);

		this.jScrollPane = new JScrollPane(this.jtable);

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		add(jtable.getTableHeader(), BorderLayout.PAGE_START);
		add(this.jScrollPane, BorderLayout.CENTER);
		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServiceCreated(DiceVariableServiceEvent diceVariableServiceEvent)
				{

				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED)
					{
					// Efface l'affichage
					model.setRowCount(0);
					}

				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{

						if (iterationEvent.getI() != -1)
							{
							// Récupère les données calculées
							Map<Integer, Integer> lancers = diceVariableServiceEvent.getCurrentDiceVariable().getMapFaceLancer();

							int face = iterationEvent.getI() + diceVariableServiceEvent.getDiceVariableInputs().nbFace.getA();
							int lancer = lancers.get(face);

							model.addRow(new Object[] { face, lancer });
							}
						}
					});

				}
			});
		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JTable jtable;
	private DefaultTableModel model;
	private JScrollPane jScrollPane;
	}
