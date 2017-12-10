package Controllers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Operacion;
import Utility.Conexion;

/**
 * @author miquel-msi
 *
 */

public class ControladorHistorial {

	public ControladorHistorial() throws SQLException {


	}

	public void getHistory(JTable t) throws SQLException{
		String[] titulos = { "Operaciones"};

		DefaultTableModel model = new DefaultTableModel(null, titulos);
		Conexion.open();
		PreparedStatement stm;
		ResultSet resp;

		String consulta = "SELECT val1, val2, sym, res FROM operacion";
		try{
			stm=Conexion.con.prepareStatement(consulta);
			resp = stm.executeQuery(consulta);

			while (resp.next()){
			new Operacion(new Double(resp.getDouble("val1")),
					new Double(resp.getDouble("val2")),
					resp.getString("sym").charAt(0),
					resp.getDouble("res"));
					String operacionCompleta = (resp.getDouble("val1")+"")+(resp.getString("sym").charAt(0))+(resp.getDouble("val2")+"")+ " = " +resp.getDouble("res");
					model.addRow(new Object[]{operacionCompleta});

			}
			t.setModel(model);
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null ,ex);
		}    

	}
	
}
