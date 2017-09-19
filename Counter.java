package assign6;

import java.util.concurrent.locks.*;

/**
 * Maintains a running count of integers
 * @author Steve Martel
 */
public class Counter {

	private int count; // total running count
	private Lock lock = new ReentrantLock(); // Lock to ensure thread safety
	
	/**
	 * Default constructor for Counter
	 */
	public Counter() {}
	
	/**
	 * Adds one to the running count of integers
	 */
	public void addOne(){
		lock.lock();
		try {
			++count;
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * Returns total count
	 * @return the total integer count
	 */
	public int getCount(){
		return count;
	}

}
