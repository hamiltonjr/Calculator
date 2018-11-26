/*
 * This code is a simple calculator implementation without MVC design pattern. It is result of study of Java GUI design using the
 * WindowBuilder Pro GUI Designer tool.
 */

package calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * This class implements the calculator itself.
 * @author Hamilton G. Jr (hamiltonjr2010@gmail.com) .
 *
 */
public class Calculator {
	private static final int OUTPUT_SIZE = 14;		// maximum nember length in the display (including point)
	private JFrame frmSimpleCalculator;				// the calculator GUI frame
	private JTextField txtOutput;					// the calculator diaplay
	private double number1, number2;				// the operands
	private char operator;							// the operator
	private boolean operand;						// operand flag
	private CustomizedButton btn;


	/**
	 * Launch the application (this is the main method).
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmSimpleCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application (this is the constructor of the calculator). It's contains all the initial configuration.
	 */
	public Calculator() {
		initialize();
		txtOutput.setText("0");
		number1 = 0.0;
		number2 = 0.0;
		operator = '=';
		operand = true;
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
		txtOutput.setText(r);
	}
	
	/**
	 * This code 
	 */
	public void digitPressed(String digit) {
		if (operand  || (!operand && txtOutput.getText().equals("0"))) {
			txtOutput.setText("");
			operand = false;
		}
		
		if (txtOutput.getText().length() < OUTPUT_SIZE)
			txtOutput.setText(txtOutput.getText() + digit);		
	}
	
	/**
	 * This code
	 */
	public void executeOperation() {
		number2 = Double.parseDouble(txtOutput.getText());
		switch (operator) {
			case '+': number1 += number2; break;
			case '-': number1 -= number2; break;
			case '*': number1 *= number2; break;
			case '/': number1 /= number2; break;
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// set the frame.
		frmSimpleCalculator = new JFrame();
		frmSimpleCalculator.getContentPane().setForeground(Color.GRAY);
		frmSimpleCalculator.getContentPane().setBackground(Color.DARK_GRAY);
		frmSimpleCalculator.setForeground(Color.WHITE);
		frmSimpleCalculator.setBackground(Color.BLACK);
		frmSimpleCalculator.setTitle("Simple Calculator");
		frmSimpleCalculator.setResizable(false);
		frmSimpleCalculator.setBounds(100, 100, 302, 414);
		frmSimpleCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimpleCalculator.getContentPane().setLayout(null);
		
		// set the display.
		txtOutput = new JTextField();
		txtOutput.setEditable(false);
		txtOutput.setForeground(Color.WHITE);
		txtOutput.setBackground(Color.BLACK);
		txtOutput.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		txtOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOutput.setText("0");
		txtOutput.setBounds(12, 11, 274, 45);
		frmSimpleCalculator.getContentPane().add(txtOutput);
		txtOutput.setColumns(10);
		
		// set the button 7.
		btn = new CustomizedButton("7", 12, 130, 60, 50);
		JButton btn7 = btn.getBtn();
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("7");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn7);
		
		
		// set the button 8.
		btn = new CustomizedButton("8", 84, 130, 60, 50);
		JButton btn8 = btn.getBtn();
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("8");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn8);
		
		// set the button 9.
		btn = new CustomizedButton("9", 156, 130, 60, 50);
		JButton btn9 = btn.getBtn();
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("9");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn9);
		
		// set the button - (subtraction operation).
		btn = new CustomizedButton("-", 228, 130, 60, 50);
		JButton btnMinus = btn.getBtn();
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(txtOutput.getText());
				} else 
					executeOperation();
				show(number1);
				operator = '-';
				operand = true;		
			}
		});
		frmSimpleCalculator.getContentPane().add(btnMinus);

		// set the button 4.
		btn = new CustomizedButton("4", 12, 192, 60, 50);
		JButton btn4 = btn.getBtn();
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("4");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn4);
		
		// set the button 5.
		btn = new CustomizedButton("5", 84, 192, 60, 50);
		JButton btn5 = btn.getBtn();
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("5");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn5);
		
		// set the button 6.
		btn = new CustomizedButton("6", 156, 192, 60, 50);
		JButton btn6 = btn.getBtn();
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("6");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn6);
		
		// set the button X (multiplication operation).
		btn = new CustomizedButton("X", 228, 192, 60, 50);
		JButton btnMult = btn.getBtn();
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(txtOutput.getText());
				} else 
					executeOperation();
				show(number1);
				operator = '*';
				operand = true;		
			}
		});
		frmSimpleCalculator.getContentPane().add(btnMult);
		
		// set the button 1.
		btn = new CustomizedButton("1", 12, 254, 60, 50);
		JButton btn1 = btn.getBtn();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("1");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn1);
		
		// set the button 2.
		btn = new CustomizedButton("2", 84, 254, 60, 50);
		JButton btn2 = btn.getBtn();
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("2");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn2);
		
		// set the button 3.
		btn = new CustomizedButton("3", 156, 254, 60, 50);
		JButton btn3 = btn.getBtn();
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("3");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn3);
		
		// set the button / (division operation).
		btn = new CustomizedButton("/", 228, 254, 60, 50);
		JButton btnDiv = btn.getBtn();
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(txtOutput.getText());
				} else 
					executeOperation();
				show(number1);
				operator = '/';
				operand = true;		
			}
		});
		frmSimpleCalculator.getContentPane().add(btnDiv);
		
		// set the button 0.
		CustomizedButton btn = new CustomizedButton("0", 12, 316, 60, 50);
		JButton btn0 = btn.getBtn();
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("0");
			}
		});
		frmSimpleCalculator.getContentPane().add(btn0);
		
		// set the button . (called dot or floating-point)
		btn = new CustomizedButton(".", 84, 316, 60, 50);
		JButton btnDot = btn.getBtn();
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtOutput.getText().equals("0") || txtOutput.getText().equals("") || operator != '=') {
					digitPressed("0");
					txtOutput.setText(txtOutput.getText() + ".");
				} else if ((txtOutput.getText().length() < OUTPUT_SIZE) && (txtOutput.getText().indexOf(".") == -1))
						txtOutput.setText(txtOutput.getText() + ".");
			}
		});
		frmSimpleCalculator.getContentPane().add(btnDot);
		
		/// set the button for signal inversion.
		btn = new CustomizedButton("+/-", 156, 316, 60, 50);
		JButton btnInv = btn.getBtn();
		btnInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = txtOutput.getText();
				if (!s.equals("0")) 
					show((-1) * Double.parseDouble(s));
			}
		});
		frmSimpleCalculator.getContentPane().add(btnInv);
		
		// set the button = (equal or result getting operation).
		btn = new CustomizedButton("=", 228, 316, 60, 50);
		JButton btnEqual = btn.getBtn();
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeOperation();
				show(number1);
				operator = '=';
				operand = true;		
			}
		});
		frmSimpleCalculator.getContentPane().add(btnEqual);
		
		// set the backspace button.
		btn = new CustomizedButton("\u2190", 12, 68, 60, 50);
		JButton btnBack = btn.getBtn();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtOutput.getText().length() > 0)
					txtOutput.setText(txtOutput.getText().substring(0, txtOutput.getText().length() - 1));
				if ((txtOutput.getText().length() > 0) && (txtOutput.getText().indexOf(".") == txtOutput.getText().length()-1))
					txtOutput.setText(txtOutput.getText().substring(0, txtOutput.getText().length() - 1));
				if (txtOutput.getText().length() == 0) {
					txtOutput.setText("0");
					operand = true;
				}
			}
		});
		frmSimpleCalculator.getContentPane().add(btnBack);
		
		// set the clear button.
		btn= new CustomizedButton("C", 84, 68, 60, 50);
		JButton btnClear = btn.getBtn();
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText("0");
				number1 = number2 = 0.0;
				operand = true;
			}
		});
		frmSimpleCalculator.getContentPane().add(btnClear);
		
		// set the percent button (for percentage calculation).
		btn = new CustomizedButton("%", 156, 68, 60, 50);
		JButton btnPercent = btn.getBtn();
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(txtOutput.getText());
				} else {
					number2 = Double.parseDouble(txtOutput.getText());
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
		frmSimpleCalculator.getContentPane().add(btnPercent);
		
		// set the + button (sum operation).
		btn = new CustomizedButton("+", 228, 68, 60, 50);
		JButton btnPlus = btn.getBtn();
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == '=') {
					number1 = Double.parseDouble(txtOutput.getText());
				} else 
					executeOperation();
				show(number1);
				operator = '+';
				operand = true;		
			}
		});
		frmSimpleCalculator.getContentPane().add(btnPlus);
	}
}
