package base2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputQueue 
{
	private String[] Q;
	private static final String WIN_PATH = "C:\\Users\\Turner\\Destkop\\COMPUTE_RESULTS\\base2_concat";
	private static final String UNIX_PATH = "/home/turner/COMPUTE_RESULTS/base2_concat";
	private BufferedWriter out;
	public OutputQueue(int threads)
	{
		Q = new String[threads];
		String fname = "base2_concat_n=INT32_MAX.txt";
		String OS = System.getProperty("os.name");
		try
		{
			if(OS.toLowerCase().contains("windows"))
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
			else if(OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("nix"))
				out = new BufferedWriter(new FileWriter(UNIX_PATH + fname));
			else
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
	
	public OutputQueue(int threads, int range)
	{
		Q = new String[threads];
		String fname = "base2_concat_n="+range+".txt";
		String OS = System.getProperty("os.name");
		try
		{
			if(OS.toLowerCase().contains("windows"))
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
			else if(OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("nix"))
				out = new BufferedWriter(new FileWriter(UNIX_PATH + fname));
			else
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
	
	public OutputQueue(int threads, long range)
	{
		Q = new String[threads];
		String fname = "base2_concat_n="+range+".txt";
		String OS = System.getProperty("os.name");
		try
		{
			if(OS.toLowerCase().contains("windows"))
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
			else if(OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("nix"))
				out = new BufferedWriter(new FileWriter(UNIX_PATH + fname));
			else
				out = new BufferedWriter(new FileWriter(WIN_PATH + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
	
	public OutputQueue(int threads, String path)
	{
		Q = new String[threads];
		String fname = "base2_concat_n=INT32_MAX.txt";
		try
		{
			out = new BufferedWriter(new FileWriter(path + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
	
	public OutputQueue(int threads, int range, String path)
	{
		Q = new String[threads];
		String fname = "base2_concat_n="+range+".txt";
		try
		{
			out = new BufferedWriter(new FileWriter(path + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
	
	public OutputQueue(int threads, long range, String path)
	{
		Q = new String[threads];
		String fname = "base2_concat_n="+range+".txt";
		try
		{
			out = new BufferedWriter(new FileWriter(path + fname));
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}
}
