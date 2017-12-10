package Layouts;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.ControladorHistorial;

import java.awt.Font;

/**
 * @author miquel-msi
 *
 */

@SuppressWarnings("serial")
public class Historial extends JFrame {

	public JTable table;

	public Historial() {
		getContentPane().setBackground(Color.BLUE);

		JScrollPane scrollPane = new JScrollPane();
		setBounds(450, 100, 291, 350);
		getContentPane().add(scrollPane);

		setTitle("Historial operaciones");
		Color mainColor= new Color(52, 152, 219);
		Color buttonColor = new Color(30, 115, 172);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setEnabled(false);
		table.setBackground(mainColor);
		table.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
		table.setRowHeight(35);
		table.getTableHeader().setBackground(buttonColor);
		table.getTableHeader().setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 25));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Ey ey ey"
				}
				));
		scrollPane.setViewportView(table);
		
		try {
			ControladorHistorial c = new ControladorHistorial();
			c.getHistory(table);
		} catch (Exception e) {
			System.out.println("Error al cargar el historial");
		}

	}
}
