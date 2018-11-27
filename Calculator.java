/**
 * This class implements the  calculator. It is part of a reprogramming of  Calculator Project using better 
 * object-oriented practices.
 * 
 * @author Hamilton G. Jr (hamiltonjr2010@gmail.com)
 * @version 2.0 (2018 11 26)
 */
package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator implements Customizable {
	private static final int OUTPUT_SIZE = 14;	// maximum output width
	private double number1, number2;			// number for operations
	private char operator;						// operator used
	private boolean operand;					// is operand typing or not
	
	// interface
	private JFrame frame;						// calculator frame
	private JTextField output;					// calculator output (display)
	private Keyboard kb;						// calculator keyboard

	/**
	 * Create the application.
	 */
	public Calculator() {
		frame = new JFrame();					// frame start
		output = new JTextField("0");			// diaplay start
		kb = new Keyboard();					// keyboard start
		
		number1 = number2 = 0.0;				// numbers starting with 0
		operator = '=';							// operator starting with no operators (+,-,* or /)
		operand = true;							// calculation starting with operand typing

		initialize();
	}
	
	/**
	 * This code adjust for integers and shows in the display
	 * @param result
	 */
	public void show(double result) {
		String r = "" + result;
		// cut at right numbers with more than OUTPUT_SIZE digits
		if (r.length() > OUTPUT_SIZE)
			r = r.substring(0, OUTPUT_SIZE);
		
		// find the floating-point
		result = Double.parseDouble(r);
		int pos = r.indexOf(".");
		
		// cut zeroes at right
		if (pos >= 0)
			if (Math.floor(result) == result)
			r = r.substring(0, pos);
		
		// show result
		output.setText(r);
	}
	
	/**
	 * This code allows digit typing and clear the display when needed
	 */
	public void digitPressed(String digit) {
		if (operand  || (!operand && output.getText().equals("0"))) {
			output.setText("");
			operand = false;
		}
		
		if (output.getText().length() < OUTPUT_SIZE)
			output.setText(output.getText() + digit);		
	}
	
	/**
	 * This code executes the calculations
	 */
	public void executeOperation() {
		number2 = Double.parseDouble(output.getText());
		switch (operator) {
			case '+': number1 += number2; break;
			case '-': number1 -= number2; break;
			case '*': number1 *= number2; break;
			case '/': number1 /= number2; break;
		}
	}

	/**
	 * frame getter
	 * @return the frame
	 */
	public JFrame getFrame() { return frame; }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// set the frame
		frame.setTitle("Simple Calculator");
		frame.getContentPane().setForeground(Color.GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setBounds(100, 100, 8 + COLUMNS*WIDTH + (COLUMNS+1)*PADDING, 90 + LINES*HEIGHT + (LINES+1)*PADDING);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// set the display.
		output = new JTextField();
		output.setEditable(false);
		output.setForeground(Color.WHITE);
		output.setBackground(Color.BLACK);
		output.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		output.setHorizontalAlignment(SwingConstants.TRAILING);
		output.setText("0");
		output.setBounds(12, 11, 274, 45);
		output.setColumns(10);
		frame.getContentPane().add(output);

		// set the digit buttons (0-9) and its actions
		JButton[] btn = kb.getBtn();
		for (int i=0; i<10; i++) {
			String key = "" + i;
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					digitPressed(key);
				}
			});
			frame.getContentPane().add(btn[i]);
		}		
		
		// set the operator buttons (10-14) and its actions
		String signals = "+-*/=";
		for (int i=10; i<15; i++) {	
			char s = signals.charAt(i-10);
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (operator == '=') {
						number1 = Double.parseDouble(output.getText());
					} else {
						number2 = Double.parseDouble(output.getText());
						switch (operator) {
							case '+': number1 += number2; break;
							case '-': number1 -= number2; break;
							case '*': number1 *= number2; break;
							case '/': number1 /= number2; break;
						}						
					}
					show(number1);
					operator = s;
					operand = true;		
				}
			});
			frame.getContentPane().add(btn[i]);
		}
		
		// set the dot
		btn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (output.getText().equals("0") || output.getText().equals("") || operator != '=') {
					digitPressed("0");
					output.setText(output.getText() + ".");
				} else if ((output.getText().length() < OUTPUT_SIZE) && (output.getText().indexOf(".") == -1))
						output.setText(output.getText() + ".");
			}
		});
		frame.getContentPane().add(btn[15]);
		
		// set the +/- signal change 
		btn[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = output.getText();
				if (!s.equals("0")) 
					show((-1) * Double.parseDouble(s));
			}
		});
		frame.getContentPane().add(btn[16]);

		// set the backspace
		btn[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (output.getText().length() > 0)
					output.setText(output.getText().substring(0, output.getText().length() - 1));
				if ((output.getText().length() > 0) && (output.getText().indexOf(".") == output.getText().length()-1))
					output.setText(output.getText().substring(0, output.getText().length() - 1));
				if (output.getText().length() == 0) {
					output.setText("0");
					operand = true;
				}
			}
		});
		frame.getContentPane().add(btn[17]);
		
		// set the clear
		btn[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("0");
				number1 = number2 = 0.0;
				operand = true;
			}
		});
		frame.getContentPane().add(btn[18]);

		// set the % (percent)
		btn[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(output.getText());
				} else {
					number2 = Double.parseDouble(output.getText());
					switch (operator) {
						case '+': number1 += number1*number2/100; break;
						case '-': number1 -= number1*number2/100; break;
						case '*': number1 *= number2/100; break;
					}
				}
				show(number1);
				operator = '=';
				operand = true;
			}
		});
		frame.getContentPane().add(btn[19]);

	}
}