package assign6;

import java.io.*;


/**
 * Given a text file, an integer count of words (letters separated by spaces) 
 * will be maintained and returned
 * @author Steve Martel
 */
public class TextReader implements Runnable{
	
	private int wordCount; // total count of words per file
	private BufferedReader reader = null;	
	private Counter counter; // counter used to maintain count of all files read
	File file;

	/**
	 * Constructor for TextReader class
	 * @param input the text file to be read
	 * @param aCounter the Counter object used for running tally of all files
	 * @throws Exception for file errors
	 */
	public TextReader(File input, Counter aCounter) throws Exception{
		counter = aCounter;
		file = input;		
		reader = new BufferedReader(new FileReader(file));
	}
	
	/**
	 * Primary method for reading files, configured for use with multiple threads
	 */
	public void run() {		
		wordCount = 0; // reset word count
		
		try {
			String line = reader.readLine(); 
		
			// count lines until end is reached
			while (line != null) { 
				String []parts = line.split(" "); 
				for( String word : parts){
					wordCount++;
					counter.addOne(); // increment running tally
				}
				line = reader.readLine(); 
			}
			reader.close();
		} catch(IOException ie){
			ie.printStackTrace();
		}
		System.out.println(file + ": " + getCount());
	}
	
	/**
	 * Getter for word count
	 * @return word count for given file
	 */
	public int getCount(){
		return wordCount;
	}
}
