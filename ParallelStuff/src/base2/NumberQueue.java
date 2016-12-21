package base2;

public class NumberQueue 
{
	private int n = 1;
	private static final int MAX = Integer.MAX_VALUE;
	private boolean done = false;
	
	public synchronized int getNumber()
	{
		int temp = n;
		if(n < MAX)
			n++;
		else
			done = !done;
		return temp;
	}
	
	public synchronized boolean finished()
	{
		return done;
	}
}
