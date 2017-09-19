package assign6;

import java.io.*;

/**
 * Driver class for TextReader and Counter
 * @author Steve Martel
 */
public class Driver {

	/**
	 * Main method for driver
	 * @param args command line arguements for text file names
	 * @throws Exception for file reading errors
	 */
	public static void main(String[] args) throws Exception{
		
		int numThreads = args.length; // total threads = total files
		Counter counter = new Counter();
		Thread[] threads = new Thread[numThreads];		
		File file = null;
		int index;
		
		for (index = 0; index < numThreads; ++index) { 
			file = new File(args[index]);
			Runnable textreader = new TextReader(file, counter);
			threads[index] = new Thread(textreader);
			threads[index].start();			
		}
		
		// waits for all threads to complete before getting grand total
		for(int i=0; i<args.length; i++) {
		    threads[i].join();
		}
		
		System.out.println("total words: " + counter.getCount());
	}
}
