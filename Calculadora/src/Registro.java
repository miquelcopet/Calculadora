import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Registro {

	private JFrame frame;
	private JTable table;

	public Registro() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 285, 295);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 279, 253);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Valor 1", "Valor 2", "", "Resultado"
			}
		));
		scrollPane.setViewportView(table);
	}
}
