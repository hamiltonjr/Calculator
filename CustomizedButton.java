/**
 * This class implements a customized button for calculator project. It is part of a reprogramming of
 * Calculator Project using better object-oriented practices.
 * 
 * @author Hamilton G. Jr (hamiltonjr2010@gmail.com)
 * @version 2.0 (2018 11 26)
 */
package calculator;

import java.awt.Color;
import javax.swing.JButton;

public class CustomizedButton {
	// colors
	private static final Color F = Color.WHITE;
	private static final Color B = Color.BLACK;
	// dimension
	private static final int W = 60;
	private static final int H = 50;
	// button
	private JButton btn;
	
	// constructor
	public CustomizedButton(String key, int x, int y) {
		btn = new JButton(key);
		btn.setForeground(F);
		btn.setBackground(B);
		btn.setBounds(x, y, W, H);
	}
	
	// getter
	public JButton getButton() {
		return btn;
	}
}