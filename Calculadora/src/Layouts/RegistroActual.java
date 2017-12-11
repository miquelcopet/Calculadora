package Layouts;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistroActual extends JFrame{
	
public JTextField txtOperaciones;
public JTextPane textPane;

public RegistroActual()  {
		setBounds(450, 100, 289, 411);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBounds(0, 57, 273, 307);
		getContentPane().add(textPane);
		textPane.setBorder(null);
		textPane.setBackground(new Color(52, 152, 219));
		textPane.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		textPane.setForeground(Color.BLACK);
		
		txtOperaciones = new JTextField();
		txtOperaciones.setEditable(false);
		txtOperaciones.setEnabled(false);
		txtOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperaciones.setText("Operaciones");
		txtOperaciones.setBounds(0, 0, 273, 56);
		getContentPane().add(txtOperaciones);
		txtOperaciones.setBackground(new Color(30, 115, 172));
		txtOperaciones.setColumns(10);
		txtOperaciones.setBorder(null);
		txtOperaciones.setForeground(Color.WHITE);
		txtOperaciones.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
	}
}
