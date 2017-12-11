package Layouts;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	public JPanel contentPane;
	public JTextField txtResult;
	public JButton btnSRoot;
	public JButton btnPow;
	public JButton btnMasMenos;
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
	public JMenuItem mntmExit;
	public JMenuItem mntmMostrarRegistroTotal;
	public JButton btnMod;
	private JMenu mnTema;
	
	//Colores
	public Color strongBlue = new Color(30, 115, 172);
	public Color softBlue = new Color(52, 152, 219);
	
	public Color strongRed = new Color(206, 27, 27);
	public Color softRed = new Color(255, 131, 131);
	
	public Color strongGreen = new Color(80, 160, 70);
	public Color softGreen = new Color(160, 255, 145);
	
	public Color mainColor = softBlue;
	public Color buttonColor = strongBlue;
	
	public JMenuItem rojo;
	public JMenuItem verde;
	public JMenuItem azul;
	public JMenuItem mntmExportarRegistro;
	public JMenuItem mntmMostrarRegistro;

	public MainScreen() {
		setResizable(false);
		System.out.println("Pintando pantalla principal");
		setTitle("Calculadra Copet");
		Font buttonFont = new Font("Microsoft JhengHei UI Light", Font.BOLD, 25);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 597);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenu mnRegistro = new JMenu("Registro");
		mnOpciones.add(mnRegistro);
		
		mntmExportarRegistro = new JMenuItem("Exportar registro");
		mnRegistro.add(mntmExportarRegistro);
		
		mntmMostrarRegistro = new JMenuItem("Mostrar registro actual");
		mnRegistro.add(mntmMostrarRegistro);
		
		mntmMostrarRegistroTotal = new JMenuItem("Mostrar registro total");
		mnRegistro.add(mntmMostrarRegistroTotal);
		
		mnTema = new JMenu("Tema");
		mnOpciones.add(mnTema);
		
		azul = new JMenuItem("Azul");
		mnTema.add(azul);
		
		rojo = new JMenuItem("Rojo");
		mnTema.add(rojo);
		
		verde = new JMenuItem("Verde");
		mnTema.add(verde);
		
		mntmExit = new JMenuItem("Exit");

		mnOpciones.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBackground(mainColor);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(mainColor);
		
		txtResult = new JTextField();
		txtResult.setForeground(Color.WHITE);
		txtResult.setEditable(false);
		txtResult.setBackground(mainColor);
		txtResult.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 30));
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setBounds(0, 29, 253, 79);
		txtResult.setText("0");
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		txtResult.setBorder(null);
		
		txtHistory = new JTextField();
		txtHistory.setText("0");
		txtHistory.setBounds(0, 0, 272, 27);
		contentPane.add(txtHistory);
		txtHistory.setColumns(10);
		txtHistory.setForeground(Color.WHITE);
		txtHistory.setEditable(false);
		txtHistory.setBackground(buttonColor);
		txtHistory.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 17));
		txtHistory.setHorizontalAlignment(SwingConstants.LEFT);
		txtHistory.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(mainColor);
		panel.setBorder(null);
		panel.setBounds(0, 119, 272, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnMod = new JButton("%");
		btnMod.setForeground(Color.WHITE);
		btnMod.setBounds(0, 0, 70, 70);
		panel.add(btnMod);
		btnMod.setFocusPainted(false);
		btnMod.setBackground(buttonColor);
		btnMod.setFont(buttonFont);
		btnMod.setBorder(null);
		
		btnSRoot = new JButton("");
		btnSRoot.setForeground(Color.WHITE);
		btnSRoot.setFont(buttonFont);
		btnSRoot.setFocusPainted(false);
		btnSRoot.setBorder(null);
		btnSRoot.setBackground(buttonColor);
		btnSRoot.setBounds(69, 0, 70, 70);
		btnSRoot.setText("\u221A");
		panel.add(btnSRoot);
		
		btnPow = new JButton("x"+"\u00B2");
		btnPow.setForeground(Color.WHITE);
		btnPow.setFont(buttonFont);
		btnPow.setFocusPainted(false);
		btnPow.setBorder(null);
		btnPow.setBackground(buttonColor);
		btnPow.setBounds(137, 0, 70, 70);
		panel.add(btnPow);
		
		btnMasMenos = new JButton("±");
		btnMasMenos.setForeground(Color.WHITE);
		btnMasMenos.setIcon(new ImageIcon("I:\\Miquel\\Imágenes\\ico\\settings.png"));
		btnMasMenos.setFont(buttonFont);
		btnMasMenos.setFocusPainted(false);
		btnMasMenos.setBorder(null);
		btnMasMenos.setBackground(buttonColor);
		btnMasMenos.setBounds(204, 0, 70, 70);
		panel.add(btnMasMenos);
		
		btnCE = new JButton("CE");
		btnCE.setForeground(Color.WHITE);
		btnCE.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnCE.setFocusPainted(false);
		btnCE.setBorder(null);
		btnCE.setBackground(buttonColor);
		btnCE.setBounds(0, 69, 70, 70);
		panel.add(btnCE);
		
		btnC = new JButton("C");
		btnC.setForeground(Color.WHITE);
		btnC.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnC.setFocusPainted(false);
		btnC.setBorder(null);
		btnC.setBackground(buttonColor);
		btnC.setBounds(69, 69, 70, 70);
		panel.add(btnC);
		
		btnDelete = new JButton("");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setIcon(new ImageIcon(MainScreen.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
		btnDelete.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setBackground(buttonColor);
		btnDelete.setBounds(137, 69, 70, 70);
		panel.add(btnDelete);
		
		btnDivide = new JButton("/");
		btnDivide.setForeground(Color.WHITE);
		btnDivide.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnDivide.setFocusPainted(false);
		btnDivide.setBorder(null);
		btnDivide.setBackground(buttonColor);
		btnDivide.setBounds(204, 69, 70, 70);
		panel.add(btnDivide);
		
		btnMultiply = new JButton("x");
		btnMultiply.setForeground(Color.WHITE);
		btnMultiply.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnMultiply.setFocusPainted(false);
		btnMultiply.setBorder(null);
		btnMultiply.setBackground(buttonColor);
		btnMultiply.setBounds(204, 139, 70, 70);
		panel.add(btnMultiply);
		
		btn8 = new JButton("8");
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn8.setFocusPainted(false);
		btn8.setBorder(null);
		btn8.setBackground(buttonColor);
		btn8.setBounds(69, 139, 70, 70);
		panel.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn9.setFocusPainted(false);
		btn9.setBorder(null);
		btn9.setBackground(buttonColor);
		btn9.setBounds(137, 139, 70, 70);
		panel.add(btn9);
		
		btn7 = new JButton("7");
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn7.setFocusPainted(false);
		btn7.setBorder(null);
		btn7.setBackground(buttonColor);
		btn7.setBounds(0, 139, 70, 70);
		panel.add(btn7);
		
		btnResta = new JButton("-");
		btnResta.setForeground(Color.WHITE);
		btnResta.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnResta.setFocusPainted(false);
		btnResta.setBorder(null);
		btnResta.setBackground(buttonColor);
		btnResta.setBounds(204, 208, 70, 70);
		panel.add(btnResta);
		
		btn5 = new JButton("5");
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn5.setFocusPainted(false);
		btn5.setBorder(null);
		btn5.setBackground(buttonColor);
		btn5.setBounds(69, 208, 70, 70);
		panel.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn6.setFocusPainted(false);
		btn6.setBorder(null);
		btn6.setBackground(buttonColor);
		btn6.setBounds(137, 208, 70, 70);
		panel.add(btn6);
		
		btn4 = new JButton("4");
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn4.setFocusPainted(false);
		btn4.setBorder(null);
		btn4.setBackground(buttonColor);
		btn4.setBounds(0, 208, 70, 70);
		panel.add(btn4);
		
		btnSuma = new JButton("+");
		btnSuma.setForeground(Color.WHITE);
		btnSuma.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnSuma.setFocusPainted(false);
		btnSuma.setBorder(null);
		btnSuma.setBackground(buttonColor);
		btnSuma.setBounds(204, 277, 70, 70);
		panel.add(btnSuma);
		
		btn2 = new JButton("2");
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn2.setFocusPainted(false);
		btn2.setBorder(null);
		btn2.setBackground(buttonColor);
		btn2.setBounds(69, 277, 70, 70);
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn3.setFocusPainted(false);
		btn3.setBorder(null);
		btn3.setBackground(buttonColor);
		btn3.setBounds(137, 277, 70, 70);
		panel.add(btn3);
		
		btn1 = new JButton("1");
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn1.setFocusPainted(false);
		btn1.setBorder(null);
		btn1.setBackground(buttonColor);
		btn1.setBounds(0, 277, 70, 70);
		panel.add(btn1);
		
		btnEqual = new JButton("=");
		btnEqual.setForeground(Color.WHITE);
		btnEqual.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnEqual.setFocusPainted(false);
		btnEqual.setBorder(null);
		btnEqual.setBackground(buttonColor);
		btnEqual.setBounds(137, 347, 135, 70);
		panel.add(btnEqual);
		
		btnComa = new JButton(",");
		btnComa.setForeground(Color.WHITE);
		btnComa.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btnComa.setFocusPainted(false);
		btnComa.setBorder(null);
		btnComa.setBackground(buttonColor);
		btnComa.setBounds(0, 347, 70, 70);
		panel.add(btnComa);
		
		btn0 = new JButton("0");
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		btn0.setFocusPainted(false);
		btn0.setBorder(null);
		btn0.setBackground(buttonColor);
		btn0.setBounds(69, 347, 70, 70);
		panel.add(btn0);
		
		revalidate();
		repaint();
		
	}
}
