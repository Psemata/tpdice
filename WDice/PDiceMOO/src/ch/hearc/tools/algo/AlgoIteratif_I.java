
package ch.hearc.tools.algo;

public interface AlgoIteratif_I extends Runnable
	{

	public void onBegin();

	public void iterationStep(int i);

	public void onEnd();

	public boolean isFini(int i);

	public void stop();

	public void addIterationListener(IterationListener iterationListener);

	public void removeIterationListener(IterationListener iterationListener);
	}
