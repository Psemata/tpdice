
package ch.hearc.dice.gui.atomic.display.graph;

import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JGrapheLancerMoyen
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JGrapheLancerMoyen()
		{
		datasetMoyen = new DefaultCategoryDataset();
		barChartMoyen = ChartFactory.createBarChart("Moyen", " Nombres Faces", "Nombres Lancer", datasetMoyen);
		chartPanelMoyen = new ChartPanel(barChartMoyen);
		DiceListener();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public ChartPanel getChartPanel()
		{
		return chartPanelMoyen;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void DiceListener()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServiceCreated(DiceVariableServiceEvent diceVariableServiceEvent)
				{

				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED)
					{
					datasetMoyen.clear();
					}

				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{
						if (iterationEvent.getI() != -1)
							{
							//Récupère les données calculées
							Map<Integer, Integer> lancers = diceVariableServiceEvent.getCurrentDiceVariable().getMapFaceLancer();

							int face = iterationEvent.getI() + diceVariableServiceEvent.getDiceVariableInputs().nbFace.getA();
							int lancer = lancers.get(face);

							datasetMoyen.addValue(lancer, "Nombre de lancer pour avoir toutes les faces", Integer.valueOf(face));
							}
						}
					});
				}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	JFreeChart barChartMoyen;
	DefaultCategoryDataset datasetMoyen;
	ChartPanel chartPanelMoyen;
	}
