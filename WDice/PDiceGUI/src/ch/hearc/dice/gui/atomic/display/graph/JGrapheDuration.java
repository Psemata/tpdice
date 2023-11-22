
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
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JGrapheDuration
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JGrapheDuration()
		{
		datasetTemps = new DefaultCategoryDataset();
		barChartTemps = ChartFactory.createBarChart("Temps", " Nombres Faces", "Temps pris [ms]", datasetTemps);
		chartPanelTemps = new ChartPanel(barChartTemps);
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
		return chartPanelTemps;
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
					datasetTemps.clear();
					}

				diceVariableServiceEvent.getCurrentDiceVariable().addIterationListener(new IterationListener()
					{

					@Override
					public void iterationPerformed(IterationEvent iterationEvent)
						{
						if (iterationEvent.getI() != -1)
							{
							//Récupère les données calculées
							Map<Integer, Chrono> temps = diceVariableServiceEvent.getCurrentDiceVariable().getMapFaceChrono();

							int face = iterationEvent.getI() + diceVariableServiceEvent.getDiceVariableInputs().nbFace.getA();
							Chrono tempsChrono = temps.get(face);
							datasetTemps.addValue(tempsChrono.getTimeMS(), "Durée prise pour avoir toutes les faces", Integer.valueOf(face));
							}
						}
					});
				}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JFreeChart barChartTemps;
	private DefaultCategoryDataset datasetTemps;
	private ChartPanel chartPanelTemps;
	}
