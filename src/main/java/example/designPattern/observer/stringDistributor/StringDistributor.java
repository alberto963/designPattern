package example.designPattern.observer.stringDistributor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable; //Observable is here
import java.util.Observer;

@SuppressWarnings("deprecation")
class EventSource extends Observable implements Runnable {
	public void run() {
		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader br = new BufferedReader(isr);
			while (true) {
				String response = br.readLine();
				setChanged();
				notifyObservers(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("deprecation")
class ResponseHandler implements Observer {
	private String resp;

	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			resp = (String) arg;
			System.out.println("\nReceived Response: " + resp);
		}
	}
}

public class StringDistributor {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		System.out.println("Enter Text >");

		// create an event source - reads from stdin
		final EventSource evSrc = new EventSource();

		// create an observer
		final ResponseHandler respHandler = new ResponseHandler();

		// subscribe the observer to the event source
		evSrc.addObserver(respHandler);

		// starts the event thread
		Thread thread = new Thread(evSrc);
		thread.start();
	}
}
