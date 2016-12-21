package prime;

public class MyPrimeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//int[] test = new int[(Integer.MAX_VALUE - 8) / 2];
		if (args.length < 3) {
			System.out.println("Usage: MyPrimeTest numThread low high \n");
			return;
		}
		int nthreads = Integer.parseInt(args[0]);
		int low = Integer.parseInt(args[1]);
		int high = Integer.parseInt(args[2]);
		Counter c = new Counter();
		
		//test cost of serial code
		long start = System.currentTimeMillis();
		int numPrimeSerial = SerialPrime.numSerailPrimes(low, high);
		long end = System.currentTimeMillis();
		long timeCostSer = end - start;
		System.out.println("Time cost of serial code: " + timeCostSer + " ms.");
		
		//test of concurrent code
		// **************************************
        // Write me here
		long timeCostCon = 0;
		int r = (high - low + 1) % nthreads;
		int length = (high - low + 1) / nthreads;
		ThreadPrime[] threads = new ThreadPrime[nthreads];
		start = System.currentTimeMillis();
		for(int i = 0; i < threads.length; i++)
		{
			int tstart = length * i + low;
			int tend = tstart + length - 1;
			if(r > 0 && i == threads.length - 1)
				tend += r;
			threads[i] = new ThreadPrime(tstart, tend, c);
			threads[i].start();
		}
		for(ThreadPrime t : threads)
			t.join();
		end = System.currentTimeMillis();
		timeCostCon = end - start;
		// **************************************
		System.out.println("Time cost of parallel code: " + timeCostCon + " ms.");
		System.out.format("The speedup ration is by using concurrent programming: %5.2f. %n", (double)timeCostSer / timeCostCon);
		
		System.out.println("Number prime found by serial code is: " + numPrimeSerial);
		System.out.println("Number prime found by parallel code is " + c.total());
	}


}
