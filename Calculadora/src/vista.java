import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Font;
import java.lang.invoke.ConstantCallSite;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class vista extends JFrame {

	public JPanel contentPane;
	public JTextField txtResult;
	public JButton btnSRoot;
	public JButton btnPow;
	public JButton btnSettings;
	public JButton btnC;
	public JButton btnCE;
	public JButton btnDelete;
	public JButton btnDivide;
	public JButton btnMultiply;
	public JButton btn8;
	public JButton btn9;
	public JButton btn7;
	public JButton btnResta;
	public JButton btn5;
	public JButton btn6;
	public JButton btn4;
	public JButton btnSuma;
	public JButton btn2;
	public JButton btn3;
	public JButton btn1;
	public JButton btnEqual;
	public JButton btnComa;
	public JButton btn0;
	public JTextField txtHistory;

	public vista() {
		setTitle("Calculadra Copet");
		Color mainColor= new Color(52, 152, 219);
		Color buttonColor = new Color(30, 115, 172);
	
		Font buttonFont = new Font("Microsoft JhengHei UI Light", Font.BOLD, 25);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 576);
		contentPane = new JPanel();
		contentPane.setBackground(mainColor);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtResult = new JTextField();
		txtResult.setForeground(Color.decode("#0B3A8A"));
		txtResult.setEditable(false);
		txtResult.setBackground(mainColor);
		txtResult.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 30));
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setBounds(0, 29, 271, 79);
		txtResult.setText("");
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		txtResult.setBorder(null);
		
		txtHistory = new JTextField();
		txtHistory.setBounds(0, 0, 272, 27);
		contentPane.add(txtHistory);
		txtHistory.setColumns(10);
		txtHistory.setForeground(Color.decode("#0B3A8A"));
		txtHistory.setEditable(false);
		txtHistory.setBackground(buttonColor);
		txtHistory.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 14));
		txtHistory.setHorizontalAlignment(SwingConstants.LEFT);
		txtHistory.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(mainColor);
		panel.setBorder(null);
		panel.setBounds(0, 119, 272, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMod = new JButton("%");
		btnMod.setBounds(0, 0, 70, 70);
		panel.add(btnMod);
		btnMod.setFocusPainted(false);
		btnMod.setBackground(buttonColor);
		btnMod.setFont(buttonFont);
		btnMod.setBorder(null);
		
		btnSRoot = new JButton("");
		btnSRoot.setFont(buttonFont);
		btnSRoot.setFocusPainted(false);
		btnSRoot.setBorder(null);
		btnSRoot.setBackground(buttonColor);
		btnSRoot.setBounds(69, 0, 70, 70);
		btnSRoot.setText("\u221A");
		panel.add(btnSRoot);
		
		btnPow = new JButton("x^x");
		btnPow.setFont(buttonFont);
		btnPow.setFocusPainted(false);
		btnPow.setBorder(null);
		btnPow.setBackground(buttonColor);
		btnPow.setBounds(137, 0, 70, 70);
		panel.add(btnPow);
		
		btnSettings = new JButton("");
		btnSettings.setIcon(new ImageIcon("I:\\Miquel\\Imágenes\\ico\\settings.png"));
		btnSettings.setFont(buttonFont);
		btnSettings.setFocusPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setBackground(buttonColor);
		btnSettings.setBounds(204, 0, 70, 70);
		panel.add(btnSettings);
		
		btnCE = new JButton("CE");
		btnCE.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnCE.setFocusPainted(false);
		btnCE.setBorder(null);
		btnCE.setBackground(new Color(30, 115, 172));
		btnCE.setBounds(0, 69, 70, 70);
		panel.add(btnCE);
		
		btnC = new JButton("C");
		btnC.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnC.setFocusPainted(false);
		btnC.setBorder(null);
		btnC.setBackground(new Color(30, 115, 172));
		btnC.setBounds(69, 69, 70, 70);
		panel.add(btnC);
		
		btnDelete = new JButton("<--");
		btnDelete.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(30, 115, 172));
		btnDelete.setBounds(137, 69, 70, 70);
		panel.add(btnDelete);
		
		btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnDivide.setFocusPainted(false);
		btnDivide.setBorder(null);
		btnDivide.setBackground(new Color(30, 115, 172));
		btnDivide.setBounds(204, 69, 70, 70);
		panel.add(btnDivide);
		
		btnMultiply = new JButton("x");
		btnMultiply.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnMultiply.setFocusPainted(false);
		btnMultiply.setBorder(null);
		btnMultiply.setBackground(new Color(30, 115, 172));
		btnMultiply.setBounds(204, 139, 70, 70);
		panel.add(btnMultiply);
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn8.setFocusPainted(false);
		btn8.setBorder(null);
		btn8.setBackground(new Color(30, 115, 172));
		btn8.setBounds(69, 139, 70, 70);
		panel.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn9.setFocusPainted(false);
		btn9.setBorder(null);
		btn9.setBackground(new Color(30, 115, 172));
		btn9.setBounds(137, 139, 70, 70);
		panel.add(btn9);
		
		btn7 = new JButton("7");
		btn7.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn7.setFocusPainted(false);
		btn7.setBorder(null);
		btn7.setBackground(new Color(30, 115, 172));
		btn7.setBounds(0, 139, 70, 70);
		panel.add(btn7);
		
		btnResta = new JButton("-");
		btnResta.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnResta.setFocusPainted(false);
		btnResta.setBorder(null);
		btnResta.setBackground(new Color(30, 115, 172));
		btnResta.setBounds(204, 208, 70, 70);
		panel.add(btnResta);
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn5.setFocusPainted(false);
		btn5.setBorder(null);
		btn5.setBackground(new Color(30, 115, 172));
		btn5.setBounds(69, 208, 70, 70);
		panel.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn6.setFocusPainted(false);
		btn6.setBorder(null);
		btn6.setBackground(new Color(30, 115, 172));
		btn6.setBounds(137, 208, 70, 70);
		panel.add(btn6);
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn4.setFocusPainted(false);
		btn4.setBorder(null);
		btn4.setBackground(new Color(30, 115, 172));
		btn4.setBounds(0, 208, 70, 70);
		panel.add(btn4);
		
		btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnSuma.setFocusPainted(false);
		btnSuma.setBorder(null);
		btnSuma.setBackground(new Color(30, 115, 172));
		btnSuma.setBounds(204, 277, 70, 70);
		panel.add(btnSuma);
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn2.setFocusPainted(false);
		btn2.setBorder(null);
		btn2.setBackground(new Color(30, 115, 172));
		btn2.setBounds(69, 277, 70, 70);
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn3.setFocusPainted(false);
		btn3.setBorder(null);
		btn3.setBackground(new Color(30, 115, 172));
		btn3.setBounds(137, 277, 70, 70);
		panel.add(btn3);
		
		btn1 = new JButton("1");
		btn1.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn1.setFocusPainted(false);
		btn1.setBorder(null);
		btn1.setBackground(new Color(30, 115, 172));
		btn1.setBounds(0, 277, 70, 70);
		panel.add(btn1);
		
		btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnEqual.setFocusPainted(false);
		btnEqual.setBorder(null);
		btnEqual.setBackground(new Color(30, 115, 172));
		btnEqual.setBounds(137, 347, 135, 70);
		panel.add(btnEqual);
		
		btnComa = new JButton(",");
		btnComa.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnComa.setFocusPainted(false);
		btnComa.setBorder(null);
		btnComa.setBackground(new Color(30, 115, 172));
		btnComa.setBounds(0, 347, 70, 70);
		panel.add(btnComa);
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn0.setFocusPainted(false);
		btn0.setBorder(null);
		btn0.setBackground(new Color(30, 115, 172));
		btn0.setBounds(69, 347, 70, 70);
		panel.add(btn0);
	}
}
