/**
 * This class implements te main method of the calculator project. It is part of a reprogramming of
 * Calculator Project using better oriented0object practices.
 * 
 * @author Hamilton G. Jr (hamiltonjr2010@gmail.com)
 * @version 2.0 (2018 11 26)
 */
package calculator;

import java.awt.EventQueue;

public class Main {
	// buttons dimension (public)
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}