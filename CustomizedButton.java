/**
 * This class allows reuse repetitive info about buttons.
 */
package calculator;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.UIManager;

public class CustomizedButton {
	private static final Color FOREGROUND = Color.CYAN;
	private static final Color BACKGROUND = Color.BLACK;
	private JButton btn;
	
	public CustomizedButton(String keyword, int x, int y, int width, int height) {
		btn = new JButton(keyword);
		btn.setForeground(FOREGROUND);
		btn.setBackground(BACKGROUND);
		btn.setFont(UIManager.getFont("Button.font"));
		btn.setBounds(x, y, width, height);
	}

	/**
	 * @return the btn
	 */
	public JButton getBtn() { return btn; }
}
