/*
 * This code is a simple calculator implementation without MVC design pattern. It is result of study of Java GUI design using the
 * WindowBuilder Pro GUI Designer tool.
 */

package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		if (operand || (!operand && txtOutput.getText().equals("0"))) {
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
		txtOutput.setForeground(Color.WHITE);
		txtOutput.setBackground(Color.BLACK);
		txtOutput.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		txtOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOutput.setText("0");
		txtOutput.setBounds(12, 11, 274, 45);
		frmSimpleCalculator.getContentPane().add(txtOutput);
		txtOutput.setColumns(10);
		
		// set the button 7.
		JButton btn7 = new JButton("7");
		btn7.setForeground(Color.CYAN);
		btn7.setBackground(Color.BLACK);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("7");
			}
		});
		btn7.setFont(UIManager.getFont("Button.font"));
		btn7.setBounds(12, 130, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn7);
		
		// set the button 8.
		JButton btn8 = new JButton("8");
		btn8.setForeground(Color.CYAN);
		btn8.setBackground(Color.BLACK);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("8");
			}
		});
		btn8.setFont(UIManager.getFont("Button.font"));
		btn8.setBounds(84, 130, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn8);
		
		// set the button 9.
		JButton btn9 = new JButton("9");
		btn9.setForeground(Color.CYAN);
		btn9.setBackground(Color.BLACK);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("9");
			}
		});
		btn9.setFont(UIManager.getFont("Button.font"));
		btn9.setBounds(156, 130, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn9);
		
		// set the button - (subtraction operation).
		JButton btnMinus = new JButton("-");
		btnMinus.setForeground(Color.CYAN);
		btnMinus.setBackground(Color.BLACK);
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
		btnMinus.setFont(UIManager.getFont("Button.font"));
		btnMinus.setBounds(228, 130, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnMinus);

		// set the button 4.
		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.CYAN);
		btn4.setBackground(Color.BLACK);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("4");
			}
		});
		btn4.setFont(UIManager.getFont("Button.font"));
		btn4.setBounds(12, 192, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn4);
		
		// set the button 5.
		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.CYAN);
		btn5.setBackground(Color.BLACK);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("5");
			}
		});
		btn5.setFont(UIManager.getFont("Button.font"));
		btn5.setBounds(84, 192, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn5);
		
		// set the button 6.
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.CYAN);
		btn6.setBackground(Color.BLACK);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("6");
			}
		});
		btn6.setFont(UIManager.getFont("Button.font"));
		btn6.setBounds(156, 192, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn6);
		
		// set the button X (multiplication operation).
		JButton btnMult = new JButton("X");
		btnMult.setForeground(Color.CYAN);
		btnMult.setBackground(Color.BLACK);
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
		btnMult.setFont(UIManager.getFont("Button.font"));
		btnMult.setBounds(228, 192, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnMult);
		
		// set the button 1.
		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.CYAN);
		btn1.setBackground(Color.BLACK);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("1");
			}
		});
		btn1.setFont(UIManager.getFont("Button.font"));
		btn1.setBounds(12, 254, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn1);
		
		// set the button 2.
		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.CYAN);
		btn2.setBackground(Color.BLACK);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("2");
			}
		});
		btn2.setFont(UIManager.getFont("Button.font"));
		btn2.setBounds(84, 254, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn2);
		
		// set the button 3.
		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.CYAN);
		btn3.setBackground(Color.BLACK);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("3");
			}
		});
		btn3.setFont(UIManager.getFont("Button.font"));
		btn3.setBounds(156, 254, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn3);
		
		// set the button / (division operation).
		JButton btnDiv = new JButton("/");
		btnDiv.setForeground(Color.CYAN);
		btnDiv.setBackground(Color.BLACK);
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
		btnDiv.setFont(UIManager.getFont("Button.font"));
		btnDiv.setBounds(228, 254, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnDiv);
		
		// set the button 0.
		JButton btn0 = new JButton("0");
		btn0.setForeground(Color.CYAN);
		btn0.setBackground(Color.BLACK);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitPressed("0");
			}
		});
		btn0.setFont(UIManager.getFont("Button.font"));
		btn0.setBounds(12, 316, 60, 50);
		frmSimpleCalculator.getContentPane().add(btn0);
		
		// set the button . (called dot or floating-point)
		JButton btnDot = new JButton(".");
		btnDot.setForeground(Color.CYAN);
		btnDot.setBackground(Color.BLACK);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtOutput.getText().equals("0"))
					txtOutput.setText("0.");
				else if ((txtOutput.getText().length() < OUTPUT_SIZE) && (txtOutput.getText().indexOf(".") == -1))
						txtOutput.setText(txtOutput.getText() + ".");
			}
		});
		btnDot.setFont(UIManager.getFont("Button.font"));
		btnDot.setBounds(84, 316, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnDot);
		
		/// set the button for signal inversion.
		JButton btnInv = new JButton("+/-");
		btnInv.setForeground(Color.CYAN);
		btnInv.setBackground(Color.BLACK);
		btnInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = txtOutput.getText();
				if (!s.equals("0")) 
					show((-1) * Double.parseDouble(s));
			}
		});
		btnInv.setFont(UIManager.getFont("Button.font"));
		btnInv.setBounds(156, 316, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnInv);
		
		// set the button = (equal or result getting operation).
		JButton btnEqual = new JButton("=");
		btnEqual.setForeground(Color.CYAN);
		btnEqual.setBackground(Color.BLACK);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeOperation();
				show(number1);
				operator = '=';
				operand = true;		
			}
		});
		btnEqual.setFont(UIManager.getFont("Button.font"));
		btnEqual.setBounds(228, 316, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnEqual);
		
		// set the backspace button.
		JButton btnBack = new JButton("<-");
		btnBack.setForeground(Color.CYAN);
		btnBack.setBackground(Color.BLACK);
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
		btnBack.setFont(UIManager.getFont("Button.font"));
		btnBack.setBounds(12, 68, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnBack);
		
		// set the clear button.
		JButton btnClear = new JButton("C");
		btnClear.setForeground(Color.CYAN);
		btnClear.setBackground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText("0");
				number1 = number2 = 0.0;
				operand = true;
			}
		});
		btnClear.setFont(UIManager.getFont("Button.font"));
		btnClear.setBounds(84, 68, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnClear);
		
		// set the percent button (for percentage calculation).
		JButton btnPercent = new JButton("%");
		btnPercent.setForeground(Color.CYAN);
		btnPercent.setBackground(Color.BLACK);
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
		btnPercent.setFont(UIManager.getFont("Button.font"));
		btnPercent.setBounds(156, 68, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnPercent);
		
		// set the + button (sum operation).
		JButton btnPlus = new JButton("+");
		btnPlus.setForeground(Color.CYAN);
		btnPlus.setBackground(Color.BLACK);
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
		btnPlus.setFont(UIManager.getFont("Button.font"));
		btnPlus.setBounds(228, 68, 60, 50);
		frmSimpleCalculator.getContentPane().add(btnPlus);
	}
}
