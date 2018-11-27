/**
 * This class implements a customized keyboard for calculator project. It is part of a reprogramming of
 * Calculator Project using better object-oriented practices.
 * 
 * @author Hamilton G. Jr (hamiltonjr2010@gmail.com)
 * @version 2.0 (2018 11 26)
 */
package calculator;

import javax.swing.JButton;

public class Keyboard implements Customizable {
	private static final int X = PADDING;
	private static final int Y = 68;
	
	private static final int COLUMN_1 = X;
	private static final int LINE_1 = Y;
	private static final int COLUMN_2 = X + WIDTH + PADDING;
	private static final int LINE_2 = Y + HEIGHT + PADDING;
	private static final int COLUMN_3 = X + 2*(WIDTH + PADDING);
	private static final int LINE_3 = Y + 2*(HEIGHT + PADDING);
	private static final int COLUMN_4 = X + 3*(WIDTH + PADDING);
	private static final int LINE_4 = Y + 3*(HEIGHT + PADDING);
	private static final int LINE_5 = Y + 4*(HEIGHT + PADDING);

	private JButton[] btn;
	
	public Keyboard() {
		btn = new JButton[20];
		
		// 0-9 digits
		btn[0] = new CustomizedButton("0", COLUMN_1, LINE_5).getButton();
		btn[1] = new CustomizedButton("1", COLUMN_1, LINE_4).getButton();
		btn[2] = new CustomizedButton("2", COLUMN_2, LINE_4).getButton();
		btn[3] = new CustomizedButton("3", COLUMN_3, LINE_4).getButton();
		btn[4] = new CustomizedButton("4", COLUMN_1, LINE_3).getButton();
		btn[5] = new CustomizedButton("5", COLUMN_2, LINE_3).getButton();
		btn[6] = new CustomizedButton("6", COLUMN_3, LINE_3).getButton();
		btn[7] = new CustomizedButton("7", COLUMN_1, LINE_2).getButton();
		btn[8] = new CustomizedButton("8", COLUMN_2, LINE_2).getButton();
		btn[9] = new CustomizedButton("9", COLUMN_3, LINE_2).getButton();

		// operator signals
		btn[10] = new CustomizedButton("+", COLUMN_4, LINE_1).getButton();
		btn[11] = new CustomizedButton("-", COLUMN_4, LINE_2).getButton();
		btn[12] = new CustomizedButton("X", COLUMN_4, LINE_3).getButton();
		btn[13] = new CustomizedButton("/", COLUMN_4, LINE_4).getButton();
		btn[14] = new CustomizedButton("=", COLUMN_4, LINE_5).getButton();
		
		// auxiliary buttons
		btn[15] = new CustomizedButton(".", COLUMN_2, LINE_5).getButton();
		btn[16] = new CustomizedButton("+/-", COLUMN_3, LINE_5).getButton();
		btn[17] = new CustomizedButton("\u2190", COLUMN_1, LINE_1).getButton();
		btn[18] = new CustomizedButton("C", COLUMN_2, LINE_1).getButton();
		btn[19] = new CustomizedButton("%", COLUMN_3, LINE_1).getButton();
	}
	
	// getter
	public JButton[] getBtn() { return btn; }
}