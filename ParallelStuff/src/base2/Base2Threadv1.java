package base2;

import java.math.BigInteger;
import java.util.concurrent.BrokenBarrierException;

public class Base2Threadv1 extends Thread
{
	private int start, end, step;
	private OutputQueue Q;
	public Base2Threadv1(int start, int end, int step, OutputQueue Q)
	{
		this.start = start;
		this.end = end;
		this.step = step;
		this.Q = Q;
	}
	
	public void run()
	{
		for(int i = start; i <= end; i += step)
		{
			//1. translate to concatenated powers of 2 expansion
			BigInteger N = new BigInteger("" + i);
			Q.insert(N.toString());
			try {
				Q.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
