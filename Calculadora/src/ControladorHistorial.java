import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

public class ControladorHistorial {

	public Historial h;

	public ControladorHistorial() throws SQLException {

		h = new Historial();

	}

	public void getHistory(JTable t) throws SQLException{
		String[] titulos = { "Operacion"};
		String[] registro = new String[4];

		DefaultTableModel model = new DefaultTableModel(null, titulos);
		Conexion.open();
		PreparedStatement stm;
		ResultSet resp;

		String consulta = "SELECT val1, val2, sym, res FROM operacion";
		try{
			stm=Conexion.con.prepareStatement(consulta);
			resp = stm.executeQuery(consulta);

			while (resp.next()){
				registro[0] = resp.getString("DATE");
				//registro[1] = resp.getString("OPERATION");
				registro[2] = resp.getString("RESULT");

				model.addRow(registro);

			}
			t.setModel(model);
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null ,ex);
		}    

	}
	
}
